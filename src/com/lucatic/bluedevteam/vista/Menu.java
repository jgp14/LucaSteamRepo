package com.lucatic.bluedevteam.vista;

/**
 * Clase menu que dispone de un metodo statico 
 * que muestra por consola una lista de opciones
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 22-02-2024
 */
public class Menu {

	/**
	 * Muestra por consola un menu indexado de opciones para que 
	 * el usuario pueda introducir la opcion que desee.
	 */
	public static void mostrarMenu() {
		System.out.println(" ");
		System.out.println("ADMINISTRACION JUEGOS");
		System.out.println(" ");
		System.out.println("****************************");
		System.out.println("Escoge una opcion: ");
		System.out.println("1-Cargar Datos: ");
		System.out.println("2-Alta de juego: ");
		System.out.println("3-Listado de juegos: ");
		System.out.println("4-Listado de editores (Publisher): ");
		System.out.println("5-Listado de juegos (filtrado por plataforma): ");
		System.out.println("6-Listado de juegos filtrado por género 'Plataforma'");
		System.out.println("7-Listado de juegos filtrado por siglo XX");
		System.out.println("8-Listado de juegos filtrado por género: ");
		System.out.println("9-Listado de juegos de años pares: ");
		System.out.println("0-Finalizar sesion.");
		System.out.println("Gestion:");
	}

}
