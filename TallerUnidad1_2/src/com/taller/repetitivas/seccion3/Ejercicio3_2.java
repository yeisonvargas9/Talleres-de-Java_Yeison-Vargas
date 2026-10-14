package com.taller.repetitivas.seccion3;

import java.util.Scanner;

public class Ejercicio3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Ingrese un entero positivo N (máximo 20): ");
            n = sc.nextInt();
        } while (n < 1 || n > 20);   // long solo soporta hasta 20!

        // Parte A: factorial
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        System.out.println(n + "! = " + factorial);

        // Parte B: triángulo
        System.out.println("\nTriángulo de altura " + n + ":");
        for (int fila = 1; fila <= n; fila++) {
            for (int j = 1; j <= fila; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        sc.close();
    }
}