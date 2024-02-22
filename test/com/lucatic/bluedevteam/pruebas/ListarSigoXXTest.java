package com.lucatic.bluedevteam.pruebas;

import com.lucatic.bluedevteam.excepciones.CsvException;
import com.lucatic.bluedevteam.excepciones.JuegoException;
import org.junit.jupiter.api.Test;
import com.lucatic.bluedevteam.servicios.JuegosServicio;
import com.lucatic.bluedevteam.servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test para comprobar juegos siglo xx
 *
 * @since 22/02/2024
 * @author BlueDevTeam
 * @version 1.0.0
 */
public class ListarSigoXXTest {

	/**
	 * Instanciar servicio
	 */
	private JuegosServicio juegosServicio;

	/**
	 * Cargar datos
	 */
	public void cargarDatos() {

		try {
			juegosServicio = new JuegosServicioImpl();
			juegosServicio.cargarDatos("vgsales.csv");
		} catch (CsvException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * no carga datos
	 */
	public void noCargar() {

		juegosServicio = new JuegosServicioImpl();
	}

	/**
	 * Test para listar juegos siglo xx sin cargar datos
	 */
	@Test
	public void ListarSigloXXSinCargar() {

		noCargar();
		assertThrows(JuegoException.class, () -> juegosServicio.listarPorSigloXX());

	}

	/**
	 * Test para listar juegos siglo xx cargando datos
	 */
	@Test
	public void listarSigloXXCargando() {

		try {
			cargarDatos();
			assertFalse(juegosServicio.listarPorSigloXX().isEmpty());
		} catch (JuegoException e) {
			throw new RuntimeException(e);
		}
	}
}