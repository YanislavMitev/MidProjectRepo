package bg.dominos.models;

import java.util.ArrayList;
import java.util.List;

import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalWeightException;
import bg.dominos.exceptions.InvalidQuantityException;

public class Pizza extends Food {
	private Size size;
	private Dough dough;
	
	public Pizza(float price, String type, int quantity, float weight, Size size, Dough dough)
			throws Exception {
		super(price, type, quantity, weight);
		setSize(size);
		setDough(dough);
	}

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Dough getDough() {
		return this.dough;
	}

	public void setDough(Dough dough) {
		this.dough = dough;
	}
}
