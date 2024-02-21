package servicios;

import excepciones.CsvException;

public interface JuegosServicio {
	public void cargarDatos(String nombreFichero) throws CsvException;
}
