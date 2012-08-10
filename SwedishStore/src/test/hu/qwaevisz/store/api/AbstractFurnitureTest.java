package hu.qwaevisz.store.api;

import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AbstractFurnitureTest {

	private class TestA extends AbstractFurniture {

		private final String	fieldA;

		public TestA(String fancyName, Room room, Material material, Size size, double price, String fieldA) {
			super(fancyName, room, material, size, price);
			this.fieldA = fieldA;
		}

		@Override
		protected String printType() {
			return null;
		}

		@Override
		protected String sellDetails() {
			return null;
		}

	}

	private class TestB extends AbstractFurniture {

		private final Integer	fieldB;

		public TestB(String fancyName, Room room, Material material, Size size, double price, Integer fieldB) {
			super(fancyName, room, material, size, price);
			this.fieldB = fieldB;
		}

		@Override
		protected String printType() {
			return null;
		}

		@Override
		protected String sellDetails() {
			return null;
		}

	}

	@Test(groups = "unit")
	public void The_beds_equal_when_all_fields_are_the_same() {
		Size size = new Size(10, 10, 10);
		TestA testA = new TestA("fancyName1", Room.Bedroom, Material.Metal, size, 100, "fieldA");
		TestB testb = new TestB("fancyName1", Room.Bedroom, Material.Metal, size, 100, 42);
		TestA testC = new TestA("fancyName2", Room.Bedroom, Material.Metal, size, 100, "fieldA");

		Assert.assertEquals(testA, testb);
		Assert.assertEquals(testb, testA);
		Assert.assertEquals(testA, testA);
		Assert.assertNotEquals(testC, testb);
		Assert.assertNotEquals(testb, testC);
	}

}
