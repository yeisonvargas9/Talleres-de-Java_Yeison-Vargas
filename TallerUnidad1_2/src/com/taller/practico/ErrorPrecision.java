package com.taller.practico;

public class ErrorPrecision {
    public static void main(String[] args) {
        int tareasCompletadas = 3;
        int tareasTotales = 4;
        // Error original: (3 / 4) era división entera y daba 0
        double porcentajeAvance = ((double) tareasCompletadas / tareasTotales) * 100;
        System.out.println("El porcentaje de avance es: " + porcentajeAvance + "%");
    }
}