package hu.qwaevisz.movies;

import java.util.Date;

public class Comedy extends Movie {

	private String actor;

	public Comedy(String name, Date releaseDate, String actor) {
		super(name, releaseDate);
		this.actor = actor;

	}

	public Comedy(String name, String releaseDate, String actor) {
		super(name, releaseDate);
		this.actor = actor;
	}

	@Override
	public String toString() {
		return super.toString() + " Actor: " + this.actor;
	}

	@Override
	public void toPrint() {
		System.out.println("Comedy data: " + this.toString());
	}

	@Override
	public void sell(String customer) {
		System.out.println(customer + " buys this movie: " + this);
	}

}
