package com.lucatic.bluedevteam.pruebas;

import com.lucatic.bluedevteam.excepciones.CsvException;
import com.lucatic.bluedevteam.excepciones.JuegoException;
import com.lucatic.bluedevteam.model.TipoGenero;
import org.junit.jupiter.api.Test;
import com.lucatic.bluedevteam.servicios.JuegosServicio;
import com.lucatic.bluedevteam.servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
* Test para listar por género
* 
* @since 22/02/2024
* @author BlueDevTeam
* @version 1.0.0
*/
class ListarFiltrandoPorGeneroTest {

    /**
     * Instanciar servicio
     */
    private JuegosServicio juegosServicio;
    
    /**
     * cargar datos
     */
    public void cargarDatos() {

        try {
            juegosServicio = new JuegosServicioImpl();
            juegosServicio.cargarDatos("vgsales.csv");
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * no cargar datos
     */
    public void noCargar() {

        juegosServicio = new JuegosServicioImpl();
    }

    /**
     * Test para filtar por genero si no existe
     */
    @Test
    public void listarFiltrandoPorGeneroCargarNoExiste() {
        cargarDatos();
        assertThrows(IllegalArgumentException.class, () -> juegosServicio.listarPorGenero(TipoGenero.valueOf("aaa")));
    }


    /**
     * Test para listrar filtrando por genero si existe
     */
    @Test
    public void listarFiltrandoPorGeneroCargarExiste() {
        try {
            cargarDatos();
            assertTrue(!juegosServicio.listarPorGenero(TipoGenero.PLATFORM).isEmpty());
        } catch (JuegoException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Test filtrando por genero sin cargar y si existe
     */
    @Test
    public void listarFiltrandoPoGeneroNoCargarExiste() {
        noCargar();
        assertThrows(JuegoException.class, () -> juegosServicio.listarPorGenero(TipoGenero.PLATFORM));
    }
}