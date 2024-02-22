package com.lucatic.bluedevteam.pruebas;

import com.lucatic.bluedevteam.excepciones.CsvException;
import com.lucatic.bluedevteam.excepciones.JuegoException;
import org.junit.jupiter.api.Test;
import com.lucatic.bluedevteam.servicios.JuegosServicio;
import com.lucatic.bluedevteam.servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

**
* Pruebas unitarias para evaluar el comportamiento de JuegosServicioImpl al listar juegos según los años pares.
* 
* @since 22/02/2024
* @author BlueDevTeam
* @version 1.0.0
*/

public class AniosParesTest {

    private JuegosServicio juegosServicio;
    
    /**
     * Carga datos desde un archivo CSV para su uso en las pruebas.
     * Si ocurre un error al cargar el archivo, lanza una excepción de tiempo de ejecución.
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
     * Inicializa JuegosServicio sin cargar datos para su uso en las pruebas.
     */

    public void noCargar() {
        juegosServicio = new JuegosServicioImpl();
    }
    
    /**
     * Prueba para verificar el manejo de excepciones al intentar listar juegos según los años pares sin cargar datos.
     */

    @Test
    public void listarAniosParesSinCargar() {

        noCargar();
        assertThrows(JuegoException.class, () -> juegosServicio.listarPorAnhosPares());
    }
    
    /**
     * Prueba para verificar que se puedan listar juegos según los años pares después de cargar datos.
     * Si ocurre un error al cargar los datos o al listar los juegos, lanza una excepción de tiempo de ejecución.
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