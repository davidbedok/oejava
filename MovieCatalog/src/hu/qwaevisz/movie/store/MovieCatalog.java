package hu.qwaevisz.movie.store;

import hu.qwaevisz.movie.model.Movie;

public class MovieCatalog {

	private static final int MAXIMUM_MOVIES = 20;
	private final Movie[] movies;
	private int currentIndex;

	public MovieCatalog() {
		this.movies = new Movie[MovieCatalog.MAXIMUM_MOVIES];
		this.currentIndex = 0;
	}

	public void addMovie(Movie movie) {
		if (this.currentIndex < this.movies.length) {
			this.movies[this.currentIndex++] = movie;
		}
	}

	public String rent(String name, String title) {
		Movie movie = this.find(title);
		return movie.rent(name);
	}

	public Movie find(String title) {
		Movie movie = null;
		int i = 0;
		while ((i < this.currentIndex)
				&& (!this.movies[i].getTitle().equals(title))) {
			i++;
		}
		if (i < this.currentIndex) {
			movie = this.movies[i];
		}
		return movie;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		for (int i = 0; i < this.currentIndex; i++) {
			info.append(this.movies[i]).append("\n");
		}
		return info.toString();
	}

}
