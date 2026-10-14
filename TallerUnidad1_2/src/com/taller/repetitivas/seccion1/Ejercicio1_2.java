package com.taller.repetitivas.seccion1;

import java.util.Scanner;

public class Ejercicio1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double LIMITE = 1_000_000;
        double acumulador = 0;
        boolean procesando = true;
        String causa = "";

        while (procesando) {
            System.out.print("Ingrese el monto de la transacción: ");
            double monto = sc.nextDouble();

            if (monto < 0) {
                causa = "Monto negativo (no válido)";
                procesando = false;
            } else {
                acumulador += monto;
                if (acumulador > LIMITE) {
                    causa = "Se superó el límite de $1'000.000";
                    procesando = false;
                }
            }
        }

        System.out.println("--- Informe ---");
        System.out.println("Saldo final acumulado: $" + acumulador);
        System.out.println("Causa de finalización: " + causa);
        sc.close();
    }
}