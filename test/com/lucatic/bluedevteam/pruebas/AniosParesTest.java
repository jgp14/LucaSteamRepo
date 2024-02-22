package com.lucatic.bluedevteam.pruebas;

import com.lucatic.bluedevteam.excepciones.CsvException;
import com.lucatic.bluedevteam.excepciones.JuegoException;
import org.junit.jupiter.api.Test;
import com.lucatic.bluedevteam.servicios.JuegosServicio;
import com.lucatic.bluedevteam.servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test para anios pares
 *
 * @since 22/02/2024
 * @author BlueDevTeam
 * @version 1.0.0.
 */
public class AniosParesTest {

    /**
     * Servicio
     */
    private JuegosServicio juegosServicio;


    /**
     * carga de datos de juegos
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
     * No carga los datos
     */

    public void noCargar() {
        juegosServicio = new JuegosServicioImpl();
    }
    
    /**
     * Test para comprobar si hay anios pares sin cargar listado
     */

    @Test
    public void listarAniosParesSinCargar() {

        noCargar();
        assertThrows(JuegoException.class, () -> juegosServicio.listarPorAnhosPares());
    }

    /**
     * Test para comprobar listado de anios pares cargando datos
     */

    @Test
    public void listarAniosParesCargando() {

        try {
            cargarDatos();
            assertTrue(!juegosServicio.listarPorAnhosPares().isEmpty());
        } catch (JuegoException e) {
            throw new RuntimeException(e);
        }
    }

}