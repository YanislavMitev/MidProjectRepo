package bg.Dominos;

import java.io.File;

public interface IUser {
	public void logIn(String userName, String password);
	public void logOut();
	public void addAddress(Address address);
	public void deleteAddress(Address address);
	public void changePassword(String oldPassword, String newPassword, String reenteredNewPassword);
	public void changeAvatar(File avatar);
	public void removeAvatar();
	public void emptyBasket();
}
