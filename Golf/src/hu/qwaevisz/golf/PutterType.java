package hu.qwaevisz.golf;

import java.util.Random;

public enum PutterType {

	Big(100, 250), //
	Medium(20, 100), //
	Small(0, 20), //
	Sand(0, 50);

	private final int min;
	private final int max;

	private PutterType(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public static PutterType getPutterType(int value) {
		PutterType type = PutterType.Big;
		if (value < PutterType.Small.max) {
			type = PutterType.Small;
		} else if (value < PutterType.Medium.max) {
			type = PutterType.Medium;
		}
		return type;
	}

	public int hit(Random rand, double modifierMultipler) {
		return (int) Math.round(this.min + rand.nextInt(this.max - this.min) * modifierMultipler);
	}

}
