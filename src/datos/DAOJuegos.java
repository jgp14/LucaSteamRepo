package datos;

import excepciones.CsvException;
import model.Juego;

public interface DAOJuegos {

	
	public void cargarDatos(String nombreFichero) throws CsvException;
	public boolean existeJuego(Juego juego);
}
