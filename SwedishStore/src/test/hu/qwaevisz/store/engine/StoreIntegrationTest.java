package hu.qwaevisz.store.engine;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Room;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StoreIntegrationTest {

	private Store	store;

	@BeforeTest(alwaysRun = true)
	public void setup() {
		this.store = new Store("resources/furniture.csv");
	}

	@Test(groups = "integration")
	public void Search_furniture_with_small_surface() {
		FurnitureSearch search = new FurnitureSearch();
		search.addSizeSurfaceCriterion(null, 2500.);
		List<AbstractFurniture> result = this.store.search(search);
		Assert.assertTrue(this.store.getFurnitureByFancyName("Yankee").getSize().getSurface() <= 2500);
		Assert.assertTrue(this.store.getFurnitureByFancyName("Zulu").getSize().getSurface() <= 2500);
		Assert.assertTrue(this.store.getFurnitureByFancyName("Lincoln").getSize().getSurface() <= 2500);
		Assert.assertTrue(this.store.getFurnitureByFancyName("Mary").getSize().getSurface() <= 2500);
		Assert.assertTrue(this.store.getFurnitureByFancyName("Young").getSize().getSurface() <= 2500);
		this.echoSearchResult("Search_furniture_with_small_surface", result);
		Assert.assertEquals(result.size(), 5);
		this.checkResult(result, "Yankee", "Zulu", "Lincoln", "Mary", "Young");
	}

	private void checkResult(List<AbstractFurniture> result, String... fancyNames) {
		for (String fancyName : fancyNames) {
			Assert.assertTrue(result.contains(this.store.getFurnitureByFancyName(fancyName)));
		}
	}

	private void echoSearchResult(String header, List<AbstractFurniture> items) {
		System.out.println("> " + header);
		for (AbstractFurniture furniture : items) {
			System.out.println(furniture);
		}
	}

	@Test(groups = "integration")
	public void Search_Bath_and_Bedroom_furniture_from_CherryTree_with_maximum_height_and_medium_width_TestCaseA() {
		FurnitureSearch search = new FurnitureSearch();
		search.addRoomCriterion(Room.Bathroom, Room.Bedroom);
		search.addMaterialCriterion(Material.CherryTree);
		search.addSizeHeightCriterion(null, 170.);
		search.addSizeWidthCriterion(40., 150.);
		List<AbstractFurniture> result = this.store.search(search);

		this.checkSearchCriteriaForTestCaseA("Quebec", "Papa", "Denver", "Mary");
		this.echoSearchResult("Search_Bath_and_Bedroom_furniture_from_CherryTree_with_maximum_height_and_medium_width_TestCaseA", result);
		Assert.assertEquals(result.size(), 4);
		this.checkResult(result, "Quebec", "Papa", "Denver", "Mary");
	}

	private void checkSearchCriteriaForTestCaseA(String... fancyNames) {
		for (String fancyName : fancyNames) {
			Assert.assertTrue(Room.Bathroom.equals(this.store.getFurnitureByFancyName(fancyName).getRoom())
					|| Room.Bedroom.equals(this.store.getFurnitureByFancyName(fancyName).getRoom()));
			Assert.assertTrue(Material.CherryTree.equals(this.store.getFurnitureByFancyName(fancyName).getMaterial()));
			Assert.assertTrue(this.store.getFurnitureByFancyName(fancyName).getSize().getHeight() <= 170);
			Assert.assertTrue(this.store.getFurnitureByFancyName(fancyName).getSize().getWidth() <= 150);
			Assert.assertTrue(this.store.getFurnitureByFancyName(fancyName).getSize().getWidth() >= 40);
		}
	}

}
