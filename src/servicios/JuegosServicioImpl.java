package servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import datos.DAOJuegosImp;
import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;
import util.CsvUtils;

public class JuegosServicioImpl implements JuegosServicio {
	DAOJuegosImp datos = new DAOJuegosImp();
    private static final Logger LOGGER = Logger.getLogger(CsvUtils.class.getName());

	@Override
	public void cargarDatos(String nombreFichero) throws CsvException {

		if (nombreFichero != null) {
			datos.cargarDatos(nombreFichero);
			//System.out.println("Prueba");
		} else {
			throw new CsvException("Fichero con valor null");
		}
	}
	
	@Override
	public void altaJuego(Juego juego) throws JuegoException {
		datos.altaJuego(juego) ;
	}

	@Override
	public List<Juego> listarJuegos() throws JuegoException {
		List<Juego> juegos = datos.getJuegos();
		if(juegos != null && !juegos.isEmpty()) {
			return juegos;
		} else {
			String msg = "Lista de juegos es nula o vacia";
			LOGGER.log(Level.WARNING, msg);
			throw new JuegoException(msg);
		}	
	}

}
