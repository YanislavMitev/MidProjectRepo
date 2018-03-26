package bg.dominos.exceptions;

public class AddressException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1511594633676846745L;

	public AddressException() {
	}

	public AddressException(String message) {
		super(message);
	}

	public AddressException(Throwable cause) {
		super(cause);
	}

	public AddressException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}