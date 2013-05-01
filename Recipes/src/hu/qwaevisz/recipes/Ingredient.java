package hu.qwaevisz.recipes;

public class Ingredient {

	private final Commodity commodity;
	private final float quantity;

	public Ingredient(Commodity commodity, float quantity) {
		super();
		this.commodity = commodity;
		this.quantity = quantity;
	}

	public Commodity getCommodity() {
		return this.commodity;
	}

	public float getQuantity() {
		return this.quantity;
	}

	@Override
	public String toString() {
		return this.commodity + "-" + this.quantity;
	}

}
