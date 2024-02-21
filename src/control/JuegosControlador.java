package control;

import excepciones.CsvException;

import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;
import servicios.JuegosServicioImpl;
import util.LeeDatos;

import datos.DAOJuegosImp;
import vista.Menu;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JuegosControlador {

	private static final Logger LOGGER = Logger.getLogger(JuegosControlador.class.getName());


	JuegosServicioImpl servicio = new JuegosServicioImpl();

	public void cargarDatos() {
		try {
			servicio.cargarDatos("vgsales.csv");
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
			
			String nombreFichero = "vgsales.csv";
			try {
				servicio.cargarDatos(nombreFichero);
				//System.out.println(dao.getJuegos().toString());
			} catch (CsvException e) {
				e.printStackTrace();
			}
			break;

		case 7:
			// ALTA DE UN JUEGO
			altaJuego();
			break;

		case 0:
			continuar = false;
			break;
		}

		return continuar;
	}


}
