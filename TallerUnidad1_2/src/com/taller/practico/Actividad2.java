package com.taller.practico;

public class Actividad2 {
    public static void main(String[] args) {
        // Reto 1: edades
        int edadUsuario = 28;
        if (edadUsuario < 12) {
            System.out.println("Infante - requiere tutor de cuenta");
        } else if (edadUsuario <= 17) {
            System.out.println("Adolescente - acceso restringido a foros comunitarios");
        } else if (edadUsuario <= 64) {
            System.out.println("Adulto - acceso a funcionalidades estándar");
        } else {
            System.out.println("Adulto Mayor - acceso con interfaz adaptada");
        }

        // Reto 2: notas y asistencia
        double calificacionFinal = 65.0;
        int porcentajeAsistencia = 75;
        boolean entregoProyectoFinal = true;
        if (calificacionFinal >= 70.0 && porcentajeAsistencia >= 80) {
            System.out.println("Estado: Aprobado");
        } else if (entregoProyectoFinal && calificacionFinal >= 60.0) {
            System.out.println("Estado: Pendiente de Examen Extraordinario");
        } else {
            System.out.println("Estado: Reprobado");
        }

        // Reto 3: tarifas
        String tipoEntrada = "ESTUDIANTE";
        double precioBase = 100.0;
        double precioFinal;
        if (tipoEntrada.equals("VIP")) {
            precioFinal = precioBase * 1.10;
        } else if (tipoEntrada.equals("ESTUDIANTE")) {
            precioFinal = precioBase * 0.50;
        } else if (tipoEntrada.equals("ADULTO_MAYOR")) {
            precioFinal = precioBase * 0.60;
        } else {
            precioFinal = precioBase;
        }
        System.out.println("Entrada " + tipoEntrada + " - Total a pagar: $" + precioFinal);

        // Refactorización a ternario
        boolean cookieSesionActiva = true;
        String estadoConexion = cookieSesionActiva ? "ACTIVA" : "INACTIVA";
        System.out.println("Estado de conexión: " + estadoConexion);
    }
}