package hu.qwaevisz.store.main;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Mattress;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;
import hu.qwaevisz.store.criteria.BedSearchCriteria;
import hu.qwaevisz.store.criteria.FurnitureSearchCriteria;
import hu.qwaevisz.store.engine.Store;

import java.util.List;

public class Program {

	public static void testStore() {

		Store store = new Store();
		Size size = new Size(10, 10, 10);
		store.addBed(Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false, 2);
		store.addBed(Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false, 3);
		store.addBed(Room.Bedroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false, 1);
		store.addBed(Room.Bathroom, Material.Metal, size, 42, Mattress.Antiallergic, true, true, false, 6);
		store.addBed(Room.Chamber, Material.Beech, new Size(10, 15, 10), 42, Mattress.Antiallergic, true, true, true, 6);

		System.out.println(store);

		FurnitureSearchCriteria criteria = new FurnitureSearchCriteria();
		criteria.addRoomCriteria(Room.Bathroom, Room.Chamber);
		// criteria.addMaterialCriteria(Material.Beech);
		// criteria.addSizeHeightRangeCriteria(12, 20);

		List<AbstractFurniture> items = store.search(criteria);

		System.out.println("Search result: ");
		for (AbstractFurniture furniture : items) {
			System.out.println(furniture);
		}

		BedSearchCriteria bedCriteria = new BedSearchCriteria();
		bedCriteria.addRoomCriteria(Room.Bathroom, Room.Chamber);
		bedCriteria.addBuiltInLampConstraint(true);

		List<AbstractFurniture> beds = store.search(bedCriteria);

		System.out.println("Search result (beds): ");
		for (AbstractFurniture furniture : beds) {
			System.out.println(furniture);
		}

	}

	public static void main(String[] args) {
		Program.testStore();

	}

}
