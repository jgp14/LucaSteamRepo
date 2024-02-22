package com.lucatic.bluedevteam.servicios;

import java.util.List;

import com.lucatic.bluedevteam.datos.ListaEditor;
import com.lucatic.bluedevteam.datos.ListaPlataforma;
import com.lucatic.bluedevteam.excepciones.CsvException;
import com.lucatic.bluedevteam.excepciones.JuegoException;
import com.lucatic.bluedevteam.model.Juego;
import com.lucatic.bluedevteam.model.TipoGenero;

/**
 * Interfaz servicio que especifica la cabecera de los métodos de la lógica de negocio
 *
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 22-02-2024
 */
public interface JuegosServicio {

    /**
     *  Carga datos de un csv
     *
     * @param nombreFichero El nombre del fichero csv
     * @throws CsvException Si hay error en la carga del fichero
     */
    void cargarDatos(String nombreFichero) throws CsvException;

    /**
     * Da de alta un juego en el sistema
     *
     * @param juego el juego a dar de alta
     * @throws JuegoException Lanza si hay algún problema de juego ya existente o estar intentando dar de alta un juego incorrecto
     */
    void altaJuego(Juego juego) throws JuegoException;

    /**
     * Lista los juegos existentes en el sistema
     *
     * @return Devuelve la lista de juegos existente
     * @throws JuegoException Lanza excepción si no se ha podido listar juegos porque la lista está vacía
     */
    List<Juego> listarJuegos() throws JuegoException;

    /**
     * Lista por genero de tipo PLATFORM
     *
     * @return devuelve una lista de juegos con el genero plataformas
     * @throws JuegoException Si no se puede obtener una lista de juegos filtrado por genero PLATFORM o lista vacía de juegos
     */
    List<Juego> listarGeneroPorPlataforma() throws JuegoException;

    /**
     * Lista por género
     *
     * @param tipoGenero El tipo enumerado tipo género
     * @return Una lista de juegos que corresponda al tipo de genero
     * @throws JuegoException Si no se puede mostrar por ese tipo de género o la lista está vacía
     */
    List<Juego> listarPorGenero(TipoGenero tipoGenero) throws JuegoException;

    /**
     * Obtiene el objeto ListaPlataformas
     *
     * Obtenemos la lista de plataformas
     * @see ListaPlataforma
     * @return El objeto lista de plataformas
     */
    ListaPlataforma getListaPlataformas();

    /**
     * Obtiene una lista de juegos filtrando por plataforma
     *
     * @param nombrePlataforma La plataforma por la que vamos a filtrar
     * @return La lista de juegos que corresponde con la plataforma
     * @throws JuegoException Si lista de juegos vacía o no hay juegos de platform
     */
    List<Juego> listarPorPlataforma(String nombrePlataforma) throws JuegoException;

    /**
     * Obtener lista editores
     *
     * @return Un objeto de tipo ListaEditor
     * @see ListaEditor
     */
    ListaEditor getListaEditores();

    /**
     * Obtener Juegos del siglo XX
     *
     * @return Retorna una lista de juegos del siglo XX
     * @throws JuegoException Lanza excepción si la lista está vacía o no hay juegos del siglo XX
     */
    List<Juego> listarPorSigloXX() throws JuegoException;

    /**
     * Retorna una lista de juegos lanzados en años pares
     * @return Retorna una lista de juegos lanzados en años pares
     * @throws JuegoException Lanza error si lista de juegos es vacía o no hay anios pares
     */
    List<Juego> listarPorAnhosPares() throws JuegoException;

}
