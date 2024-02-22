package com.lucatic.bluedevteam.datos;

import java.util.ArrayList;
import java.util.List;

import com.lucatic.bluedevteam.excepciones.CsvException;
import com.lucatic.bluedevteam.model.Juego;
import com.lucatic.bluedevteam.model.TipoGenero;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lucatic.bluedevteam.util.CsvUtils;

import com.lucatic.bluedevteam.excepciones.JuegoException;

/**
 * Clase que valida todos los datos de la aplicacion
 * 
 * @since 22/02/2024
 * @author BlueDevTeam
 * @version 1.0.0
 */
public class DAOJuegosImpl implements DAOJuegos {
	/**
	 * Atributo que gestiona la carga de datos
	 */
	private static int count = 0;
	/**
	 * Atributo que gestiona los logs producidos en la clase
	 */
	private static final Logger LOGGER = LogManager.getLogger(DAOJuegosImpl.class);
	/**
	 * Lista de objetos Juego. Almacena todos los juegos de la aplicacion
	 */
	private List<Juego> juegos;
	/**
	 * Objeto de tipo ListaEditor. Gestiona todos los editores de la aplicacion
	 */
	private ListaEditor listaEditor;
	/**
	 * Objeto de tipo ListaPlataforma. Gestiona todos las plataformas de la
	 * aplicacion
	 */
	private ListaPlataforma listaPlataforma;

	/**
	 * Contructor de clase vacio que inicializa atributos
	 */
	public DAOJuegosImpl() {
		this.juegos = new ArrayList<>();
		this.listaEditor = new ListaEditor();
		this.listaPlataforma = new ListaPlataforma();
	}

