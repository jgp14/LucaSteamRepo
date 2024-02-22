package com.lucatic.bluedevteam.excepciones;


/**
 * Clase de error que representa un error de la lecutra del fichero csv
 *
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 22-02-2024
 */
public class CsvException extends JuegoException {

	/**
	 * Constructor con mensaje de error
	 * @param msg mensaje de error
	 */
	public CsvException(String msg) {
		super(msg);
	}

	/**
	 * Constructor con texto de error y el tipo e
	 * @param msg Mensaje de error
	 * @param e Objeto de error e
	 */
	public CsvException(String msg, Throwable e) {
		super(msg, e);
	}

}
