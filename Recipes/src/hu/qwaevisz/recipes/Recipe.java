package hu.qwaevisz.recipes;

public class Recipe {

	private static final int MAX_INGREDIENTS = 10;

	private final String name;
	private final Ingredient[] ingredients;
	private int index;

	public Recipe(String name) {
		this.name = name;
		this.ingredients = new Ingredient[Recipe.MAX_INGREDIENTS];
		this.index = 0;
	}

	private void addIngredient(Ingredient ingredient) {
		if (this.index < this.ingredients.length) {
			this.ingredients[this.index++] = ingredient;
		}
	}

	public void addIngredient(Commodity commodity, float quantity) {
		this.addIngredient(new Ingredient(commodity, quantity));
	}

	public String getName() {
		return this.name;
	}

	public boolean hasCommodity(Commodity commodity) {
		int i = 0;
		while (i < this.index && this.ingredients[i].getCommodity() != commodity) {
			i++;
		}
		return (i < this.index);
	}

	public float totalQuantity() {
		float totalQuantity = 0;
		for (int i = 0; i < this.index; i++) {
			totalQuantity += this.ingredients[i].getQuantity();
		}
		return totalQuantity;
	}

	public int numberOfDifferentCommodities() {
		int count = 0;
		for (int i = 0; i < this.index; i++) {
			int j = 0;
			while (j < i && this.ingredients[i].getCommodity() != this.ingredients[j].getCommodity()) {
				j++;
			}
			if (j == i) {
				count++;
			}
		}
		return count;
	}

	public Commodity[] necessaryCommodities() {
		Commodity[] commodities = new Commodity[this.numberOfDifferentCommodities()];
		int index = 0;
		for (int i = 0; i < this.index; i++) {
			int j = 0;
			while (j < index && commodities[j] != this.ingredients[i].getCommodity()) {
				j++;
			}
			if (j == index) {
				commodities[index++] = this.ingredients[i].getCommodity();
			}
		}
		return commodities;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		info.append("[").append(this.name).append("] ");
		for (int i = 0; i < this.index; i++) {
			info.append(this.ingredients[i]).append(" ");
		}
		return info.toString();
	}

}
