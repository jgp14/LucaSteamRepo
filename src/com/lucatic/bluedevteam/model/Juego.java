package com.lucatic.bluedevteam.model;

import java.util.Objects;


/**
 * Clase que representa un Juego
 *
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 22-02-2024
 */
public class Juego {

	/** Ranking */
	private int ranking;
	/** Nombre del juego */
	private String nombre;
	/** Plataforma */
	private String plataforma;
	/** Fecha de lanzamiento del juego */
	private int fecha;
	/** Tipo de genero  enum */
	private TipoGenero tipoGenero;
	/** editor de juego */
	private String editor;

	/**
	 * Constructor sin parámetros
	 */
	public Juego() {
	}

	/**
	 * Constructor con parametros que inicializa un juego
	 * @param ranking rank
	 * @param nombre nombre juego
	 * @param plataforma plataforma
	 * @param fecha fecha de lanzamiento
	 * @param tipoGenero tipo de género
	 * @param editor Editor del juego
	 */
	public Juego(int ranking, String nombre, String plataforma, int fecha, TipoGenero tipoGenero, String editor) {
		this.ranking = ranking;
		this.nombre = nombre;
		this.plataforma = plataforma;
		this.fecha = fecha;
		this.tipoGenero = tipoGenero;
		this.editor = editor;
	}

	/**
	 * Getter ranking
	 *
	 * @return el rank
	 */
	public int getRanking() {
		return ranking;
	}

	/**
	 * Setter rank
	 * @param ranking el rank
	 */
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	/**
	 * Obtener nombre
	 *
	 * @return el nombre del juego
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter nombre
	 * @param nombre nonbre juego
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene plataforma
	 *
	 * @return la plataforma
	 */
	public String getPlataforma() {
		return plataforma;
	}

	/**
	 * Setter plataforma
	 * @param plataforma la plataforma
	 */
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * Getter fecha
	 * @return la fecha lanzamiento
	 */
	public int getFecha() {
		return fecha;
	}

	/**
	 * Setter fecha
	 * @param fecha fecha lanzamiento
	 */
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	/**
	 * Getter tipo genero
	 * @return tipo genero
	 */
	public TipoGenero getTipoGenero() {
		return tipoGenero;
	}

	/**
	 * Setter tipo genero
	 * @param tipoGenero tipo genero
	 */
	public void setTipoGenero(TipoGenero tipoGenero) {
		this.tipoGenero = tipoGenero;
	}

	/**
	 * Getter editor
	 *
	 * @return el editor
	 */
	public String getEditor() {
		return editor;
	}

	/**
	 * Setter editor
	 * @param editor el editor del juego
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}

	/**
	 * toString
	 * @return devuelve el toString
	 */
	@Override
	public String toString() {
		return "Juego [ranking=" + ranking + ", nombre=" + nombre + ", plataforma=" + plataforma + ", fecha=" + fecha
				+ ", tipoGenero=" + tipoGenero + ", editor=" + editor + "]";
	}

	/**
	 * Hashcode
	 * @return el hashcode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(editor, fecha, nombre, plataforma, ranking, tipoGenero);
	}

	/**
	 * Equals para comparar objetos
	 * @param obj objeto genérico object
	 * @return si es igual o distinto
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juego other = (Juego) obj;
		return Objects.equals(editor, other.editor) && fecha == other.fecha && Objects.equals(nombre, other.nombre)
				&& Objects.equals(plataforma, other.plataforma) && ranking == other.ranking
				&& Objects.equals(tipoGenero, other.tipoGenero);
	}

	/**
	 * Juego válido
	 * @return devuelve el juego válido
	 */
	public boolean isJuegoValido() {
		return ranking != 0 && nombre != null && plataforma != null && fecha != 0 && tipoGenero != null
				&& editor != null;
	}

}
