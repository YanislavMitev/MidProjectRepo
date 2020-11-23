package dominos.models.item;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Interface type denoting an item.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
		@JsonSubTypes.Type(Chicken.class),
		@JsonSubTypes.Type(Dessert.class),
		@JsonSubTypes.Type(Drink.class),
		@JsonSubTypes.Type(Pasta.class),
		@JsonSubTypes.Type(Pizza.class),
		@JsonSubTypes.Type(Salad.class),
		@JsonSubTypes.Type(Sandwich.class),
		@JsonSubTypes.Type(Sauce.class),
		@JsonSubTypes.Type(Starter.class)
})
public interface Item {

	/**
	 * Getter.
	 *
	 * @return the item's price.
	 */
	float getPrice();

	/**
	 * Getter.
	 *
	 * @return item's type.
	 */
	String getType();

	/**
	 * Getter.
	 *
	 * @return item's description.
	 */
	String getDescription();
}
