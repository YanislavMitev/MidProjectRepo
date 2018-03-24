package bg.dominos.exceptions;

public class CannotRemoveFromBasketException extends Exception {

	public CannotRemoveFromBasketException() {
		super();
	}

	public CannotRemoveFromBasketException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CannotRemoveFromBasketException(String message, Throwable cause) {
		super(message, cause);
	}

	public CannotRemoveFromBasketException(String message) {
		super(message);
	}

	public CannotRemoveFromBasketException(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -9203043292553340987L;

}
