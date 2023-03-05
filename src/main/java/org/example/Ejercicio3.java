package org.example;

import java.util.Random;

public class Ejercicio3 {

    public static void main(String[] args) {
        int[] tabla = crearTabla(10, 1, 100);
        System.out.print("Tabla generada: ");
        for (int i = 0; i < tabla.length; i++) {
            System.out.print(tabla[i] + " ");
        }
        System.out.println();
        int mayorValor = obtenerMayor(tabla);
        System.out.println("El mayor valor en la tabla es: " + mayorValor);
    }

    public static int[] crearTabla(int dimension, int minimo, int maximo) {
        Random random = new Random();
        int[] tabla = new int[dimension];
        for (int i = 0; i < dimension; i++) {
            tabla[i] = random.nextInt(maximo - minimo + 1) + minimo;
        }
        return tabla;
    }

    public static int obtenerMayor(int[] tabla) {
        int mayor = tabla[0];
        for (int i = 1; i < tabla.length; i++) {
            if (tabla[i] > mayor) {
                mayor = tabla[i];
            }
        }
        return mayor;
    }
}
