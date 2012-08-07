package hu.qwaevisz.store.api;

import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;

public abstract class AbstractFurniture {

	private static final String	CURRENCY	= "EUR";

	protected final Room		room;
	protected final Material	material;
	protected final Size		size;

	protected final double		price;

	public AbstractFurniture(final Room room, final Material material, final Size size, double price) {
		this.room = room;
		this.material = material;
		this.size = size;
		this.price = price;
	}

	public Material getMaterial() {
		return this.material;
	}

	public double getPrice() {
		return this.price;
	}

	public Room getRoom() {
		return this.room;
	}

	public Size getSize() {
		return this.size;
	}

	@Override
	public int hashCode() {
		return this.room.hashCode() * this.material.hashCode() * this.size.hashCode();
	}

	@Override
	public boolean equals(Object othat) {
		if (this == othat) {
			return true;
		}
		if (!(othat instanceof AbstractFurniture)) {
			return false;
		}
		AbstractFurniture that = (AbstractFurniture) othat;
		if ((this.room.equals(that.room)) && this.material.equals(that.material) && this.size.equals(that.size)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return this.room + " " + this.material + " " + this.size + " " + this.price + " " + AbstractFurniture.CURRENCY;
	}

}
