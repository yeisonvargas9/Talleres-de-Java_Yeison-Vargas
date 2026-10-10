package com.taller.practico;

public class Actividad3 {
    public static void main(String[] args) {
        int dia = 6;

        // Versión 1: tradicional
        String jornada1;
        switch (dia) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                jornada1 = "Jornada laboral";
                break;
            case 6:
                jornada1 = "Medio día / sábado";
                break;
            case 7:
                jornada1 = "Descanso (domingo)";
                break;
            default:
                jornada1 = "Día inválido";
        }
        System.out.println("Tradicional: día " + dia + " -> " + jornada1);

        // Versión 2: moderna con flecha
        final String jornada2 = switch (dia) {
            case 1, 2, 3, 4, 5 -> "Jornada laboral";
            case 6 -> "Medio día / sábado";
            case 7 -> "Descanso (domingo)";
            default -> "Día inválido";
        };
        System.out.println("Moderno: día " + dia + " -> " + jornada2);
    }
}