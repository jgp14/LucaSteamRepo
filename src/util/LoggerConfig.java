package com.lucatic.ruben.utilidades;

import java.io.IOException;
import java.util.logging.*;

/**
 * Clase de configuracion del logger de Java
 *
 * @author Rubén Grueso Vega
 * @version 1.0
 */
public class LoggerConfig {

	public static void configureLogger(Logger logger) {

		try {
			FileHandler fileHandler = new FileHandler("juegosfile.log", true);
			ConsoleHandler consoleHandler = new ConsoleHandler();
			SimpleFormatter simpleFormatter = new SimpleFormatter();

			fileHandler.setFormatter(simpleFormatter);
			consoleHandler.setFormatter(simpleFormatter);

			// Desactivar la propagación a los loggers superiores
			logger.setUseParentHandlers(false);

			logger.addHandler(fileHandler);
			logger.addHandler(consoleHandler);

			logger.setLevel(Level.ALL);
			consoleHandler.setLevel(Level.ALL);
			fileHandler.setLevel(Level.ALL);
		} catch (Exception e) {
			System.err.println("Error al configurar el logger");
		}
	}
}

