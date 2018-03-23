package bg.dominos.exceptions;

public class IllegalNameException extends Exception{
	private static final String MSG = "Illegal name";
	
	
	public IllegalNameException() {
		super();
	}

	public IllegalNameException(Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(MSG, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IllegalNameException(String message, Throwable cause) {
		super(MSG, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalNameException(String message) {
		super(MSG);
		// TODO Auto-generated constructor stub
	}

	public IllegalNameException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 4985622585793752034L;


}
