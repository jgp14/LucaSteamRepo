package com.lucatic.bluedevteam.pruebas;

import com.lucatic.bluedevteam.excepciones.CsvException;
import org.junit.jupiter.api.Test;
import com.lucatic.bluedevteam.servicios.JuegosServicio;
import com.lucatic.bluedevteam.servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

class ListarGenerosTest {

	private JuegosServicio juegosServicio;

	public void cargarDatos() {
		try {
			juegosServicio = new JuegosServicioImpl();
			juegosServicio.cargarDatos("vgsales.csv");
		} catch (CsvException e) {
			throw new RuntimeException(e);
		}
	}

	public void noCargar() {
		juegosServicio = new JuegosServicioImpl();
	}

	@Test
	public void ListaEditoresSinCargar() {
		noCargar();
		assertEquals(juegosServicio.getListaEditores().getSizeListaEditor(), 0);
	}

	@Test
	public void ListarEditoresCargando() {
		cargarDatos();
		assertTrue(juegosServicio.getListaEditores().getSizeListaEditor() > 0);
	}
}