package com.taller.practico;

public class Actividad4 {
    public static void main(String[] args) {
        calcularFactura(3, "VIP", "PROMO1 año");    // esperado 638.00
        calcularFactura(1, "NUEVO", "PROMO1 año");  // esperado 275.50
    }

    static void calcularFactura(int cantidad, String tipoCliente, String cupon) {
        double subtotal = cantidad * 250.00;

        double porcentaje = switch (tipoCliente) {
            case "VIP" -> 0.20;
            case "REGULAR" -> 0.10;
            case "NUEVO" -> 0.05;
            default -> 0.0;
        };
        double subtotalConDescuento = subtotal - (subtotal * porcentaje);

        double descuentoCupon = 0.0;
        if (cupon.equals("PROMO1 año") && subtotalConDescuento >= 500.00) {
            descuentoCupon = 50.00;
        }

        double baseImponible = subtotalConDescuento - descuentoCupon;
        double iva = baseImponible * 0.16;
        double total = baseImponible + iva;

        System.out.printf("Cantidad: %d | Cliente: %s%n", cantidad, tipoCliente);
        System.out.printf("Subtotal: %.2f | Con descuento: %.2f | Cupón: %.2f%n",
                subtotal, subtotalConDescuento, descuentoCupon);
        System.out.printf("Base: %.2f | IVA: %.2f | Total a pagar = $%.2f%n%n",
                baseImponible, iva, total);
    }
}