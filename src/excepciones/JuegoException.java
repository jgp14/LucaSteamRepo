package excepciones;

public class JuegoException extends Exception {

	public JuegoException(String msg) {
		super(msg);
	}

	public JuegoException(String msg, Throwable e) {
		super(msg, e);
	}

}
