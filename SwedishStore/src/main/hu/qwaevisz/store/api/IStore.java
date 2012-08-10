package hu.qwaevisz.store.api;

import hu.qwaevisz.store.common.DoorType;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Mattress;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;
import hu.qwaevisz.store.engine.FurnitureSearch;

import java.util.List;

public interface IStore {

	abstract void addBed(String fancyName, Room room, Material material, Size size, double price, Mattress mattress, boolean doubleSize, boolean compactSize,
			boolean builtInLamp, int count);

	abstract void addTable(String fancyName, Room room, Material material, Size size, double price, int numberOfChairs, boolean scratchResistant,
			boolean compactSize, int count);

	abstract void addWardrobe(String fancyName, Room room, Material material, Size size, double price, int numberOfShelves, DoorType typeOfDoor,
			boolean mirror, boolean builtInLamp, int count);

	abstract List<AbstractFurniture> search(FurnitureSearch search);

	abstract void loadFurniture(String fileName);

	abstract AbstractFurniture getFurnitureByFancyName(String fancyName);

	abstract Integer getCount(AbstractFurniture furniture);

	abstract String buy(AbstractFurniture furniture, int count);

}
