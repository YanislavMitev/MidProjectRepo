package order.exceptions;

public class ItemException extends Exception {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 3598434663114123947L;

	/**
	 * Constructor.
	 *
	 * @param msg is the exception message.
	 */
	public ItemException(String msg) {
		super(msg);
	}
}
