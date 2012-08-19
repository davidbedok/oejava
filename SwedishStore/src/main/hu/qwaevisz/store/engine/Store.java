package hu.qwaevisz.store.engine;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.api.IStore;
import hu.qwaevisz.store.common.CsvFurnitureType;
import hu.qwaevisz.store.common.DoorType;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Mattress;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;
import hu.qwaevisz.store.criteria.bad.FurnitureSearchCriteria;
import hu.qwaevisz.store.furniture.Bed;
import hu.qwaevisz.store.furniture.Table;
import hu.qwaevisz.store.furniture.Wardrobe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store implements IStore {

	// final Map<Salable, Integer>
	private final Map<AbstractFurniture, Integer>	items;

	public Store() {
		this.items = new HashMap<AbstractFurniture, Integer>();
	}

	public Store(String fileName) {
		this();
		this.loadFurniture(fileName);
	}

	private void addFurniture(AbstractFurniture furniture, Integer count) {
		Integer newCount = count;
		if (this.items.containsKey(furniture)) {
			newCount += this.items.get(furniture);
		}
		this.items.put(furniture, newCount);
	}

	@Override
	public void addBed(String fancyName, Room room, Material material, Size size, double price, Mattress mattress, boolean doubleSize, boolean compactSize,
			boolean builtInLamp, int count) {
		this.addFurniture(new Bed(fancyName, room, material, size, price, mattress, doubleSize, compactSize, builtInLamp), count);
	}

	@Override
	public void addTable(String fancyName, Room room, Material material, Size size, double price, int numberOfChairs, boolean scratchResistant,
			boolean compactSize, int count) {
		this.addFurniture(new Table(fancyName, room, material, size, price, numberOfChairs, scratchResistant, compactSize), count);
	}

	@Override
	public void addWardrobe(String fancyName, Room room, Material material, Size size, double price, int numberOfShelves, DoorType typeOfDoor, boolean mirror,
			boolean builtInLamp, int count) {
		this.addFurniture(new Wardrobe(fancyName, room, material, size, price, numberOfShelves, typeOfDoor, mirror, builtInLamp), count);
	}

	// bad pattern
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
	public List<AbstractFurniture> search(FurnitureSearch search) {
		List<AbstractFurniture> listOfFurniture = new ArrayList<AbstractFurniture>();
		if (search != null) {
			for (AbstractFurniture furniture : this.items.keySet()) {
				Integer pieces = this.items.get(furniture);
				if ((pieces != null) && (pieces > 0)) {
					if (search.isValid(furniture)) {
						listOfFurniture.add(furniture);
					}
				}
			}
		}
		return listOfFurniture;
	}

	@Override
	public Integer getCount(AbstractFurniture furniture) {
		return this.items.get(furniture);
	}

	@Override
	public String buy(AbstractFurniture furniture, int count) {
		String info = null;
		if (this.items.containsKey(furniture)) {
			Integer pieces = this.items.get(furniture);
			if (count > 0 && (pieces - count) >= 0) {
				info = furniture.sell(count);
				this.addFurniture(furniture, new Integer(count * -1));
			}
		}
		return info;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		for (AbstractFurniture furniture : this.items.keySet()) {
			Integer count = this.items.get(furniture);
			info.append(String.format("%2s piece(s) - ", Math.round(count))).append(furniture).append("\n");
		}
		return info.toString();
	}

	@Override
	public void loadFurniture(String fileName) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine(); // first line --> header
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(";");
				CsvFurnitureType furnitureType = CsvFurnitureType.valueOf(values[0].trim());
				Room room = Room.valueOf(values[1].trim());
				Material material = Material.valueOf(values[2].trim());
				Size size = Size.fromString(values[3], values[4], values[5].trim());
				double price = Double.parseDouble(values[6].trim());
				boolean compactSize = Boolean.valueOf(values[9].trim());
				boolean builtInLamp = Boolean.valueOf(values[10].trim());
				int count = Integer.valueOf(values[16].trim());
				String fancyName = values[17].trim();
				switch (furnitureType) {
					case BED:
						Mattress mattress = Mattress.valueOf(values[7].trim());
						boolean doubleSize = Boolean.valueOf(values[8].trim());
						this.addBed(fancyName, room, material, size, price, mattress, doubleSize, compactSize, builtInLamp, count);
						break;
					case TABLE:
						int numberOfChairs = Integer.valueOf(values[11].trim());
						boolean scratchResistant = Boolean.valueOf(values[12].trim());
						this.addTable(fancyName, room, material, size, price, numberOfChairs, scratchResistant, compactSize, count);
						break;
					case WARDROBE:
						int numberOfShelves = Integer.valueOf(values[13].trim());
						DoorType typeOfDoor = DoorType.valueOf(values[14].trim());
						boolean mirror = Boolean.valueOf(values[15].trim());
						this.addWardrobe(fancyName, room, material, size, price, numberOfShelves, typeOfDoor, mirror, builtInLamp, count);
						break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public AbstractFurniture getFurnitureByFancyName(String fancyName) {
		AbstractFurniture ret = null;
		for (AbstractFurniture furniture : this.items.keySet()) {
			if (fancyName.equals(furniture.getFancyName())) {
				ret = furniture;
				break;
			}
		}
		return ret;
	}

}
