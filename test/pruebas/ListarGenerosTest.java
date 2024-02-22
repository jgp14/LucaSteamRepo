package pruebas;

import excepciones.CsvException;
import org.junit.jupiter.api.Test;
import servicios.JuegosServicio;
import servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase de pruebas unitarias para la gestin de editores
 * 
 * @since 22/02/2024
 * @author BlueDevTeam
 * @version 1.0.0
 */
class ListarGenerosTest {
	/**
	 * Atributo que genera el objeto que permite ejecutar pruebas
	 */
	private JuegosServicio juegosServicio;
	/**
	 * Se encarga de cargar datos desde un fichero para su posterior utilizacion
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
	 * Implementa la no carga para gestionar las pruebas segun esta accion
	 */
	public void noCargar() {
		juegosServicio = new JuegosServicioImpl();
	}
	/**
	 * Este test valida que no hay editores cargados
	 */
	@Test
	public void ListaEditoresSinCargar() {
		noCargar();
		assertEquals(juegosServicio.getListaEditores().getSizeListaEditor(), 0);
	}
	/**
	 * Este test valida que hay editores cargados
	 */
	@Test
	public void ListarEditoresCargando() {
		cargarDatos();
		assertTrue(juegosServicio.getListaEditores().getSizeListaEditor() > 0);
	}
}