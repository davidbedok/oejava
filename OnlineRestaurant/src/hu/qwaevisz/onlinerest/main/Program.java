package hu.qwaevisz.onlinerest.main;

import hu.qwaevisz.onlinerest.model.Food;
import hu.qwaevisz.onlinerest.model.Ingredient;
import hu.qwaevisz.onlinerest.model.MenuItem;
import hu.qwaevisz.onlinerest.model.Restaurant;
import hu.qwaevisz.onlinerest.model.RestaurantCatalog;

import java.util.Random;

public class Program {

	private static void testFood() {
		Food food = Program.createGoulashSoup();
		System.out.println(food);
	}

	private static Food createGoulashSoup() {
		Food food = new Food("goulash soup");
		food.addIngredient(Ingredient.Pepper);
		food.addIngredient(Ingredient.Potato);
		return food;
	}

	private static void testMenuItem() {
		MenuItem item = new MenuItem(Program.createGoulashSoup(), 1300);
		System.out.println(item);
	}

	private static void testRestaurant(Random rand) {
		Restaurant restaurant = Restaurant.createRandomRestaurant(rand);
		System.out.println(restaurant);
	}

	private static void testRestaurantCatalog(Random rand) {
		RestaurantCatalog catalog = new RestaurantCatalog();
		int numberOfRest = rand.nextInt(8) + 3;
		for (int i = 0; i < numberOfRest; i++) {
			catalog.addRestaurant(Restaurant.createRandomRestaurant(rand));
		}
		System.out.println(catalog);
	}

	private static void testRestaurantCatalogWithSimilarMenu(Random rand) {
		Food[] foods = Food.createRandomFoods(rand);
		RestaurantCatalog catalog = RestaurantCatalog.createRandomCatalog(rand,
				foods);
		System.out.println(catalog);

		Program.whichRestHas(catalog, foods[0].getName());
		Program.howManyFoodHas(catalog, Ingredient.Pepper);
	}

	private static void whichRestHas(RestaurantCatalog catalog, String foodName) {
		Restaurant[] result = catalog.whichRestaurantHas(foodName);
		System.out.println("Selected food: " + foodName);
		for (Restaurant rest : result) {
			System.out.println(rest.getName());
		}
	}

	private static void howManyFoodHas(RestaurantCatalog catalog,
			Ingredient ingredient) {
		int count = catalog.howManyFoodsHas(ingredient);
		System.out.println(count + " food(s) has/ve " + ingredient);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Program.testFood();
		Program.testMenuItem();
		Program.testRestaurant(rand);
		Program.testRestaurantCatalog(rand);
		Program.testRestaurantCatalogWithSimilarMenu(rand);
	}

}
