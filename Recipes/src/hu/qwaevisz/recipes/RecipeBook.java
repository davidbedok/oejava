package hu.qwaevisz.recipes;


public class RecipeBook {

	private static final int MAX_RECIPES = 100;

	private final Recipe[] recipes;
	private int index;

	public RecipeBook() {
		this.recipes = new Recipe[RecipeBook.MAX_RECIPES];
		this.index = 0;
	}

	public void addRecipe(Recipe recipe) {
		if (this.index < this.recipes.length) {
			this.recipes[this.index++] = recipe;
		}
	}

	public Recipe find(String name) {
		Recipe recipe = null;
		int i = 0;
		while (i < this.index && !this.recipes[i].getName().equals(name)) {
			i++;
		}
		if (i < this.index) {
			recipe = this.recipes[i];
		}
		return recipe;
	}

	public int numberOfRecipesWithout(Commodity commodity) {
		int count = 0;
		for (int i = 0; i < this.index; i++) {
			if (!this.recipes[i].hasCommodity(commodity)) {
				count++;
			}
		}
		return count;
	}

	public Recipe[] contains(Commodity commodity) {
		Recipe[] ret = new Recipe[this.index - this.numberOfRecipesWithout(commodity)];
		int index = 0;
		for (int i = 0; i < this.index; i++) {
			if (this.recipes[i].hasCommodity(commodity)) {
				ret[index++] = this.recipes[i];
			}
		}
		return ret;
	}

	public Recipe mostComplicated() {
		Recipe ret = null;
		if (this.index > 0) {
			ret = this.recipes[0];
			int maxDiffCommodities = this.recipes[0].numberOfDifferentCommodities();
			for (int i = 1; i < this.index; i++) {
				int currentDiffCommodities = this.recipes[i].numberOfDifferentCommodities();
				if (currentDiffCommodities > maxDiffCommodities) {
					maxDiffCommodities = currentDiffCommodities;
					ret = this.recipes[i];
				}
			}
		}
		return ret;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		for (int i = 0; i < this.index; i++) {
			info.append(this.recipes[i]).append("\n");
		}
		return info.toString();
	}

}
