package com.lucatic.bluedevteam.pruebas;


import com.lucatic.bluedevteam.excepciones.JuegoException;
import com.lucatic.bluedevteam.model.Juego;
import org.junit.jupiter.api.Test;
import com.lucatic.bluedevteam.servicios.JuegosServicio;
import com.lucatic.bluedevteam.servicios.JuegosServicioImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListarJuegosTest {

    private final JuegosServicio servicio = new JuegosServicioImpl();

    @Test
    public void listarJuegosSinCargarDatos() {
        assertThrows(JuegoException.class, () -> servicio.listarJuegos());
    }

    @Test
    public void listarJuegosCargarDatos() {

        List<Juego> juegos;
        try {
            servicio.cargarDatos("vgsales.csv");
            juegos = servicio.listarJuegos();
            assertFalse(juegos.isEmpty());
        } catch (JuegoException e) {
            throw new RuntimeException(e);
        }

    }
}