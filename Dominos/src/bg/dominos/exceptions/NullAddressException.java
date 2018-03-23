package bg.dominos.exceptions;

public class NullAddressException extends Exception {
	private static final long serialVersionUID = 1908505256301557468L;
	private static final String MSG = "Null address";

	public NullAddressException() {
		super();
	}

	public NullAddressException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(MSG, cause, enableSuppression, writableStackTrace);
	}

	public NullAddressException(String message, Throwable cause) {
		super(MSG, cause);
	}

	public NullAddressException(String message) {
		super(MSG);
	}

	public NullAddressException(Throwable cause) {
		super(cause);
	}

}
