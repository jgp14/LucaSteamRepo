package servicios;

import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;

public interface JuegosServicio {
	public void cargarDatos(String nombreFichero) throws CsvException;
	void altaJuego(Juego juego) throws JuegoException;
	List<Juego> listarGeneroPorPlataforma() throws JuegoException;
	List<Juego> listarPorGenero(TipoGenero tipoGenero) throws JuegoException;
	public void listarJuegos() throws JuegoException;
}
