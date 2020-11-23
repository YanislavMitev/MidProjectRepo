package dominos.application;

import dominos.exceptions.UserException;

public class DominosApp {

	public static void main(String[] args) {
		try {
			Loader loader = Loader.getInstance();
			loader.loadHomePage();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}
}
