package order.exceptions;

public class BasketException extends Exception{

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -5467911739658383909L;

	/**
	 * Constructor.
	 *
	 * @param msg is the exception message.
	 */
	public BasketException(String msg) {
		super(msg);
	}
}
