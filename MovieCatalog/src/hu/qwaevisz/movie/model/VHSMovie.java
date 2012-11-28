package hu.qwaevisz.movie.model;

public class VHSMovie extends Movie {

	private final VHSMode mode;
	private int watchCounter;

	public VHSMovie(String title, String directorName, VHSMode mode) {
		super(title, directorName);
		this.mode = mode;
		this.watchCounter = 0;
	}

	public void watch() {
		this.watchCounter++;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		info.append(super.toString());
		info.append(" | Mode: ").append(this.mode);
		info.append(" | Watch counter: ").append(this.watchCounter);
		return info.toString();
	}

	@Override
	public String rent(String name) {
		this.watch();
		return this.getTitle() + " was rent by " + name;
	}

	@Override
	public String typeDesciption() {
		return "VHS";
	}

}
