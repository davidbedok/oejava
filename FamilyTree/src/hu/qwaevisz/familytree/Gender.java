package hu.qwaevisz.familytree;

public enum Gender {

	MAN("Ferfi"), //
	WOMAN("No");

	private final String label;

	private Gender(final String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

}
