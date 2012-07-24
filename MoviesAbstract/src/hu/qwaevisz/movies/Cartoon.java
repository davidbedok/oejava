package hu.qwaevisz.movies;

import java.util.Date;

public class Cartoon extends Movie {

	private int ageLimit;
	private String comment;

	public Cartoon(String name, Date releaseDate, int ageLimit) {
		super(name, releaseDate);
		this.ageLimit = ageLimit;
	}

	public Cartoon(String name, String releaseDate, int ageLimit) {
		super(name, releaseDate);
		this.ageLimit = ageLimit;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return super.toString() + " AgeLimit: " + this.ageLimit;
	}

	@Override
	public void toPrint() {
		System.out.println("Cartoon data: " + this.toString());
	}

	@Override
	public void sell(String customer) {
		System.out.println(customer + " buys this movie: " + this);
	}

}
