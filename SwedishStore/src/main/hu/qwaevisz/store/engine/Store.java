package hu.qwaevisz.store.engine;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.common.DoorType;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Mattress;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;
import hu.qwaevisz.store.criteria.FurnitureSearchCriteria;
import hu.qwaevisz.store.furniture.Bed;
import hu.qwaevisz.store.furniture.Table;
import hu.qwaevisz.store.furniture.Wardrobe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

	private final Map<AbstractFurniture, Integer> items;

	public Store() {
		this.items = new HashMap<AbstractFurniture, Integer>();
	}

	public void addFurniture(AbstractFurniture furniture, Integer count) {
		Integer newCount = count;
		if (this.items.containsKey(furniture)) {
			newCount += this.items.get(furniture);
		}
		this.items.put(furniture, newCount);
	}

	public void addBed(Room room, Material material, Size size, double price,
			Mattress mattress, boolean doubleSize, boolean compactSize,
			boolean builtInLamp, Integer count) {
		this.addFurniture(new Bed(room, material, size, price, mattress,
				doubleSize, compactSize, builtInLamp), count);
	}

	public void addTable(Room room, Material material, Size size, double price,
			int numberOfChairs, boolean scratchResistant, boolean compactSize,
			Integer count) {
		this.addFurniture(new Table(room, material, size, price,
				numberOfChairs, scratchResistant, compactSize), count);
	}

	public void addWardrobe(Room room, Material material, Size size,
			double price, int numberOfShelves, DoorType typeOfDoor,
			boolean mirror, boolean builtInLamp, Integer count) {
		this.addFurniture(new Wardrobe(room, material, size, price,
				numberOfShelves, typeOfDoor, mirror, builtInLamp), count);
	}

	public List<AbstractFurniture> search(FurnitureSearchCriteria criteria) {
		List<AbstractFurniture> listOfFurniture = new ArrayList<AbstractFurniture>();
		if (criteria != null) {
			for (AbstractFurniture furniture : this.items.keySet()) {
				if (criteria.isValid(furniture)) {
					listOfFurniture.add(furniture);
				}
			}
		}
		return listOfFurniture;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		for (AbstractFurniture furniture : this.items.keySet()) {
			Integer count = this.items.get(furniture);
			info.append(furniture).append(" count: ").append(count)
					.append("\n");
		}
		return info.toString();
	}

}
