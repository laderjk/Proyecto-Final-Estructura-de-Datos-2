/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author lader
 */
public class Mundo {

    public int world[][];
    public int tam;
    boolean OneTime = false;
    static ArrayList<HuecosEnMapa> listaHuecos = new ArrayList<HuecosEnMapa>();
    ImageIcon Ladrillo = new ImageIcon(getClass().getResource("/spriteladrillo.jpg"));
    ImageIcon Escalera = new ImageIcon(getClass().getResource("/spriteescalera.png"));
    ImageIcon Barra = new ImageIcon(getClass().getResource("/spritebarra.png"));
    ImageIcon Oro = new ImageIcon(getClass().getResource("/spriteoro.png"));
    ImageIcon LadrilloFijo = new ImageIcon(getClass().getResource("/spriteladrillofijo.png"));

    public Mundo(int[][] world, int tam) {
        this.world = world;
        this.tam = tam;
    }

    public void draw(Graphics g) {

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 26; j++) {
                if (!OneTime) {
                    AgregarMinasRandom();
                }
                AgregarEscaleraGanadora();
                switch (world[i][j]) {
                    case 8: {
                        g.setColor(Color.RED);
                        g.fillRect(j * tam, i * tam, tam, tam);
                        //System.out.println("blanco " + i + " " + "j");
                        break;
                    }
                    case 7: {
                         g.drawImage(LadrilloFijo.getImage(), j * tam, i * tam, null);
                        //System.out.println("blanco " + i + " " + "j");
                        break;
                    }
                    case 6: {
                        g.setColor(Color.WHITE);
                        g.fillRect(j * tam, i * tam, tam, tam);
                        //System.out.println("blanco " + i + " " + "j");
                        break;
                    }
                    case 5: {
                        g.setColor(Color.WHITE);
                        g.fillRect(j * tam, i * tam, tam, tam);
                        //System.out.println("blanco " + i + " " + "j");
                        break;
                    }
                    case 4: {
                        g.drawImage(Oro.getImage(), j * tam, i * tam, null);
                        break;
                    }

                    case 3: {
                        g.drawImage(Barra.getImage(), j * tam, i * tam, null);
                        break;
                    }

                    case 2: {
                        g.drawImage(Escalera.getImage(), j * tam, i * tam, null);
                        break;
                    }
                    case 1: {
                        g.drawImage(Ladrillo.getImage(), j * tam, i * tam, null);
                        //System.out.println("rojo " + i + " " + "j");
                        break;
                    }
                    case 0: {
                        g.setColor(Color.WHITE);
                        g.fillRect(j * tam, i * tam, tam, tam);
                        //System.out.println("blanco " + i + " " + "j");
                        break;
                    }

                }
            }
        }
    }

    public void AgregarMinasRandom() {
        int MinasCreadas = 0;
        Random rnd = new Random();
        while (MinasCreadas < 6) {
            int i = (int) (rnd.nextDouble() * 15 + 0);
            int j = (int) (rnd.nextDouble() * 26 + 0);
            if (world[i][j] == 5) {
                world[i][j] = 4;
                MinasCreadas++;
            }
        }
        OneTime = true;
    }

    public void AgregarEscaleraGanadora() {
        if (MainFrame.Minas == 0) {
            world[0][17] = 2;
            world[1][17] = 2;
            world[2][17] = 2;
            world[3][17] = 2;
            world[4][17] = 2;
        }
    }
    
    public void AgregarHuecoEnMapa (int x, int y, long Start){
        long End = Start+10000;
        HuecosEnMapa object = new HuecosEnMapa(x, y, Start, End);
        listaHuecos.add(object);
    }
    
    public void AutoeliminarHuecos (long time){
        if (listaHuecos.size()>0) {
            
            if (listaHuecos.get(0).getTimeEnd()<time) {
               
                int i = listaHuecos.get(0).getX();
                int j = listaHuecos.get(0).getY();
                world[i][j]=1;
                listaHuecos.remove(0);
            }  
        }
    }

    public class HuecosEnMapa {

        int x;
        int y;
        long TimeStart;
        long TimeEnd;

        public HuecosEnMapa(int x, int y, long TimeStart, long TimeEnd) {
            this.x = x;
            this.y = y;
            this.TimeStart = TimeStart;
            this.TimeEnd = TimeEnd;
        }

        public long getTimeEnd() {
            return TimeEnd;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        
    }

}
