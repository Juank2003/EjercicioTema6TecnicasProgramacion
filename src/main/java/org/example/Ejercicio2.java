package org.example;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {

    private static char[][] tablero = new char[4][4];
    private static int filaBarco;
    private static int columnaBarco;

    public static void main(String[] args) {

        inicializarTablero();
        mostrarTablero();

        while (!disparar()) {
            mostrarTablero();
        }

        System.out.println("¡Has ganado!");
    }

    private static void inicializarTablero() {
        Random random = new Random();
        filaBarco = random.nextInt(4);
        columnaBarco = random.nextInt(4);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tablero[i][j] = '?';
            }
        }
    }

    private static void mostrarTablero() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

    private static int introducirEnteroEntreLimites(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int num;

        do {
            System.out.printf("Introduce un número entre %d y %d: ", min, max);
            num = scanner.nextInt();
        } while (num < min || num > max);

        return num;
    }

    private static boolean disparar() {
        System.out.print("¿Qué fila? ");
        int fila = introducirEnteroEntreLimites(1, 4) - 1;

        System.out.print("¿Qué columna? ");
        int columna = introducirEnteroEntreLimites(1, 4) - 1;

        if (fila == filaBarco && columna == columnaBarco) {
            System.out.println("Tocado y hundido");
            tablero[fila][columna] = '~';
            return true;
        } else {
            System.out.println("Agua");
            tablero[fila][columna] = '-';
            return false;
        }
    }
}
