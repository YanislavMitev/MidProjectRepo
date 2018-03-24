package bg.dominos.exceptions;

public class IllegalTypeException extends Exception {
	private static final long serialVersionUID = -1687926581886791343L;

	public IllegalTypeException() {
		super();
	}

	public IllegalTypeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalTypeException(String message) {
		super(message);
	}

	public IllegalTypeException(Throwable cause) {
		super(cause);
	}


}
