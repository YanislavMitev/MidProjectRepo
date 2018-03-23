package CustomExceptions;

public class NullBasketException extends Exception {
	private static final long serialVersionUID = 2922393525686220872L;
	private static final String MSG = "Null basket";

	public NullBasketException() {
		super();
	}

	public NullBasketException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MSG, cause, enableSuppression, writableStackTrace);
	}

	public NullBasketException(String message, Throwable cause) {
		super(MSG, cause);
	}

	public NullBasketException(String message) {
		super(MSG);
	}

	public NullBasketException(Throwable cause) {
		super(cause);
	}

}
