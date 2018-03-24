package bg.dominos.exceptions;

public class NullOrEmptyBasketException extends Exception {
	private static final long serialVersionUID = 2922393525686220872L;
	private static final String MSG = "Null basket";

	public NullOrEmptyBasketException() {
		super();
	}

	public NullOrEmptyBasketException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MSG, cause, enableSuppression, writableStackTrace);
	}

	public NullOrEmptyBasketException(String message, Throwable cause) {
		super(MSG, cause);
	}

	public NullOrEmptyBasketException(String message) {
		super(MSG);
	}

	public NullOrEmptyBasketException(Throwable cause) {
		super(cause);
	}

}
