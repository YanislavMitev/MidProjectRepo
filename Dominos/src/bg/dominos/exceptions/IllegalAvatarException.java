package bg.dominos.exceptions;

public class IllegalAvatarException extends Exception {
	private static final long serialVersionUID = 4643377085674553053L;
	private static final String MSG = "Illegal avatar";
	
	public IllegalAvatarException() {
		super();
	}
	
	public IllegalAvatarException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(MSG, cause, enableSuppression, writableStackTrace);
	}
	
	public IllegalAvatarException(String message, Throwable cause) {
		super(MSG, cause);
	}
	
	public IllegalAvatarException(String message) {
		super(MSG);
	}
	
	public IllegalAvatarException(Throwable cause) {
		super(cause);
	}
	
}
