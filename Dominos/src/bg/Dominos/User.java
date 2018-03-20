package bg.Dominos;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import CustomExceptions.IllegalAvatarException;
import CustomExceptions.IllegalEMailException;
import CustomExceptions.IllegalNameException;
import CustomExceptions.IllegalPasswordException;
import CustomExceptions.NullBasketException;
import StaticMethods.Methods;

public class User {
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
}
