package datos;

import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;

public interface DAOJuegos {

	
	public void cargarDatos(String nombreFichero) throws CsvException;
	public boolean existeJuego(Juego juego);
	void altaJuego(Juego juego) throws JuegoException;
}
