package com.pizza.order.main.models.user;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.pizza.order.exceptions.AddressException;
import com.pizza.order.exceptions.BasketException;
import com.pizza.order.exceptions.ItemException;
import com.pizza.order.exceptions.UserException;

import com.pizza.order.main.models.address.Address;

import com.pizza.order.utils.Utils;

import com.pizza.order.main.models.item.Item;

public final class User implements IUser {
	private class Basket {
		public final Map<Item, Integer> items;
		private float totalPrice;

		public Basket() {
			this.items = new HashMap<>();
		}

		public void removeItem(Item item) {
			if (items.containsKey(item)) {
				int currentQuantity = items.get(item);

				if (currentQuantity > 1) {
					items.put(item, --currentQuantity);
				} else {
					items.remove(item);
				}
			}
		}
	}

	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private Set<Address> addresses;
	private Map<Integer, List<Item>> previousOrders;
	private Basket basket;

	@JsonIgnore
	private boolean isLoggedOn;

	public User(String firstName, String lastName, String eMail, String password) throws UserException {

		setFirstName(firstName);
		setLastName(lastName);
		setEMail(eMail);
		setPassword(password);
		this.addresses = new HashSet<>();
		this.previousOrders = new TreeMap<>();
		this.basket = new Basket();
		this.isLoggedOn = false;
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
		if (Utils.checkString(firstName)) {
			this.firstName = firstName;
		} else
			throw new UserException(ILLEGAL_FIRST_NAME);
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) throws UserException {
		if (Utils.checkString(lastName)) {
			this.lastName = lastName;
		} else
			throw new UserException(ILLEGAL_LAST_NAME);
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String eMail) throws UserException {
		if (Utils.checkString(eMail)) {
			this.eMail = eMail;
		} else
			throw new UserException("Illegal e-mail");
	}

	public void addAddress(Address address) throws AddressException, UserException {
		if (this.checkLogStatus()) {
			if (!Utils.isNull(address) && !this.addresses.contains(address)) {
				this.addresses.add(address);
			} else
				throw new AddressException(EXISTING_ADDRESS);
		} else
			throw new UserException(LOGIN_FIRST);
	}

	public void deleteAddress(Address address) throws AddressException, UserException {
		if (this.checkLogStatus()) {
			if (!Utils.isNull(address)) {
				if (this.addresses.contains(address)) {
					this.addresses.remove(address);
				} else {
					throw new AddressException(NON_EXISTING_ADDRESS);
				}
			} else {
				throw new AddressException(NULL_ADDRESS_AS_VALUE);
			}
		} else
			throw new UserException(LOGIN_FIRST);
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) throws UserException {
		if (Utils.checkString(password)) {
			this.password = password;
		} else
			throw new UserException(ILLEGAL_PASSWORD);
	}

	public Set<Address> getAddresses() {
		return Collections.unmodifiableSet(this.addresses);
	}

	public Basket getBasket() {
		return this.basket;
	}

	public void setBasket(Basket basket) throws BasketException {
		if (!Utils.isNull(basket)) {
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
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		User other = (User) obj;

		if (eMail == null) {
			return other.eMail == null;
		} else {
			return eMail.equals(other.eMail);
		}
	}

	public void addToBasket(Item item) throws BasketException {
		if (!Utils.isNull(item)) {
			if (this.basket.items.containsKey(item)) {
				int currentQuantity = this.basket.items.get(item);
				this.basket.items.put(item, ++currentQuantity);
			} else {
				this.basket.items.put(item, 1);
				this.basket.totalPrice += item.getPrice();
			}
		} else {
			throw new BasketException(CANNOT_ADD_TO_BASKET);
		}
	}

	public void removeFromBasket(Item item) throws BasketException {
		if (!Utils.isNull(item)) {
			this.basket.removeItem(item);
		} else {
			throw new BasketException(CANNOT_REMOVE_FROM_BASKET);
		}
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

	public void saveLastOrder(List<Item> items) throws ItemException {
		if (items != null && !items.isEmpty()) {
			this.previousOrders.put(previousOrders.size() + 1, items);
		} else
			throw new ItemException("Null item list.");
	}

	public Map<Item, Integer> getBasketItems() {
		return Collections.unmodifiableMap(this.basket.items);
	}

	public Map<Integer, List<Item>> getPreviousOrders() {
		return Collections.unmodifiableMap(this.previousOrders);
	}

	public float getTotalPrice() {
		return this.basket.totalPrice;
	}
}