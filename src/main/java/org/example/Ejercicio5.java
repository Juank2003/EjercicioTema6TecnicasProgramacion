package org.example;

import java.util.Scanner;

public class Ejercicio5 {
    private static char[][] canvas = new char[10][40];

    private static void printCanvas() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 40; j++) {
                System.out.print(canvas[i][j] == '\u0000' ? "*" : canvas[i][j]);
            }
            System.out.println();
        }
    }

    private static void drawChar() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el carácter a dibujar: ");
        char c = input.next().charAt(0);
        System.out.println("Ingrese la fila y la columna (separadas por un espacio): ");
        int row = input.nextInt();
        int col = input.nextInt();
        canvas[row][col] = c;
        printCanvas();
    }

    private static void drawRectangle() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el carácter a dibujar: ");
        char c = input.next().charAt(0);
        System.out.println("Ingrese la fila y la columna del primer vértice (separadas por un espacio): ");
        int row1 = input.nextInt();
        int col1 = input.nextInt();
        System.out.println("Ingrese la fila y la columna del segundo vértice (separadas por un espacio): ");
        int row2 = input.nextInt();
        int col2 = input.nextInt();
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                canvas[i][j] = c;
            }
        }
        printCanvas();
    }

    private static void paintBucket() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el carácter a usar como bote de pintura: ");
        char c = input.next().charAt(0);
        System.out.println("Ingrese la fila y la columna donde empezar a pintar (separadas por un espacio): ");
        int row = input.nextInt();
        int col = input.nextInt();
        char target = canvas[row][col];
        paint(row, col, target, c);
        printCanvas();
    }

    private static void paint(int row, int col, char target, char replacement) {
        if (row < 0 || row >= 10 || col < 0 || col >= 40) {
            return;
        }
        if (canvas[row][col] != target) {
            return;
        }
        canvas[row][col] = replacement;
        paint(row-1, col, target, replacement);
        paint(row+1, col, target, replacement);
        paint(row, col-1, target, replacement);
        paint(row, col+1, target, replacement);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 40; j++) {
                canvas[i][j] = ' ';
            }
        }
        printCanvas();
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Ingrese la opción deseada: ");
            System.out.println("1. Dibujar un carácter");
            System.out.println("2. Dibujar un rectángulo");
            System.out.println("3. Usar un bote de pintura");
            System.out.println("0. Salir");
            int option = input.nextInt();
            if (option == 0) {
                break;
            }
            switch (option) {
                case 1:
                    drawChar();
                    break;
                case 2:
                    drawRectangle();
                    break;
                case 3:
                    paintBucket();
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}