
import java.awt.Graphics;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lader
 */
public class Enemigo {

    Animacion[] animations;
    int x;
    int y;
    int PosX;
    int PosY;
    int vx;
    int vy;
    String path;
    int currentAnimation;
    int currentDirection;
    int UltimoMove = 0;

    public Enemigo(int x, int y, int vx, int vy, String path) {
        this.path = path;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.currentDirection = -1;
        animations = new Animacion[4];
        this.PosX = x / 40;
        this.PosY = y / 40;
    }

    public static int getMatrixPositionX(int x, int tam) {
        int OUT = (x / tam);
        return OUT;
    }

    public static int getMatrixPositionY(int y, int tam) {
        int OUT = (y / tam);
        return OUT;
    }

    public void loadPics(String[] names) throws Exception {
        for (int j = 0; j < 4; j++) {
            String name = names[j];
            animations[j] = new Animacion();
            for (int i = 1; i <= 4; i++) {
                animations[j].addScene(
                        new ImageIcon(getClass().getResource("/" + name + i + ".png")).getImage(), 50);
            }
        }

    }

    public boolean isValid(int[][] matrix, int tam, int x, int y) {
        boolean OUT = false;
        if (matrix[getMatrixPositionY(y, tam)][getMatrixPositionX(x, tam)] == 5
                || matrix[getMatrixPositionY(y, tam)][getMatrixPositionX(x, tam)] == 2
                || matrix[getMatrixPositionY(y, tam)][getMatrixPositionX(x, tam)] == 3
                || matrix[getMatrixPositionY(y, tam)][getMatrixPositionX(x, tam)] == 6
                || matrix[getMatrixPositionY(y, tam)][getMatrixPositionX(x, tam)] == 4) {
            OUT = true;

        }
        if (matrix[getMatrixPositionY(y, tam)][getMatrixPositionX(x, tam)] == 4) {
            OUT = true;
            matrix[getMatrixPositionY(y, tam)][getMatrixPositionX(x, tam)] = 5;
            MainFrame.Minas--;
        }

        return OUT;
    }

    public boolean isValidUp(int[][] matrix, int tam, int x, int y) {
        boolean OUT = false;
        if (matrix[getMatrixPositionY(y, tam)][getMatrixPositionX(x, tam)] == 5
                || matrix[getMatrixPositionY(y, tam)][getMatrixPositionX(x, tam)] == 2
                || matrix[getMatrixPositionY(y, tam)][getMatrixPositionX(x, tam)] == 3
                || matrix[getMatrixPositionY(y, tam)][getMatrixPositionX(x, tam)] == 4) {
            OUT = true;
        }
        return OUT;
    }

    public void moveRigth(long time, int[][] matrix, int tam) {
        if (isValid(matrix, tam, x + vx + animations[currentAnimation].getImage().getWidth(null), y)) {
            x += (vx + 3);
            PosX = getMatrixPositionX(x, tam);
            currentAnimation = Player.RIGTH;
            animations[Player.RIGTH].update(time);
        }
    }

    public void moveLeft(long time, int[][] matrix, int tam) {

        if (isValid(matrix, tam, x - vx, y)) {
            x -= (vx + 3);
            PosX = getMatrixPositionX(x, tam);
            currentAnimation = Player.LEFT;
            animations[Player.LEFT].update(time);
        }
    }

    public void moveUp(long time, int[][] matrix, int tam) {
        if (isValidUp(matrix, tam, x, y - vy)) {
            y -= (vy + 3);
            PosY = getMatrixPositionY(y, tam);
            currentAnimation = Player.UP;
            animations[Player.UP].update(time);
        }
    }

    public void moveDown(long time, int[][] matrix, int tam) {
        if (isValid(matrix, tam, x, y + vy + animations[currentAnimation].getImage().getHeight(null))) {
            y += (vy + 3);
            PosY = getMatrixPositionY(y, tam);
            currentAnimation = Player.DOWN;
            animations[Player.DOWN].update(time);
        }
    }

    public void CaidaLibre(int[][] matrix, int tam, long time) {
        if (matrix[getMatrixPositionY(y, tam)][getMatrixPositionX(x, tam)] != 3) {
            if (matrix[getMatrixPositionY(y + tam, tam)][getMatrixPositionX(x, tam)] == 6
                    || matrix[getMatrixPositionY(y + tam, tam)][getMatrixPositionX(x, tam)] == 5
                    || matrix[getMatrixPositionY(y + tam, tam)][getMatrixPositionX(x, tam)] == 0) {
                moveDown(time, matrix, tam);
            }
        }

    }

    public void draw(Graphics g) {
        g.drawImage(animations[currentAnimation].getImage(), x, y, null);
    }

    public void AutoMovimiento(int PosEneX, int PosEneY, int PosPlayerX, int PosPlayerY, long time, int[][] matrix, int tam) {

        int NodoMeta = MainFrame.graf.CaminoMin(PosEneX, PosEneY, PosPlayerX, PosPlayerY);
        if (NodoMeta > 0) {
            int MetaX = MainFrame.graf.MatrizUbiNodoActual[NodoMeta][0];
            int MetaY = MainFrame.graf.MatrizUbiNodoActual[NodoMeta][1];

            if (MetaY < PosEneY) {
                moveUp(time, matrix, tam);
                UltimoMove = 1;
            }
            if (MetaX > PosEneX) {
                moveRigth(time, matrix, tam);
                UltimoMove = 2;
            }
            if (MetaY > PosEneY) {
                moveDown(time, matrix, tam);
                UltimoMove = 3;
            }
            if (MetaX < PosEneX) {
                moveLeft(time, matrix, tam);
                UltimoMove = 4;
            }
            if (MetaX == PosEneX && MetaY == PosEneX) {
                switch (UltimoMove) {
                    case 1:
                        moveUp(time, matrix, tam);
                        break;
                    case 2:
                        moveRigth(time, matrix, tam);
                        break;
                    case 3:
                        moveDown(time, matrix, tam);
                        break;
                    case 4:
                        moveLeft(time, matrix, tam);
                        break;
                }
            }
            //System.out.println("Ultimoove" + Integer.toString(UltimoMove));
        } else {
            switch (UltimoMove) {
                case 1:
                    moveUp(time, matrix, tam);
                    break;
                case 2:
                    moveRigth(time, matrix, tam);
                    break;
                case 3:
                    moveDown(time, matrix, tam);
                    break;
                case 4:
                    moveLeft(time, matrix, tam);
                    break;
            }
        }

    }
}
