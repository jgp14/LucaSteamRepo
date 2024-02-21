package datos;

import java.util.List;

import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;

public interface DAOJuegos {

	public void cargarDatos(String nombreFichero) throws CsvException;

	public boolean existeJuego(Juego juego);

	void altaJuego(Juego juego) throws JuegoException;

	public List<Juego> listarPorGeneros(TipoGenero tipoGenero) throws JuegoException;
}
