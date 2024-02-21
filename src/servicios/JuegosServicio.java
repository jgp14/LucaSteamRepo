package servicios;

import java.util.List;

import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;

public interface JuegosServicio {
	public void cargarDatos(String nombreFichero) throws CsvException;
	public void altaJuego(Juego juego) throws JuegoException;
	public List<Juego> listarJuegos() throws JuegoException;
	public List<Juego> listarGeneroPorPlataforma() throws JuegoException;
	public List<Juego> listarPorGenero(TipoGenero tipoGenero) throws JuegoException;
}
