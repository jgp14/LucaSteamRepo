package excepciones;

/**
 * Clase CSV que hereda de JuegoException usada en la clase de utilidad CsvUtils
 * para cargar el .csv
 * 
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 22-02-2024
 */
public class CsvException extends JuegoException {

	public CsvException(String msg) {
		super(msg);
	}

	public CsvException(String msg, Throwable e) {
		super(msg, e);
	}

}
