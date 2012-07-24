package hu.qwaevisz.movies;

import hu.qwaevisz.common.SellAble;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Movie extends java.lang.Object implements SellAble {

	private static final String DATE_PATTERN = "yyyy.MM.dd";

	private SimpleDateFormat sdf;
	protected String name;
	protected Date releaseDate;

	public Movie(String name, Date releaseDate) {
		this.sdf = new SimpleDateFormat(Movie.DATE_PATTERN);

		this.name = name;
		this.releaseDate = releaseDate;

	}

	public Movie(String name, String releaseDate) {
		this.sdf = new SimpleDateFormat(Movie.DATE_PATTERN);

		this.name = name;
		try {
			this.releaseDate = sdf.parse(releaseDate);
		} catch (ParseException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public String getName() {
		return name;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public int getAge() {
		return Calendar.getInstance().getTime().getYear() - releaseDate.getYear();
	}

	@Override
	public String toString() {
		return "Name: " + this.name + " ReleaseDate: " + sdf.format(this.releaseDate);
	}

	public abstract void toPrint();

}
