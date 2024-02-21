package datos;

import java.util.HashSet;
import java.util.Set;

public class ListaPlataforma {

	private Set<String> plataformas = new HashSet<>();

	public ListaPlataforma() {
	}

	public void anadirPlataforma(String nombrePlataforma) {
		plataformas.add(nombrePlataforma);
	}

	public Set<String> getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(Set<String> plataformas) {
		this.plataformas = plataformas;
	}

	@Override
	public String toString() {
		return "ListaPlataforma{" +
				"plataformas=" + plataformas +
				'}';
	}
}
