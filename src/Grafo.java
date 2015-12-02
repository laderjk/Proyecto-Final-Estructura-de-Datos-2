
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lader
 */
public class Grafo {

    int POSX_OUT;
    int POSY_OUT;
    
    int MatrizAdyActual[][];
    int MatrizUbiNodoActual[][];

    public Grafo(int[][] MatrizAdyActual, int[][] MatrizUbiNodoActual) {
        this.MatrizAdyActual = MatrizAdyActual;
        this.MatrizUbiNodoActual = MatrizUbiNodoActual;
    }

    static int MatrizAdyNivel1[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {4, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 2, 0, 0, 6, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 4, 6, 0, 3, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 3, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 5, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 10, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 10, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 10, 0, 1, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 10, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 2, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 9, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 2},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 6, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 6, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 6, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 4},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 4, 0}
    };

    static public int MatrizUbicacionNodosNivel1[][] = new int[][]{
        {1, 2}, {5, 2}, {9, 2}, {5, 4}, {11, 4}, {14, 4}, {20, 4}, {2, 6}, {5, 6}, {11, 6}, {15, 6},
        {20, 6}, {2, 8}, {5, 8}, {15, 8}, {5, 10}, {15, 10}, {2, 11}, {5, 11}, {15, 11}, {24, 11}, {2, 13},
        {8, 13}, {14, 13}, {20, 13}, {24, 13}
    };

    static int MatrizAdyNivel2[][] = new int[][]{{0, 6, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {6, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {2, 0, 0, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 2, 6, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 4, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 6, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 2, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 4, 0, 3, 4, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 5, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 1, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 4, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 4, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 2, 0, 0, 0, 0, 6, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 3, 0, 0, 3, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 6, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 6, 0, 0, 2, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 6, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 6, 0, 0, 4},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0}
    };

    static public int MatrizUbicacionNodosNivel2[][] = new int[][]{
        {1, 1}, {7, 1}, {1, 3}, {7, 3}, {1, 7}, {7, 7}, {7, 5}, {11, 5}, {14, 5}, {11, 1}, {19, 1},
        {20, 2}, {24, 2}, {19, 5}, {24, 5}, {11, 7}, {14, 7}, {20, 7}, {24, 7}, {1, 12}, {8, 10}, {8, 12}, {11, 10},
        {14, 10}, {20, 10}, {14, 12}, {20, 12}, {23, 10}, {24, 12}

    };

    public int HallarNodoCercano(int x, int y) {
        //Math.abs(MatrizUbicacionNodosNivel1[i][0] - x) < distancia
        int TamMatriz = MatrizUbiNodoActual.length;
        int VectorDistancias[] = new int[TamMatriz];
        int VectorNodos[] = new int[TamMatriz];
        int Candidatos = 0;
        int Nodo = -1234;//Si arroja -1 algo anda mal
        int distancia = 100000;
        for (int i = 0; i < TamMatriz; i++) {
            if (y == MatrizUbiNodoActual[i][1]) {
                VectorNodos[Candidatos] = i;
                VectorDistancias[Candidatos] = Math.abs(MatrizUbiNodoActual[i][0] - x);
                Candidatos++;
                if (Math.abs(MatrizUbiNodoActual[i][0] - x) == 0) {
                    Nodo = i;
                }
            }
        }
        for (int k = 0; k < TamMatriz; k++) {
            if (x == MatrizUbiNodoActual[k][0]) {
                VectorNodos[Candidatos] = k;
                VectorDistancias[Candidatos] = Math.abs(MatrizUbiNodoActual[k][1] - y);
                Candidatos++;
                if (Math.abs(MatrizUbiNodoActual[k][1] - y) == 0) {
                    Nodo = k;
                }
            }
        }

        for (int i = 0; i < Candidatos - 1; i++) {
            if (VectorDistancias[i] < distancia) {
                distancia = VectorDistancias[i];
                Nodo = VectorNodos[i];
            }
        }

        for (int i = 0; i < TamMatriz; i++) {
            if (MatrizUbiNodoActual[i][0] == x && MatrizUbiNodoActual[i][1] == y) {
                //System.out.println("Nojoda" + x + "Nojoda" + y);
                Nodo = i;
            }
        }

        return Nodo;
    }

    int Dijsktra(int NodoIni, int NodoFin, int Matriz[][], int Nombres[][]) {
        
        int TamMatriz = MatrizUbiNodoActual.length;
        int VectorCamino[] = new int[TamMatriz];
        int PesoFinal = 0;
        int PasosCamino = 0;
        int Anterior = NodoIni;
        boolean VectorMarcados[] = new boolean[TamMatriz];
        int VectorTagName[] = new int[TamMatriz];
        int VectorTagPeso[] = new int[TamMatriz];
        int menor;
        int Candidato_Menor;
        int NumeroCandidatos = 0;

        for (int i = 0; i < TamMatriz; i++) {
            VectorMarcados[i] = false;
            VectorTagName[i] = 999999999;
            VectorTagPeso[i] = 999999999;
            VectorCamino[i] = 0;
        }

        VectorMarcados[Anterior] = true;
        VectorTagName[Anterior] = -1;

        for (int j = 0; j < TamMatriz; j++) {
            for (int i = 0; i < TamMatriz; i++) {
                if (VectorMarcados[i] == false) {
                    //VerificarPesoFinal
                    int Proximo = i;
                    int Ant = Anterior;
                    int Temp;
                    PesoFinal = 0;
                    while (Ant != -1) {
                        PesoFinal += Matriz[Ant][Proximo];
                        Temp = VectorTagName[Ant];
                        Proximo = Ant;
                        Ant = Temp;
                    }
                    if (Matriz[Anterior][i] != 0) {
                        if (VectorTagPeso[i] > PesoFinal) {
                            VectorTagPeso[i] = PesoFinal;
                            VectorTagName[i] = Anterior;
                            NumeroCandidatos++;
                        }
                    }
                }
            }
            menor = 9999;
            Candidato_Menor = 9999;
            for (int k = 0; k < TamMatriz ;k++) {
                if (VectorMarcados[k] == false) {
                    if (VectorTagPeso[k] < menor) {
                        menor = VectorTagPeso[k];
                        Candidato_Menor = k;
                    }
                }
            }
            if (Candidato_Menor != 9999) {
                VectorMarcados[Candidato_Menor] = true;
                Anterior = Candidato_Menor;
            }
        }

        //Organizar Camino
        int Nodo = NodoFin;
        VectorCamino[PasosCamino] = NodoFin;
        PasosCamino++;

        while (VectorTagName[Nodo] != NodoIni) {
            VectorCamino[PasosCamino] = VectorTagName[Nodo];
            Nodo = VectorTagName[Nodo];
            PasosCamino++;
            if (Nodo == -1) {
                return -2;
            }
        }

        //System.out.println("" + Arrays.toString(VectorCamino));
        if (PasosCamino == 0) {
            return -1;
        } else {
            return VectorCamino[PasosCamino - 1];
        }

    }

    public int CaminoMin(int XIn, int YIn, int XOUT, int YOUT) {
        int NodoCercanoLlegada = HallarNodoCercano(XOUT, YOUT);
        int NodoCercanoEntrada = HallarNodoCercano(XIn, YIn);
        if (NodoCercanoEntrada != -1234 && NodoCercanoLlegada != -1234) {
            return Dijsktra(NodoCercanoEntrada, NodoCercanoLlegada, MatrizAdyActual, MatrizUbiNodoActual);
        } else {
            return -12;
        }

    }

}
