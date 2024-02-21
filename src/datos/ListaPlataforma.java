package datos;

import java.util.HashSet;
import java.util.Set;

public class ListaPlataforma {
	private Set<String> plataformas = new HashSet<>();

	public void añadirPlataforma(String nombrePlataforma) {
		plataformas.add(nombrePlataforma);
	}
}
