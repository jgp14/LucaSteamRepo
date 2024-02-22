package com.lucatic.bluedevteam.servicios;

import java.util.List;

import com.lucatic.bluedevteam.datos.DAOJuegos;
import com.lucatic.bluedevteam.datos.DAOJuegosImpl;
import com.lucatic.bluedevteam.datos.ListaEditor;
import com.lucatic.bluedevteam.datos.ListaPlataforma;
import com.lucatic.bluedevteam.excepciones.CsvException;
import com.lucatic.bluedevteam.excepciones.JuegoException;
import com.lucatic.bluedevteam.model.Juego;
import com.lucatic.bluedevteam.model.TipoGenero;
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
    private DAOJuegos daoJuegos = new DAOJuegosImpl();

    /**
     *  Carga datos de un csv
     *
     * @param nombreFichero El nombre del fichero csv
     * @throws CsvException Si hay error en la carga del fichero
     */
    @Override
    public void cargarDatos(String nombreFichero) throws CsvException {

        if (nombreFichero != null) {
            daoJuegos.cargarDatos(nombreFichero);
        } else {
            LOGGER.error("Fichero csv con valor null");
            throw new CsvException("Fichero con valor null");
        }
    }

    /**
     * Da de alta un juego en el sistema
     *
     * @param juego el juego a dar de alta
     * @throws JuegoException Lanza si hay algún problema de juego ya existente o estar intentando dar de alta un juego incorrecto
     */
    @Override
    public void altaJuego(Juego juego) throws JuegoException {

        daoJuegos.altaJuego(juego);
    }

    /**
     * Lista los juegos existentes en el sistema
     *
     * @return Devuelve la lista de juegos existente
     * @throws JuegoException Lanza excepción si no se ha podido listar juegos porque la lista está vacía
     */
    @Override
    public List<Juego> listarJuegos() throws JuegoException {

        return daoJuegos.listarJuegos();
    }

    /**
     * Lista por genero de tipo PLATFORM
     *
     * @return devuelve una lista de juegos con el genero plataformas
     * @throws JuegoException Si no se puede obtener una lista de juegos filtrado por genero PLATFORM o lista vacía de juegos
     */
    public List<Juego> listarGeneroPorPlataforma() throws JuegoException {

        return listarPorGenero(TipoGenero.PLATFORM);
    }

    /**
     * Lista por género
     *
     * @param tipoGenero El tipo enumerado tipo género
     * @return Una lista de juegos que corresponda al tipo de genero
     * @throws JuegoException Si no se puede mostrar por ese tipo de género o la lista está vacía
     */
    @Override
    public List<Juego> listarPorGenero(TipoGenero tipoGenero) throws JuegoException {

        if (tipoGenero != null)
            return daoJuegos.listarPorGeneros(tipoGenero);
        else {
            LOGGER.warn("Tipo de genero es listar por genero es null");
            throw new JuegoException("Tipo de genero en listar por genero es null");
        }
    }

    /**
     * Obtiene el objeto ListaPlataformas
     *
     * Obtenemos la lista de plataformas
     * @see ListaPlataforma
     * @return El objeto lista de plataformas
     */
    @Override
    public ListaPlataforma getListaPlataformas() {

        return daoJuegos.getListaPlataforma();
    }

    /**
     * Obtiene una lista de juegos filtrando por plataforma
     *
     * @param nombrePlataforma La plataforma por la que vamos a filtrar
     * @return La lista de juegos que corresponde con la plataforma
     * @throws JuegoException Si lista de juegos vacía o no hay juegos de platform
     */
    public List<Juego> listarPorPlataforma(String nombrePlataforma) throws JuegoException {

        if (nombrePlataforma != null) {
            return daoJuegos.listarPorPlataforma(nombrePlataforma);
        } else {
            LOGGER.warn("Nombre de plataforma es nulo");
            throw new JuegoException("ListaPorPlataforma - Nombre de plataforma es nulo");
        }
    }

    /**
     * Obtener lista editores
     *
     * @return Un objeto de tipo ListaEditor
     * @see ListaEditor
     */
    @Override
    public ListaEditor getListaEditores() {
        return daoJuegos.getListaEditor();
    }

    /**
     * Obtener Juegos del siglo XX
     *
     * @return Retorna una lista de juegos del siglo XX
     * @throws JuegoException Lanza excepción si la lista está vacía o no hay juegos del siglo XX
     */
    @Override
    public List<Juego> listarPorSigloXX() throws JuegoException {
        return daoJuegos.listarPorSigloXX();
    }

    /**
     * Retorna una lista de juegos lanzados en años pares
     * @return Retorna una lista de juegos lanzados en años pares
     * @throws JuegoException Lanza error si lista de juegos es vacía o no hay anios pares
     */
    @Override
    public List<Juego> listarPorAnhosPares() throws JuegoException {
        return daoJuegos.listarPorAnhosPares();
    }
}
