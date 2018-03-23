package bg.dominos.models.user;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import bg.dominos.exceptions.ExistingAddressException;
import bg.dominos.exceptions.IllegalAvatarException;
import bg.dominos.exceptions.IllegalEMailException;
import bg.dominos.exceptions.IllegalNameException;
import bg.dominos.exceptions.IllegalPasswordException;
import bg.dominos.exceptions.NonExistingAddressException;
import bg.dominos.exceptions.NullAddressException;
import bg.dominos.exceptions.NullBasketException;
import bg.dominos.models.Address;
import bg.dominos.models.Basket;
import bg.dominos.models.Order;
import bg.dominos.utils.Methods;

public class User implements IUser {
	private static int userNumber = 0;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private Set<Address> addresses;
	private List<Order> previousOrders;
	private File avatar;
	private Basket basket;

	public User(String firstName, String lastName, String eMail, String password)
			throws IllegalPasswordException, IllegalEMailException, IllegalNameException {

		setFirstName(firstName);
		setLastName(lastName);
		setEMail(eMail);
		setPassword(password);
		this.addresses = new HashSet<Address>();
		this.previousOrders = new ArrayList<Order>();

	}

	public void updateJSON() {
		// TODO:implement
	}

	@Override
	public void logIn(String userName, String password) {
		if (Methods.checkString(userName) && Methods.checkPassword(password)) {
			// TODO: check in JSON file if there is such user with password
		}
	}

	@Override
	public void logOut() {
		// TODO: implement

	}

	@Override
	public void addAddress(Address address) throws ExistingAddressException {
		if (!Methods.isNull(address) && !this.addresses.contains(address)) {
			this.addresses.add(address);
		} else
			throw new ExistingAddressException();
	}

	@Override
	public void deleteAddress(Address address) throws NullAddressException, NonExistingAddressException {
		if (!Methods.isNull(address)) {
			if (this.addresses.contains(address)) {
				this.addresses.remove(address);
			} else {
				throw new NonExistingAddressException();
			}
		} else {
			throw new NullAddressException();
		}
	}

	@Override
	public void changePassword(String oldPassword, String newPassword, String reenteredNewPassword) {
		//TODO: implement
	}

	@Override
	public void changeAvatar(File avatar) {
		//TODO: implement

	}

	@Override
	public void removeAvatar() {
		//TODO: implement

	}

	@Override
	public void emptyBasket() {
		//TODO: implement
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) throws IllegalNameException {
		if (Methods.checkString(firstName)) {
			this.firstName = firstName;
		} else
			throw new IllegalNameException();
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) throws IllegalNameException {
		if (Methods.checkString(lastName)) {
			this.lastName = lastName;
		} else
			throw new IllegalNameException();
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String eMail) throws IllegalEMailException {
		if (Methods.checkString(eMail)) {
			this.eMail = eMail;
		} else
			throw new IllegalEMailException();
	}

	private String getPassword() {
		// read form JSON
		return this.password;
	}

	public void setPassword(String password) throws IllegalPasswordException {
		if (Methods.checkString(password)) {
			this.password = password;
		} else
			throw new IllegalPasswordException();
	}

	public Set<Address> getAddresses() {
		return Collections.unmodifiableSet(this.addresses);
	}

	public File getAvatar() {
		return this.avatar;
	}

	public void setAvatar(File avatar) throws IllegalAvatarException {
		if (avatar.exists() && avatar.isFile()) {
			this.avatar = avatar;
		} else
			throw new IllegalAvatarException();
	}

	public Basket getBasket() {
		return this.basket;
	}

	public void setBasket(Basket basket) throws NullBasketException {
		if (!Methods.isNull(basket)) {
			this.basket = basket;
		} else
			throw new NullBasketException();
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub

	}
}
