package hu.qwaevisz.disney.model;

import java.util.Random;

public enum PhoneType {

	HOME_PHONE(10, "home"), //
	CELL_PHONE(20, "cell"), //
	WORK_PHONE(30, "work");

	private final int grid;
	private final String label;

	private PhoneType(int grid, String label) {
		this.grid = grid;
		this.label = label;
	}

	public int getGrid() {
		return this.grid;
	}

	public String getLabel() {
		return this.label;
	}

	public static PhoneType fromGrid(int grid) {
		PhoneType type = PhoneType.getDefault();
		for (PhoneType phoneType : PhoneType.values()) {
			if (phoneType.getGrid() == grid) {
				type = phoneType;
				break;
			}
		}
		return type;
	}

	private static PhoneType getDefault() {
		return PhoneType.HOME_PHONE;
	}

	public static PhoneType randomType(Random rand) {
		PhoneType[] values = PhoneType.values();
		return values[rand.nextInt(values.length)];
	}

}
