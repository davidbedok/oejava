package hu.qwaevisz.store.common;

public enum DoorType {

	Double, // ketszarnyu
	Sliding, // tolo
	Shutter; // redony

	@Override
	public String toString() {
		return "[" + super.toString() + " doortype]";
	}

}
