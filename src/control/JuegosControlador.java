package control;

import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import datos.ListaEditor;
import servicios.JuegosServicio;
import servicios.JuegosServicioImpl;
import util.LeeDatos;

import vista.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;
/**
 * Clase JuegoControlador que se instancia de en la main y carga el 
 * metodo de inicio que aparece un meotodo y se muestra una seleccion de opciones.
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 22-02-2024
 */
public class JuegosControlador {

    private static final Logger LOGGER = LogManager.getLogger(JuegosControlador.class);

    JuegosServicio juegosServicio = new JuegosServicioImpl();

    /**
     * Inicia el programa, se lanza en la main. 
     * Empieza un bucle que muestra un menu de opciones y 
     * un input de opcion pasada por teclado.
     */
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
            } catch (IllegalArgumentException e) {
                LOGGER.error("Error al introducir enumerado");
            }
        }
    }

    /**
     * Switch-case que segun el entero introducido 
     * por teclado pasa por una o otra opcion de las 
     * funcionalidades del programa y controlador.. 
     * @return
     * @throws JuegoException
     * @throws InputMismatchException
     */
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
                mostrarListaEditores(juegosServicio.getListaEditores());

                break;
	        case 5:
				// LISTADO JUEGOS FILTRADO POR PLATAFORMAS(CONSOLAS)
				String plataforma = listarPlataformas();
				juegosServicio.listarPorPlataforma(plataforma).forEach(System.out::println);
				break;
	
	        case 6:
	            // LISTADO JUEGOS FILTRADO POR GENERO PLATAFORMA
	            mostrarLista(juegosServicio.listarGeneroPorPlataforma());
	            break;
	
	        case 7:
	            // LISTADO JUEGOS FILTRADOS POR SIGLO
	            listarPorSigloXX();
	            break;
	
	        case 8:
	            // LISTADO JUEGOS FILTRADO POR GENERO
	            TipoGenero genero = listarPorGenero();
	            mostrarLista(juegosServicio.listarPorGenero(genero));
	            break;
	        case 9:
	        	// LISTAR JUEGO POR AÑOS PARES
	            listarPorAnhosPares();
	            break;
	
	        case 0:
	            continuar = false;
	            break;
	        }

        return continuar;
    }

    /**
     * Recoge por consola valores de campos que 
     * despues se meten en un objeto nuevo de clase Juego. 
     * Tras completar todos los atributos se llama 
     * al metodo altaJuego de servicio.
     * @throws InputMismatchException
     * @throws JuegoException
     */
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

    /**
     * Muestra por consola la lista linea a linea de todos los Editores.
     * Ordenados alfabeticamente.
     * @param listaEditores
     */
    public static void mostrarListaEditores(ListaEditor listaEditores) {
    	List<String> editoresSorted = new ArrayList<>(listaEditores.getEditores());
    	Collections.sort(editoresSorted);
    	editoresSorted.forEach(System.out::println);
    }

    /**
     * Muestra e imprime consola la lista de juegos que previamente se paso como parametro.     
     * @param juegos
     */
    public static void mostrarLista(List<Juego> juegos) {
        juegos.forEach(System.out::println);
    }

    /**
     * Muestra por consola una lista de juegos que son 
     * todas de un mismo tipo de plataformas ordenadas.
     * @return
     */
    public String listarPlataformas() {

        Set<String> plataformas = juegosServicio.getListaPlataformas().getPlataformas();
        List<String> plataformasList = new ArrayList<>(plataformas);
        Collections.sort(plataformasList);
        System.out.println("Elige un editor de la lista: ");

        for (int i = 0; i < plataformasList.size(); i++) {
            System.out.println((i + 1) + " - " + plataformasList.get(i));
        }
        int n;
        do {
            System.out.print("Dime codigo de plataforma: ");
            n = LeeDatos.leerInt();
        } while (n <= 0 || n > plataformasList.size());

        return plataformasList.get(n - 1);
    }

    /**
     * Listado de juegos ordenados que esten comprendidos en el siglo XX
     * @throws JuegoException
     */
    public void listarPorSigloXX() throws JuegoException {
        List<Juego> juegosSigloXX = juegosServicio.listarPorSigloXX();
        Collections.sort(juegosSigloXX, Comparator.comparingInt(Juego::getFecha));;
        for (Juego sigloXX : juegosSigloXX) {
            System.out.println(sigloXX);
        }
    }

    /**
     * Muestra un menu de opciones con los distintos 
     * tipos de generos y despues pide por consola un 
     * codigo y muestra la lista de juegos que comparten 
     * genero.
     * @return
     */
    public TipoGenero listarPorGenero() {
        for (int i = 0; i < TipoGenero.values().length; i++) {
            System.out.println((i + 1) + " - " + TipoGenero.values()[i]);
        }
        int n;
        do {
            System.out.print("Dime el codigo de genero de videojuego: ");
            n = LeeDatos.leerInt();
        } while (n <= 0 || n > TipoGenero.values().length);
        return TipoGenero.values()[n - 1];
    }

    /**
     * Muestra la lista de juegos cuyo año de lanzamiento fue en un año par.
     * @throws JuegoException
     */
    public void listarPorAnhosPares() throws JuegoException {
        List<Juego> juegosAnhosPares = juegosServicio.listarPorAnhosPares();
        for (Juego juego : juegosAnhosPares) {
            System.out.println(juego.toString());
        }
    }

}
