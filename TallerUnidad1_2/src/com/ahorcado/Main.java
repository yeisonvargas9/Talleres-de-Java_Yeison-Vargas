package com.educacion.ahorcado;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static final int MAX_INTENTOS = 6;
    static final String[] PALABRAS = {"JAVA", "BUCLE", "CADENA", "VARIABLE", "COMPILADOR", "OBJETO"};

    static Scanner sc = new Scanner(System.in);

    // Estadísticas de la sesión
    static int partidasJugadas = 0;
    static int partidasGanadas = 0;
    static double puntajeTotal = 0.0;

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== AHORCADO DE CONSOLA ===");
            System.out.println("1. Jugar");
            System.out.println("2. Ver Estadísticas");
            System.out.println("3. Salir");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    jugar();
                    break;
                case 2:
                    verEstadisticas();
                    break;
                case 3:
                    System.out.println("¡Hasta pronto!");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }

    // Lee la opción del menú validando con while + Integer.parseInt
    static int leerOpcion() {
        int opcion = 0;
        boolean valida = false;
        while (!valida) {
            System.out.print("Seleccione una opción (1-3): ");
            String linea = sc.nextLine().trim();
            try {
                opcion = Integer.parseInt(linea);
                if (opcion >= 1 && opcion <= 3) {
                    valida = true;
                } else {
                    System.out.println("Error: la opción debe ser 1, 2 o 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese solo números (1, 2 o 3).");
            }
        }
        return opcion;
    }

    // Pide el nombre y lo normaliza con trim() y toUpperCase()
    static String leerNombre() {
        String nombre = "";
        while (nombre.length() == 0) {
            System.out.print("Ingrese su nombre: ");
            nombre = sc.nextLine().trim().toUpperCase();
            if (nombre.length() == 0) {
                System.out.println("Error: el nombre no puede estar vacío.");
            }
        }
        return nombre;
    }

    static void jugar() {
        String nombreJugador = leerNombre();
        String palabraSecreta = PALABRAS[new Random().nextInt(PALABRAS.length)];

        int intentosRestantes = MAX_INTENTOS;
        double puntaje = 0.0;
        boolean juegoGanado = false;
        char ultimaLetra = ' ';
        int aciertos = 0;
        int fallos = 0;

        // Máscara oculta: "_ _ _ _"
        StringBuilder mascara = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            mascara.append('_');
            if (i < palabraSecreta.length() - 1) {
                mascara.append(' ');
            }
        }
        StringBuilder historial = new StringBuilder();

        System.out.println("\n¡Hola, " + nombreJugador + "! Adivina la palabra secreta.");
        System.out.println("(Escribe RENDIRSE para abandonar la partida)");

        while (intentosRestantes > 0 && !juegoGanado) {
            System.out.println("\nPalabra: " + mascara);
            System.out.println("Letras usadas: " + (historial.length() == 0 ? "-" : historial));
            System.out.println("Intentos restantes: " + intentosRestantes + " / " + MAX_INTENTOS);
            System.out.print("Ingrese una letra: ");
            String entrada = sc.nextLine().trim();

            if (entrada.length() == 0) {
                System.out.println("Debe ingresar una letra.");
                continue;
            }
            if (entrada.equalsIgnoreCase("RENDIRSE")) {
                System.out.println("Te has rendido.");
                break;
            }

            ultimaLetra = Character.toUpperCase(entrada.charAt(0));
            if (!Character.isLetter(ultimaLetra)) {
                System.out.println("Carácter inválido: ingrese solo letras.");
                continue;
            }
            if (historial.indexOf(String.valueOf(ultimaLetra)) >= 0) {
                System.out.println("Ya habías usado la letra " + ultimaLetra + ".");
                continue;
            }
            historial.append(ultimaLetra).append(' ');

            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (String.valueOf(palabraSecreta.charAt(i)).equalsIgnoreCase(String.valueOf(ultimaLetra))) {
                    mascara.setCharAt(i * 2, ultimaLetra);
                    acierto = true;
                }
            }

            if (acierto) {
                aciertos++;
            } else {
                fallos++;
                intentosRestantes--;
            }
            System.out.println(acierto ? "¡Bien! La letra " + ultimaLetra + " está en la palabra."
                    : "Fallaste: la letra " + ultimaLetra + " no está en la palabra.");

            if (mascara.indexOf("_") < 0) {
                juegoGanado = true;
                break;
            }
        }

        // Puntaje: 100 por ganar + 12.5 por cada intento que sobró
        if (juegoGanado) {
            puntaje = 100.0 + intentosRestantes * 12.5;
            partidasGanadas++;
        }
        partidasJugadas++;
        puntajeTotal += puntaje;

        int totalIntentos = aciertos + fallos;
        double porcentajeAciertos = totalIntentos == 0 ? 0.0 : (double) aciertos / totalIntentos * 100;

        // Resumen con printf
        System.out.println("\n====================================================");
        System.out.println("RESUMEN DE LA PARTIDA");
        System.out.println("====================================================");
        System.out.printf("Jugador: %s%n", nombreJugador);
        System.out.printf("Estado Final: %s%n", juegoGanado ? "¡VICTORIA!" : "DERROTA");
        System.out.printf("Palabra Secreta: %s%n", palabraSecreta);
        System.out.printf("Intentos Restantes: %d / %d%n", intentosRestantes, MAX_INTENTOS);
        System.out.printf("Porcentaje Aciertos: %.2f%%%n", porcentajeAciertos);
        System.out.printf("Puntaje Final: %.2f pts%n", puntaje);
        System.out.println("====================================================");
    }

    static void verEstadisticas() {
        System.out.println("\n--- ESTADÍSTICAS DE LA SESIÓN ---");
        System.out.printf("Partidas jugadas: %d%n", partidasJugadas);
        System.out.printf("Partidas ganadas: %d%n", partidasGanadas);
        System.out.printf("Puntaje acumulado: %.2f pts%n", puntajeTotal);
    }
}