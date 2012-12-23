package hu.qwaevisz.onlinerest.model;

import java.util.Random;

public class Restaurant {

	private static final int MAX_MENUITEMS = 20;

	private final String name;
	private final MenuItem[] menu;
	private int index;

	public Restaurant(String name) {
		this.name = name;
		this.menu = new MenuItem[Restaurant.MAX_MENUITEMS];
		this.index = 0;
	}

	private void addMenuItem(MenuItem item) {
		if (this.index < Restaurant.MAX_MENUITEMS) {
			this.menu[this.index++] = item;
		}
	}

	public void addMenuItem(Food food, int price) {
		this.addMenuItem(new MenuItem(food, price));
	}

	public String getName() {
		return name;
	}

	public boolean hasFood(String name) {
		int i = 0;
		while ((i < this.index)
				&& (!this.menu[i].getFood().getName().equals(name))) {
			i++;
		}
		return (i < this.index);
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		info.append("Restaurant: ").append(this.name).append("\n");
		for (int i = 0; i < this.index; i++) {
			info.append(this.menu[i]).append("\n");
		}
		return info.toString();
	}

	public static Restaurant createRandomRestaurant(Random rand) {
		Restaurant restaurant = Restaurant
				.createRandomRestaurantWithoutFoods(rand);
		int numberOfFood = rand.nextInt(7) + 2;
		for (int i = 0; i < numberOfFood; i++) {
			restaurant.addMenuItem(Food.createRandomFood(rand),
					rand.nextInt(3000) + 300);
		}
		return restaurant;
	}

	public static Restaurant createRandomRestaurantWithoutFoods(Random rand) {
		Restaurant restaurant = new Restaurant("restaurant_"
				+ (rand.nextInt(90) + 10));
		return restaurant;
	}

	public int howManyFoodsHas(Ingredient ingredient) {
		int count = 0;
		for (int i = 0; i < this.index; i++) {
			if (this.menu[i].getFood().hasIngredient(ingredient)) {
				count++;
			}
		}
		return count;
	}

}
