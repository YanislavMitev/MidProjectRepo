package bg.dominos.business.logic;

import bg.dominos.exceptions.UserException;

public interface IUserService {
	public static final String FILES_PATH = "src/files";
	
	public void extractRestaurants();
	
	public void extractUsers() throws Exception;

	public void saveChangesToUsers() throws Exception;

	public void register(String firstName, String lastName, String eMail, String password) throws Exception;

	public void logIn(String eMail, String password) throws UserException;

	public void logOut() throws UserException;

	public void changePassword(String oldPassword, String newPassword, String reenteredNewPassword) throws UserException;

	public void order();
}
