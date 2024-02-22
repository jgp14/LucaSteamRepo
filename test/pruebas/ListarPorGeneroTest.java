package pruebas;

import excepciones.CsvException;
import excepciones.JuegoException;
import model.TipoGenero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicios.JuegosServicio;
import servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

class ListarPorGeneroTest {

	/**
	 * Atributo que declara la interfaz del juegoServicio
	 */
	private JuegosServicio servicio;

	/**
	 * Carga los datos del fichero .csv y sino devuelve una RuntimeException. Sirve
	 * para contemplar los casos de datos cargados correctamente. Captura una
	 * CsvExcaption y lanza un RuntimeException
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
	 * Comprueba que cuando se le pasa por parametro un null listarPorGenero lanza
	 * un NullPointerException
	 */
	@Test
	public void listarPorGeneroNull() {
		assertThrows(JuegoException.class, () -> servicio.listarPorGenero(null), "Lista por genero con null");
	}

	/**
	 * Comprueba que cuando se le pasa por parametro no nulo y valido,
	 * listarPorGenero no lanza excepcion
	 */
	@Test
	public void listarPorGeneroNotNull() {
		assertDoesNotThrow(() -> servicio.listarPorGenero(TipoGenero.PLATFORM), "Listar por genero sin not null");
	}

	/**
	 * Comprueba que cuando se le pasa por parametro de la enumeracion no nulo pero
	 * que no es valido por ejemplo un string , listarPorGenero lanza un
	 * IllegalArgumentException
	 */
	@Test
	public void listarPorGeneroNoExiste() {
		assertThrows(IllegalArgumentException.class, () -> servicio.listarPorGenero(TipoGenero.valueOf("prueba")),
				"Listar por tipo enumerado que no existe");
	}
}