	/**
	 * Comprueba si el juego de parametro ya existe en la lista juegos
	 * 
	 * @param juegoCompara
	 * @return Devuelve un booleano dependiendo de si existe o no el juego
	 */
	@Override
	public boolean existeJuego(Juego juegoCompara) {

		for (Juego juego : juegos) {

			if (juego.equals(juegoCompara)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Constructor que incializa los atributos de clase con valores nuevos
	 * 
	 * @param juegos
	 * @param listaEditor
	 * @param listaPlataforma
	 */
	public DAOJuegosImpl(List<Juego> juegos, ListaEditor listaEditor, ListaPlataforma listaPlataforma) {

		this.juegos = juegos;
		this.listaEditor = listaEditor;
		this.listaPlataforma = listaPlataforma;
	}

	/**
	 * Devuelve una lista de todos los juegos almacenados
	 * 
	 * @return Devuelve una lista de todos los juegos almacenados
	 */
	public List<Juego> getJuegos() {
		return juegos;
	}

	/**
	 * Reestablece la lista de juegos a una nueva pasada por parametro
	 * 
	 * @param juegos
	 */
	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}

	/**
	 * Devuelve un objeto de tipo ListaEditor
	 * 
	 * @return Devuelve un objeto de tipo ListaEditor
	 * @see ListaEditor
	 */
	public ListaEditor getListaEditor() {
		return listaEditor;
	}

	/**
	 * Modifica el objeto de ListaEditor reestableciendose al atributo
	 * 
	 * @param listaEditor
	 */
	public void setListaEditor(ListaEditor listaEditor) {
		this.listaEditor = listaEditor;
	}

	/**
	 * Devuelve el objeto ListaPlataforma
	 * 
	 * @return Devuelve el objeto ListaPlataforma
	 * @see ListaPlataforma
	 */
	public ListaPlataforma getListaPlataforma() {
		return listaPlataforma;
	}

	/**
	 * Modifica el objeto de ListaPlataforma reestableciendose al atributo
	 * 
	 * @param listaPlataforma
	 */
	public void setListaPlataforma(ListaPlataforma listaPlataforma) {
		this.listaPlataforma = listaPlataforma;
	}

	/**
	 * Se encarga de recolectar datos de un fichero. Ejecuta una excepcion si hay
	 * algun error en la carga
	 * 
	 * @param nombreFichero
	 * @throws nombreFichero
	 */
	@Override
	public void cargarDatos(String nombreFichero) throws CsvException {

		if (count == 0) {
			try {
				if (!juegos.isEmpty()) {
					juegos.addAll(CsvUtils.deCsvAList(nombreFichero));
				} else {
					juegos = CsvUtils.deCsvAList(nombreFichero);
				}

				for (Juego juego : juegos) {
					listaEditor.anadirEditor(juego.getEditor());
					listaPlataforma.anadirPlataforma(juego.getPlataforma());
				}
				LOGGER.info("Juegos, Editores, Plataformas cargados correctamente");
			} catch (CsvException e) {
				LOGGER.error("Error en Dao al cargar datos");
				throw e;
			}
			count++;
		} else {
			LOGGER.warn("Ya has cargado el csv anteriormente");
		}

	}

	/**
	 * Registra un nuevo juego en la lista de juegos. Lanza la exepcion si el juego
	 * ya existe o es incorrecto
	 * 
	 * @param juego
	 * @throws JuegoException
	 */
	@Override
	public void altaJuego(Juego juego) throws JuegoException {

		if (juego != null && juego.isJuegoValido()) {
			if (existeJuego(juego)) {
				LOGGER.warn("Juego ya existe no se puede dar de alta");
				throw new JuegoException("No se puede dar de alta porque el juego ya existe");
			} else {
				juegos.add(juego);
				listaEditor.anadirEditor(juego.getEditor());
				listaPlataforma.anadirPlataforma(juego.getPlataforma());
				LOGGER.info("Juego dado de alta " + juego.getNombre());
			}
		} else {
			LOGGER.warn("Error dadndo de alta juego, estás intentado dar de alta un juego incorrecto");
			throw new JuegoException("Intentado dar de alta un juego incorrecto");
		}
	}

	/**
	 * Devuelve una lista de Juego filtrados por la enumeracion de TipoGenero. Lanza
	 * excepcion si no existe el genero
	 * 
	 * @param tipoGenero
	 * @return Devuelve una lista de Juego filtrados por la enumeracion de
	 *         TipoGenero
	 * @throws JuegoException
	 */
	public List<Juego> listarPorGeneros(TipoGenero tipoGenero) throws JuegoException {

		List<Juego> juegosPorGenero = new ArrayList<>();

		for (int i = 0; i < juegos.size(); i++) {

			if (tipoGenero == juegos.get(i).getTipoGenero()) {
				juegosPorGenero.add(juegos.get(i));
			}
		}

		if (juegos.size() == 0) {
			LOGGER.warn("No hay juegos disponibles");
			throw new JuegoException("No hay juegos en la base");
		} else if (juegosPorGenero.size() == 0) {
			LOGGER.warn("No hay juegos con ese genero");
			throw new JuegoException("No hay juegos en ese genero");
		}
		return juegosPorGenero;
	}

	/**
	 * Devuelve una lista de juegos registrados. Lanza una excepción si no hay
	 * juegos
	 * 
	 * @return Devuelve una lista de juegos registrados
	 * @throws JuegoException
	 */
	@Override
	public List<Juego> listarJuegos() throws JuegoException {

		List<Juego> juegos = getJuegos();
		juegos = getJuegos();

		if (juegos != null && !juegos.isEmpty()) {
			return juegos;
		} else {
			String msg = "Lista de juegos es  vacia";
			LOGGER.warn(msg);
			throw new JuegoException(msg);
		}
	}

	/**
	 * Genera una lista con los juegos de la plataforma pasada como parametro. Lanza
	 * una excepción en caso de no existir esta plataforma
	 * 
	 * @param nombrePlataforma
	 * @throws JuegoException
	 * @return Genera una lista con los juegos de la plataforma pasada como
	 *         parametro
	 */
	public List<Juego> listarPorPlataforma(String nombrePlataforma) throws JuegoException {

		List<Juego> listaPorPlataforma = new ArrayList<>();

		for (int i = 0; i < juegos.size(); i++) {
			if (juegos.get(i).getPlataforma().equalsIgnoreCase(nombrePlataforma)) {
				listaPorPlataforma.add(juegos.get(i));
			}
		}
		if (juegos.size() == 0) {
			String msg = "Lista de juegos es  vacia";
			LOGGER.warn(msg);
			throw new JuegoException(msg);
		} else if (listaPorPlataforma.size() == 0) {
			String msg = "No hay juegos en ese genero";
			LOGGER.warn(msg);
			throw new JuegoException(msg);
		}
		return listaPorPlataforma;
	}

	/**
	 * Devuelve una lista de objeto Juego de juegos del siglo XX
	 * 
	 * @return Devuelve una lista de objeto Juego de juegos del siglo XX
	 * @throws JuegoException
	 */
	public List<Juego> listarPorSigloXX() throws JuegoException {
		List<Juego> juegosSigloXX = new ArrayList<>();
		for (int i = 0; i < juegos.size(); i++) {
			if (juegos.get(i).getFecha() <= 2000 && juegos.get(i).getFecha() > 1900) {
				juegosSigloXX.add(juegos.get(i));
			}
		}
		if (juegos.size() == 0) {
			String msg = "Lista de juegos es  vacia";
			LOGGER.warn(msg);
			throw new JuegoException(msg);
		} else if (juegosSigloXX.size() == 0) {
			String msg = "No hay juegos en ese siglo";
			LOGGER.warn(msg);
			throw new JuegoException(msg);
		}
		return juegosSigloXX;
	}

	/**
	 * Devuelve una lista de objeto Juego que aparecieron en los anios pares o
	 * ejecuta una excepcion si no hay juegos en estos anios
	 * 
	 * @return Devuelve una lista de objeto Juego que aparecieron en los anios pares
	 * @throws JuegoException
	 */

	@Override
	public List<Juego> listarPorAnhosPares() throws JuegoException {
		List<Juego> juegosAnhosPares = new ArrayList<>();

		if (juegos.size() == 0) {
			String msg = "Lista de juegos es  vacia";
			LOGGER.warn(msg);
			throw new JuegoException(msg);
		}

		for (int i = 0; i < juegos.size(); i++) {
			if (juegos.get(i).getFecha() % 2 == 0) {
				juegosAnhosPares.add(juegos.get(i));
			}
		}

		if (juegosAnhosPares.size() == 0) {
			String msg = "No hay juegos en años pares";
			LOGGER.warn(msg);
			throw new JuegoException(msg);
		}
		return juegosAnhosPares;
	}
}
