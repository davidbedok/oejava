package hu.qwaevisz.store.furniture;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.api.BuiltInLampCapable;
import hu.qwaevisz.store.common.CsvFurnitureType;
import hu.qwaevisz.store.common.DoorType;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;

public class Wardrobe extends AbstractFurniture implements BuiltInLampCapable {

	private final int		numberOfShelves;
	private final DoorType	typeOfDoor;
	private final boolean	mirror;

	private final boolean	builtInLamp;

	public Wardrobe(String fancyName, Room room, Material material, Size size, double price, int numberOfShelves, DoorType typeOfDoor, boolean mirror,
			boolean builtInLamp) {
		super(fancyName, room, material, size, price);
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
	public int hashCode() {
		return super.hashCode() * Integer.valueOf(this.numberOfShelves).hashCode() * this.typeOfDoor.hashCode() * Boolean.valueOf(this.mirror).hashCode()
				* Boolean.valueOf(this.builtInLamp).hashCode();
	}

	@Override
	public boolean equals(Object othat) {
		if (this == othat) {
			return true;
		}
		if ((othat != null) && (!(othat.getClass() == this.getClass()))) {
			return false;
		}
		if (super.equals(othat)) {
			Wardrobe that = (Wardrobe) othat;
			if (this.numberOfShelves == that.numberOfShelves && this.typeOfDoor.equals(that.typeOfDoor) && this.mirror == that.mirror
					&& this.builtInLamp == that.builtInLamp) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return CsvFurnitureType.WARDROBE.toString() + super.toString() + ", " + this.numberOfShelves + " shel(f/ves) " + this.typeOfDoor + " "
				+ (this.mirror ? "[Mirror] " : "") + (this.builtInLamp ? "[BuiltInLamp]" : "");
	}

}
