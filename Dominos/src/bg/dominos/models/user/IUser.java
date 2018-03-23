package bg.dominos.models.user;

import java.io.File;

import bg.dominos.exceptions.ExistingAddressException;
import bg.dominos.exceptions.NonExistingAddressException;
import bg.dominos.exceptions.NullAddressException;
import bg.dominos.models.Address;

public interface IUser {
	public void logIn(String userName, String password);
	public void logOut();
	public void register();
	public void addAddress(Address address) throws ExistingAddressException;
	public void deleteAddress(Address address) throws NullAddressException, NonExistingAddressException;
	public void changePassword(String oldPassword, String newPassword, String reenteredNewPassword);
	public void changeAvatar(File avatar);
	public void removeAvatar();
	public void emptyBasket();
}
