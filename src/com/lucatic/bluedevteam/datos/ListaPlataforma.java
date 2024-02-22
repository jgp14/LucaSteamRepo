package com.lucatic.bluedevteam.datos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/**
 * Clase que encapsula una lista de valores unica de plataformas
 * @since 22/02/2024
 * @author BlueDevTeam
 * @version 1.0.0
 */
public class ListaPlataforma {

	/**
	 * Atributo que almacena plataformas de manera unica
	 */
    private Set<String> plataformas = new HashSet<>();

	/**
	 * Contructor por defecto
	 */
    public ListaPlataforma() {
    }
	/**
	 * 
	 * @param nombrePlataforma
	 */
    public void anadirPlataforma(String nombrePlataforma) {
        plataformas.add(nombrePlataforma);
    }
    /**
	 * Devuelve una lista de valores unicos de tipos de plataformas
	 * @return Devuelve una lista de valores unicos de tipos de plataformas
	 */
    public Set<String> getPlataformas() {
        return plataformas;
    }
    /**
     * Modifica la lista de valores unicos de plataformas
     * @param plataformas
     */
    public void setPlataformas(Set<String> plataformas) {
        this.plataformas = plataformas;
    }
    /**Devuelve el tamaño de la cantidad de datos almacenados en la lista de valores unicos
     * @return Devuelve el tamaño de la cantidad de datos almacenados en la lista de valores unicos
     */
    public int sizePlataformas() {
        return plataformas.size();
    }
    /**
     * Sobreescribe el metodo equals para comparar entre objetos del mismo tipo
     * @param object
     * return devuelve true o false dependiendo de la igualdad de los objetos
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ListaPlataforma)) return false;
        ListaPlataforma that = (ListaPlataforma) object;
        return Objects.equals(plataformas, that.plataformas);
    }
	/**
	 * Sobreescribe el metodo hashCode generando uno para este tipo de objeto
	 * @return Devuelve el hash en tipo entero
	 */
    @Override
    public int hashCode() {
        return Objects.hash(plataformas);
    }
    /**
     * Sobreescribe el metodo toString para listar el contenido de la lista de plataformas
     * @return Representa de manera textual el contenido de la lista plataformas
     */
    @Override
    public String toString() {
        return "ListaPlataforma{" + "plataformas=" + plataformas + '}';
    }

}
