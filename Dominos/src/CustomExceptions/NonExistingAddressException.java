package CustomExceptions;

public class NonExistingAddressException extends Exception {

	private static final long serialVersionUID = -7425050211513720370L;
	private static final String MSG = "Non-Existing Address";
	public NonExistingAddressException() {
		super();
	}
	public NonExistingAddressException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(MSG, cause, enableSuppression, writableStackTrace);
	}
	public NonExistingAddressException(String message, Throwable cause) {
		super(MSG, cause);
	}
	public NonExistingAddressException(String message) {
		super(MSG);
	}
	public NonExistingAddressException(Throwable cause) {
		super(cause);
	}
	
	

}
