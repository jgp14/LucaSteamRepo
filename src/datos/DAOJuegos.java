package datos;

import excepciones.CsvException;

public interface DAOJuegos {

	
	public void cargarDatos(String nombreFichero) throws CsvException;
}
