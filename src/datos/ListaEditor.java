package datos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/**
 * Clase que encapsula una lista de valores unica de editores
 * 
 * @since 22/02/2024
 * @author BlueDevTeam
 * @version 1.0.0
 */
public class ListaEditor {
	/**
	 * Atributo que almacena editores de manera unica
	 */
    private Set<String> editores = new HashSet<>();
    /**
     * Contstructor vacio de clase
     */
    public ListaEditor() {
    }
    /**
     * Añade el nombre de un editor a la lista unica de editores
     * @param nombreEditor
     */
    public void anadirEditor(String nombreEditor) {
        editores.add(nombreEditor);
    }
    /**
     * Devuelve una lista unica de editores
     * @return Devuelve una lista unica de editores
     */
    public Set<String> getEditores() {
        return editores;
    }
    /**
     * Reestablece una linea diferente de editores
     * @param editores
     */
    public void setEditores(Set<String> editores) {
        this.editores = editores;
    }
    /**
     * Devuelve el numero de editores en la lista unica de editores
     * @return Devuelve el numero de editores en la lista unica de editores
     */
    public int getSizeListaEditor() {
        return editores.size();
    }
    /**
     * Sobreescribe el metodo equals para comparar entre objetos del mismo tipo
     * @param object
     * return devuelve true o false dependiendo de la igualdad de los objetos
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ListaEditor)) return false;
        ListaEditor that = (ListaEditor) object;
        return Objects.equals(editores, that.editores);
    }
    /**
	 * Sobreescribe el metodo hashCode generando uno para este tipo de objeto
	 * @return Devuelve el hash en tipo entero
	 */
    @Override
    public int hashCode() {
        return Objects.hash(editores);
    }
    /**
     * Sobreescribe el metodo toString para listar el contenido de la lista de plataformas
     * @return Representa de manera textual el contenido de la lista plataformas
     */
    @Override
    public String toString() {
        return "ListaEditor{" + "editores=" + editores + '}';
    }
}
