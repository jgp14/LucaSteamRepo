package datos;

import java.util.HashSet;
import java.util.Set;

public class ListaEditor {

	private Set<String> editores = new HashSet<>();


	public ListaEditor() {
	}

	public void anadirEditor(String nombreEditor) {
		editores.add(nombreEditor);
	}

	public Set<String> getEditores() {
		return editores;
	}

	public void setEditores(Set<String> editores) {
		this.editores = editores;
	}

	@Override
	public String toString() {
		return "ListaEditor{" +
				"editores=" + editores +
				'}';
	}
}
