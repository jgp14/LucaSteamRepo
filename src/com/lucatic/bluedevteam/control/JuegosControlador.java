package com.lucatic.bluedevteam.control;


import com.lucatic.bluedevteam.excepciones.JuegoException;
import com.lucatic.bluedevteam.model.Juego;
import com.lucatic.bluedevteam.model.TipoGenero;
import com.lucatic.bluedevteam.util.LeeDatos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lucatic.bluedevteam.datos.ListaEditor;
import com.lucatic.bluedevteam.servicios.JuegosServicio;
import com.lucatic.bluedevteam.servicios.JuegosServicioImpl;

import com.lucatic.bluedevteam.vista.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;

/**
 * Clase controladora llamada desde el main con menú prnicipal y opciones
 * 
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 22-02-2024
 */
public class JuegosControlador {

	/**
	 * Logger log4j2
	 */
	private static final Logger LOGGER = LogManager.getLogger(JuegosControlador.class);

	/**
	 * Instancia del servicio
	 */
	private JuegosServicio juegosServicio = new JuegosServicioImpl();

	/**
	 * Método que incializa el programa
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
	 * Selecciona las opciones del programa
	 *
	 * @return false si salir o true si no
	 * @throws JuegoException Si hay error en la gestión del juego
	 * @throws InputMismatchException Errores de la clase Scanner en la lectura de datos por consola
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
			String plataforma = obtenerPlataforma();
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
			TipoGenero genero = seleccionaPorGenero();
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
	 * Método que da de alta un juego
	 *
	 * @throws InputMismatchException Excepción propagada en la lecutra de datos por consola
	 * @throws JuegoException Excepción programada en caso de error en la gestión del juego
	 */
	public void altaJuego() throws InputMismatchException, JuegoException {

		Juego juego = new Juego();

		int ranking = LeeDatos.leerInt("Introduce ranking");

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
	 * Mostrar lista editores
	 *
	 * @param listaEditores Objeto listaEditor que contiene los editores
	 */
	public static void mostrarListaEditores(ListaEditor listaEditores) {
		List<String> editoresSorted = new ArrayList<>(listaEditores.getEditores());
		Collections.sort(editoresSorted);
		editoresSorted.forEach(System.out::println);
	}


	/**
	 * Se encarga de mostrar todos los juegos almacenados
	 *
	 * @param juegos Lista que contiene todos los juegos almacenados
	 */
	public static void mostrarLista(List<Juego> juegos) {
		juegos.forEach(System.out::println);
	}

	/**
	 * Seleccionar plataforma
	 *
	 * @return Devuelve la plataforma seleccionada
	 */
	public String obtenerPlataforma() {

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
	 * Listar juegos por siglo xx
	 *
	 * @throws JuegoException ERror si no hay juegos del siglo xx o lista vacía
	 */
	public void listarPorSigloXX() throws JuegoException {

		List<Juego> juegosSigloXX = juegosServicio.listarPorSigloXX();

		juegosSigloXX.forEach(System.out::println);
	}

	/**
	 * Obteiene un genero determinado
	 *
	 * @return El tipo de genero enumerado
	 */
	public TipoGenero seleccionaPorGenero() {
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
	 * Se encarga de listar los juegos de los años pares
	 *
	 * @throws JuegoException Error si nos hay juegos de año spares o lista vacía
	 */
	public void listarPorAnhosPares() throws JuegoException {
		List<Juego> juegosAnhosPares = juegosServicio.listarPorAnhosPares();
		for (Juego juego : juegosAnhosPares) {
			System.out.println(juego.toString());
		}
	}

}
