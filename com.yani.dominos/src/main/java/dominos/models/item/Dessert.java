package dominos.models.item;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Dessert")
public class Dessert extends Food {

	/**
	 * Constructor.
	 */
	public Dessert() {
		super();
	}

	/**
	 * Constructor.
	 * @param dessertType is the dessert type.
	 * @param price is the dessert price.
	 * @param description is the dessert description.
	 *
	 * @throws IllegalArgumentException whenever an invalid
	 * 									argument is passed to
	 * 									be set as an item value.
	 */
	public Dessert(String dessertType, float price, String description) {
		setDescription(description);
		setType(dessertType);
		setPrice(price);
	}
}
