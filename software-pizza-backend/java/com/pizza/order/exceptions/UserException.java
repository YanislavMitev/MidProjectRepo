package com.pizza.order.exceptions;

public class UserException extends Exception {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -688668280110241129L;

	/**
	 * Constructor.
	 *
	 * @param msg is the exception message.
	 */
	public UserException(String msg) {
		super(msg);
	}
}
