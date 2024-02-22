package com.lucatic.bluedevteam.pruebas;

import com.lucatic.bluedevteam.excepciones.CsvException;
import com.lucatic.bluedevteam.excepciones.JuegoException;
import com.lucatic.bluedevteam.model.Juego;
import com.lucatic.bluedevteam.model.TipoGenero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.lucatic.bluedevteam.servicios.JuegosServicio;
import com.lucatic.bluedevteam.servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

class JuegosServicioImplTest {

    private JuegosServicio servicio;

    @BeforeEach
    void inicio() {
        servicio = new JuegosServicioImpl();

        try {
            servicio.cargarDatos("vgsales.csv");
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void cargarDatosFicheroNoExiste() {
        assertThrows(CsvException.class, () -> servicio.cargarDatos("holamundo.cv"), "Cargar datos con un fichero que no existe");
    }

    @Test
    public void cargarDatosNull() {
        assertThrows(CsvException.class, () -> servicio.cargarDatos(null), "Cargar datos con fichero nulo");
    }

    @Test
    public void altaJuegoNull() {
        assertThrows(JuegoException.class, () -> servicio.altaJuego(null), "Prueba alta juego con null");
    }


    @Test
    public void altaJuegoConExistente() {
        assertThrows(JuegoException.class, () -> servicio.altaJuego(
                new Juego(1, "Wii Sports", "Wii", 2006, TipoGenero.SPORTS, "Nintendo")), "Alta juego con objeto existente");
    }


    @Test
    public void altaJuegoNoExistente() {
        assertDoesNotThrow(() -> servicio.altaJuego(new Juego(1, "aaa", "aaa", 2020, TipoGenero.ACTION, "aaa")));
    }

    @Test
    public void altaJuegoVacio() {
        assertThrows(JuegoException.class, () -> servicio.altaJuego(new Juego()), "Dando de alta Juego con objeto vacío");
    }

}