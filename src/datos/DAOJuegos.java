package datos;

import java.util.List;

import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;

/**
 * Interfaz que gestiona los metodos a usar en la capa de datos
 * 
 * @since 22/02/2024
 * @author BlueDevTeam
 * @version 1.0.0
 */

public interface DAOJuegos {
	/**
	 * Se encarga de recolectar datos de un fichero. 
	 * 
	 * @param nombreFichero Indica el nombre de un fichero csv
	 * @throws CsvException Ejecuta una excepcion si hay algun error en la carga
	 */
	void cargarDatos(String nombreFichero) throws CsvException;

	/**
	 * Comprueba si el juego de parametro ya existe en la lista juegos
	 * 
	 * @param juego Recive un juego de parametro para comprovar su existencia
	 * @return Devuelve un booleano dependiendo de si existe o no el juego
	 */
	boolean existeJuego(Juego juego);

	/**
	 * Registra un nuevo juego en la lista de juegos. Lanza la exepcion si el juego
	 * ya existe o es incorrecto
	 * 
	 * @param juego recoje un objeto tipo Juego
	 * @throws JuegoException Se ejecuta la excepcion si el juego no es valido
	 */
	void altaJuego(Juego juego) throws JuegoException;

	/**
	 * Devuelve una lista de Juego filtrados por la enumeracion de TipoGenero. Lanza
	 * excepcion si no existe el genero
	 * 
	 * @param tipoGenero Recoje un tipo de genero para comparar en el listado
	 * @return Devuelve una lista de Juego filtrados por la enumeracion de
	 *         TipoGenero
	 * @throws JuegoException Se ejecuta si no hay ningun genero de este tipo
	 */

	List<Juego> listarPorGeneros(TipoGenero tipoGenero) throws JuegoException;

	/**
	 * Devuelve una lista de juegos registrados. Lanza una excepción si no hay
	 * juegos
	 * 
	 * @return Devuelve una lista de juegos registrados
	 * @throws JuegoException Devuelve la excepcion si no hay juegos registrados
	 */
	List<Juego> listarJuegos() throws JuegoException;

	/**
	 * Genera una lista con los juegos de la plataforma pasada como parametro. Lanza
	 * una excepción en caso de no existir esta plataforma
	 * 
	 * @param nombrePlataforma Recoge una cadena de tipo de plataforma
	 * @throws JuegoException Devuelve una excepcion si el nombre de la plataforma es incorrecta
	 * @return Genera una lista con los juegos de la plataforma pasada como
	 *         parametro
	 */
	List<Juego> listarPorPlataforma(String nombrePlataforma) throws JuegoException;

	/**
	 * Devuelve el objeto ListaPlataforma
	 * 
	 * @return Devuelve el objeto ListaPlataforma
	 * @see ListaPlataforma
	 */
	ListaPlataforma getListaPlataforma();

	/**
	 * Devuelve un objeto de tipo ListaEditor
	 * 
	 * @return Devuelve un objeto de tipo ListaEditor
	 * @see ListaEditor
	 */
	ListaEditor getListaEditor();

	/**
	 * Devuelve una lista de todos los juegos almacenados
	 * 
	 * @return Devuelve una lista de todos los juegos almacenados
	 */
	List<Juego> getJuegos();

	/**
	 * Devuelve una lista de objeto Juego de juegos del siglo XX
	 * 
	 * @return Devuelve una lista de objeto Juego de juegos del siglo XX
	 * @throws JuegoException Devuelve la excepcion si no hay juegos de ese siglo
	 */
	List<Juego> listarPorSigloXX() throws JuegoException;

	/**
	 * Devuelve una lista de objeto Juego que aparecieron en los anios pares o
	 * ejecuta una excepcion si no hay juegos en estos anios
	 * 
	 * @return Devuelve una lista de objeto Juego que aparecieron en los anios pares
	 * @throws JuegoException Devuelve la excepcion si no hay juegos en anios pares
	 */
	List<Juego> listarPorAnhosPares() throws JuegoException;

}
