package bg.dominos.exceptions;

public class CannotRemoveIngredientException extends Exception {

	public CannotRemoveIngredientException() {
		super();
	}

	public CannotRemoveIngredientException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CannotRemoveIngredientException(String message, Throwable cause) {
		super(message, cause);
	}

	public CannotRemoveIngredientException(String message) {
		super(message);
	}

	public CannotRemoveIngredientException(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1021319197673198168L;

}
