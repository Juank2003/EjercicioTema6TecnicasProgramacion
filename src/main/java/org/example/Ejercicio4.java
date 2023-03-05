package org.example;
import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args) {
        int tamTablero = 6;
        int[][] tablero = new int[tamTablero][tamTablero];
        int[] posJugadores = {0, tamTablero-1};
        int turno = 1;
        boolean juegoTerminado = false;

        inicializarTablero(tablero, posJugadores);

        while(!juegoTerminado){
            imprimirTablero(tablero);
            int movimiento = pedirMovimiento(turno);
            int[] nuevaPosicion = moverOveja(movimiento, posJugadores[turno-1], tablero);

            if(nuevaPosicion[0] == posJugadores[turno-1]){
                System.out.println("Movimiento no válido");
                continue;
            }

            tablero[posJugadores[turno-1]][turno == 1 ? 0 : tamTablero-1] = 0;
            posJugadores[turno-1] = nuevaPosicion[0];
            tablero[posJugadores[turno-1]][turno == 1 ? 0 : tamTablero-1] = turno;

            if(posJugadores[turno-1] == (turno == 1 ? tamTablero-1 : 0)){
                System.out.println("Jugador " + turno + " ha ganado");
                juegoTerminado = true;
                imprimirTablero(tablero);
                break;
            }
            turno = turno == 1 ? 2 : 1;
        }

    }

    public static void inicializarTablero(int[][] tablero, int[] posJugadores){
        tablero[posJugadores[0]][0] = 1;
        tablero[posJugadores[1]][tablero.length-1] = 2;
    }

    public static void imprimirTablero(int[][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int pedirMovimiento(int turno){
        Scanner sc = new Scanner(System.in);
        System.out.println("Jugador " + turno + " introduce movimiento: ");
        int movimiento = sc.nextInt();
        return movimiento;
    }

    public static int[] moverOveja(int movimiento, int posicion, int[][] tablero){
        int[] nuevaPosicion = {posicion, 0};
        switch(movimiento){
            case 1:
                if(posicion == 0){
                    System.out.println("Movimiento no válido");
                    break;
                }
                if(tablero[posicion-1][0] == 0){
                    nuevaPosicion[0] = posicion-1;
                }else{
                    System.out.println("Movimiento no válido");
                }
                break;
            case 2:
                if(posicion == tablero.length-1){
                    System.out.println("Movimiento no válido");
                    break;
                }
                if(tablero[posicion+1][0] == 0){
                    nuevaPosicion[0] = posicion+1;
                }else{
                    System.out.println("Movimiento no válido");
                }
                break;
            case 3:
                if(posicion == 0){
                    System.out.println("Movimiento no válido");
                    break;
                }
                if(tablero[posicion-1][0] == 0){
                    nuevaPosicion[0] = posicion-1;
                    nuevaPosicion[1] = 1;
                }else{
                    System.out.println("Movimiento no válido");
                }
                break;
            case 4:
                if(posicion == tablero.length-1){
                    System.out.println("Movimiento no válido");
                    break;
                }
                if(tablero[posicion+1][0] == 0){
                    nuevaPosicion[0] = posicion+1;
                    nuevaPosicion[1] = 1;
                }else{
                    System.out.println("Movimiento no válido");
                }
                break;
            default:
                System.out.println("Movimiento no válido");
                break;
        }
        return nuevaPosicion;
    }

}