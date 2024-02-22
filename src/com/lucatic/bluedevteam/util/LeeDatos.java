package com.lucatic.bluedevteam.util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase de utilidades para leer datos introducidos por teclado desde la
 * consola.
 * 
 * @since 22/02/2024
 * @author BlueDevTeam
 * @version 1.0.0
 */

public class LeeDatos {

	/**
	 * Lee una linea de texto desde la consola
	 *
	 * @return la línea de texto leída.
	 */
	public static String leerString() {
		Scanner lector = new Scanner(System.in);
		return lector.nextLine();
	}

	/**
	 * Lee una línea de texto desde la consola con un mensaje
	 *
	 * @param mensaje El mensaje a mostrar por consola
	 * @return el string
	 */
	public static String leerString(String mensaje) {
		System.out.println(mensaje);
		return leerString();
	}

	/**
	 * Lee un número entero desde la consola.
	 *
	 * @return El número entero
	 * @throws InputMismatchException si el tipo de dato de entrada es diferente al esperado.
	 */
	public static int leerInt() throws InputMismatchException {
		return new Scanner(System.in).nextInt();
	}

	/**
	 * Lee un número entero desde la consola con un mensaje
	 *
	 * @param mensaje mensaje a mostrar antes de la entrada.
	 * @return El número entero que hemos ingresado
	 * @throws InputMismatchException si el tipo de dato de entrada es diferente al esperado.
	 */
	public static int leerInt(String mensaje) throws InputMismatchException {
		System.out.println(mensaje);
		return leerInt();
	}

}
