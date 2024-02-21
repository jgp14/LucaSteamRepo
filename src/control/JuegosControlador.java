package control;

import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import servicios.JuegosServicio;
import servicios.JuegosServicioImpl;
import util.LeeDatos;

import vista.Menu;

import java.util.InputMismatchException;
import java.util.List;

public class JuegosControlador {

    private static final Logger LOGGER = LogManager.getLogger(JuegosControlador.class);

    JuegosServicio juegosServicio = new JuegosServicioImpl();

    public void inicio() {

        boolean salirGeneral = false;

        while (!salirGeneral) {

            try {
                boolean seguir = true;

                do {
                    Menu.mostrarMenu();
                    seguir = this.seleccionOpciones();
                } while (seguir);

                LOGGER.info("Fin de la sesión");
                salirGeneral = true;

            } catch (JuegoException e) {
                LOGGER.error("Error en la aplicacion: ", e);
            } catch (InputMismatchException e) {
                LOGGER.error("Error introduciendo datos", e);
            }
        }
    }

    public void altaJuego() throws InputMismatchException, JuegoException {

        Juego juego = new Juego();

        int ranking = LeeDatos.leerInt("Introdue ranking");

        String nombre = LeeDatos.leerString("Intrdoduce el nombre");
        String plataforma = LeeDatos.leerString("Introduce la plataforma");
        int anioFecha = LeeDatos.leerInt("Intoduce fecha");
        TipoGenero tipoGenero = TipoGenero.valueOf(LeeDatos.leerString("Introduce tipo genero"));
        String editor = LeeDatos.leerString("Introduce el editor");

        juego.setRanking(ranking);
        juego.setNombre(nombre);
        juego.setPlataforma(plataforma);
        juego.setFecha(anioFecha);
        juego.setTipoGenero(tipoGenero);
        juego.setEditor(editor);

        juegosServicio.altaJuego(juego);
    }

    public boolean seleccionOpciones() throws JuegoException, InputMismatchException {

        boolean continuar = true;

        switch (LeeDatos.leerInt()) {

            case 1:
                juegosServicio.cargarDatos("vgsales.csv");
                break;

            case 2:
                // ALTA DE UN JUEGO
                altaJuego();
                break;

            case 3:
                // LISTADO JUEGOS
                mostrarLista(juegosServicio.listarJuegos());
                break;

            case 4:
                // LISTADO EDITORES

                break;

            case 5:
                // LISTADO JUEGOS FILTRADO POR GENERO PLATAFORMA
                mostrarLista(juegosServicio.listarGeneroPorPlataforma());
                break;

            case 6:
                // LISTADO JUEGOS FILTRADO POR GENERO

                break;

            case 8:

                break;

            case 0:
                continuar = false;
                break;
        }

        return continuar;
    }

    public static void mostrarLista(List<Juego> juegos) {

        juegos.forEach(System.out::println);
    }

}
