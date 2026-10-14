package com.taller.repetitivas.seccion2;

import java.util.Scanner;

public class Ejercicio2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 0;
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizar Retiro");
            System.out.println("4. Salir del Sistema");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + saldo);
                    break;
                case 2:
                    System.out.print("Monto a depositar: ");
                    double deposito = sc.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito realizado. Nuevo saldo: $" + saldo);
                    } else {
                        System.out.println("Monto inválido.");
                    }
                    break;
                case 3:
                    System.out.print("Monto a retirar: ");
                    double retiro = sc.nextDouble();
                    if (retiro <= 0) {
                        System.out.println("Monto inválido.");
                    } else if (retiro > saldo) {
                        System.out.println("Fondos insuficientes.");
                    } else {
                        saldo -= retiro;
                        System.out.println("Retiro realizado. Nuevo saldo: $" + saldo);
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}