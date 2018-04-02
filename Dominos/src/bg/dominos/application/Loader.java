package bg.dominos.application;

import java.util.Scanner;

import bg.dominos.business.logic.UserService;
import bg.dominos.exceptions.UserException;

public final class Loader {
	private static Loader loader;
	private UserService service;

	private Loader() {
		service = UserService.getInstance();
		try {
			service.extractRestaurants();
			service.extractUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Loader getInstance() {
		if (loader == null) {
			loader = new Loader();
		}
		return loader;
	}

	public void loadHomePage() throws UserException {
		Scanner sc = new Scanner(System.in);

		if (this.service != null && this.service.getLoggedUser() == null) {
			System.out.println("---- Login ------- Register ------- Exit");
			String option = sc.next().trim().toLowerCase();
			switch (option) {
			case "login":
				login(sc);
				System.out.println("Successfully logged in.");
				// lead to next page
				break;
			case "register":
				register(sc);
				System.out.println("Navigated to login page...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				login(sc);
				break;
			case "exit":
				try {
					this.service.saveChangesToUsers();
					loader = null;
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			default:
				System.out.println("Invalid option. Navigated to homepage...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				loadHomePage();
				break;
			}
		}
	}

	private void register(Scanner sc) {
		System.out.print("First name: ");
		String firstName = sc.next();
		System.out.print("Last name: ");
		String lastName = sc.next();
		System.out.print("E-mail: ");
		String eMail = sc.next();
		System.out.print("Password: ");
		String password = sc.next();
		try {
			this.service.register(firstName, lastName, eMail, password);
		} catch (UserException e) {
			System.out.println(e.getMessage());
			register(sc);
		}
	}

	private void login(Scanner sc)  {
		System.out.print("E-mail: ");
		String email = sc.next();
		System.out.print("Password: ");
		String pass = sc.next();
		try {
			this.service.logIn(email, pass);
		} catch (UserException e) {
			System.out.println(e.getMessage());
			login(sc);
		}
	}

}
