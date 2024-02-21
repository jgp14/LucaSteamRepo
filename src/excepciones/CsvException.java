package excepciones;

public class CsvException extends JuegoException {

	public CsvException(String msg) {
		super(msg);
	}

	public CsvException(String msg, Throwable e) {
		super(msg, e);
	}

}
