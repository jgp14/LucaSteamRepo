package servicios;

import java.util.List;

import datos.ListaEditor;
import datos.ListaPlataforma;
import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;

public interface JuegosServicio {

	void cargarDatos(String nombreFichero) throws CsvException;

	void altaJuego(Juego juego) throws JuegoException;

	public List<Juego> listarJuegos() throws JuegoException;

	public List<Juego> listarGeneroPorPlataforma() throws JuegoException;

	public List<Juego> listarPorGenero(TipoGenero tipoGenero) throws JuegoException;

	public ListaPlataforma getListaPlataformas();

	public List<Juego> listarPorPlataforma(String nombrePlataforma) throws JuegoException;

	public ListaEditor getListaEditores();

	public List<Juego> listarPorSigloXX() throws JuegoException;

	public List<Juego> listarPorAnhosPares() throws JuegoException;

}
