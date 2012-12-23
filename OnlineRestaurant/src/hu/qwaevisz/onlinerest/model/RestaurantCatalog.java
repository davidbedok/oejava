package hu.qwaevisz.onlinerest.model;

import java.util.Arrays;
import java.util.Random;

public class RestaurantCatalog {

	private static final int MAX_RESTAURANTS = 15;

	private final Restaurant[] restaurants;
	private int index;

	public RestaurantCatalog() {
		this.restaurants = new Restaurant[RestaurantCatalog.MAX_RESTAURANTS];
		this.index = 0;
	}

	public void addRestaurant(Restaurant restaurant) {
		if (this.index < RestaurantCatalog.MAX_RESTAURANTS) {
			this.restaurants[this.index++] = restaurant;
		}
	}

	public Restaurant find(String name) {
		Restaurant restaurant = null;
		int i = 0;
		while ((i < this.index)
				&& (!this.restaurants[i].getName().equals(name))) {
			i++;
		}
		if (i < this.index) {
			restaurant = this.restaurants[i];
		}
		return restaurant;
	}

	public void addMenuItem(String name, Food food, int price) {
		Restaurant restaurant = this.find(name);
		if (restaurant != null) {
			restaurant.addMenuItem(food, price);
		}
	}

	public Restaurant[] whichRestaurantHas(String name) {
		int numOfResult = 0;
		Restaurant[] selected = new Restaurant[RestaurantCatalog.MAX_RESTAURANTS];
		for (int i = 0; i < this.index; i++) {
			if (restaurants[i].hasFood(name)) {
				selected[numOfResult++] = restaurants[i];
			}
		}
		return Arrays.copyOf(selected, numOfResult);
	}

	public int howManyFoodsHas(Ingredient ingredient) {
		int count = 0;
		for (int i = 0; i < this.index; i++) {
			count += restaurants[i].howManyFoodsHas(ingredient);
		}
		return count;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		for (int i = 0; i < this.index; i++) {
			info.append(this.restaurants[i]);
		}
		return info.toString();
	}

	public static RestaurantCatalog createRandomCatalog(Random rand,
			Food[] foods) {
		RestaurantCatalog catalog = new RestaurantCatalog();
		int numberOfRest = rand.nextInt(4) + 3;
		for (int i = 0; i < numberOfRest; i++) {
			Restaurant rest = Restaurant
					.createRandomRestaurantWithoutFoods(rand);
			int numOfCurrentRestFood = rand.nextInt(foods.length - 3) + 3;
			for (int j = 0; j < numOfCurrentRestFood; j++) {
				rest.addMenuItem(foods[rand.nextInt(foods.length)],
						rand.nextInt(3000) + 300);
			}
			catalog.addRestaurant(rest);
		}
		return catalog;
	}

}
