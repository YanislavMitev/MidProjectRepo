package bg.dominos.exceptions;

public class RestaurantException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 485956462186875436L;

	public RestaurantException() {
		super();
	}

	public RestaurantException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RestaurantException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestaurantException(String message) {
		super(message);
	}

	public RestaurantException(Throwable cause) {
		super(cause);
	}

	

}
