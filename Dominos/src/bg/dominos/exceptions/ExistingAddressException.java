package bg.dominos.exceptions;

public class ExistingAddressException extends Exception {

	private static final long serialVersionUID = 2672672950394223508L;
	private static final String MSG = "ExistingAddress";
	public ExistingAddressException() {
		super();
	}

	public ExistingAddressException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(MSG, cause, enableSuppression, writableStackTrace);
	}

	public ExistingAddressException(String message, Throwable cause) {
		super(MSG, cause);
	}

	public ExistingAddressException(String message) {
		super(MSG);
	}

	public ExistingAddressException(Throwable cause) {
		super(cause);
	}


}
