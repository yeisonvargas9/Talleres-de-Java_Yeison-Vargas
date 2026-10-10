package com.taller.practico;

public class Actividad1 {
    public static void main(String[] args) {
        int seg = 86400 % 3600;
        System.out.println("86400 % 3600 = " + seg);                  // 0

        int x = 7;
        int y = ++x + x++;
        System.out.println("y = " + y + ", x = " + x);                // y=16, x=9

        double div1 = 15 / 2;
        double div2 = 15.0 / 2;
        System.out.println("div1 = " + div1 + ", div2 = " + div2);    // 7.0 y 7.5

        x = 7;
        boolean flag = false;
        boolean res = flag && (++x > 0);
        System.out.println("res = " + res + ", x = " + x);            // false, x sigue en 7
    }
}