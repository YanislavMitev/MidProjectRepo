package dominos.exceptions;

public class DealException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4723315882810102654L;

	public DealException() {
		super();
	}

	public DealException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DealException(String message, Throwable cause) {
		super(message, cause);
	}

	public DealException(String message) {
		super(message);
	}

	public DealException(Throwable cause) {
		super(cause);
	}


}
