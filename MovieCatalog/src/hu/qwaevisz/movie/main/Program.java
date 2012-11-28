package hu.qwaevisz.movie.main;

import hu.qwaevisz.movie.model.DVDMovie;
import hu.qwaevisz.movie.model.Language;
import hu.qwaevisz.movie.model.Movie;
import hu.qwaevisz.movie.model.VHSMode;
import hu.qwaevisz.movie.model.VHSMovie;
import hu.qwaevisz.movie.store.MovieCatalog;

public class Program {

	private static void testDVDMovie() {
		System.out.println("# test DVDMovie");
		DVDMovie dvdmovie = new DVDMovie("StarWars", "George Lucas");
		dvdmovie.addMainCharacter("Harrison Ford");
		dvdmovie.addSubtitles(Language.English, Language.Hungarian);
		dvdmovie.addAudios(Language.English);
		System.out.println(dvdmovie);
	}

	private static void testVHSMovie() {
		System.out.println("# test VHSMovie");
		VHSMovie vhsmovie = new VHSMovie("Leon a profi", "Luc Besson",
				VHSMode.SP);
		vhsmovie.addMainCharacter("Jean Reno");
		vhsmovie.addMainCharacter("Natalie Portman");
		System.out.println(vhsmovie);
	}

	private static void testCatalog() {
		System.out.println("# test Catalog");

		MovieCatalog catalog = new MovieCatalog();
		catalog.addMovie(new DVDMovie("Apple", "Alfa"));
		catalog.addMovie(new DVDMovie("Pear", "Brave"));
		catalog.addMovie(new VHSMovie("Peach", "Charlie", VHSMode.SP));
		catalog.addMovie(new VHSMovie("Plum", "Delta", VHSMode.LP));
		catalog.addMovie(new VHSMovie("Grape", "Echo", VHSMode.SP));

		System.out.println(catalog);

		System.out.println(catalog.rent("Nemecsek", "Peach"));
		System.out.println(catalog.rent("Krumpli", "Plum"));

		Movie movie = catalog.find("Plum");
		System.out.println(movie);
		VHSMovie vhsMovie = (VHSMovie) movie;
		vhsMovie.watch();
		System.out.println(movie);

		if (movie instanceof DVDMovie) {
			DVDMovie dvdMovie = (DVDMovie) movie;
			dvdMovie.addSubtitles(Language.English);
		}
	}

	public static void main(String[] args) {
		Program.testDVDMovie();
		Program.testVHSMovie();

		Program.testCatalog();
	}

}
