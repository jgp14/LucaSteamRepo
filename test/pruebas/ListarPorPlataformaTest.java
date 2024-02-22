package pruebas;

import excepciones.CsvException;
import excepciones.JuegoException;
import org.junit.jupiter.api.Test;
import servicios.JuegosServicio;
import servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

class ListarPorPlataformaTest {

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
	void listarPorPlataformaNull() {

		cargarDatos();
		assertThrows(JuegoException.class, () -> juegosServicio.listarPorPlataforma(null));
	}

	@Test
	void listarPorPlataformaInexistente() {

		cargarDatos();
		assertThrows(JuegoException.class, () -> juegosServicio.listarPorPlataforma("AAAA"));
	}

	@Test
	void listarPorPlataformaExistente() {

		cargarDatos();
		assertDoesNotThrow(() -> juegosServicio.listarPorPlataforma("DC"));
	}

	@Test
	void listarPorPlataformaStrVacio() {

		cargarDatos();
		assertThrows(JuegoException.class, () -> juegosServicio.listarPorPlataforma(""));
	}

	@Test
	public void listarPorPlataformaSinCargar() {

		noCargar();
		assertEquals(juegosServicio.getListaPlataformas().sizePlataformas(), 0);
	}
}