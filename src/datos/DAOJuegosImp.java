package datos;

import java.util.ArrayList;
import java.util.List;

import excepciones.CsvException;
import model.Juego;
import model.TipoGenero;
import util.CsvUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

import excepciones.JuegoException;

public class DAOJuegosImp implements DAOJuegos {

	private static final Logger LOGGER = Logger.getLogger(DAOJuegosImp.class.getName());

	private List<Juego> juegos;
	private ListaEditor listaEditor;
	private ListaPlataforma listaPlataforma;

	public DAOJuegosImp() {
		super();
		this.juegos = new ArrayList<Juego>();
		this.listaEditor = new ListaEditor();
		this.listaPlataforma = new ListaPlataforma();
	}

	@Override
	public boolean existeJuego(Juego juegoCompara) {
		for (Juego juego : juegos) {
			if (juego.equals(juegoCompara)) {
				return true;
			}
		}
		return false;
	}

	public DAOJuegosImp(List<Juego> juegos, ListaEditor listaEditor, ListaPlataforma listaPlataforma) {
		super();
		this.juegos = juegos;
		this.listaEditor = listaEditor;
		this.listaPlataforma = listaPlataforma;
	}

	public List<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}

	public ListaEditor getListaEditor() {
		return listaEditor;
	}

	public void setListaEditor(ListaEditor listaEditor) {
		this.listaEditor = listaEditor;
	}

	public ListaPlataforma getListaPlataforma() {
		return listaPlataforma;
	}

	public void setListaPlataforma(ListaPlataforma listaPlataforma) {
		this.listaPlataforma = listaPlataforma;
	}

	@Override
	public void cargarDatos(String nombreFichero) throws CsvException {
		juegos = CsvUtils.deCsvAList(nombreFichero);

		if (!juegos.isEmpty()) {
			for (Juego juego : juegos) {
				listaEditor.añadirEditor(juego.getEditor());
				listaPlataforma.añadirPlataforma(juego.getPlataforma());
			}

			LOGGER.log(Level.INFO, "Juegos, Editores, Plataformas cargados correctamente");
		}
	}

	@Override
	public void altaJuego(Juego juego) throws JuegoException {

		if (juego != null && juego.isJuegoValido()) {
			if (existeJuego(juego)) {
				LOGGER.log(Level.INFO, "Juego ya existe no se puede dar de alta");
				throw new JuegoException("No se puede dar de alta porque el juego ya existe");
			} else {
				juegos.add(juego);
				LOGGER.log(Level.INFO, "Juego dado de alta " + juego.getNombre());
			}
		} else {
			LOGGER.log(Level.WARNING, "Error dadndo de alta juego, estás intentado dar de alta un juego incorrecto");
			throw new JuegoException("Intentado dar de alta un jeugo incorrecto");
		}
	}

	public List<Juego> listarPorGeneros(TipoGenero tipoGenero) throws JuegoException {
		List<Juego> juegosPorGenero = new ArrayList<Juego>();
		for (int i = 0; i < juegos.size(); i++) {
			if (tipoGenero == juegos.get(i).getTipoGenero()) {
				juegosPorGenero.add(juegos.get(i));
			}
		}
		if (juegos.size() == 0) {
			throw new JuegoException("No hay juegos en la base");
		} else if (juegosPorGenero.size() == 0) {
			throw new JuegoException("No hay juegos en ese genero");
		}
		return juegosPorGenero;
	}

	@Override
	public List<Juego> listarJuegos() throws JuegoException {
		List<Juego> juegos = getJuegos();
		juegos = getJuegos();
		if (juegos != null && !juegos.isEmpty()) {
			return juegos;
		} else {
			String msg = "Lista de juegos es  vacia";
			LOGGER.log(Level.WARNING, msg);
			throw new JuegoException(msg);
		}
	}
}
