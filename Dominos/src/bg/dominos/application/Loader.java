package bg.dominos.application;

import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import bg.dominos.business.logic.UserService;
import bg.dominos.exceptions.AddressException;
import bg.dominos.exceptions.BasketException;
import bg.dominos.exceptions.ItemException;
import bg.dominos.exceptions.UserException;
import bg.dominos.models.Address;
import bg.dominos.models.City;
import bg.dominos.models.Item;

public final class Loader {
	private static final String INVALID_OPTION = "Invalid option.";
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

	public void settingsPage() {
		System.out.println("---- My profile ------- My addresses ------- My orders ------- Back ----");
		Scanner input = new Scanner(System.in);
		switch (input.nextLine().toLowerCase()) {
		case "my profile":
			System.out.println("Name: " + service.getLoggedUser().getFirstName());
			System.out.println("Surname: " + service.getLoggedUser().getLastName());
			System.out.println("E-mail: " + service.getLoggedUser().getEMail());
			System.out.println("Would you like to change your password? YES/NO");
			String choice = input.next().toLowerCase();
			if (choice.equals("yes")) {
				String oldPassword = input.next();
				String newPassword = input.next();
				String reenterNewPassword = input.next();
				try {
					service.changePassword(oldPassword, newPassword, reenterNewPassword);
				} catch (UserException e) {
					e.printStackTrace();
				}
			}
			goBack(input);
			break;
		case "my addresses":
			System.out.println("My addresses");

			for (Address a : service.getLoggedUser().getAddresses()) {
				System.out.println("----------------------------------");
				System.out.println("Friendly name " + ((a.getName() == null) ? " " : a.getName()));
				System.out.println("Street " + ((a.getStreet() == null) ? " " : a.getStreet()));
				System.out.println("Number " + ((a.getStreetNumber() == null) ? " " : a.getStreetNumber()));
				System.out.println("Post code " + a.getPostCode());
				System.out.println("City " + a.getCity());
				System.out.println("Phone number " + ((a.getPhoneNumber() == null) ? " " : a.getPhoneNumber()));
				System.out.println("Bell " + a.getBell());
				System.out.println("Floor " + a.getFloor());
				System.out.println("Block " + a.getBlock());
				System.out.println("Apartment " + a.getApartament());
				System.out.println("Entrance " + a.getEntrance());
				System.out.println("----------------------------------");
			}

			System.out.println("Add new address? YES/NO");
			if (input.next().toLowerCase().equals("yes")) {
				System.out.print("Street:");
				String street = input.nextLine();
				System.out.print("Street number:");
				String streetNumber = input.next();
				System.out.print("Post code:");
				int postCode = input.nextInt();
				System.out.print("City:");
				City city = (input.next().equalsIgnoreCase("PLOVDIV")) ? City.PlOVDIV : City.SOFIA;
				System.out.print("Phone number:");
				String phoneNumber = input.next();
				System.out.print("Floor:");
				int floor = input.nextInt();

				try {
					service.getLoggedUser()
							.addAddress(new Address(street, streetNumber, postCode, city, phoneNumber, floor));
					System.out.println("New address has been added!");
				} catch (AddressException | UserException e) {
					e.printStackTrace();
				}

				goBack(input);
			}
			break;
		case "my orders":
			for (Entry<Integer, List<Item>> entry : service.getLoggedUser().getPreviousOreders().entrySet()) {
				float price = 0;
				for (Item item : entry.getValue()) {
					System.out.println("Product: " + item.getType());
					System.out.println("Quantity: " + item.getQuantity());
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
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		float price = 0.0f;
		for (Item item : service.getLoggedUser().getBasketItems()) {
			System.out.print("Item: " + item.getType() + "\t");
			System.out.println("Quantity: " + item.getQuantity());
			price += item.getPrice();
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
			String itemName = input.nextLine();

			Item itemToRemove = null;
			for (Item item : service.getLoggedUser().getBasketItems()) {
				if (item.getType().equalsIgnoreCase(itemName)) {
					itemToRemove = item;
				}
			}
			if (itemToRemove != null) {
				try {
					service.getLoggedUser().removeFromBasket(itemToRemove);
				} catch (BasketException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("No such item.");
			}
			basketPage();
			break;
		case "empty basket":
			System.out.println("Are you sure you want to empty your basket? YES/NO");
			if(input.next().equalsIgnoreCase("yes")) {
				try {
					service.getLoggedUser().emptyBasket();
					pageAfterLogin();
				} catch (BasketException e) {
					e.printStackTrace();
				}
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
			service.order();
			break;
		case "finish order" :
			try {
				service.finishOrder();
			} catch (ItemException | BasketException e) {
				e.printStackTrace();
			}
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
			service.order();
			break;
		case "settings":
			settingsPage();
			break;
		case "basket":
			basketPage();
			break;
		case "log out":
			try {
				service.logOut();
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

		if (this.service != null && this.service.getLoggedUser() == null) {
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
				if (service.getLoggedUser() != null) {
					pageAfterLogin();
				}
				break;
			case "exit":
				try {
					this.service.saveChangesToUsers();
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
		try {
			this.service.register(firstName, lastName, eMail, password);
		} catch (UserException e) {
			System.out.println(e.getMessage());
			register(sc);
		}
	}

	private void login(Scanner sc) {
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
