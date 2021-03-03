package order.models.item;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Salad")
public class Salad extends Food {

	/**
	 * Constructor.
	 */
	public Salad() {
		// No ops.
	}

	/**
	 * Constructor.
	 *
	 * @param description is the salad description.
	 * @param saladType is the salad type.
	 * @param price is the salad price.
	 */
	public Salad(String description, String saladType, float price) {
		setDescription(description);
		setType(saladType);
		setPrice(price);
	}
}
