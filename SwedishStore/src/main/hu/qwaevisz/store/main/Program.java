package hu.qwaevisz.store.main;

import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Mattress;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.common.Size;
import hu.qwaevisz.store.engine.Store;

public class Program {

	public static void testStore(){
		
		Store store = new Store();
		Size size = new Size(10, 10, 10);
		store.addBed(Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false, 2);
		store.addBed(Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false, 3);
		store.addBed(Room.Bedroom, Material.Beech, size, 42, Mattress.Antiallergic, true, false, false, 1);
		store.addBed(Room.Bathroom, Material.Beech, size, 42, Mattress.Antiallergic, true, true, false, 6);
		
		System.out.println(store);
	}
	
	public static void main(String[] args) {
		Program.testStore();

	}

}
