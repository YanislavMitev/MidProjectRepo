package bg.dominos.exceptions;

public class IllegalPasswordException extends Exception {
	private static final long serialVersionUID = -4600226465412571618L;
	private static final String MSG = "Illegal password";
	
	public IllegalPasswordException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IllegalPasswordException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(MSG, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public IllegalPasswordException(String message, Throwable cause) {
		super(MSG, cause);
		// TODO Auto-generated constructor stub
	}
	public IllegalPasswordException(String message) {
		super(MSG);
		// TODO Auto-generated constructor stub
	}
	public IllegalPasswordException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
