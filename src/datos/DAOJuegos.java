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

	List<Juego> listarPorGeneros(TipoGenero tipoGenero) throws JuegoException;

	List<Juego> listarJuegos() throws JuegoException;

	List<Juego> listarPorPlataforma(String nombrePlataforma) throws JuegoException;

	ListaPlataforma getListaPlataforma();

	ListaEditor getListaEditor();

	List<Juego> getJuegos();
	List<Juego> listarPorSigloXX()throws JuegoException;
}
