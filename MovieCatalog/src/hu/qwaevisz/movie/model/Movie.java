package hu.qwaevisz.movie.model;

public abstract class Movie extends Object {

	private static final int MAX_MAIN_CHARACTERS = 10;
	private final String title;
	private final Person director;
	private final Person[] mainCharacters;
	private int index;

	public Movie(String title, String directorName) {
		super();
		this.title = title;
		this.director = new Person(directorName);
		this.mainCharacters = new Person[Movie.MAX_MAIN_CHARACTERS];
	}

	private void addMainCharacter(Person person) {
		if (this.index < this.mainCharacters.length) {
			this.mainCharacters[this.index++] = person;
		}
	}

	public void addMainCharacter(String charcterName) {
		this.addMainCharacter(new Person(charcterName));
	}

	public Person getDirector() {
		return this.director;
	}

	public String getTitle() {
		return this.title;
	}

	public abstract String rent(String name);

	public abstract String typeDesciption();

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(50);
		info.append("[").append(this.typeDesciption()).append("] ");
		info.append(this.director).append(": ").append(this.title);
		if (this.index > 0) {
			info.append(" | Main character(s): ");
			for (int i = 0; i < this.index; i++) {
				info.append(this.mainCharacters[i]);
				if (i != this.index - 1) {
					info.append(", ");
				}
			}
		}
		return info.toString();
	}

}
