package bg.dominos.exceptions;

public class CannotAddToBasketException extends Exception {

	public CannotAddToBasketException() {
		super();
	}

	public CannotAddToBasketException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CannotAddToBasketException(String message, Throwable cause) {
		super(message, cause);
	}

	public CannotAddToBasketException(String message) {
		super(message);
	}

	public CannotAddToBasketException(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8096666330687930745L;

}
