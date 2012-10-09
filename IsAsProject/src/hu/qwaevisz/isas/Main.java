package hu.qwaevisz.isas;

public class Main {

	public static void main(String[] args) {
		Movie[] movies = new Movie[2];
		movies[0] = new Comedy();
		movies[1] = new Cartoon();

		for (Movie movie : movies) {

			if (movie.getClass() == Comedy.class) {
				System.out.println("COMDEDY IS " + movie.toPrint());
			} else {
				System.out.println("NOT COMDEDY --> " + movie.toPrint());
			}

			if (movie instanceof Comedy) {
				System.out.println("COMDEDY IS " + movie.toPrint());
			} else {
				System.out.println("NOT COMDEDY --> " + movie.toPrint());
			}

		}

	}

}
