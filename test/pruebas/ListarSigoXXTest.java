package pruebas;

import excepciones.CsvException;
import excepciones.JuegoException;
import org.junit.jupiter.api.Test;
import servicios.JuegosServicio;
import servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de Test que comprueba los metodos del servicio relacionados con listar
 * los juegos del siglo XX
 * 
 * @since 22/02/2024
 * @author BlueDevTeam
 * @version 1.0.0
 */
public class ListarSigoXXTest {

	/**
	 * Atributo que declara el juegoServicio para testear los metodos
	 */
	private JuegosServicio juegosServicio;

	/**
	 * Carga los datos del fichero .csv y sino devuelve una RuntimeException. Sirve
	 * para contemplar los casos de datos cargados correctamente.
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
	 * Instancia el atributo juegosServicio con la implementacion JuegosServicioImpl
	 * para contemplar los escenarios en donde los datos existen pero estan vacios.
	 */
	public void noCargar() {

		juegosServicio = new JuegosServicioImpl();
	}

	/**
	 * Comprueba que el metodo listarPorSigloXX lanza una excepcion si no se han
	 * cargado los datos
	 */
	@Test
	public void ListarSigloXXSinCargar() {

		noCargar();
		assertThrows(JuegoException.class, () -> juegosServicio.listarPorSigloXX());

	}

	/**
	 * Comprueba que el metodo listarPorSigloXX NO devuelve una lista vacia.
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