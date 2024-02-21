package util;

import java.util.Scanner;

public class LeeDatos {
	
	public static int leerInt() {
		return new Scanner(System.in).nextInt();
	}
	public static int leerInt(String mensaje) {
		System.out.println(mensaje);
		return leerInt();
	}
}
