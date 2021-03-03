package order.models.item;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Sauce")
public class Sauce extends Food {

	/**
	 * Constructor.
	 */
	public Sauce() {
		// No ops.
	}

	/**
	 * Constructor.
	 *
	 * @param description is the sauce description.
	 * @param sauceType is the sauce type.
	 * @param price is the sauce price.
	 */
	public Sauce(String description, String sauceType, float price) {
		setDescription(description);
		setType(sauceType);
		setPrice(price);
	}
}