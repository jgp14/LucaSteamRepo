package datos;

import java.util.ArrayList;
import java.util.List;

import excepciones.CsvException;
import model.Juego;
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

	}
	

    @Override
    public void altaJuego(Juego juego) throws JuegoException {

		if (juego != null) {
			if (existeJuego(juego)) {
				throw new JuegoException("No se puede dar de alta porque el juego ya existe");
			} else {
				juegos.add(juego);
				LOGGER.log(Level.INFO, "Juego dado de alta " + juego.getNombre());
			}
		} else {
			LOGGER.log(Level.WARNING, "Error dadndo de alta juego, estás intentado dar de alta un juego null");
		}
    }
}
