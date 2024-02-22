package com.lucatic.bluedevteam.pruebas;

import com.lucatic.bluedevteam.excepciones.CsvException;
import com.lucatic.bluedevteam.excepciones.JuegoException;
import com.lucatic.bluedevteam.model.TipoGenero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.lucatic.bluedevteam.servicios.JuegosServicio;
import com.lucatic.bluedevteam.servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test para listar por genero
 *
 * @since 22/02/2024
 * @author BlueDevTeam
 * @version 1.0.0
 */
class ListarPorGeneroTest {

	/**
	 * instanciar servicio
	 */
	private JuegosServicio servicio;

	/**
	 * Carga inicial
	 */
	@BeforeEach
	void inicio() {
		servicio = new JuegosServicioImpl();

		try {
			servicio.cargarDatos("vgsales.csv");
		} catch (CsvException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * TEst para listar por género nulo
	 */
	@Test
	public void listarPorGeneroNull() {
		assertThrows(JuegoException.class, () -> servicio.listarPorGenero(null), "Lista por genero con null");
	}

	/**
	 * Test para listar por genero no nulo
	 */
	@Test
	public void listarPorGeneroNotNull() {
		assertDoesNotThrow(() -> servicio.listarPorGenero(TipoGenero.PLATFORM), "Listar por genero sin not null");
	}

	/**
	 * Test para listar por genero que no existe
	 */
	@Test
	public void listarPorGeneroNoExiste() {
		assertThrows(IllegalArgumentException.class, () -> servicio.listarPorGenero(TipoGenero.valueOf("prueba")),
				"Listar por tipo enumerado que no existe");
	}
}