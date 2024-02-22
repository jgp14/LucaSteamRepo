package pruebas;

import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicios.JuegosServicio;
import servicios.JuegosServicioImpl;

import static org.junit.jupiter.api.Assertions.*;

**
* Clase de pruebas unitarias para JuegosServiciosImpl.
* 
* @since 22/02/2024
* @author BlueDevTeam
* @version 1.0.0
*/

class JuegosServicioImplTest {

    private JuegosServicio servicio;
    
    /**
     * Configuración inicial para cada prueba.
     */

    @BeforeEach
    void inicio() {
        servicio = new JuegosServicioImpl();

        try {
            servicio.cargarDatos("vgsales.csv");
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Prueba para verificar el manejo de excepciones al intentar cargar datos desde un archivo que no existe.
     */

    @Test
    public void cargarDatosFicheroNoExiste() {
        assertThrows(CsvException.class, () -> servicio.cargarDatos("holamundo.cv"), "Cargar datos con un fichero que no existe");
    }
    
    /**
     * Prueba para verificar el manejo de excepciones al intentar cargar datos desde un archivo nulo.
     */

    @Test
    public void cargarDatosNull() {
        assertThrows(CsvException.class, () -> servicio.cargarDatos(null), "Cargar datos con fichero nulo");
    }
    
    /**
     * Prueba para verificar el manejo de excepciones al intentar dar de alta un juego con objeto nulo.
     */

    @Test
    public void altaJuegoNull() {
        assertThrows(JuegoException.class, () -> servicio.altaJuego(null), "Prueba alta juego con null");
    }
    
    /**
     * Prueba para verificar el manejo de excepciones al intentar dar de alta un juego con un ID ya existente.
     */


    @Test
    public void altaJuegoConExistente() {
        assertThrows(JuegoException.class, () -> servicio.altaJuego(
                new Juego(1, "Wii Sports", "Wii", 2006, TipoGenero.SPORTS, "Nintendo")), "Alta juego con objeto existente");
    }
    
    /**
     * Prueba para verificar que se pueda dar de alta un juego que aún no existe.
     */


    @Test
    public void altaJuegoNoExistente() {
        assertDoesNotThrow(() -> servicio.altaJuego(new Juego(1, "aaa", "aaa", 2020, TipoGenero.ACTION, "aaa")));
    }
    
    /**
     * Prueba para verificar el manejo de excepciones al intentar dar de alta un juego con objeto vacío.
     */

    @Test
    public void altaJuegoVacio() {
        assertThrows(JuegoException.class, () -> servicio.altaJuego(new Juego()), "Dando de alta Juego con objeto vacío");
    }

}