package hu.qwaevisz.onlinerest.model;

public class MenuItem {

	private static final String CURRENCY = "HUF";

	private final Food food;
	private final int price;

	public MenuItem(Food food, int price) {
		this.food = food;
		this.price = price;
	}

	public Food getFood() {
		return food;
	}

	@Override
	public String toString() {
		return this.food + " (" + this.price + " " + MenuItem.CURRENCY + ")";
	}

}
