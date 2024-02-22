package servicios;

import java.util.List;

import datos.DAOJuegos;
import datos.DAOJuegosImpl;
import datos.ListaEditor;
import datos.ListaPlataforma;
import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Implementación del servicio con la lógica de negocio
 *
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 22-02-2024
 */
public class JuegosServicioImpl implements JuegosServicio {

    /**
     * LOGGER log4j2
     *
     */
    private static final Logger LOGGER = LogManager.getLogger(JuegosServicioImpl.class);

    /**
     * capa DAO juegos
     *
     */
    DAOJuegos daoJuegos = new DAOJuegosImpl();

    @Override
    public void cargarDatos(String nombreFichero) throws CsvException {

        if (nombreFichero != null) {
            daoJuegos.cargarDatos(nombreFichero);
        } else {
            LOGGER.error("Fichero csv con valor null");
            throw new CsvException("Fichero con valor null");
        }
    }

    @Override
    public void altaJuego(Juego juego) throws JuegoException {

        daoJuegos.altaJuego(juego);
    }

    @Override
    public List<Juego> listarJuegos() throws JuegoException {

        return daoJuegos.listarJuegos();
    }

    public List<Juego> listarGeneroPorPlataforma() throws JuegoException {

        return listarPorGenero(TipoGenero.PLATFORM);
    }

    @Override
    public List<Juego> listarPorGenero(TipoGenero tipoGenero) throws JuegoException {

        if (tipoGenero != null)
            return daoJuegos.listarPorGeneros(tipoGenero);
        else {
            LOGGER.warn("Tipo de genero es listar por genero es null");
            throw new JuegoException("Tipo de genero en listar por genero es null");
        }
    }

    @Override
    public ListaPlataforma getListaPlataformas() {

        return daoJuegos.getListaPlataforma();
    }

    public List<Juego> listarPorPlataforma(String nombrePlataforma) throws JuegoException {

        if (nombrePlataforma != null) {
            return daoJuegos.listarPorPlataforma(nombrePlataforma);
        } else {
            LOGGER.warn("Nombre de plataforma es nulo");
            throw new JuegoException("ListaPorPlataforma - Nombre de plataforma es nulo");
        }
    }

    @Override
    public ListaEditor getListaEditores() {
        return daoJuegos.getListaEditor();
    }

    @Override
    public List<Juego> listarPorSigloXX() throws JuegoException {
        return daoJuegos.listarPorSigloXX();
    }

    @Override
    public List<Juego> listarPorAnhosPares() throws JuegoException {
        return daoJuegos.listarPorAnhosPares();
    }
}
