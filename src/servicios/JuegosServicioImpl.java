package servicios;

import datos.DAOJuegosImp;
import excepciones.JuegoException;
import model.Juego;

public class JuegosServicioImpl implements JuegosServicio {
	DAOJuegosImp datos = new DAOJuegosImp();
	@Override
	public void cargarDatos(String nombreFichero) {
		//datos.cargarDatos("nombrefichero.txt");
		System.out.println("Prueba");
	}
	
	public void altaJuego(Juego juego) throws JuegoException {
		datos.altaJuego(juego) ;
	}

}
