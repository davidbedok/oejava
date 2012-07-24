package hu.qwaevisz.generic;

import hu.qwaevisz.generic.test.TestA;
import hu.qwaevisz.generic.test.TestB;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Program {

	public static void testGenericMethods() {
		Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.println("Array integerArray contains:");
		PrintArray.printArray(integerArray);
		System.out.println("\nArray doubleArray contains:");
		PrintArray.printArray(doubleArray);
		System.out.println("\nArray characterArray contains:");
		PrintArray.printArray(characterArray);

		System.out.println("\nArray integerArray contains:");
		GenericPrintArray.printArray(integerArray);
		System.out.println("\nArray doubleArray contains:");
		GenericPrintArray.printArray(doubleArray);
		System.out.println("\nArray characterArray contains:");
		GenericPrintArray.printArray(characterArray);
	}

	public static void testGenericClass() {
		System.out.println("\ntestGenericClass\n");

		GenericClass<Integer> intgc = new GenericClass<Integer>(42);
		System.out.println(intgc);
		intgc.add(2);
		System.out.println(intgc);

		GenericClass<String> strgc = new GenericClass<String>("42");
		System.out.println(strgc);
		strgc.add("2");
		System.out.println(strgc);
	}

	public static void testGenericPracticeClass() {
		System.out.println("\ntestGenericPracticeClass\n");

		GenericPracticeClass<TestA> gpcA = new GenericPracticeClass<TestA>(new TestA());
		gpcA.print();

		GenericPracticeClass<TestB> gpcB = new GenericPracticeClass<TestB>(new TestB());
		gpcB.print();

	}

	public static void testGenericMaps() {
		System.out.println("\n\nM a p");

		Map iMap = new HashMap();
		iMap.put(new Integer(5), new String("Teszt Elek"));
		iMap.put(new Integer(4), new String("Nemecsek Erno"));

		Integer tmpInt;
		String tmpStr;
		Entry tmpEntry;

		System.out.println("Print from keySet");
		Iterator iks = iMap.keySet().iterator();
		while (iks.hasNext()) {
			tmpInt = (Integer) iks.next();
			tmpStr = (String) iMap.get(tmpInt);
			System.out.println("[" + tmpInt + " - " + tmpStr + "]");
		}

		System.out.println("Print from entrySet");
		Iterator ies = iMap.entrySet().iterator();
		while (ies.hasNext()) {
			tmpEntry = (Entry) ies.next();
			tmpInt = (Integer) tmpEntry.getKey();
			tmpStr = (String) tmpEntry.getValue();
			System.out.println("[" + tmpInt + " - " + tmpStr + "]");
		}

		System.out.println("G e n e r i c   M a p");
		Map<Integer, String> iGenMap = new HashMap<Integer, String>();
		iGenMap.put(5, "Teszt Elek");
		iGenMap.put(4, "Nemecsek Erno");

		System.out.println("Print from keySet");
		Iterator<Integer> igks = iGenMap.keySet().iterator();
		while (igks.hasNext()) {
			tmpInt = igks.next();
			tmpStr = iGenMap.get(tmpInt);
			System.out.println("[" + tmpInt + " - " + tmpStr + "]");
		}

		Entry<Integer, String> tmpGenEntry;

		System.out.println("Print from entrySet");
		Iterator<Entry<Integer, String>> iges = iGenMap.entrySet().iterator();
		while (iges.hasNext()) {
			tmpGenEntry = iges.next();
			tmpInt = tmpGenEntry.getKey();
			tmpStr = tmpGenEntry.getValue();
			System.out.println("[" + tmpInt + " - " + tmpStr + "]");
		}
	}

	public static void main(String[] args) {
		// Program.testGenericMethods();
		// Program.testGenericClass();
		// Program.testGenericPracticeClass();
		Program.testGenericMaps();
	}

}
