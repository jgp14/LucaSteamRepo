package control;

import excepciones.CsvException;
import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;
import servicios.JuegosServicioImpl;
import util.LeeDatos;
import datos.DAOJuegosImp;
import vista.Menu;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JuegosControlador {

	private static final Logger LOGGER = Logger.getLogger(JuegosControlador.class.getName());


	JuegosServicioImpl servicio = new JuegosServicioImpl();

	public void incio() {
		boolean seguir = true;
		do {
			Menu.mostrarMenu();
			seguir = this.seleccionOpciones();
		} while (seguir);
		System.out.println("   --- Fin de la sesion ---");
	}

	public void altaJuego() {
		try {
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
		} catch (JuegoException e) {
			LOGGER.log(Level.SEVERE, "Error en el controlador" , e);
		}
	}

	public boolean seleccionOpciones() {

		boolean continuar = true;
		switch (LeeDatos.leeInt()) {
		case 1:
			cargarDatos();
			break;

		case 2:
			// ALTA DE UN JUEGO
			altaJuego();	
			break;
		case 3:
			// LISTADO JUEGOS 
			listarJuegos();
			break;
		case 4:
			// LISTADO EDITORES 

			break;
		case 5:
			// LISTADO JUEGOS FILTRADO POR GENERO PLATAFORMA 
		
			break;
		case 6:
			// LISTADO JUEGOS FILTRADO POR GENERO 

			
			break;
		case 7:
			// LISTADO JUEGOS DEL SIGLO XX
			
			break;
		case 8:
			
			break;
		case 0:
			continuar = false;
			break;
		}

		return continuar;
	}

	public void cargarDatos() {
		try {
			servicio.cargarDatos("vgsales.csv");
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}
	
	public void listarJuegos() {
		try {
			mostrarLista(servicio.listarJuegos());
		}catch (JuegoException e) {
			e.printStackTrace();
		}
	}
	
	public static void mostrarLista(List<Juego> juegos) {
		juegos.forEach(System.out::println);
	}
}
