package servicios;

import datos.DAOJuegosImp;
import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;

public class JuegosServicioImpl implements JuegosServicio {
	DAOJuegosImp datos = new DAOJuegosImp();
	@Override
	public void cargarDatos(String nombreFichero) throws CsvException {
		datos.cargarDatos(nombreFichero);
		//System.out.println("Prueba");
	}
	
	public void altaJuego(Juego juego) throws JuegoException {
		datos.altaJuego(juego) ;
	}

}
