package bg.dominos.exceptions;

public class IllegalPriceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2391900733260720535L;

	public IllegalPriceException() {
		super();
	}

	public IllegalPriceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public IllegalPriceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public IllegalPriceException(String arg0) {
		super(arg0);
	}

	public IllegalPriceException(Throwable arg0) {
		super(arg0);
	}

	
}
