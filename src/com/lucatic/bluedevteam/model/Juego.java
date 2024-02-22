package com.lucatic.bluedevteam.model;

import java.util.Objects;

public class Juego {

    private int ranking;
    private String nombre;
    private String plataforma;
    private int fecha;
    private TipoGenero tipoGenero;
    private String editor;

    public Juego() {
    }

    public Juego(int ranking, String nombre, String plataforma, int fecha, TipoGenero tipoGenero, String editor) {
        this.ranking = ranking;
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.fecha = fecha;
        this.tipoGenero = tipoGenero;
        this.editor = editor;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public TipoGenero getTipoGenero() {
        return tipoGenero;
    }

    public void setTipoGenero(TipoGenero tipoGenero) {
        this.tipoGenero = tipoGenero;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "Juego [ranking=" + ranking + ", nombre=" + nombre + ", plataforma=" + plataforma + ", fecha=" + fecha
                + ", tipoGenero=" + tipoGenero + ", editor=" + editor + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(editor, fecha, nombre, plataforma, ranking, tipoGenero);
    }

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

    public boolean isJuegoValido() {
        return ranking != 0 && nombre != null && plataforma != null && fecha != 0 && tipoGenero != null
                && editor != null;
    }

}
