package hu.qwaevisz.theorem;

public class MinimumData {

	private final int	minimum;
	private final int	count;

	public MinimumData(final int minimum, final int count) {
		this.minimum = minimum;
		this.count = count;
	}

	public int getMinimum() {
		return this.minimum;
	}

	public int getCount() {
		return this.count;
	}

}
