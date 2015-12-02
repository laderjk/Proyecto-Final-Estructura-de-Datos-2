
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lader
 */
public class WelcomeScreen extends JFrame {

    private static Object sonido;
    private static Object fondo;

    public Thread loop;
    public Thread first;
    public static Canvas pantalla;
    static long StartTime;
    boolean First = false;
    boolean IsTransicion = false;
    boolean FirstOUT = true;
    boolean IsTransicionOUT = true;
    boolean Press = false;
    ImageIcon Welcome1 = new ImageIcon(getClass().getResource("/LoadRunnerW1.png"));
    ImageIcon Welcome2 = new ImageIcon(getClass().getResource("/LoadRunnerW2.png"));
    ImageIcon Transicion5 = new ImageIcon(getClass().getResource("/Transicion5.png"));
    

    public WelcomeScreen() throws Exception {
        pantalla = new Canvas();
        this.setSize(1060, 640);
        pantalla.setSize(1060, 640);
        this.add(pantalla);
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER: {
                        try {
                            Welcome1 = Transicion5;
                            IsTransicion = true;
                            First = true;
                            break;
                        } catch (Exception ex) {
                            Logger.getLogger(WelcomeScreen.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Throwable ex) {
                            Logger.getLogger(WelcomeScreen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
        });

        loop = new Thread(new Runnable() {
            @Override
            public void run() {
                pantalla.createBufferStrategy(2);
                Graphics g = pantalla.getBufferStrategy().getDrawGraphics();
                while (true) {
                    try {
                        g.drawImage(Welcome1.getImage(), 0, 0, null);
                        pantalla.getBufferStrategy().show();
                        Transicion();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        });

    }

    public void VisibleOff() {
        this.setVisible(false);
    }

    public void Transicion() throws InterruptedException {
        if (First) {
            StartTime = System.currentTimeMillis();
            First = false;
        }
        if (IsTransicion) {
            if (System.currentTimeMillis() > (StartTime + 2000)) {
                MainFrame.main();
                VisibleOff();
                IsTransicion = false;
            }
        }
    }

    public void TransicionOUT(WelcomeScreen W) throws InterruptedException {
        Welcome1 = Transicion5;
        W.setVisible(true);
        W.loop.start();
        if (FirstOUT) {
            StartTime = System.currentTimeMillis();
            FirstOUT = false;
        }
        if (IsTransicionOUT) {
            if (System.currentTimeMillis() > (StartTime + 2000)) {           
                W.VisibleOff();
                IsTransicionOUT = false;
            }
        }    
       
    }

    public static void main(String args[]) {
        try {
            WelcomeScreen W = new WelcomeScreen();
            W.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            W.setVisible(true);
            W.loop.start();

        } catch (IOException error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
