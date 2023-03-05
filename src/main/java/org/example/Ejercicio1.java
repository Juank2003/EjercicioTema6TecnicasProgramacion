package org.example;

import java.util.Scanner;

public class Ejercicio1 {

    public static double getMaximo(double a, double b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static String comparar(double a, double b) {
        if (a == b) {
            return "0";
        } else if (a > b) {
            return "1";
        } else {
            return "-1";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        double x = input.nextDouble();

        System.out.print("Introduce el segundo número: ");
        double y = input.nextDouble();

        double max = getMaximo(x, y);
        System.out.println("El número mayor entre " + x + " y " + y + " es: " + max);

        String comparison = comparar(x, y);
        if (comparison.equals("0")) {
            System.out.println("Los números " + x + " y " + y + " son iguales.");
        } else if (comparison.equals("1")) {
            System.out.println("El número " + x + " es mayor que el número " + y + ".");
        } else {
            System.out.println("El número " + y + " es mayor que el número " + x + ".");
        }
    }
}