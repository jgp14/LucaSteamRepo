package com.lucatic.bluedevteam.pruebas;

import com.lucatic.bluedevteam.excepciones.CsvException;
import com.lucatic.bluedevteam.excepciones.JuegoException;
import org.junit.jupiter.api.Test;
import com.lucatic.bluedevteam.servicios.JuegosServicio;
import com.lucatic.bluedevteam.servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test para listar por plataforma
 *
 * @since 22/02/2024
 * @author BlueDevTeam
 * @version 1.0.0
 */
class ListarPorPlataformaTest {

	/**
	 * Instanciar el servicio
	 */
	private JuegosServicio juegosServicio;

	/**
	 * Método que carga los datos de los juegos
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
	 * Este método no carga los datos de los juegos
	 */
	public void noCargar() {
		juegosServicio = new JuegosServicioImpl();
	}

	/**
	 * Test para listar por plataforma nula
	 */
	@Test
	void listarPorPlataformaNull() {

		cargarDatos();
		assertThrows(JuegoException.class, () -> juegosServicio.listarPorPlataforma(null));
	}

	/**
	 * Test para listar por plataforma no existente
	 */
	@Test
	void listarPorPlataformaInexistente() {

		cargarDatos();
		assertThrows(JuegoException.class, () -> juegosServicio.listarPorPlataforma("AAAA"));
	}

	/**
	 * Test para listar por plataforma existente
	 */
	@Test
	void listarPorPlataformaExistente() {

		cargarDatos();
		assertDoesNotThrow(() -> juegosServicio.listarPorPlataforma("DC"));
	}

	/**
	 * Test para listar por plataforma si el String de tipo de plataforma está vacía
	 */
	@Test
	void listarPorPlataformaStrVacio() {

		cargarDatos();
		assertThrows(JuegoException.class, () -> juegosServicio.listarPorPlataforma(""));
	}

	/**
	 * Test para listar por plataforma sin cargar datos
	 */
	@Test
	public void listarPorPlataformaSinCargar() {

		noCargar();
		assertEquals(juegosServicio.getListaPlataformas().sizePlataformas(), 0);
	}
}