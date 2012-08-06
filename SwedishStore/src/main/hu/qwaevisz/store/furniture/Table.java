package hu.qwaevisz.store.furniture;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.api.CompactSizeCapable;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;

public class Table extends AbstractFurniture implements CompactSizeCapable {

	private final int		numberOfChairs;
	private final boolean	scratchResistant;

	private final boolean	compactSize;

	public Table(Room room, Material material, Size size, double price, int numberOfChairs, boolean scratchResistant, boolean compactSize) {
		super(room, material, size, price);
		this.numberOfChairs = numberOfChairs;
		this.scratchResistant = scratchResistant;
		this.compactSize = compactSize;
	}

	@Override
	public boolean isCompactSizeMode() {
		return this.compactSize;
	}

	public int getNumberOfChairs() {
		return this.numberOfChairs;
	}

	public boolean isScratchResistant() {
		return this.scratchResistant;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() * Integer.valueOf(numberOfChairs).hashCode() * Boolean.valueOf(scratchResistant).hashCode() * Boolean.valueOf(compactSize).hashCode();
	}
	
	@Override
	public boolean equals(Object othat) {
		if (this == othat) {
			return true;
		}
		if ( (othat != null) && (!(othat.getClass() == this.getClass())) ) {
			return false;
		}
		if ( super.equals(othat) ) {
			Table that = (Table) othat;
			if ( this.numberOfChairs == that.numberOfChairs && this.scratchResistant == that.scratchResistant && this.compactSize == that.compactSize ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + ", numberOfChairs: " + this.numberOfChairs + ", scratchResistant: " + this.scratchResistant + ", compactSize: "
				+ this.compactSize;
	}

}
