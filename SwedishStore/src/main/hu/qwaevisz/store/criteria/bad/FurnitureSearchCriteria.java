package hu.qwaevisz.store.criteria.bad;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.criteria.api.DoubleRange;

import java.util.Arrays;
import java.util.EnumSet;

public class FurnitureSearchCriteria {

	protected EnumSet<Room>			rooms;
	protected EnumSet<Material>		materials;
	protected SizeSearchCriteria	sizeCriteria;
	protected DoubleRange			priceRange;

	public FurnitureSearchCriteria() {
		this.rooms = EnumSet.noneOf(Room.class);
		this.materials = EnumSet.noneOf(Material.class);
		this.sizeCriteria = new SizeSearchCriteria();
	}

	public void addRoomCriteria(Room... rooms) {
		this.rooms.addAll(Arrays.asList(rooms));
	}

	public void addMaterialCriteria(Material... materials) {
		this.materials.addAll(Arrays.asList(materials));
	}

	public void addSizeWidthRangeCriteria(double minValue, double maxValue) {
		this.sizeCriteria.addWidthRangeCriteria(minValue, maxValue);
	}

	public void addSizeHeightRangeCriteria(double minValue, double maxValue) {
		this.sizeCriteria.addHeightRangeCriteria(minValue, maxValue);
	}

	public void addSizeLengthRangeCriteria(double minValue, double maxValue) {
		this.sizeCriteria.addLengthRangeCriteria(minValue, maxValue);
	}

	public void addPriceRangeCriteria(double minValue, double maxValue) {
		this.priceRange = new DoubleRange(minValue, maxValue);
	}

	public boolean isValid(AbstractFurniture furniture) {
		boolean valid = true;
		if (furniture != null) {
			valid = this.isValidRoom(furniture.getRoom()) && this.isValidMaterial(furniture.getMaterial()) && this.sizeCriteria.isValid(furniture.getSize())
					&& DoubleRange.isValid(this.priceRange, furniture.getPrice());
		}
		return valid;
	}

	private boolean isValidRoom(Room room) {
		return (this.rooms.size() == 0 || this.rooms.contains(room));
	}

	private boolean isValidMaterial(Material material) {
		return (this.materials.size() == 0 || this.materials.contains(material));
	}

}
