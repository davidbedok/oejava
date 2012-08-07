package hu.qwaevisz.store.common;

public enum Mattress {

	Normal, //
	Comfortable, //
	Healthy, //
	Antiallergic, //
	Exclusive; //

	@Override
	public String toString() {
		return "[" + super.toString() + " mattress]";
	}

}
