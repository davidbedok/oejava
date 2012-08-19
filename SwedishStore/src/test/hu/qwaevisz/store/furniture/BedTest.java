package hu.qwaevisz.store.furniture;

import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Mattress;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BedTest {

	@Test(groups = "unit")
	public void The_beds_equal_when_all_fields_are_the_same() {
		Size size = new Size(10, 10, 10);
		Bed bedOne = this.createBedForTest("Alice", size);
		Bed bedTwo = this.createBedForTest("Bob", size);
		Bed bedTreee = this.createBedForTest("Alice", size);

		Assert.assertEquals(bedOne, bedTreee);
		Assert.assertEquals(bedTreee, bedOne);
		Assert.assertNotEquals(bedOne, bedTwo);
		Assert.assertNotEquals(bedTwo, bedOne);
		Assert.assertEquals(bedOne, bedOne);
		Assert.assertNotEquals(bedTwo, bedTreee);
	}

	private Bed createBedForTest(String fancyName, Size size) {
		return new Bed(fancyName, Room.Bathroom, Material.Beech, size, 100, Mattress.Antiallergic, true, true, false);
	}

}
