/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author lader
 */
public class Animacion {

    private ArrayList<OneScene> scenes;
    private int sceneIndex;
    private long movieTime;
    private long totalTime;
    
    public synchronized void start(){
        movieTime=0;
        sceneIndex=0;
    }
    public Animacion(){
        scenes = new ArrayList<OneScene>();
        totalTime=0;
        start();
    }
    
    public synchronized void update(long timePassed){
        if(scenes.size()>1){
            if(timePassed > totalTime){
                movieTime=timePassed-((int)(timePassed/totalTime))*totalTime;
                sceneIndex=0;
            }else{
                movieTime=timePassed;
            }
            
            while(movieTime > getScene(sceneIndex).endTime){
                sceneIndex++;
            }
        }
        
    }
    
    public synchronized void addScene(Image i, long t){
        totalTime+=t;
        scenes.add(new OneScene(i, totalTime));
    }
    
    private OneScene getScene(int x){return scenes.get(x);}
    
    public synchronized  Image getImage(){
        if(scenes.isEmpty()){
            return null;
        }else{
           return getScene(sceneIndex).pic;
        }
    }
    
    private class OneScene{
        Image pic;
        long endTime;
    
        public OneScene(Image pic, long endTime){
            this.pic=pic;
            this.endTime=endTime;
        }
    }
}
