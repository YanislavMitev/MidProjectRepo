package bg.dominos.exceptions;

public class IllegalWorkingTimeException extends Exception {
	public IllegalWorkingTimeException() {
		super();
	}

	public IllegalWorkingTimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalWorkingTimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalWorkingTimeException(String message) {
		super(message);
	}

	public IllegalWorkingTimeException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 8225294531512706866L;

}
