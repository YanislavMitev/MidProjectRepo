package dominos.exceptions;

public class BasketException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5467911739658383909L;

	public BasketException() {
		super();
	}

	public BasketException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BasketException(String message, Throwable cause) {
		super(message, cause);
	}

	public BasketException(String message) {
		super(message);
	}

	public BasketException(Throwable cause) {
		super(cause);
	}


}
