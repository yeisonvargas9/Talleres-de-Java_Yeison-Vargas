package com.taller.repetitivas.seccion4 ;

public class Ejercicio4_2 {
    public static void main(String[] args) {
        System.out.println("Pares no múltiplos de 5 entre 1 y 50:");
        for (int i = 1; i <= 50; i++) {
            if (i % 2 != 0) {
                continue;   // omite impares
            }
            if (i % 5 == 0) {
                continue;   // omite múltiplos de 5
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }
}