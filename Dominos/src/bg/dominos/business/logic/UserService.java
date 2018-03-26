package bg.dominos.business.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import bg.dominos.models.user.User;

public final class UserService implements IUserService {

	private static UserService userService = null;
	public List<User> reigsteredUsers;
//	private User user;
	
	private UserService() {
		this.reigsteredUsers = new ArrayList<User>();
	}

	public static UserService getInstance() {
		if (userService == null) {
			userService = new UserService();
		}
		return userService;
	}

	@Override
	public void register(String firstName, String lastName, String eMail, String password) throws Exception {
		User user = new User(firstName, lastName, eMail, password);
		
		if(!(this.reigsteredUsers.contains(user))) {
			this.reigsteredUsers.add(user);
		}
		//else throws new UserException;
	}

	@Override
	public void logIn(String eMail, String password) {
		for(User user : reigsteredUsers) {
			if(user.getEMail().equals(eMail)&& user.getPassword().equals(password)) {
				user.setLoggedIn(true);
			}
			//else throw InvalidTryToLogInException();
		}
	}

	@Override
	public void extractUsers() throws Exception {
		File registeredUsers = new File(PATH_REGISTERED_USERS);
		registeredUsers.mkdir();
		File usersRepo = new File(registeredUsers, "usersRepo.json");
		usersRepo.createNewFile();
		FileInputStream fileInputStream = new FileInputStream(usersRepo);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		int fileSizeInBytes = (int) usersRepo.length();

		if (fileSizeInBytes > 0) {
			byte fileContentAsBytes[] = new byte[fileSizeInBytes];

			fileInputStream.read(fileContentAsBytes);
			String fileAsString = new String(fileContentAsBytes, "UTF-8");

			Type usersCollectionType = new TypeToken<List<User>>() {
			}.getType();
			this.reigsteredUsers = gson.fromJson(fileAsString, usersCollectionType);

		} else {
			System.out.println("File is empty");
		}
		fileInputStream.close();
	}

	@Override
	public void saveChangesToUsers() throws Exception {
		File registeredUsers = new File(PATH_REGISTERED_USERS);
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
	
	

	

}
