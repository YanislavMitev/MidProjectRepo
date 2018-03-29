package bg.dominos.business.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import bg.dominos.exceptions.UserException;
import bg.dominos.models.Item;
import bg.dominos.models.Restaurant;
import bg.dominos.models.user.User;
import bg.dominos.utils.Methods;

public final class UserService implements IUserService {

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
		if (Methods.isNull(this.user)) {
			User user = new User(firstName, lastName, eMail, password);

			if (!(this.reigsteredUsers.contains(user))) {
				this.reigsteredUsers.add(user);
			} else
				throw new UserException(EXISTING_USER);
		} else
			throw new UserException(USER_LOGGED_IN_CANNOT_REGISTER);
	}

	@Override
	public void logIn(String eMail, String password) throws UserException {
		if (Methods.isNull(this.user)) {
			for (User user : this.reigsteredUsers) {
				if (user.getEMail().equalsIgnoreCase(eMail) && user.getPassword().equals(password)) {
					this.user = user;
					this.user.setLogStatus(true);
					break;
				} else continue;
			}
			if(this.user == null) throw new UserException(INVALID_CREDENTIALS);
		} else {
			throw new UserException(USER_LOGGED_IN);
		}
	}

	@Override
	public void logOut() throws UserException {
		if (!Methods.isNull(this.user)) {
			this.user.setLogStatus(false);
			this.user = null;
		} else
			throw new UserException(NO_USER_SIGNED_IN);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword, String reenteredNewPassword)
			throws UserException {
		if (!Methods.isNull(this.user)) {
			if (Methods.passwordMatching(this.user, oldPassword, newPassword, reenteredNewPassword)) {
				try {
					this.user.setPassword(reenteredNewPassword);
				} catch (UserException e) {
					e.getMessage();
				}
			} else
				throw new UserException("Password missmatch.");
		} else
			throw new UserException("Null user passed as value.");
	}

	@Override
	public void changeAvatar(String avatarPath) {
		// TODO: implement
	}

	@Override
	public void removeAvatar() {
		// TODO: implement

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

	@Override
	public void order() {
		// TODO Auto-generated method stub

	}

}
