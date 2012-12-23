package hu.qwaevisz.onlinerest.model;

import java.util.Random;

public class Food {

	private static final int MAX_INGREDIENTS = 10;

	private final String name;
	private final Ingredient[] ingredients;
	private int index;

	public Food(String name) {
		this.name = name;
		this.ingredients = new Ingredient[Food.MAX_INGREDIENTS];
		this.index = 0;
	}

	public void addIngredient(Ingredient ingredient) {
		if (this.index < Food.MAX_INGREDIENTS) {
			this.ingredients[this.index++] = ingredient;
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		info.append(this.name).append(" ingredient(s): ");
		for (int i = 0; i < this.index; i++) {
			info.append(this.ingredients[i]);
			if (i != this.index - 1) {
				info.append(", ");
			}
		}
		return info.toString();
	}

	public static Food createRandomFood(Random rand) {
		Food food = new Food("food_" + (rand.nextInt(900) + 100));
		int numberOfIngredients = rand.nextInt(5) + 1;
		Ingredient[] ingredients = Ingredient.values();
		for (int i = 0; i < numberOfIngredients; i++) {
			food.addIngredient(ingredients[rand.nextInt(ingredients.length)]);
		}
		return food;
	}

	public static Food[] createRandomFoods(Random rand) {
		int numberOfFood = rand.nextInt(6) + 4;
		Food[] foods = new Food[numberOfFood];
		for (int i = 0; i < numberOfFood; i++) {
			foods[i] = Food.createRandomFood(rand);
		}
		return foods;
	}

	public boolean hasIngredient(Ingredient ingredient) {
		int i = 0;
		while ((i < this.index) && (!this.ingredients[i].equals(ingredient))) {
			i++;
		}
		return (i < this.index);
	}

}
