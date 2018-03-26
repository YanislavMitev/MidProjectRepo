package bg.dominos.models.user;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bg.dominos.exceptions.CannotAddToBasketException;
import bg.dominos.exceptions.CannotRemoveFromBasketException;
import bg.dominos.exceptions.ExistingAddressException;
import bg.dominos.exceptions.IllegalAvatarException;
import bg.dominos.exceptions.IllegalEMailException;
import bg.dominos.exceptions.IllegalNameException;
import bg.dominos.exceptions.IllegalPasswordException;
import bg.dominos.exceptions.InvalidQuantityException;
import bg.dominos.exceptions.NonExistingAddressException;
import bg.dominos.exceptions.NullAddressException;
import bg.dominos.exceptions.NullOrEmptyBasketException;
import bg.dominos.models.Address;
import bg.dominos.models.Item;
import bg.dominos.models.Order;
import bg.dominos.utils.Methods;

public final class User implements IUser {
	private static final String CANNOT_ADD_TO_BASKET = "Cannot add to basket.";
	private static final String CANNOT_REMOVE_FROM_BASKET = "Cannot remove from basket.";
	private static final String EMPTY_BASKET = "Empty basket.";

	private class Basket {
		private List<Item> items;

		public Basket() {
			this.items = new ArrayList<Item>();
		}

		private int getIndexOfItem(Item item) {
			int indexOfItem = this.items.indexOf(item);
			return indexOfItem;
		}

		public void addToBasket(Item item) throws InvalidQuantityException, CannotAddToBasketException {
			if (!Methods.isNull(item)) {
				if (this.items.contains(item)) {
					int indexOfItem = getIndexOfItem(item);
					int increasedQuantity = this.items.get(indexOfItem).getQuantity() + 1;
					this.items.get(indexOfItem).setQuantity(increasedQuantity);
				} else {
					this.items.add(item);
				}
			} else
				throw new CannotAddToBasketException(CANNOT_ADD_TO_BASKET);
		}

		public void removeFromBasket(Item item) throws CannotRemoveFromBasketException {
			if (!Methods.isNull(item)) {
				if (this.items.contains(item)) {
					this.items.remove(getIndexOfItem(item));
				}
			}
			throw new CannotRemoveFromBasketException(CANNOT_REMOVE_FROM_BASKET);
		}

		public void emptyBasket() throws NullOrEmptyBasketException {
			if (!this.items.isEmpty()) {
				this.items.clear();
			} else
				throw new NullOrEmptyBasketException(EMPTY_BASKET);
		}
	}

	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private Set<Address> addresses;
	private boolean isLoggedIn;
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
		this.basket = new Basket();
		this.setLoggedIn(false);
		// check for log in each method
	}

	@Override
	public void addAddress(Address address) throws ExistingAddressException {
		if (!Methods.isNull(address) && !this.addresses.contains(address)) {
			this.addresses.add(address);
		} else
			throw new ExistingAddressException();
	}

	@Override
	public void deleteAddress(Address address) throws NonExistingAddressException, NullAddressException {
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
		// TODO: implement
	}

	@Override
	public void changeAvatar(File avatar) {
		// TODO: implement

	}

	@Override
	public void removeAvatar() {
		// TODO: implement

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

	public String getPassword() {
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

	public void setBasket(Basket basket) throws NullOrEmptyBasketException {
		if (!Methods.isNull(basket)) {
			this.basket = basket;
		} else
			throw new NullOrEmptyBasketException();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		return true;
	}

	public boolean isLoggedIn() {
		return this.isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	@Override
	public void logOut() {
		this.setLoggedIn(false);
	}
}