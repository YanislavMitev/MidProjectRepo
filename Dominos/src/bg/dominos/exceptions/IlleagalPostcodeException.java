package bg.dominos.exceptions;

public class IlleagalPostcodeException extends Exception {
	private static final long serialVersionUID = -7380131730517107912L;
	private static final String MSG = "Illegal postcode";
	
	public IlleagalPostcodeException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IlleagalPostcodeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(MSG, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public IlleagalPostcodeException(String message, Throwable cause) {
		super(MSG, cause);
		// TODO Auto-generated constructor stub
	}
	public IlleagalPostcodeException(String message) {
		super(MSG);
		// TODO Auto-generated constructor stub
	}
	public IlleagalPostcodeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
