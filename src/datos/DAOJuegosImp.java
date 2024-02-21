package datos;

import java.util.ArrayList;
import java.util.List;

import excepciones.CsvException;
import model.Juego;
import util.CsvUtils;

public class DAOJuegosImp implements DAOJuegos {

	private List<Juego> juegos;
	private ListaEditor listaEditor;
	private ListaPlataforma listaPlataforma;

	public DAOJuegosImp() {
		super();
		this.juegos = new ArrayList<Juego>();
		this.listaEditor = new ListaEditor();
		this.listaPlataforma = new ListaPlataforma();
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

}
