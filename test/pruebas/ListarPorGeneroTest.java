package pruebas;

import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicios.JuegosServicio;
import servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

class ListarPorGeneroTest {

	private JuegosServicio servicio;

	@BeforeEach
	void inicio() {
		servicio = new JuegosServicioImpl();

		try {
			servicio.cargarDatos("vgsales.csv");
		} catch (CsvException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void listarPorGeneroNull() {
		assertThrows(JuegoException.class, () -> servicio.listarPorGenero(null), "Lista por genero con null");
	}

	@Test
	public void listarPorGeneroNotNull() {
		assertDoesNotThrow(() -> servicio.listarPorGenero(TipoGenero.PLATFORM), "Listar por genero sin not null");
	}

	@Test
	public void listarPorGeneroNoExiste() {
		assertThrows(IllegalArgumentException.class, () -> servicio.listarPorGenero(TipoGenero.valueOf("prueba")),
				"Listar por tipo enumerado que no existe");
	}
}