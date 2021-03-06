package hu.qwaevisz.store.furniture;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.api.BuiltInLampCapable;
import hu.qwaevisz.store.api.CompactSizeCapable;
import hu.qwaevisz.store.common.CsvFurnitureType;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Mattress;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;

public class Bed extends AbstractFurniture implements BuiltInLampCapable, CompactSizeCapable {

	private final Mattress	mattress;
	private final boolean	doubleSize;	// double or single
	private final boolean	compactSize;
	private final boolean	builtInLamp;

	public Bed(String fancyName, Room room, Material material, Size size, double price, Mattress mattress, boolean doubleSize, boolean compactSize,
			boolean builtInLamp) {
		super(fancyName, room, material, size, price);
		this.mattress = mattress;
		this.doubleSize = doubleSize;
		this.compactSize = compactSize;
		this.builtInLamp = builtInLamp;
	}

	@Override
	public boolean isCompactSizeMode() {
		return this.compactSize;
	}

	@Override
	public boolean isBuiltInLamp() {
		return this.builtInLamp;
	}

	public Mattress getMattress() {
		return this.mattress;
	}

	public boolean isDoubleSize() {
		return this.doubleSize;
	}

	@Override
	public int hashCode() {
		return super.hashCode() * this.mattress.hashCode() * Boolean.valueOf(this.doubleSize).hashCode() * Boolean.valueOf(this.compactSize).hashCode()
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
			Bed that = (Bed) othat;
			if ((this.mattress.equals(that.mattress)) && this.doubleSize == that.doubleSize && this.compactSize == that.compactSize
					&& this.builtInLamp == that.builtInLamp) {
				return true;
			}
		}
		return false;
	}

	public boolean equalsTest(Object othat) {
		return super.equals(othat);
	}

	@Override
	public String toString() {
		return super.toString() + " " + this.mattress + " " + (this.doubleSize ? "[DoubleSize] " : "[SingleSize] ")
				+ (this.compactSize ? "[CompactSize] " : "") + (this.builtInLamp ? "[BuiltInLamp]" : "");
	}

	@Override
	protected String printType() {
		return CsvFurnitureType.BED.toString();
	}

	@Override
	protected String sellDetails() {
		return "Slats have to get from warehouse by customer, but the " + this.mattress + " has to get by fellow worker of store.";
	}

}
