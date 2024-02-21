package test;

import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicios.JuegosServicio;
import servicios.JuegosServicioImpl;

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
    void cargarDatos() {
            assertThrows(CsvException.class, () -> servicio.cargarDatos(null), "Correcto");
            assertThrows(CsvException.class, () -> servicio.cargarDatos("holamundo.cv"), "coreccto");
    }

    @Test
    void altaJuego() {

        assertAll("comprobando alta juegos",

                () -> assertThrows(JuegoException.class, () -> servicio.altaJuego(null)),
                () -> assertThrows(JuegoException.class, () -> servicio.altaJuego(
                        new Juego(1, "Wii Sports", "Wii", 2006, TipoGenero.SPORTS, "Nintendo"))),
                () -> assertDoesNotThrow(() -> servicio.altaJuego(new Juego(1, "aaa", "aaa", 2020, TipoGenero.ACTION, "aaa"))),
                () -> assertThrows(JuegoException.class, () -> servicio.altaJuego(new Juego()))
        );
    }

    @Test
    public void TestCargarDatos()
    {
        try
        {
            servicio.cargarDatos(null);
            fail("Should have thrown SomeException but did not!");
        }
        catch( final CsvException e )
        {
            final String msg = "Fichero con valor null";
            assertEquals(msg, e.getMessage());
        }
    }


}