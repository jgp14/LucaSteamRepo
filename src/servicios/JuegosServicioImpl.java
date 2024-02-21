package servicios;

import control.JuegosControlador;
import datos.DAOJuegosImp;
import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JuegosServicioImpl implements JuegosServicio {

	private static final Logger LOGGER = Logger.getLogger(JuegosServicioImpl.class.getName());

	DAOJuegosImp datos = new DAOJuegosImp();
	@Override
	public void cargarDatos(String nombreFichero) throws CsvException {

		if (nombreFichero != null) {
			datos.cargarDatos(nombreFichero);
			//System.out.println("Prueba");
		} else {
			throw new CsvException("Fichero con valor null");
		}
	}
	
	public void altaJuego(Juego juego) throws JuegoException {
		datos.altaJuego(juego) ;
	}

	@Override
	public List<Juego> listarGeneroPorPlataforma() throws JuegoException {
		return listarPorGenero(TipoGenero.PLATFORM);
	}

	@Override
	public List<Juego> listarPorGenero(TipoGenero tipoGenero) throws JuegoException {
		if (tipoGenero != null)
			return datos.listarPorGeneros(tipoGenero);
		else {
			LOGGER.log(Level.WARNING, "Tipo de genero es listar por genero es null");
			throw new JuegoException("Tipo de genero en listar por genero es null");
		}
	}

}
