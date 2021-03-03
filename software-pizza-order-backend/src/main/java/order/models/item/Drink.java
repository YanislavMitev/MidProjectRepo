package order.models.item;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Drink")
public class Drink extends Food {

	/**
	 * Constructor.
	 */
	public Drink() {
		// No ops.
	}

	/**
	 * Constructor.
	 *
	 * @param description is the drink description.
	 * @param type is the drink type.
	 * @param price is the drink price.
	 */
	public Drink(String description, String type, float price) {
		setDescription(description);
		setType(type);
		setPrice(price);
	}
}
