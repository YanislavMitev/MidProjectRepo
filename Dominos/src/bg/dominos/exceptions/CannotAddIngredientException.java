package bg.dominos.exceptions;

public class CannotAddIngredientException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2616779227646123796L;

	public CannotAddIngredientException() {
		super();
	}

	public CannotAddIngredientException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CannotAddIngredientException(String message, Throwable cause) {
		super(message, cause);
	}

	public CannotAddIngredientException(String message) {
		super(message);
	}

	public CannotAddIngredientException(Throwable cause) {
		super(cause);
	}
	

}
