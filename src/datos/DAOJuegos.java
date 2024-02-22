package datos;

import java.util.List;

import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;

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
