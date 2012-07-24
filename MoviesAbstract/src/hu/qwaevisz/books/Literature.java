package hu.qwaevisz.books;

public class Literature extends Book {

	private int ageLimit;
	private String comment;

	public Literature(String name, int ageLimit) {
		super(name);
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
		System.out.println("Literature data: " + this.toString());
	}

	@Override
	public void sell(String customer) {
		System.out.println(customer + " buys this book: " + this);
	}

}
