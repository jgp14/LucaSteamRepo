package model;

public class Juego {

    private int ranking;
    private String nombre;
    private String plataforma;
    private int fecha;
    private TipoGenero tipoGenero;
    private String editor;

    public Juego(int ranking, String nombre, String plataforma, int fecha, TipoGenero tipoGenero, String editor) {
        this.ranking = ranking;
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.fecha = fecha;
        this.tipoGenero = tipoGenero;
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "ranking=" + ranking +
                ", nombre='" + nombre + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", fecha=" + fecha +
                ", tipoGenero=" + tipoGenero +
                ", editor='" + editor + '\'' +
                '}';
    }
}
