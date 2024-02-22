package datos;

import java.util.ArrayList;
import java.util.List;

import excepciones.CsvException;
import model.Juego;
import model.TipoGenero;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.CsvUtils;

import excepciones.JuegoException;

public class DAOJuegosImpl implements DAOJuegos {

    private static int count = 0;

    private static final Logger LOGGER = LogManager.getLogger(DAOJuegosImpl.class);

    private List<Juego> juegos;
    private ListaEditor listaEditor;
    private ListaPlataforma listaPlataforma;

    public DAOJuegosImpl() {
        this.juegos = new ArrayList<>();
        this.listaEditor = new ListaEditor();
        this.listaPlataforma = new ListaPlataforma();
    }

    @Override
    public boolean existeJuego(Juego juegoCompara) {

        for (Juego juego : juegos) {

            if (juego.equals(juegoCompara)) {
                return true;
            }
        }
        return false;
    }

    public DAOJuegosImpl(List<Juego> juegos, ListaEditor listaEditor, ListaPlataforma listaPlataforma) {

        this.juegos = juegos;
        this.listaEditor = listaEditor;
        this.listaPlataforma = listaPlataforma;
    }

    public List<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }

    public ListaEditor getListaEditor() {
        return listaEditor;
    }

    public void setListaEditor(ListaEditor listaEditor) {
        this.listaEditor = listaEditor;
    }

    public ListaPlataforma getListaPlataforma() {
        return listaPlataforma;
    }

    public void setListaPlataforma(ListaPlataforma listaPlataforma) {
        this.listaPlataforma = listaPlataforma;
    }

    @Override
    public void cargarDatos(String nombreFichero) throws CsvException {

        if (count == 0) {
            try {
                if (!juegos.isEmpty()) {
                    juegos.addAll(CsvUtils.deCsvAList(nombreFichero));
                } else {
                    juegos = CsvUtils.deCsvAList(nombreFichero);
                }

                for (Juego juego : juegos) {
                    listaEditor.anadirEditor(juego.getEditor());
                    listaPlataforma.anadirPlataforma(juego.getPlataforma());
                }
                LOGGER.info("Juegos, Editores, Plataformas cargados correctamente");
            } catch (CsvException e) {
                throw e;
            }
            count++;
        } else {
            LOGGER.warn("Ya has cargado el csv anteriormente");
        }

    }

    @Override
    public void altaJuego(Juego juego) throws JuegoException {

        if (juego != null && juego.isJuegoValido()) {
            if (existeJuego(juego)) {
                LOGGER.warn("Juego ya existe no se puede dar de alta");
                throw new JuegoException("No se puede dar de alta porque el juego ya existe");
            } else {
                juegos.add(juego);
                listaEditor.anadirEditor(juego.getEditor());
                listaPlataforma.anadirPlataforma(juego.getPlataforma());
                LOGGER.info("Juego dado de alta " + juego.getNombre());
            }
        } else {
            LOGGER.warn("Error dadndo de alta juego, estás intentado dar de alta un juego incorrecto");
            throw new JuegoException("Intentado dar de alta un jeugo incorrecto");
        }
    }

    public List<Juego> listarPorGeneros(TipoGenero tipoGenero) throws JuegoException {

        List<Juego> juegosPorGenero = new ArrayList<>();

        for (int i = 0; i < juegos.size(); i++) {

            if (tipoGenero == juegos.get(i).getTipoGenero()) {
                juegosPorGenero.add(juegos.get(i));
            }
        }
        if (juegos.size() == 0) {
            throw new JuegoException("No hay juegos en la base");
        } else if (juegosPorGenero.size() == 0) {
            throw new JuegoException("No hay juegos en ese genero");
        }
        return juegosPorGenero;
    }

    @Override
    public List<Juego> listarJuegos() throws JuegoException {

        List<Juego> juegos = getJuegos();
        juegos = getJuegos();

        if (juegos != null && !juegos.isEmpty()) {
            return juegos;
        } else {
            String msg = "Lista de juegos es  vacia";
            LOGGER.warn(msg);
            throw new JuegoException(msg);
        }
    }

    public List<Juego> listarPorPlataforma(String nombrePlataforma) throws JuegoException {

        List<Juego> listaPorPlataforma = new ArrayList<Juego>();
        for (int i = 0; i < juegos.size(); i++) {
            if (juegos.get(i).getPlataforma().equalsIgnoreCase(nombrePlataforma)) {
                listaPorPlataforma.add(juegos.get(i));
            }
        }
        if (juegos.size() == 0) {
            String msg = "Lista de juegos es  vacia";
            LOGGER.warn(msg);
            throw new JuegoException(msg);
        } else if (listaPorPlataforma.size() == 0) {
            String msg = "No hay juegos en ese genero";
            LOGGER.warn(msg);
            throw new JuegoException(msg);
        }
        return listaPorPlataforma;
    }

    public List<Juego> listarPorSigloXX() throws JuegoException {
        List<Juego> juegosSigloXX = new ArrayList<Juego>();
        for (int i = 0; i < juegos.size(); i++) {
            if (juegos.get(i).getFecha() <= 2000 && juegos.get(i).getFecha() > 1900) {
                juegosSigloXX.add(juegos.get(i));
            }
        }
        if (juegos.size() == 0) {
            String msg = "Lista de juegos es  vacia";
            LOGGER.warn(msg);
            throw new JuegoException(msg);
        } else if (juegosSigloXX.size() == 0) {
            String msg = "No hay juegos en ese siglo";
            LOGGER.warn(msg);
            throw new JuegoException(msg);
        }
        return juegosSigloXX;
    }

    @Override
    public List<Juego> listarPorAnhosPares() throws JuegoException {
        List<Juego> juegosAnhosPares = new ArrayList<>();

        if (juegos.size() == 0) {
            String msg = "Lista de juegos es  vacia";
            LOGGER.warn(msg);
            throw new JuegoException(msg);
        }

        for (int i = 0; i < juegos.size(); i++) {
            if (juegos.get(i).getFecha() % 2 == 0) {
                juegosAnhosPares.add(juegos.get(i));
            }
        }

        if (juegosAnhosPares.size() == 0) {
            String msg = "No hay juegos en años pares";
            LOGGER.warn(msg);
            throw new JuegoException(msg);
        }
        return juegosAnhosPares;
    }
}
