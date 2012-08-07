package hu.qwaevisz.store.main;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.api.BuiltInLampCapable;
import hu.qwaevisz.store.api.CompactSizeCapable;
import hu.qwaevisz.store.common.DoorType;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Mattress;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;
import hu.qwaevisz.store.criteria.bad.BedSearchCriteria;
import hu.qwaevisz.store.criteria.bad.FurnitureSearchCriteria;
import hu.qwaevisz.store.engine.FurnitureSearch;
import hu.qwaevisz.store.engine.Store;
import hu.qwaevisz.store.furniture.Bed;
import hu.qwaevisz.store.furniture.Wardrobe;

import java.util.List;

public class Program {

	public static void testStore() {

		Store store = new Store();
		Size size = new Size(10, 10, 10);
		store.addBed(Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false, 2);
		store.addBed(Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, false, false, false, 3);
		store.addTable(Room.Chamber, Material.Beech, new Size(10, 18, 10), 30, 4, false, true, 3);
		store.addBed(Room.Bedroom, Material.Beech, size, 42, Mattress.Comfortable, true, false, false, 1);
		store.addBed(Room.Bathroom, Material.Metal, size, 42, Mattress.Healthy, false, true, false, 6);
		store.addBed(Room.Chamber, Material.Beech, new Size(10, 15, 10), 42, Mattress.Antiallergic, true, false, true, 6);
		store.addWardrobe(Room.Bathroom, Material.Oak, size, 20, 1, DoorType.Shutter, true, false, 2);

		System.out.println(store);

		Program.searchBadPattern(store);
		Program.searchWithCommands(store);
		Program.searchWithCommandsAndComposite(store);
	}

	private static void searchBadPattern(Store store) {
		FurnitureSearchCriteria criteria = new FurnitureSearchCriteria();
		criteria.addRoomCriteria(Room.Bathroom, Room.Chamber);
		criteria.addMaterialCriteria(Material.Beech);
		criteria.addSizeHeightRangeCriteria(12, 20);

		Program.echoSearchResult("bad pattern", store.search(criteria));

		BedSearchCriteria bedCriteria = new BedSearchCriteria();
		bedCriteria.addRoomCriteria(Room.Bathroom, Room.Chamber);
		bedCriteria.addBuiltInLampConstraint(true);

		Program.echoSearchResult("beds", store.search(bedCriteria));
	}

	private static void searchWithCommands(Store store) {
		FurnitureSearch search = new FurnitureSearch();
		search.addRoomCriterion(Room.Bathroom, Room.Chamber);
		// search.addCriterion(new RoomCriterion(Room.Bathroom, Room.Chamber));
		search.addMaterialCriterion(Material.Beech);
		// search.addCriterion(new MaterialCriterion(Material.Beech));
		search.addSizeHeightCriterion(12., 20.);
		// SizeCriterion sizeCriterion = new SizeCriterion();
		// sizeCriterion.addHeightCriteria(12., 20.);
		// search.addCriterion(sizeCriterion);

		Program.echoSearchResult("command pattern", store.search(search));

		FurnitureSearch search2 = new FurnitureSearch();
		// search2.addClassCriterion(BuiltInLampCapable.class, CompactSizeCapable.class); // only beds
		search2.addClassCriterion(BuiltInLampCapable.class); // wardrobes and beds

		Program.echoSearchResult("BuiltInLampCapable", store.search(search2));

		FurnitureSearch search3 = new FurnitureSearch();
		search3.addBedDoubleSizeCriterion(true);
		// search3.addBedMattressCriterion(Mattress.Healthy, Mattress.Comfortable);

		Program.echoSearchResult("BedDoubleSizeCriterion", store.search(search3));

		FurnitureSearch search4 = new FurnitureSearch();
		search4.addCompactSizeCriterion(true);

		Program.echoSearchResult("CompactSizeCriterion", store.search(search4));
	}

	private static void searchWithCommandsAndComposite(Store store) {
		FurnitureSearch searchA = new FurnitureSearch();
		searchA.addRoomCriterion(Room.Bedroom, Room.Chamber);

		FurnitureSearch searchB = new FurnitureSearch();
		searchB.addMaterialCriterion(Material.Beech);
		searchB.addFurnitureSearchCriterion(searchA);

		Program.echoSearchResult("Composite", store.search(searchB));
	}

	private static void fewgre(Store store) {

		FurnitureSearch search = new FurnitureSearch();
		search.addMaterialCriterion(Material.Oak, Material.Beech, Material.Pine, Material.CherryTree);
		search.addBedMattressCriterion(Mattress.Antiallergic);
		search.addClassCriterion(CompactSizeCapable.class);
		search.addRoomCriterion(Room.Hall);
		search.addClassCriterion(BuiltInLampCapable.class);

		search.addClassCriterion(Wardrobe.class, BuiltInLampCapable.class);
		search.addPriceCriterion(null, 300.);
		search.addWardrobeMirrorCriterion(true);
		search.addCompactSizeCriterion(true);
		search.addBedMattressCriterion(Mattress.Antiallergic, Mattress.Healthy);
		search.addRoomCriterion(Room.Bedroom, Room.LivingRoom);
		search.addClassCriterion(Bed.class);
		search.addBuiltInLampCriterion(true);
		search.addClassCriterion(Wardrobe.class);
		search.addSizeHeightCriterion(200., 240.);

		List<AbstractFurniture> items = store.search(search);
	}

	private static void echoSearchResult(String header, List<AbstractFurniture> items) {
		System.out.println("Search result (" + header + "): ");
		for (AbstractFurniture furniture : items) {
			System.out.println(furniture);
		}
	}

	public static void main(String[] args) {
		Program.testStore();
	}

}
