package order.application;

import order.exceptions.UserException;

import order.models.address.Address;
import order.models.address.City;
import order.models.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public final class Loader {
	private static final String INVALID_OPTION = "Invalid option.";
	private static Loader loader;

	private Loader() {

	}

	public static Loader getInstance() {
		if (loader == null) {
			loader = new Loader();
		}
		return loader;
	}

	public void settingsPage() {
		System.out.println("---- My profile ------- My addresses ------- My orders ------- Back ----");
		Scanner input = new Scanner(System.in);
		switch (input.nextLine().toLowerCase()) {
		case "my profile":
			System.out.println("Name: " + "LOGGED_USER_FIRST_NAME");
			System.out.println("Surname: " + "LOGGED_USER_LAST_NAME");
			System.out.println("E-mail: " + "LOGGED_USER_EMAIL");
			System.out.println("Would you like to change your password? YES/NO");
			String choice = input.next().toLowerCase();
			if (choice.equals("yes")) {
				String oldPassword = input.next();
				String newPassword = input.next();
				String reenterNewPassword = input.next();

				/*change password*/
			}
			goBack(input);
			break;
		case "my addresses":
			System.out.println("My addresses");

			for (Address a : new ArrayList<Address>() /*get addresses*/) {
				System.out.println("----------------------------------");
				System.out.println("Friendly name " + a.getAlias());
				System.out.println("Street " + ((a.getStreet() == null) ? " " : a.getStreet()));
				System.out.println("Number " + ((a.getStreetNumber() == null) ? " " : a.getStreetNumber()));
				System.out.println("Post code " + a.getPostCode());
				System.out.println("City " + a.getCity());
				System.out.println("Phone number " + "USER_PHONE_NUMBER");
				System.out.println("Floor " + a.getFloor());
				System.out.println("Block " + a.getApartmentBuildingNumber());
				System.out.println("Apartment " + a.getFlatNumber());
				System.out.println("Entrance " + a.getEntrance());
				System.out.println("----------------------------------");
			}

			System.out.println("Add new address? YES/NO");
			if (input.next().equalsIgnoreCase("yes")) {
				System.out.println("Street:");
				input.nextLine();
				String street = input.nextLine();
				
				System.out.println("Street number:");
				String streetNumber = input.nextLine();
				
				System.out.println("Post code:");
				int postCode = input.nextInt();
				
				System.out.println("City:");
				City city = (input.next().equalsIgnoreCase("PLOVDIV")) ? City.PLOVDIV : City.SOFIA;
				
				System.out.println("Phone number:");
				String phoneNumber = input.next();
				
				System.out.println("Floor:");
				byte floor = input.nextByte();

				/*service.getLoggedUser()
						.addAddress(new Address("alias", street, streetNumber, postCode, city, floor));*/
				System.out.println("New address has been added!");

				goBack(input);
			}
			break;
		case "my orders":
			for (Entry<Integer, List<Item>> entry : new HashMap<Integer, List<Item>>().entrySet() /*previous orders*/) {
				float price = 0;
				for (Item item : entry.getValue()) {
					System.out.println("Product: " + item.getType());
					System.out.println("Quantity: " /* choose quantity logic */);
					price += item.getPrice();
				}
				System.out.println("Price: " + price);
				System.out.println("----------------------------");
			}
			goBack(input);
			break;
		case "back":
			pageAfterLogin();
			break;
		default:
			System.out.println(INVALID_OPTION);
			settingsPage();
			break;
		}
	}

	private void goBack(Scanner input) {
		System.out.println("Do you wish to go back? YES/NO");
		while (input.next().equalsIgnoreCase("no")) {
			try {
				Thread.sleep(10000);
				System.out.println("Do you wish to go back? YES/NO");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		settingsPage();
	}

	public void basketPage() {
		if(false/*service.getLoggedUser().getBasketItems().isEmpty()*/) {
			System.out.println("Basket is empty.");
			try {
				Thread.sleep(2000);
				pageAfterLogin();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		float price = 0.0f;
		for (Entry<Item, Integer> entry : new HashMap<Item, Integer>().entrySet()/*get basket items*/) {
			System.out.print("Item: " + entry.getKey().getType() + "\t");
			System.out.println("Quantity: " + entry.getValue());
			price += entry.getKey().getPrice();
		}
		System.out.println("Price: " + price);
		if(price == 0.0f) {
			System.out.println("Empty basket. Navigated back to user homepage.");
			pageAfterLogin();
		}
		System.out.println("Remove item | Empty basket | Continue ordering | Finish order | Back");
		switch (input.nextLine().toLowerCase()) {
		case "remove item":
			System.out.println("Enter item's name...");
			String itemName = input.nextLine().toLowerCase();

			for (Item item : new HashMap<Item, Integer>().keySet()) {
				if (item.getType().equalsIgnoreCase(itemName)) {
					/*remove item from basket*/
					break;
				} else {
					System.out.println("No such element");
				}
			}
			basketPage();
			break;
		case "empty basket":
			System.out.println("Are you sure you want to empty your basket? YES/NO");
			if(input.next().equalsIgnoreCase("yes")) {
				/*empty basket*/
				System.out.println("Empty basket.");
				pageAfterLogin();
			}
			System.out.println("Do you wish to go back? YES/NO");
			while(input.next().equalsIgnoreCase("no")) {
				try {
					Thread.sleep(10000);
					System.out.println("Do you wish to go back? YES/NO");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			pageAfterLogin();
			break;
		case "continue ordering":
			/* make an order */
			break;
		case "finish order" :
			/* finish order */
			break;
		case "back":
			pageAfterLogin();
			break;
		default:
			System.out.println(INVALID_OPTION);
			basketPage();
			break;
		}
	}

	@SuppressWarnings("resource")
	public void pageAfterLogin() {
		System.out.println("---- Order ------- Settings ------- Basket ------- Log out ----");
		switch (new Scanner(System.in).nextLine().toLowerCase()) {
		case "order":
			/* make an order */
			break;
		case "settings":
			settingsPage();
			break;
		case "basket":
			basketPage();
			break;
		case "log out":
			try {
				/* log out */
				loadHomePage();
				break;
			} catch (UserException e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.println(INVALID_OPTION);
			pageAfterLogin();
			break;
		}
	}

	@SuppressWarnings("resource")
	public void loadHomePage() throws UserException {
		Scanner sc = new Scanner(System.in);

		if (true /*no one has logged in*/) {
			System.out.println("---- Login ------- Register ------- Exit");
			String option = sc.next().trim().toLowerCase();
			switch (option) {
			case "login":
				login(sc);
				System.out.println("Successfully logged in.");
				pageAfterLogin();
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
				if (false/*service.getLoggedUser() != null*/) {
					pageAfterLogin();
				}
				break;
			case "exit":
				try {
					/*this.service.saveChangesToUsers();*/
					loader = null;
					System.out.println("Credits: Nikoleta Deleva & Yanislav Mitev ");
					System.exit(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println(INVALID_OPTION);
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

		/*this.service.register(firstName, lastName, eMail, password);*/
	}

	private void login(Scanner sc) {
		System.out.print("E-mail: ");
		String email = sc.next();
		System.out.print("Password: ");
		String pass = sc.next();
		/*this.service.logIn(email, pass);*/
	}
}
