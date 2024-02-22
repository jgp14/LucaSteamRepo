package pruebas;

import excepciones.CsvException;
import excepciones.JuegoException;
import org.junit.jupiter.api.Test;
import servicios.JuegosServicio;
import servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

public class ListarSigoXXTest {

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
	public void ListarSigloXXSinCargar() {

		noCargar();
		assertThrows(JuegoException.class, () -> juegosServicio.listarPorSigloXX());

	}

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