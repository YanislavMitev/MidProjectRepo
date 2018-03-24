package bg.dominos.models.user;

import java.io.File;

import bg.dominos.exceptions.CannotAddToBasketException;
import bg.dominos.exceptions.CannotRemoveFromBasketException;
import bg.dominos.exceptions.ExistingAddressException;
import bg.dominos.exceptions.InvalidQuantityException;
import bg.dominos.exceptions.NonExistingAddressException;
import bg.dominos.exceptions.NullAddressException;
import bg.dominos.exceptions.NullOrEmptyBasketException;
import bg.dominos.models.Address;
import bg.dominos.models.Item;

public interface IUser {
	
	//to be moved in repository class
	//	public void logIn(String userName, String password);
	//	public void logOut();
	//	public void register();
	//to be moved in repository class
	
	public void addAddress(Address address) throws ExistingAddressException;
	public void deleteAddress(Address address) throws NullAddressException, NonExistingAddressException;
	public void changePassword(String oldPassword, String newPassword, String reenteredNewPassword);
	public void changeAvatar(File avatar);
	public void removeAvatar();

}
