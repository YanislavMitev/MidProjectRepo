package bg.dominos.models.user;

import java.io.File;

import bg.dominos.exceptions.AddressException;
import bg.dominos.models.Address;

public interface IUser {

	public void addAddress(Address address) throws AddressException;

	public void deleteAddress(Address address) throws AddressException;

	public void changePassword(String oldPassword, String newPassword, String reenteredNewPassword);

	public void changeAvatar(File avatar);

	public void removeAvatar();

	public void logOut();

}
