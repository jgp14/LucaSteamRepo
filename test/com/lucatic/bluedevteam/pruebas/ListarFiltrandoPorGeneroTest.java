package com.lucatic.bluedevteam.pruebas;

import com.lucatic.bluedevteam.excepciones.CsvException;
import com.lucatic.bluedevteam.excepciones.JuegoException;
import com.lucatic.bluedevteam.model.TipoGenero;
import org.junit.jupiter.api.Test;
import com.lucatic.bluedevteam.servicios.JuegosServicio;
import com.lucatic.bluedevteam.servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

class ListarFiltrandoPorGeneroTest {
    private JuegosServicio juegosServicio;

    public void cargarDatos() {

        try {
            juegosServicio = new JuegosServicioImpl();
            juegosServicio.cargarDatos("vgsales.csv");
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public void noCargar() {

        juegosServicio = new JuegosServicioImpl();
    }

    @Test
    public void listarFiltrandoPorGeneroCargarNoExiste() {
        cargarDatos();
        assertThrows(IllegalArgumentException.class, () -> juegosServicio.listarPorGenero(TipoGenero.valueOf("aaa")));
    }

    @Test
    public void listarFiltrandoPorGeneroCargarExiste() {
        try {
            cargarDatos();
            assertTrue(!juegosServicio.listarPorGenero(TipoGenero.PLATFORM).isEmpty());
        } catch (JuegoException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void listarFiltrandoPoGeneroNoCargarExiste() {
        noCargar();
        assertThrows(JuegoException.class, () -> juegosServicio.listarPorGenero(TipoGenero.PLATFORM));
    }

}