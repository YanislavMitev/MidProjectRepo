package dominos.business.logic;

import dominos.exceptions.BasketException;
import dominos.exceptions.ItemException;
import dominos.exceptions.UserException;
import dominos.models.item.Item;
import dominos.models.Restaurant;
import dominos.models.user.User;
import dominos.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
		this.reigsteredUsers = new ArrayList<>();
		this.restaurants = new ArrayList<>();
	}

	public static UserService getInstance() {
		if (userService == null) {
			userService = new UserService();
		}

		return userService;
	}

	@Override
	public void register(String firstName, String lastName, String eMail, String password) {
		// TODO: provide new implementation
	}

	@Override
	public void logIn(String eMail, String password) {
		// TODO: provide new implementation
	}

	@Override
	public void logOut() throws UserException {
		if (!Utils.isNull(this.user)) {
			this.user.setLogStatus(false);
			this.user = null;
		} else {
			throw new UserException(NO_USER_SIGNED_IN);
		}
	}

	@Override
	public void changePassword(String oldPassword, String newPassword, String reenteredNewPassword) {
		// TODO: provide new implementation
	}

	@Override
	public void extractUsers() { // will be refactored using Jackson
		// TODO: provide new implementation
	}

	@Override
	public void extractRestaurants() { // will be refactored using Jackson
		// TODO: provide new implementation
	}

	@Override
	public void saveChangesToUsers() throws Exception { // will be refactored using Jackson
		// TODO: provide new implementation
	}

	public User getLoggedUser() {
		return this.user; // TODO: decide whether I need such method
	}

	@SuppressWarnings("resource")
	@Override // will be refactored
	public void order() {
		// TODO: provide new implementation
	}

	private void chooseAmountAndProceed(Scanner input, Item order) throws ItemException, BasketException {
		// TODO: provide new implementation
	}

	public void finishOrder() throws ItemException, BasketException {
		// TODO: provide new implementation
	}
}
