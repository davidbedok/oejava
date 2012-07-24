package hu.qwaevisz.common;

import hu.qwaevisz.books.SciFi;
import hu.qwaevisz.movies.Cartoon;
import hu.qwaevisz.movies.Comedy;
import hu.qwaevisz.movies.Movie;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Movie[] movies = new Movie[4];
		movies[0] = new Comedy("The Distinguished Gentleman", new GregorianCalendar(1993, 10, 10).getTime(), "Eddie Murphy");
		movies[1] = new Cartoon("Shrek", new GregorianCalendar(2001, 6, 21).getTime(), 12);
		movies[2] = new Comedy("Twins", "1989.07.06", "Arnold Schwarzenegger");
		movies[3] = new Cartoon("A Legy", "1980.01.01", 16);

		for (Movie movie : movies) {
			movie.toPrint();
			System.out.println("Movie age: " + movie.getAge());
			System.out.println(movie.getClass().getName());
			// if ( movie.getClass().getName().equals("hu.qwaevisz.movies.Cartoon") ){
			if (movie.getClass() == Cartoon.class) {
				((Cartoon) movie).setComment("This is a comment for movie " + movie.getName() + ".");
			}
		}

		for (Movie movie : movies) {

			if (movie instanceof Cartoon) {
				System.out.println(movie + " --> comment: " + ((Cartoon) movie).getComment());
			}

		}

		SellAble[] isa = new SellAble[3];
		isa[0] = new Comedy("The Distinguished Gentleman", new GregorianCalendar(1993, 10, 10).getTime(), "Eddie Murphy");
		isa[1] = new Cartoon("Shrek", new GregorianCalendar(2001, 6, 21).getTime(), 12);
		isa[2] = new SciFi("Dune", "Arakis");

		for (int i = 0; i < isa.length; i++) {
			isa[i].sell("Joska");
		}

		Map m = new HashMap();
		m.put("dwsfew", "fwfew");

		Map mm = new Krumpli();
		mm.put("ferwfer", "fewfgerw");

	}

}
