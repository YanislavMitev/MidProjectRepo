package bg.dominos.business.logic;

import java.io.File;

public interface IUserService {
	public static final String PATH_REGISTERED_USERS = "D:" + File.separator + "NikSu" + File.separator + "ITtalents"
			+ File.separator + "MidProjectRepo" + File.separator + "Dominos" + File.separator + "src" + File.separator
			+ "registeredUsers";

	public void extractUsers() throws Exception;

	public void saveChangesToUsers() throws Exception;

	public void register(String firstName, String lastName, String eMail, String password) throws Exception;

	public void logIn(String eMail, String password);

}
