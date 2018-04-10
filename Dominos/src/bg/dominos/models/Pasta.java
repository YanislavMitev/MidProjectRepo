package bg.dominos.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bg.dominos.exceptions.ItemException;
import bg.dominos.utils.Utils;

public class Pasta extends Food {
	private String pastaType;
	private static List<Pasta> pastas = new ArrayList<Pasta>();
	
	private Pasta(String pastaType, float price, int quantity, float weight) throws Exception {
		super(price, pastaType, quantity, weight);
		setPastaType(pastaType);
	}
	
	
	private void setPastaType(String pastaType) throws ItemException {
		if(Utils.checkString(pastaType)) {
			this.pastaType = pastaType;
		}else throw new ItemException("Illegal pasta type.");
	}


	public String getPastaType() {
		return this.pastaType;
	}
	
	public static List<Pasta> getPastas() throws Exception{
		if(pastas.isEmpty()) {
			pastas.add(new Pasta("Carbonara", 6.8f, 1, 0.440f));
			pastas.add(new Pasta("Napolien", 6.8f, 1, 0.400f));
			pastas.add(new Pasta("Pasta Pepperoni", 6.8f, 1, 0.410f));
		}
		return Collections.unmodifiableList(pastas);
	}

}
