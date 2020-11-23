package dominos.models.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import dominos.utils.Utils;

/**
 * Abstract representation for all food items.
 */
public abstract class Food implements Item {
	private static final String INVALID_DESCRIPTION = "Invalid description";

	@JsonProperty
	protected String description;

	@JsonProperty
	protected String type;

	@JsonProperty
	protected float price;

	/**
	 * Constructor.
	 */
	protected Food() {
		// No ops.
	}

	/**
	 * Setter.
	 * @param description is the food description.
	 *
	 * @throws IllegalArgumentException whenever an invalid
	 * 									description value is
	 * 									passed as argument.
	 */
	void setDescription(String description) {
		if (Utils.checkString(description)) {
			this.description = description;
		} else {
			throw new IllegalArgumentException(INVALID_DESCRIPTION);
		}
	}

	/**
	 * Getter.
	 *
	 * @return the string value of the description.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Setter.
	 *
	 * @param type is the food dish type.
	 *
	 * @throws IllegalArgumentException whenever an invalid
	 * 									type value is passed
	 * 									as argument.
	 */
	void setType(String type) {
		if (Utils.checkString(type)) {
			this.type = type;
		} else {
			throw new IllegalArgumentException("Illegal food type.");
		}
	}

	/**
	 * Getter.
	 *
	 * @return the string value of the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter.
	 *
	 * @param price is the food price.
	 *
	 * @throws IllegalArgumentException whenever an invalid
	 * 									price value is passed
	 * 									as argument.
	 */
	void setPrice(float price) {
		if (price <= 0) {
			throw new IllegalArgumentException("You have entered an invalid price");
		}

		this.price = price;
	}

	/**
	 * Getter.
	 *
	 * @return the float value of the price.
	 */
	public float getPrice() {
		return price;
	}
}
