package servicios;

import java.util.List;

import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;

public interface JuegosServicio {

	void cargarDatos(String nombreFichero) throws CsvException;
	void altaJuego(Juego juego) throws JuegoException;
	List<Juego> listarJuegos() throws JuegoException;
	List<Juego> listarGeneroPorPlataforma() throws JuegoException;
	List<Juego> listarPorGenero(TipoGenero tipoGenero) throws JuegoException;
}
