package bg.dominos.business.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import bg.dominos.application.Loader;
import bg.dominos.exceptions.BasketException;
import bg.dominos.exceptions.ItemException;
import bg.dominos.exceptions.UserException;
import bg.dominos.models.Chicken;
import bg.dominos.models.Dessert;
import bg.dominos.models.Drink;
import bg.dominos.models.Item;
import bg.dominos.models.Pasta;
import bg.dominos.models.Pizza;
import bg.dominos.models.Restaurant;
import bg.dominos.models.Salad;
import bg.dominos.models.Sandwich;
import bg.dominos.models.Sauce;
import bg.dominos.models.Starter;
import bg.dominos.models.user.User;
import bg.dominos.utils.Utils;

public final class UserService implements IUserService {

	private static final String ORDER_IS_PROCESSING = "Your order is being processing. In 30 minutes it shall be delivered.";
	private static final String NO_USER_SIGNED_IN = "No user signed in.";
	private static final String EXISTING_USER = "Existing user.";
	private static final String USER_LOGGED_IN_CANNOT_REGISTER = "User is logged in. Cannot register. Log out first.";
	private static final String INVALID_CREDENTIALS = "Invalid credentials.";
	private static final String USER_LOGGED_IN = "User is logged in. Log out first.";
	private static UserService userService = null;
	public List<User> reigsteredUsers;
	public List<Restaurant> restaurants;
	public Map<String, Item> menu;

	private User user;

	private UserService() {

		this.reigsteredUsers = new ArrayList<User>();
		this.restaurants = new ArrayList<Restaurant>();
	}

	public static UserService getInstance() {
		if (userService == null) {
			userService = new UserService();
		}
		return userService;
	}

