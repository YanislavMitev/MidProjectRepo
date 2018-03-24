package bg.dominos.exceptions;

public class IllegalListException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8037828780258417546L;

	public IllegalListException() {
		super();
	}

	public IllegalListException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public IllegalListException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public IllegalListException(String arg0) {
		super(arg0);
	}

	public IllegalListException(Throwable arg0) {
		super(arg0);
	}

}
