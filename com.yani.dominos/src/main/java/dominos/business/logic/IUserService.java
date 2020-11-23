package dominos.business.logic;

import dominos.exceptions.UserException;

public interface IUserService {
	String FILES_PATH = "src/files";
	
	void extractRestaurants();
	
	void extractUsers() throws Exception; // define and throw a dedicated exception

	void saveChangesToUsers() throws Exception; // define and throw a dedicated exception

	void register(String firstName, String lastName, String eMail, String password) throws Exception; // define and throw a dedicated exception

	void logIn(String eMail, String password) throws UserException;

	void logOut() throws UserException;

	void changePassword(String oldPassword, String newPassword, String reenteredNewPassword) throws UserException;

	void order();
}
