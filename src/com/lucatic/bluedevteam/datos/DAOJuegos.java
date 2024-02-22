package com.lucatic.bluedevteam.datos;

import java.util.List;

import com.lucatic.bluedevteam.excepciones.CsvException;
import com.lucatic.bluedevteam.excepciones.JuegoException;
import com.lucatic.bluedevteam.model.Juego;
import com.lucatic.bluedevteam.model.TipoGenero;


public interface DAOJuegos {

	void cargarDatos(String nombreFichero) throws CsvException;

	boolean existeJuego(Juego juego);

	void altaJuego(Juego juego) throws JuegoException;

	public List<Juego> listarPorGeneros(TipoGenero tipoGenero) throws JuegoException;

	public List<Juego> listarJuegos() throws JuegoException;

	public List<Juego> listarPorPlataforma(String nombrePlataforma) throws JuegoException;

	public ListaPlataforma getListaPlataforma();

	public ListaEditor getListaEditor();

	public List<Juego> getJuegos();

	public List<Juego> listarPorSigloXX() throws JuegoException;

	public List<Juego> listarPorAnhosPares() throws JuegoException;
}
