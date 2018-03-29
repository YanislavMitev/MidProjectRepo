package bg.dominos.models.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bg.dominos.exceptions.AddressException;
import bg.dominos.exceptions.BasketException;
import bg.dominos.exceptions.ItemException;
import bg.dominos.exceptions.UserException;
import bg.dominos.models.Address;
import bg.dominos.models.Item;
import bg.dominos.models.Order;
import bg.dominos.utils.Methods;

public final class User implements IUser {

	private class Basket {
		private List<Item> items;

		public Basket() {
			this.items = new ArrayList<Item>();
		}

	}

	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private Set<Address> addresses;
	private List<Order> previousOrders;
	private String avatarPath;
	private Basket basket;
	private transient boolean isLoggedOn;

	public User(String firstName, String lastName, String eMail, String password) throws UserException {

		setFirstName(firstName);
		setLastName(lastName);
		setEMail(eMail);
		setPassword(password);
		this.addresses = new HashSet<Address>();
		this.previousOrders = new ArrayList<Order>();
		this.basket = new Basket();
		this.isLoggedOn = false;
		// check for log in each method
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLogStatus(boolean isLoggedOn) {
		this.isLoggedOn = isLoggedOn;
	}

	public boolean checkLogStatus() {
		return this.isLoggedOn;
	}

	public void setFirstName(String firstName) throws UserException {
		if (Methods.checkString(firstName)) {
			this.firstName = firstName;
		} else
			throw new UserException(ILLEGAL_FIRST_NAME);
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) throws UserException {
		if (Methods.checkString(lastName)) {
			this.lastName = lastName;
		} else
			throw new UserException(ILLEGAL_LAST_NAME);
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String eMail) throws UserException {
		if (Methods.checkString(eMail)) {
			this.eMail = eMail;
		} else
			throw new UserException("Illegal e-mail");
	}

	@Override
	public void addAddress(Address address) throws AddressException, UserException {
		if (this.checkLogStatus()) {
			if (!Methods.isNull(address) && !this.addresses.contains(address)) {
				this.addresses.add(address);
			} else
				throw new AddressException(IUser.EXISTING_ADDRESS);
		} else
			throw new UserException(IUser.LOGIN_FIRST);
	}

	@Override
	public void deleteAddress(Address address) throws AddressException, UserException {
		if (this.checkLogStatus()) {
			if (!Methods.isNull(address)) {
				if (this.addresses.contains(address)) {
					this.addresses.remove(address);
				} else {
					throw new AddressException(IUser.NON_EXISTING_ADDRESS);
				}
			} else {
				throw new AddressException(IUser.NULL_ADDRESS_AS_VALUE);
			}
		} else
			throw new UserException(IUser.LOGIN_FIRST);
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) throws UserException {
		if (Methods.checkString(password)) {
			this.password = password;
		} else
			throw new UserException(ILLEGAL_PASSWORD);
	}

	public Set<Address> getAddresses() {
		return Collections.unmodifiableSet(this.addresses);
	}

	public String getAvatarPath() {
		return this.avatarPath;
	}
	
	public void setAvatarPath(String avatarPath) throws UserException {
		if(Methods.checkString(avatarPath)) {
			this.avatarPath = avatarPath;
		}else throw new UserException(INVALID_AVATAR_PATH);
	}
	public Basket getBasket() {
		return this.basket;
	}

	public void setBasket(Basket basket) throws BasketException {
		if (!Methods.isNull(basket)) {
			this.basket = basket;
		} else
			throw new BasketException(NULL_BASKET);
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

	private int getIndexOfItem(Item item) {
		int indexOfItem = this.basket.items.indexOf(item);
		return indexOfItem;
	}

	public void addToBasket(Item item) throws ItemException, BasketException {
		if (!Methods.isNull(item)) {
			if (this.basket.items.contains(item)) {
				int indexOfItem = getIndexOfItem(item);
				int increasedQuantity = this.basket.items.get(indexOfItem).getQuantity() + 1;
				this.basket.items.get(indexOfItem).setQuantity(increasedQuantity);
			} else {
				this.basket.items.add(item);
			}
		} else
			throw new BasketException(CANNOT_ADD_TO_BASKET);
	}

	public void removeFromBasket(Item item) throws BasketException {
		if (!Methods.isNull(item)) {
			if (this.basket.items.contains(item)) {
				this.basket.items.remove(getIndexOfItem(item));
			}
		}
		throw new BasketException(CANNOT_REMOVE_FROM_BASKET);
	}

	public void emptyBasket() throws BasketException {
		if (!this.basket.items.isEmpty()) {
			this.basket.items.clear();
		} else
			throw new BasketException(EMPTY_BASKET);
	}
	
	@Override
	public String toString() {
		return "User [firstName = " + firstName + ", lastName = " + lastName + ", eMail = " + eMail + "]";
	}
}