package control;

import datos.DAOJuegosImp;
import excepciones.CsvException;

public class Main {

	public static void main(String[] args) {

		new JuegosControlador().incio();
		

		//Prueba Cargar Datos
		/*DAOJuegosImp dao = new DAOJuegosImp();
		String nombreFichero= "vgsales.csv";
		try {
			dao.cargarDatos(nombreFichero);
		} catch (CsvException e) {
			e.printStackTrace();
		}*/

	}
}
