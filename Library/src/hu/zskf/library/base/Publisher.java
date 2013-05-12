package hu.zskf.library.base;

public enum Publisher {

	AKADEMIA("Akad�miai Kiad�"), //
	BABITS("Babits Kiad�"), //
	KISKAPU("Kiskapu Kiad�"), //
	KOSSUTH("Kossuth Kiad�"), //
	KRONIKA("Kr�nika Nova Kiad�"), //
	MUSZAKI("M�szaki K�nyvkiad�"), //
	TYPOTEX("Typotex Elektronikus Kiad�");

	private final String label;

	private Publisher(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return this.label;
	}

}