	@Override
	public void register(String firstName, String lastName, String eMail, String password) throws UserException {
		if (Utils.isNull(this.user)) {
			User user = new User(firstName, lastName, eMail, password);

			if (!(this.reigsteredUsers.contains(user))) {
				this.reigsteredUsers.add(user);
				try {
					this.saveChangesToUsers();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else
				throw new UserException(EXISTING_USER);
		} else
			throw new UserException(USER_LOGGED_IN_CANNOT_REGISTER);
	}

	@Override
	public void logIn(String eMail, String password) throws UserException {
		if (Utils.isNull(this.user)) {
			for (User user : this.reigsteredUsers) {
				if (user.getEMail().equalsIgnoreCase(eMail) && user.getPassword().equals(password)) {
					this.user = user;
					this.user.setLogStatus(true);
					break;
				} else
					continue;
			}
			if (this.user == null)
				throw new UserException(INVALID_CREDENTIALS);
		} else {
			throw new UserException(USER_LOGGED_IN);
		}
	}

	@Override
	public void logOut() throws UserException {
		if (!Utils.isNull(this.user)) {
			this.user.setLogStatus(false);
			this.user = null;
		} else
			throw new UserException(NO_USER_SIGNED_IN);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword, String reenteredNewPassword)
			throws UserException {
		if (!Utils.isNull(this.user)) {
			if (Utils.passwordMatching(this.user, oldPassword, newPassword, reenteredNewPassword)) {
				try {
					this.user.setPassword(reenteredNewPassword);
					System.out.println("Password changed successfully!");
				} catch (UserException e) {
					e.getMessage();
				}
			} else
				throw new UserException("Password missmatch.");
		} else
			throw new UserException("Null user passed as value.");
	}


	@Override
	public void extractUsers() throws Exception {
		File filesDir = new File(FILES_PATH);
		filesDir.mkdir();

		File usersRepo = new File(filesDir, "usersRepo.json");
		if (!usersRepo.exists()) {
			usersRepo.createNewFile();
		}

		FileInputStream userRepoInputStream = new FileInputStream(usersRepo);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		int usersRepoSizeInBytes = (int) usersRepo.length();

		if (usersRepoSizeInBytes > 0) {
			byte fileContentAsBytes[] = new byte[usersRepoSizeInBytes];

			userRepoInputStream.read(fileContentAsBytes);
			String fileAsString = new String(fileContentAsBytes, "UTF-8");

			Type usersCollectionType = new TypeToken<List<User>>() {
			}.getType();
			this.reigsteredUsers = gson.fromJson(fileAsString, usersCollectionType);
		} else {
			System.out.println("File is empty");
		}

		userRepoInputStream.close();
	}

	@Override
	public void extractRestaurants() {
		File filesDir = new File(FILES_PATH);
		filesDir.mkdir();

		File restaurants = new File(filesDir, "restaurants.json");
		if (!restaurants.exists()) {
			try {
				restaurants.createNewFile();
				FileInputStream restaurantsInputStream = new FileInputStream(restaurants);

				Gson gson = new GsonBuilder().setPrettyPrinting().create();

				int restaurantsSizeInBytes = (int) restaurants.length();

				if (restaurantsSizeInBytes > 0) {
					byte fileContentAsBytes[] = new byte[restaurantsSizeInBytes];

					restaurantsInputStream.read(fileContentAsBytes);
					String fileAsString = new String(fileContentAsBytes, "UTF-8");

					Type restaurantsCollectionType = new TypeToken<List<Restaurant>>() {
					}.getType();
					this.restaurants = gson.fromJson(fileAsString, restaurantsCollectionType);

				} else {
					System.out.println("Restaurants: File is empty");
				}
				restaurantsInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void saveChangesToUsers() throws Exception {
		File registeredUsers = new File(FILES_PATH);
		registeredUsers.mkdir();
		File usersRepo = new File(registeredUsers, "usersRepo.json");

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// clear the file
		FileOutputStream fileOutputStream = new FileOutputStream(usersRepo);

		String allUsers = gson.toJson(this.reigsteredUsers);
		fileOutputStream.write(allUsers.getBytes());
		// should be in the finally clause of a try catch
		fileOutputStream.close();
	}

	public User getLoggedUser() {
		return this.user;
	}

	@SuppressWarnings("resource")
	@Override
	public void order() {
		System.out.println(
				"Pizza | Sandwich | Pasta | Salad | Starter | Chicken | Sauce | Dessert | Drink | Back | Basket");
		switch (new Scanner(System.in).next().toLowerCase()) {
		case "pizza":
			try (Scanner input = new Scanner(System.in);) {
				
				for(Pizza p : Pizza.getPizzaList()) {
					System.out.println(p.getPizzaType() + " price: " + p.getPrice());
				}
				String pizza = input.nextLine().toLowerCase();
				Pizza order = null;
				for (Pizza p : Pizza.getPizzaList()) {
					if (pizza.equalsIgnoreCase(p.getPizzaType())) {
						order = p;
					}
				}
				if (order == null) {
					break;
				}
				chooseAmounAndProceed(input, order);
			} catch (ItemException | BasketException e) {
				e.printStackTrace();
			}
			break;
		case "sandwich": {
			try (Scanner input = new Scanner(System.in);) {
				for(Sandwich s : Sandwich.getSandwiches()) {
					System.out.println(s.getSandwichType() + " price: " + s.getPrice());
					System.out.println(s.getDescription());
					System.out.println("Weight: " + s.getWeight() + " kg.");
				}
				String sandwich = input.nextLine().toLowerCase();
				Sandwich order = null;
				for (Sandwich s : Sandwich.getSandwiches()) {
					if (sandwich.equals(s.getSandwichType())) {
						order = s;
					}
				}
				if (order == null) {
					break;
				}
				chooseAmounAndProceed(input, order);
			} catch (ItemException | BasketException e) {
				e.printStackTrace();
			}
			break;
		}
		case "pasta":
			try (Scanner input = new Scanner(System.in)) {
				for(Pasta p : Pasta.getPastas()) {
					System.out.println(p.getPastaType() + " price: " + p.getPrice());
					System.out.println("Weight: " + p.getWeight() + " kg.");
				}
				String pasta = input.nextLine().toLowerCase();
				Pasta order = null;
				for (Pasta p : Pasta.getPastas()) {
					if (pasta.equalsIgnoreCase(p.getPastaType())) {
						order = p;
					}
				}
				if (order == null) {
					break;
				}
				chooseAmounAndProceed(input, order);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "salad":
			try (Scanner input = new Scanner(System.in)) {
				
				for(Salad s : Salad.getSalads()) {
					System.out.println(s.getSaladType()+ " price: " + s.getPrice());
					System.out.println(s.getDescription());
					System.out.println("Weight: " + s.getWeight() + " kg.");
				}
				
				String salad = input.nextLine().toLowerCase();
				Salad order = null;
				for (Salad s : Salad.getSalads()) {
					if (salad.equalsIgnoreCase(s.getSaladType())) {
						order = s;
					}
				}
				if (order == null) {
					break;
				}
				chooseAmounAndProceed(input, order);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "starter":
			try (Scanner input = new Scanner(System.in);) {
				System.out.println(Starter.getInstance().getType() + " Price: " + Starter.getInstance().getPrice() + " lv.");
				System.out.println(Starter.getInstance().getDescription());
				System.out.println("Add to basket: YES/NO");
				String choice = input.next();
				if (choice.equalsIgnoreCase("yes")) {
					userService.getLoggedUser().addToBasket(Starter.getInstance());
					System.out.println("Do you wish to continue ordering?");
					choice = input.next();
					if (choice.equalsIgnoreCase("yes")) {
						order();
					}
				}
				userService.getLoggedUser().saveLastOrder(userService.getLoggedUser().getBasketItems());
				userService.getLoggedUser().emptyBasket();
			} catch (ItemException | BasketException e) {
				e.printStackTrace();
			}

			break;
		case "chicken":
			try (Scanner input = new Scanner(System.in);) {
				
				for(Chicken c : Chicken.getListWithChicken()) {
					System.out.println(c.getChickenType() + " price: " + c.getPrice());
					System.out.println(c.getDescription());
				}
				
				String chicken = input.nextLine().toLowerCase();
				Chicken order = null;
				for (Chicken c : Chicken.getListWithChicken()) {
					if (chicken.equalsIgnoreCase(c.getChickenType())) {
						order = c;
					}
				}
				if (order == null) {
					break;
				}
				chooseAmounAndProceed(input, order);
			} catch (ItemException | BasketException e) {
				e.printStackTrace();
			}
			break;
		case "sauce":
			try (Scanner input = new Scanner(System.in);) {
				
				for(Sauce s : Sauce.getSauces()) {
					System.out.println(s.getSauceType()+ " price: " + s.getPrice());
				}
				
				String sauce = input.nextLine().toLowerCase();
				Sauce order = null;
				for (Sauce s : Sauce.getSauces()) {
					if (sauce.equalsIgnoreCase(s.getSauceType())) {
						order = s;
					}
				}
				if (order == null) {
					break;
				}
				chooseAmounAndProceed(input, order);
			} catch (ItemException | BasketException e) {
				e.printStackTrace();
			}
			break;
		case "dessert":
			try (Scanner input = new Scanner(System.in);) {
				System.out.println(Dessert.getDesserts());
				
				for(Dessert d : Dessert.getDesserts()) {
					System.out.println(d.getDessertType() + " price: " + d.getPrice());
				}
				
				
				String dessert = input.nextLine().toLowerCase();
				Dessert order = null;
				for (Dessert d : Dessert.getDesserts()) {
					if (dessert.equalsIgnoreCase(d.getDessertType())) {
						order = d;
					}
				}
				if (order == null) {
					break;
				}
				chooseAmounAndProceed(input, order);
			} catch (ItemException | BasketException e) {
				e.printStackTrace();
			}
			break;
		case "drink":
			try (Scanner input = new Scanner(System.in);) {
				
				for(Drink d : Drink.getDrinks()) {
					System.out.println(d.getDrinkType() + " price: " + d.getPrice());
				}
				
				String drink = input.nextLine().toLowerCase();
				Drink order = null;
				for (Drink d : Drink.getDrinks()) {
					if (d.getDrinkType().toLowerCase().contains(drink)) {
						order = d;
					}
				}
				if (order == null) {
					break;
				}
				chooseAmounAndProceed(input, order);
			} catch (ItemException | BasketException e) {
				e.printStackTrace();
			}
			break;
		case "back":
				Scanner input = new Scanner(System.in);
				System.out.println("Do you realy wish to go to previous page? YES/NO");
				String choice = input.next();
				if (choice.equalsIgnoreCase("yes")) {
					Loader.getInstance().pageAfterLogin();
				} else {
					order();
				}
			break;
		case "basket" :
			Loader.getInstance().basketPage();
			break;
		default:
			System.out.println("Invalid option");
			order();
			break;
		}
	}
	
	
	
	private void chooseAmounAndProceed(Scanner input, Item order) throws ItemException, BasketException {
		System.out.print("Choose quantity: ");
		int amount = input.nextInt();
		order.setQuantity(amount);
		userService.getLoggedUser().addToBasket(order);

		System.out.println("Continue ordering? YES/NO");
		if (input.next().equalsIgnoreCase("yes")) {
			order();
		}
		finishOrder();
	}

	public void finishOrder() throws ItemException, BasketException {
		userService.getLoggedUser().saveLastOrder(userService.getLoggedUser().getBasketItems());
		userService.getLoggedUser().emptyBasket();
		System.out.println("Total price: " + this.user.getTotalPrice());
		System.out.println(ORDER_IS_PROCESSING);
		Loader.getInstance().pageAfterLogin();
	}

}
