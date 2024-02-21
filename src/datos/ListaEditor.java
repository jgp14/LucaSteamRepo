package datos;

import java.util.HashSet;
import java.util.Set;

public class ListaEditor {

	private Set<String> editores = new HashSet<>();

	public void añadirEditor(String nombreEditor) {
		editores.add(nombreEditor);

	}
}
