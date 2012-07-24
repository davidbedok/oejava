package hu.qwaevisz.books;

public class SciFi extends Book {

	private String world;

	public SciFi(String name, String world) {
		super(name);
		this.world = world;
	}

	@Override
	public String toString() {
		return super.toString() + " World: " + this.world;
	}

	@Override
	public void toPrint() {
		System.out.println("SciFi data: " + this.toString());
	}

	@Override
	public void sell(String customer) {
		System.out.println(customer + " buys this book: " + this);
	}

}
