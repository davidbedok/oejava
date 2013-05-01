package hu.qwaevisz.recipes;

import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		Program.testRecipe();
		Program.testRecipeBook();
	}

	private static void testRecipe() {
		System.out.println("---[ Recipe ]---");
		Recipe recipe = Program.createBesamel();

		System.out.println(recipe);
		System.out.println("has Onion? " + recipe.hasCommodity(Commodity.Onion));
		System.out.println("has Butter? " + recipe.hasCommodity(Commodity.Butter));

		System.out.println("number of different commodities: " + recipe.numberOfDifferentCommodities());
		System.out.println("total quantity: " + recipe.totalQuantity());
		System.out.println("necessary commodities: " + Arrays.toString(recipe.necessaryCommodities()));
	}

	private static Recipe createBesamel() {
		Recipe recipe = new Recipe("Besamel");
		recipe.addIngredient(Commodity.Flour, 50);
		recipe.addIngredient(Commodity.Butter, 50);
		recipe.addIngredient(Commodity.Milk, 50);
		recipe.addIngredient(Commodity.Milk, 100);
		return recipe;
	}

	private static void testRecipeBook() {
		System.out.println("---[ RecipeBook ]---");
		RecipeBook book = new RecipeBook();
		book.addRecipe(Program.createBesamel());
		book.addRecipe(Program.createRicePudding());
		book.addRecipe(Program.createKiev());
		book.addRecipe(Program.createRoast());
		book.addRecipe(Program.createPorkSchnitzel());

		System.out.println(book);
		System.out.println("find Besamel: " + book.find("Besamel"));

		System.out.println("number of recipes without Onion: " + book.numberOfRecipesWithout(Commodity.Onion));
		System.out.println("number of recipes without Egg: " + book.numberOfRecipesWithout(Commodity.Egg));

		Recipe[] onionRecipes = book.contains(Commodity.Onion);
		System.out.println("Onion recipes: " + Arrays.toString(onionRecipes));
		System.out.println("most complicated recipe: " + book.mostComplicated());
	}

	private static Recipe createRicePudding() {
		Recipe recipe = new Recipe("Rice pudding");
		recipe.addIngredient(Commodity.Rice, 100);
		recipe.addIngredient(Commodity.Milk, 100);
		recipe.addIngredient(Commodity.Milk, 200);
		recipe.addIngredient(Commodity.Butter, 10);
		return recipe;
	}

	private static Recipe createKiev() {
		Recipe recipe = new Recipe("Kiev");
		recipe.addIngredient(Commodity.Butter, 10);
		recipe.addIngredient(Commodity.Meat, 100);
		recipe.addIngredient(Commodity.Butter, 50);
		recipe.addIngredient(Commodity.Onion, 10);
		return recipe;
	}

	private static Recipe createRoast() {
		Recipe recipe = new Recipe("Roast");
		recipe.addIngredient(Commodity.Butter, 10);
		recipe.addIngredient(Commodity.Meat, 100);
		recipe.addIngredient(Commodity.Flour, 10);
		recipe.addIngredient(Commodity.Onion, 30);
		return recipe;
	}

	private static Recipe createPorkSchnitzel() {
		Recipe recipe = new Recipe("Pork schnitzel");
		recipe.addIngredient(Commodity.Meat, 100);
		recipe.addIngredient(Commodity.Flour, 10);
		recipe.addIngredient(Commodity.Egg, 10);
		return recipe;
	}

}
