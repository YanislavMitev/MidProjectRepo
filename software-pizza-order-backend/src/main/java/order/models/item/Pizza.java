package order.models.item;

import com.fasterxml.jackson.annotation.JsonTypeName;

import order.models.Dough;
import order.models.Size;

@JsonTypeName("Pizza")
public class Pizza extends Food {
	private final Size size;
	private final Dough dough;

	/**
	 * Constructor.
	 */
	public Pizza() {
		size = Size.MEDIUM;
		dough = Dough.HAND_TOSSED;
	}

	/**
	 * Constructor.
	 *
	 * @param description is the pizza description.
	 * @param pizzaType is the pizza type.
	 * @param price is the pizza price.
	 * @param size is the pizza size.
	 * @param dough is the pizza dough.
	 */
	public Pizza(String description, String pizzaType, float price, Size size, Dough dough) {
		setDescription(description);
		setType(pizzaType);
		setPrice(price);
		this.size = size;
		this.dough = dough;
	}

	/**
	 * Getter.
	 *
	 * @return the size of the pizza.
	 */
	public Size getSize() {
		return this.size;
	}

	/**
	 * Getter.
	 *
	 * @return the dough used for the pizza.
	 */
	public Dough getDough() {
		return this.dough;
	}

	@Override
	public String toString() {
		return getType() + " | size: "  + getSize() + " | dough: " + getDough();
	}
}
