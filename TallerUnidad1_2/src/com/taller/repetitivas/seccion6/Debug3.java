package com.taller.repetitivas.seccion6;

public class Debug3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.println("Número impar detectado: " + i);
                continue;   // Error original: break abortaba el ciclo
            }
            System.out.println("Número par procesado: " + i);
        }
    }
}