package control;

import excepciones.JuegoException;
import model.Juego;
import model.TipoGenero;
import servicios.JuegosServicioImpl;
import util.LeeDatos;

public class JuegosControlador {
	JuegosServicioImpl servicio= new JuegosServicioImpl();
		public void incio() {
			
		} 
		public void cargarDatos() {
			
		}
		public void altaJuego() {
			try {
				Juego juego= new Juego();
				System.out.println("Introduce ranking");
				int ranking=LeeDatos.leeInt();
				System.out.println("Intrdoduce el nombre");
				String nombre = LeeDatos.leeString();
				System.out.println("Introduce la plataforma");
				String plataforma = LeeDatos.leeString();
				System.out.println("Intoduce fecha");
				int añoFecha=LeeDatos.leeInt();
				System.out.println("Introduce tipo genero");
				TipoGenero tipoGenero=TipoGenero.valueOf(LeeDatos.leeString());
				System.out.println("Introduce el editor");
				String editor=LeeDatos.leeString();
				juego.setRanking(ranking);
				juego.setNombre(nombre);
				juego.setPlataforma(plataforma);
				juego.setFecha(añoFecha);
				juego.setTipoGenero(tipoGenero);
				juego.setEditor(editor);
				servicio.cargarDatos(nombre);
			}catch (JuegoException e) {
				System.out.println("error");
			}
		}
		
	
}
