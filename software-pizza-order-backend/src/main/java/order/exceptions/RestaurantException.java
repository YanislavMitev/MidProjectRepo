package order.exceptions;

public class RestaurantException extends Exception{

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 485956462186875436L;

	/**
	 * Constructor.
	 *
	 * @param msg is the exception message.
	 */
	public RestaurantException(String msg) {
		super(msg);
	}
}
