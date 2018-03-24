package bg.dominos.exceptions;

public class IllegalWeightException extends Exception {

	public IllegalWeightException() {
		super();
	}

	public IllegalWeightException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalWeightException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalWeightException(String message) {
		super(message);
	}

	public IllegalWeightException(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8452774606870850449L;

}
