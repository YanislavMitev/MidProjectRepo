package dominos.exceptions;

public class AddressException extends Exception {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -1511594633676846745L;

	/**
	 * Constructor
	 * @param msg is the exception message.
	 */
	public AddressException(String msg) {
		super(msg);
	}
}
