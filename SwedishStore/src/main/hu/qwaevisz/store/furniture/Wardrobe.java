package hu.qwaevisz.store.furniture;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.api.BuiltInLampCapable;
import hu.qwaevisz.store.common.DoorType;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;

public class Wardrobe extends AbstractFurniture implements BuiltInLampCapable {

	private final int		numberOfShelves;
	private final DoorType	typeOfDoor;
	private final boolean	mirror;
	private final boolean	builtInLamp;

	public Wardrobe(Room room, Material material, Size size, double price, int numberOfShelves, DoorType typeOfDoor, boolean mirror, boolean builtInLamp) {
		super(room, material, size, price);
		this.numberOfShelves = numberOfShelves;
		this.typeOfDoor = typeOfDoor;
		this.mirror = mirror;
		this.builtInLamp = builtInLamp;
	}

	@Override
	public boolean isBuiltInLamp() {
		return this.builtInLamp;
	}

	public int getNumberOfShelves() {
		return this.numberOfShelves;
	}

	public DoorType getTypeOfDoor() {
		return this.typeOfDoor;
	}

	public boolean isMirror() {
		return this.mirror;
	}

	@Override
	public String toString() {
		return super.toString() + ", numberOfShelves: " + this.numberOfShelves + ", typeOfDoor: " + this.typeOfDoor + ", mirror: " + this.mirror
				+ ", builtInLamp: " + this.builtInLamp;
	}

}
