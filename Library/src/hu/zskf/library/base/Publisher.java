package hu.zskf.library.base;

public enum Publisher {

	AKADEMIA("Akadémiai Kiadó"), //
	BABITS("Babits Kiadó"), //
	KISKAPU("Kiskapu Kiadó"), //
	KOSSUTH("Kossuth Kiadó"), //
	KRONIKA("Krónika Nova Kiadó"), //
	MUSZAKI("Mûszaki Könyvkiadó"), //
	TYPOTEX("Typotex Elektronikus Kiadó");

	private final String label;

	private Publisher(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return this.label;
	}

}
