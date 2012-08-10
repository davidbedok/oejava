package hu.qwaevisz.store.engine;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.common.DoorType;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Mattress;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;
import hu.qwaevisz.store.furniture.Bed;
import hu.qwaevisz.store.furniture.Table;
import hu.qwaevisz.store.furniture.Wardrobe;

import java.util.List;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoreTest {

	@Test(groups = "unit")
	public void Fill_store_and_check_unique_contents() {
		Store store = new Store();
		Size size = new Size(10, 10, 10);
		store.addBed("Alpha", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false, 2);
		store.addBed("Bravo", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, false, false, false, 3);
		store.addTable("Charlie", Room.Chamber, Material.Beech, new Size(10, 18, 10), 30, 4, false, true, 3);
		store.addBed("Delta", Room.Bedroom, Material.Beech, size, 42, Mattress.Comfortable, true, false, false, 1);

		store.addBed("Alpha", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false, 3);

		store.addBed("Echo", Room.Bathroom, Material.Metal, size, 42, Mattress.Healthy, false, true, false, 6);
		store.addBed("Foxtrot", Room.Chamber, Material.Beech, new Size(10, 15, 10), 42, Mattress.Antiallergic, true, false, true, 6);
		store.addWardrobe("Golf", Room.Bathroom, Material.Oak, size, 20, 1, DoorType.Shutter, true, false, 2);

		Assert.assertEquals(store.getCount(store.getFurnitureByFancyName("Alpha")), new Integer(5));
		Assert.assertEquals(store.getCount(store.getFurnitureByFancyName("Bravo")), new Integer(3));
		Assert.assertEquals(store.getCount(store.getFurnitureByFancyName("Charlie")), new Integer(3));
		Assert.assertEquals(store.getCount(store.getFurnitureByFancyName("Delta")), new Integer(1));
		Assert.assertEquals(store.getCount(store.getFurnitureByFancyName("Echo")), new Integer(6));
		Assert.assertEquals(store.getCount(store.getFurnitureByFancyName("Foxtrot")), new Integer(6));
		Assert.assertEquals(store.getCount(store.getFurnitureByFancyName("Golf")), new Integer(2));
	}

	@Test(groups = "unit")
	public void Search_furniture() {
		Size size = new Size(10, 10, 10);

		Store store = new Store();
		store.addBed("Alpha", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false, 2);
		store.addBed("Bravo", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, false, false, false, 3);
		store.addTable("Charlie", Room.Chamber, Material.Beech, new Size(10, 18, 10), 30, 4, false, true, 3);
		store.addWardrobe("Golf", Room.Bathroom, Material.Oak, size, 20, 1, DoorType.Shutter, true, false, 0);

		FurnitureSearch mockedSearch = Mockito.mock(FurnitureSearch.class);
		Bed bedAlpha = new Bed("Alpha", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false);
		Mockito.when(mockedSearch.isValid(bedAlpha)).thenReturn(false);
		Bed bedBravo = new Bed("Bravo", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, false, false, false);
		Mockito.when(mockedSearch.isValid(bedBravo)).thenReturn(true);
		Table tableCharlie = new Table("Charlie", Room.Chamber, Material.Beech, new Size(10, 18, 10), 30, 4, false, true);
		Mockito.when(mockedSearch.isValid(tableCharlie)).thenReturn(false);
		Wardrobe wardrobeGolf = new Wardrobe("Golf", Room.Bathroom, Material.Oak, size, 20, 1, DoorType.Shutter, true, false);
		Mockito.when(mockedSearch.isValid(wardrobeGolf)).thenReturn(true);

		List<AbstractFurniture> result = store.search(mockedSearch);

		Mockito.verify(mockedSearch).isValid(bedAlpha);
		Mockito.verify(mockedSearch).isValid(bedBravo);
		Mockito.verify(mockedSearch).isValid(tableCharlie);
		Mockito.verify(mockedSearch, Mockito.never()).isValid(wardrobeGolf);

		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(result.get(0), bedBravo);
	}

	@Test(groups = "unit")
	public void Buy_two_bed() {
		Size size = new Size(10, 10, 10);

		Store store = new Store();
		store.addBed("Alpha", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false, 2);
		store.addBed("Bravo", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, false, false, false, 3);
		store.addTable("Charlie", Room.Chamber, Material.Beech, new Size(10, 18, 10), 30, 4, false, true, 3);
		store.addWardrobe("Golf", Room.Bathroom, Material.Oak, size, 20, 1, DoorType.Shutter, true, false, 0);

		Bed bedAlpha = new Bed("Alpha", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false);
		Bed bedBravo = new Bed("Bravo", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, false, false, false);
		Table tableCharlie = new Table("Charlie", Room.Chamber, Material.Beech, new Size(10, 18, 10), 30, 4, false, true);
		Wardrobe wardrobeGolf = new Wardrobe("Golf", Room.Bathroom, Material.Oak, size, 20, 1, DoorType.Shutter, true, false);

		Assert.assertEquals(store.getCount(bedAlpha), new Integer(2));
		Assert.assertEquals(store.getCount(bedBravo), new Integer(3));
		Assert.assertEquals(store.getCount(tableCharlie), new Integer(3));
		Assert.assertEquals(store.getCount(wardrobeGolf), new Integer(0));

		String info = store.buy(bedBravo, 2);

		Assert.assertEquals(
				info,
				"2 piece(s) BRAVO      Bed       was sold. Slats have to get from warehouse by customer, but the [Antiallergic mattress ] has to get by fellow worker of store.");

		Assert.assertEquals(store.getCount(bedAlpha), new Integer(2));
		Assert.assertEquals(store.getCount(bedBravo), new Integer(1));
		Assert.assertEquals(store.getCount(tableCharlie), new Integer(3));
		Assert.assertEquals(store.getCount(wardrobeGolf), new Integer(0));
	}

	@Test(groups = "unit")
	public void Try_to_buy_a_wordrobe_which_is_not_available() {
		Size size = new Size(10, 10, 10);

		Store store = new Store();
		store.addBed("Alpha", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false, 2);
		store.addBed("Bravo", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, false, false, false, 3);
		store.addTable("Charlie", Room.Chamber, Material.Beech, new Size(10, 18, 10), 30, 4, false, true, 3);
		store.addWardrobe("Golf", Room.Bathroom, Material.Oak, size, 20, 1, DoorType.Shutter, true, false, 0);

		Bed bedAlpha = new Bed("Alpha", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false);
		Bed bedBravo = new Bed("Bravo", Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, false, false, false);
		Table tableCharlie = new Table("Charlie", Room.Chamber, Material.Beech, new Size(10, 18, 10), 30, 4, false, true);
		Wardrobe wardrobeGolf = new Wardrobe("Golf", Room.Bathroom, Material.Oak, size, 20, 1, DoorType.Shutter, true, false);

		Assert.assertEquals(store.getCount(bedAlpha), new Integer(2));
		Assert.assertEquals(store.getCount(bedBravo), new Integer(3));
		Assert.assertEquals(store.getCount(tableCharlie), new Integer(3));
		Assert.assertEquals(store.getCount(wardrobeGolf), new Integer(0));

		String info = store.buy(wardrobeGolf, 1);

		Assert.assertNull(info);

		Assert.assertEquals(store.getCount(bedAlpha), new Integer(2));
		Assert.assertEquals(store.getCount(bedBravo), new Integer(3));
		Assert.assertEquals(store.getCount(tableCharlie), new Integer(3));
		Assert.assertEquals(store.getCount(wardrobeGolf), new Integer(0));
	}

}
