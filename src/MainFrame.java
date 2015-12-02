/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author lader
 */
public class MainFrame extends JFrame {

    public Thread movieLoop;
    public Canvas c;
    public Player Jugador;
    public Enemigo Enemigo1;
    public Enemigo Enemigo2;
    public Enemigo Enemigo3;
    long currentTime = 0;
    public  int world2[][] = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 6, 6, 6, 6, 2, 3, 3, 3, 3, 3, 3, 3, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1},
        {1, 6, 6, 6, 6, 2, 6, 6, 6, 1, 1, 2, 6, 6, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
        {1, 5, 5, 5, 5, 2, 6, 6, 6, 1, 1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 2, 5, 5, 5, 5, 1},
        {1, 1, 2, 1, 1, 1, 6, 6, 6, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2, 6, 6, 6, 6, 6, 6, 6, 6, 6, 1},
        {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 6, 6, 6, 6, 6, 6, 6, 6, 6, 1},
        {1, 6, 6, 6, 6, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 6, 6, 6, 6, 6, 6, 6, 6, 6, 1},
        {1, 6, 5, 5, 5, 2, 5, 6, 6, 6, 6, 6, 6, 6, 6, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1},
        {1, 6, 2, 1, 1, 1, 1, 6, 6, 6, 6, 6, 6, 6, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1},
        {1, 5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};
    public static int world1[][] = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 6, 6, 6, 6, 2, 3, 3, 3, 3, 3, 3, 3, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1},
        {1, 6, 6, 6, 6, 2, 6, 6, 6, 1, 1, 2, 6, 6, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
        {1, 5, 5, 5, 5, 2, 6, 6, 6, 1, 1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 2, 5, 5, 5, 5, 1},
        {1, 1, 2, 1, 1, 1, 6, 6, 6, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2, 6, 6, 6, 6, 6, 6, 6, 6, 6, 1},
        {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 6, 6, 6, 6, 6, 6, 6, 6, 6, 1},
        {1, 6, 6, 6, 6, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 6, 6, 6, 6, 6, 6, 6, 6, 6, 1},
        {1, 6, 5, 5, 5, 2, 5, 6, 6, 6, 6, 6, 6, 6, 6, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1},
        {1, 6, 2, 1, 1, 1, 1, 6, 6, 6, 6, 6, 6, 6, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1},
        {1, 5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};
    public static int world[][] = {
        {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
        {7, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 2, 7},
        {7, 2, 7, 7, 1, 7, 7, 2, 6, 6, 6, 2, 1, 1, 1, 1, 1, 1, 1, 2, 5, 5, 5, 5, 2, 7},
        {7, 2, 5, 5, 5, 5, 5, 2, 6, 6, 6, 2, 6, 6, 6, 6, 6, 6, 6, 2, 1, 1, 1, 1, 2, 7},
        {7, 2, 1, 7, 1, 7, 1, 2, 6, 6, 6, 2, 6, 6, 6, 6, 6, 6, 6, 2, 6, 6, 6, 6, 6, 7},
        {7, 2, 6, 6, 6, 6, 6, 2, 3, 3, 3, 2, 3, 3, 3, 5, 5, 5, 5, 2, 5, 5, 5, 5, 5, 7},
        {7, 2, 6, 6, 6, 6, 6, 2, 6, 6, 6, 2, 5, 5, 2, 1, 1, 1, 1, 7, 7, 7, 7, 7, 2, 7},
        {7, 2, 5, 5, 5, 5, 5, 2, 5, 5, 5, 2, 1, 1, 2, 6, 6, 6, 6, 6, 5, 5, 5, 5, 2, 7},
        {7, 7, 1, 1, 1, 7, 1, 1, 7, 1, 7, 2, 6, 6, 6, 6, 6, 6, 6, 6, 2, 1, 1, 2, 1, 7},
        {7, 7, 1, 1, 1, 7, 6, 6, 6, 6, 6, 2, 6, 6, 6, 6, 6, 6, 6, 6, 2, 6, 6, 2, 6, 7},
        {7, 7, 5, 5, 5, 7, 5, 5, 5, 5, 5, 2, 5, 5, 3, 3, 3, 3, 3, 3, 2, 6, 5, 2, 5, 7},
        {7, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 7, 7, 7, 6, 6, 6, 6, 6, 2, 6, 1, 1, 1, 7},
        {7, 5, 5, 5, 5, 5, 5, 5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2, 5, 5, 5, 5, 7},
        {7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7},
        {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7},};
    public Mundo mundo;
    public int tam = 40;
    public static int Minas = 2;

    public MainFrame(int w, int h) throws Exception {
        c = new Canvas();
        this.setSize(w, h);
        c.setSize(w, h);
        this.add(c);
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: {
                        Jugador.currentDirection = Player.UP;
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        Jugador.currentDirection = Player.DOWN;
                        break;
                    }
                    case KeyEvent.VK_LEFT: {
                        Jugador.currentDirection = Player.LEFT;
                        break;
                    }
                    case KeyEvent.VK_RIGHT: {
                        Jugador.currentDirection = Player.RIGTH;
                        break;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: {
                        Jugador.currentDirection = Player.NONE;
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        Jugador.currentDirection = Player.NONE;
                        break;
                    }
                    case KeyEvent.VK_LEFT: {
                        Jugador.currentDirection = Player.NONE;
                        break;
                    }
                    case KeyEvent.VK_RIGHT: {
                        Jugador.currentDirection = Player.NONE;
                        break;
                    }
                    case KeyEvent.VK_Z: {
                        Jugador.EliminarLadrilloIzquierda(mundo.world, tam, currentTime);
                        break;
                    }
                    case KeyEvent.VK_X: {
                        Jugador.EliminarLadrilloDerecha(mundo.world, tam, currentTime);
                        break;
                    }
                }
            }
        });
        Jugador = new Player(640, 520, 1, 1, "");
        Enemigo1 = new Enemigo(310, 80, 1, 1, "");
        Enemigo2 = new Enemigo(860, 160, 1, 1, "");
        Enemigo3 = new Enemigo(200, 520, 1, 1, "");
        String[] names = {"arriba", "adelante", "abajo", "atras"};
        Jugador.loadPics(names);
        Enemigo1.loadPics(names);
        Enemigo2.loadPics(names);
        Enemigo3.loadPics(names);
        mundo = new Mundo(world, tam);
        movieLoop = new Thread(new Runnable() {

            @Override
            public void run() {
                c.createBufferStrategy(2);
                Graphics g = c.getBufferStrategy().getDrawGraphics();
                long startTime = System.currentTimeMillis();

                while (true) {
                    try {
                        //Toma el tiempo actual
                        currentTime = System.currentTimeMillis() - startTime;
                        //Dibuja el mundo
                        mundo.draw(g);
                        //Valida Si ganó
                        if (Minas == 0) {
                            // System.out.println("Ganaste");
                        }
                        //Enemigo1.AutoMovimiento(Enemigo1.PosX, Enemigo1.PosY, Jugador.PosX, Jugador.PosY, currentTime, mundo.world, tam);
                        //Enemigo2.AutoMovimiento(Enemigo2.PosX, Enemigo2.PosY, Jugador.PosX, Jugador.PosY, currentTime, mundo.world, tam);
                        //Enemigo3.AutoMovimiento(Enemigo3.PosX, Enemigo3.PosY, Jugador.PosX, Jugador.PosY, currentTime, mundo.world, tam);
                        //Validar Colisión
                        if (Enemigo1.PosX == Jugador.PosX && Enemigo1.PosY == Jugador.PosY) {
                            System.out.println("Perdiste");
                        }

                        //Rehace los ladrillos rotos
                        mundo.AutoeliminarHuecos(currentTime);
                        //Valida la caida del personaje
                        if (Jugador.y > 0) {
                            Jugador.CaidaLibre(mundo.world, tam, currentTime);
                        } else {
                            
                            CambiarMundo2();
                        }

                        Enemigo1.CaidaLibre(mundo.world, tam, currentTime);
                        Enemigo2.CaidaLibre(mundo.world, tam, currentTime);
                        Enemigo3.CaidaLibre(mundo.world, tam, currentTime);
                        switch (Jugador.currentDirection) {
                            case Player.RIGTH: {
                                Jugador.moveRigth(currentTime, mundo.world, tam);
                                break;
                            }
                            case Player.DOWN: {
                                Jugador.moveDown(currentTime, mundo.world, tam);
                                break;
                            }
                            case Player.LEFT: {
                                Jugador.moveLeft(currentTime, mundo.world, tam);
                                break;
                            }
                            case Player.UP: {
                                Jugador.moveUp(currentTime, mundo.world, tam);
                                break;
                            }
                        }
                        //Jugador.draw(g);
                        //Enemigo1.draw(g);
                        //Enemigo2.draw(g);
                        //Enemigo3.draw(g);
                        Thread.sleep(10);
                        c.getBufferStrategy().show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void CambiarMundo2() throws Exception {
        
        WelcomeScreen.Prueba();
        mundo = new Mundo(world2, tam);
        Jugador.x = 500;
        Jugador.y = 360;
        mundo.AgregarMinasRandom();
    }

    public static void main() {
        try {
            MainFrame p = new MainFrame(1060, 640);
            p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            p.setVisible(true);
            p.movieLoop.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
