package hu.qwaevisz.movie.model;

public class DVDMovie extends Movie {

	private static final int MAXIMUM_AUDIOS = 5;
	private static final int MAXIMUM_SUBTITLES = 5;
	private final Language[] subtitles;
	private final Language[] audios;
	private int subtitlesIndex;
	private int audiosIndex;

	public DVDMovie(String title, String directorName) {
		super(title, directorName);
		this.subtitles = new Language[DVDMovie.MAXIMUM_SUBTITLES];
		this.audios = new Language[DVDMovie.MAXIMUM_AUDIOS];
		this.subtitlesIndex = 0;
		this.audiosIndex = 0;
	}

	public void addSubtitles(Language... languages) {
		for (Language lang : languages) {
			this.addSubtitle(lang);
		}
	}

	private void addSubtitle(Language lang) {
		if (this.subtitlesIndex < this.subtitles.length) {
			this.subtitles[this.subtitlesIndex++] = lang;
		}
	}

	public void addAudios(Language... languages) {
		for (Language lang : languages) {
			this.addAudio(lang);
		}
	}

	private void addAudio(Language lang) {
		if (this.audiosIndex < this.audios.length) {
			this.audios[this.audiosIndex++] = lang;
		}
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		info.append(super.toString());
		info.append(this.printLanguages(this.subtitles, "Subtitles",
				this.subtitlesIndex));
		info.append(this
				.printLanguages(this.audios, "Audios", this.audiosIndex));
		return info.toString();
	}

	private String printLanguages(Language[] langs, String label, int index) {
		String infoStr = "";
		if (index > 0) {
			StringBuilder info = new StringBuilder(100);
			info.append(" | ").append(label).append(": ");
			for (int i = 0; i < index; i++) {
				info.append(langs[i]);
				if (i != index - 1) {
					info.append(", ");
				}
			}
			infoStr = info.toString();
		}
		return infoStr;
	}

	@Override
	public String rent(String name) {
		return this.getTitle() + " was rent by " + name;
	}

	@Override
	public String typeDesciption() {
		return "DVD";
	}

}
