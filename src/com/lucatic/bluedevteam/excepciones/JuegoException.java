package com.lucatic.bluedevteam.excepciones;

/**
 * Clase personalizada JuegoException que hereda de Exception usada en la todo
 * el proyecto del programa de administracion de guegos para gestionar las
 * excecciones hasta el controlador
 * 
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 22-02-2024
 */
public class JuegoException extends Exception {

	public JuegoException(String msg) {
		super(msg);
	}

	public JuegoException(String msg, Throwable e) {
		super(msg, e);
	}

}
