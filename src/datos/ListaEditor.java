package datos;

import java.util.HashSet;
import java.util.Objects;
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

    public int getSizeListaEditor() {
        return editores.size();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ListaEditor)) return false;
        ListaEditor that = (ListaEditor) object;
        return Objects.equals(editores, that.editores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(editores);
    }

    @Override
    public String toString() {
        return "ListaEditor{" + "editores=" + editores + '}';
    }
}
