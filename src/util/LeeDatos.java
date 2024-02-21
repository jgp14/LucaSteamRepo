package util;

import java.util.Scanner;

public class LeeDatos {
	public static String leeString() {
		Scanner lector = new Scanner(System.in);
		return lector.nextLine();
	}

	public static int leeInt() {
		Scanner lector = new Scanner(System.in);
		return lector.nextInt();
	}
}
