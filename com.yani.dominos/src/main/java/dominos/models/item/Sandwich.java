package dominos.models.item;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Sandwich")
public class Sandwich extends Food {

	/**
	 * Constructor.
	 */
	public Sandwich() {
		// No ops.
	}

	/**
	 * Constructor.
	 *
	 * @param description is the sandwich description.
	 * @param sandwichType is hte sandwich type.
	 * @param price is the sandwich type.
	 */
	public Sandwich(String description, String sandwichType, float price) {
		setDescription(description);
		setType(sandwichType);
		setPrice(price);
	}

	@Override
	public String toString() {
		return getType() + " | price: " + this.getPrice() + " lv." + "\n" + this.description;
	}
}
