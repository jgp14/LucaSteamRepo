package com.lucatic.bluedevteam.datos;

import java.util.HashSet;
import java.util.Objects;
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

    public int sizePlataformas() {
        return plataformas.size();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ListaPlataforma)) return false;
        ListaPlataforma that = (ListaPlataforma) object;
        return Objects.equals(plataformas, that.plataformas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plataformas);
    }

    @Override
    public String toString() {
        return "ListaPlataforma{" + "plataformas=" + plataformas + '}';
    }
}
