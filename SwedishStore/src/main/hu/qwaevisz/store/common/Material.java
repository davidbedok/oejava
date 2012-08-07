package hu.qwaevisz.store.common;

public enum Material {

	Oak, // tolgyfa
	Beech, // bukkfa
	Pine, // fenyofa
	CherryTree, // cseresznyefa
	Plastic, // muanyag
	Metal; // fem

	@Override
	public String toString() {
		return "[" + super.toString() + " material]";
	}

}
