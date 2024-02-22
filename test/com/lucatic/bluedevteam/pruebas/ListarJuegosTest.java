package com.lucatic.bluedevteam.pruebas;


import com.lucatic.bluedevteam.excepciones.JuegoException;
import com.lucatic.bluedevteam.model.Juego;
import org.junit.jupiter.api.Test;
import com.lucatic.bluedevteam.servicios.JuegosServicio;
import com.lucatic.bluedevteam.servicios.JuegosServicioImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la gestin de editores
 *
 * @since 22/02/2024
 * @author BlueDevTeam
 * @version 1.0.0
 */
public class ListarJuegosTest {

	/**
	 * Atributo que genera el objeto que permite ejecutar pruebas
	 */
	private final JuegosServicio servicio = new JuegosServicioImpl();

	/**
	 * Test que comprueba si al no cargar datos se ejecuta una excepcion
	 */
	@Test
	public void listarJuegosSinCargarDatos() {
		assertThrows(JuegoException.class, () -> servicio.listarJuegos());
	}

	/**
	 * Test que comprueba que tras cargar datos no ejecuta ningun problema
	 */
	@Test
	public void listarJuegosCargarDatos() {

		List<Juego> juegos;
		try {
			servicio.cargarDatos("vgsales.csv");
			juegos = servicio.listarJuegos();
			assertFalse(juegos.isEmpty());
		} catch (JuegoException e) {
			throw new RuntimeException(e);
		}

	}
}