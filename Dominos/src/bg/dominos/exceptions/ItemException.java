package bg.dominos.exceptions;

public class ItemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3598434663114123947L;

	public ItemException() {
	}

	public ItemException(String message) {
		super(message);
	}

	public ItemException(Throwable cause) {
		super(cause);
	}

	public ItemException(String message, Throwable cause) {
		super(message, cause);
	}

	public ItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
