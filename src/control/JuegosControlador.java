package control;

import java.util.List;

import datos.DAOJuegosImp;
import excepciones.CsvException;
import util.LeeDatos;
import vista.Menu;

public class JuegosControlador {
	
		public void incio() {
			boolean seguir = true;
			do {
				Menu.mostrarMenu();
				seguir = this.seleccionOpciones();
			} while (seguir);
			System.out.println("   --- Fin de la sesion ---");
		} 

		public void cargarDatos() {
			
		}
		
		public boolean seleccionOpciones() {

			boolean continuar = true;
			switch (LeeDatos.leerInt()) {
			case 1:
				// LISTAR JUEGOS
				//Prueba Cargar Datos
				DAOJuegosImp dao = new DAOJuegosImp();
				String nombreFichero= "vgsales.csv";
				try {
					dao.cargarDatos(nombreFichero);
					System.out.println(dao.getJuegos().toString());
				} catch (CsvException e) {
					e.printStackTrace();
				}
				break;

			case 7:
				// ALTA DE UN JUEGO
				break;

			case 0:
				continuar = false;
				break;
			}

			return continuar;
		}
	
}
