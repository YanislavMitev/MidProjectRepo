package bg.dominos.exceptions;

public class IllegalEMailException extends Exception {
	private static final long serialVersionUID = -2744785191717305161L;
	private static final String MSG = "Illegal E-mail";
	
	public IllegalEMailException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IllegalEMailException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(MSG, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IllegalEMailException(String message, Throwable cause) {
		super(MSG, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalEMailException(String message) {
		super(MSG);
		// TODO Auto-generated constructor stub
	}

	public IllegalEMailException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
