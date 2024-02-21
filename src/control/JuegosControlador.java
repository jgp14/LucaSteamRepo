package control;

import excepciones.CsvException;

import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;
import servicios.JuegosServicio;
import servicios.JuegosServicioImpl;
import util.LeeDatos;

import vista.Menu;

import java.util.List;
import java.util.logging.Logger;

public class JuegosControlador {

	private static final Logger LOGGER = Logger.getLogger(JuegosControlador.class.getName());

	JuegosServicio servicio = new JuegosServicioImpl();

	public void incio() {
		boolean salirGeneral = false;

		while (!salirGeneral) {
			try {
				boolean seguir = true;
				do {
					Menu.mostrarMenu();
					seguir = this.seleccionOpciones();
				} while (seguir);
				System.out.println("   --- Fin de la sesion ---");
				salirGeneral = true;
			} catch (Exception e) {
				System.err.println("error");
				System.err.println(e);
			}
		}
	}

	public void altaJuego() throws JuegoException {
		Juego juego = new Juego();
		System.out.println("Introduce ranking");
		int ranking = LeeDatos.leeInt();
		System.out.println("Intrdoduce el nombre");
		String nombre = LeeDatos.leeString();
		System.out.println("Introduce la plataforma");
		String plataforma = LeeDatos.leeString();
		System.out.println("Intoduce fecha");

		int añoFecha = LeeDatos.leeInt();
		System.out.println("Introduce tipo genero");
		TipoGenero tipoGenero = TipoGenero.valueOf(LeeDatos.leeString());
		System.out.println("Introduce el editor");
		String editor = LeeDatos.leeString();

		juego.setRanking(ranking);
		juego.setNombre(nombre);
		juego.setPlataforma(plataforma);
		juego.setFecha(añoFecha);
		juego.setTipoGenero(tipoGenero);
		juego.setEditor(editor);
		servicio.altaJuego(juego);
	}

	public boolean seleccionOpciones() throws JuegoException {
		boolean continuar = true;
		switch (LeeDatos.leeInt()) {
		case 1:
			servicio.cargarDatos("vgsales.csv");
			break;
		case 2:
			// ALTA DE UN JUEGO
			altaJuego();
			break;
		case 3:
			// LISTADO JUEGOS
			mostrarLista(servicio.listarJuegos());
			break;
		case 4:
			// LISTADO EDITORES

			break;
		case 5:
			// LISTADO JUEGOS FILTRADO POR GENERO PLATAFORMA
			mostrarLista(servicio.listarGeneroPorPlataforma());
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
