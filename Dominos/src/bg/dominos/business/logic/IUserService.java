package bg.dominos.business.logic;

public interface IUserService {
	public static final String PATH_REGISTERED_USERS ="src/files";

	public void extractUsers() throws Exception;

	public void saveChangesToUsers() throws Exception;

	public void register(String firstName, String lastName, String eMail, String password) throws Exception;

	public void logIn(String eMail, String password);

}
