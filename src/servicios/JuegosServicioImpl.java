package servicios;

import datos.DAOJuegosImp;

public class JuegosServicioImpl implements JuegosServicio {
	DAOJuegosImp datos = new DAOJuegosImp();
	@Override
	public void cargarDatos(String nombreFichero) {
		//datos.cargarDatos("nombrefichero.txt");
		
	}

}
