package com.lucatic.bluedevteam.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LeeDatos {

    public static String leerString() {
        Scanner lector = new Scanner(System.in);
        return lector.nextLine();
    }

    public static String leerString(String mensaje) {
        System.out.println(mensaje);
        return leerString();
    }

    public static int leerInt() throws InputMismatchException {
        return new Scanner(System.in).nextInt();
    }

    public static int leerInt(String mensaje) throws InputMismatchException {
        System.out.println(mensaje);
        return leerInt();
    }

}
