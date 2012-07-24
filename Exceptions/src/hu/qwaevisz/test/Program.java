package hu.qwaevisz.test;

import hu.qwaevisz.exception.checked.WrongValueException;
import hu.qwaevisz.exception.unchecked.UWrongValueException;

public class Program {

	public static void parseWithoutHandling(String s) {
		int i = Integer.parseInt(s);
		System.out.println("parseWithoutHandling() --> Integer.parseInt(\"" + s + "\") --> " + i);
	}

	public static void parseWithHandling(String s) {
		int i = 0;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}
		System.out.println("parseWithHandling() --> Integer.parseInt(\"" + s + "\") --> " + i);
	}

	public static void parseWithThrows(String s) throws NumberFormatException {
		int i = Integer.parseInt(s);
		System.out.println("parseWithThrows() --> Integer.parseInt(\"" + s + "\") --> " + i);
	}

	public static void NumberFormatExceptionTestSteps() {
		System.out.println("\n# NumberFormatExceptionTestSteps (unchecked exception)");

		// java.lang.Object
		//  java.lang.Throwable
		//   java.lang.Exception
		//    java.lang.RuntimeException
		//     java.lang.IllegalArgumentException
		//      java.lang.NumberFormatException

		Program.parseWithoutHandling("10");
		// Program.parseWithoutHandling("alma"); // --> terminate
		Program.parseWithHandling("10");
		Program.parseWithHandling("alma");

		Program.parseWithThrows("10");
		// Program.parseWithThrows("alma"); --> terminate
		try {
			Program.parseWithThrows("alma");
		} catch (NumberFormatException e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}
	}

	public static void TestCheckedException() {
		System.out.println("\n# TestCheckedException");

		MagicNumber mn = new MagicNumber();

		try {
			mn.setMagicNumberWithCheckedExceptions(5);
		} catch (WrongValueException e) { // checked exception --> kotelezo lekezelni, ha dobtuk
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}

		try {
			mn.setMagicNumberWithCheckedExceptions(10);
		} catch (WrongValueException e) { // checked exception --> kotelezo lekezelni, ha dobtuk
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}

		try {
			mn.setMagicNumberWithCheckedExceptions(7);
		} catch (WrongValueException e) { // checked exception --> kotelezo lekezelni, ha dobtuk
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}

	}

	public static void TestUnCheckedException() {
		System.out.println("\n# TestUnCheckedException");

		MagicNumber mn = new MagicNumber();

		// mn.setMagicNumberWithUnCheckedExceptions(5); // --> terminate

		try {
			mn.setMagicNumberWithUnCheckedExceptions(5);
		} catch (UWrongValueException e) { // unchecked exception --> NEM kotelezo lekezelni, ha dobtuk
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}

		mn.setMagicNumberWithUnCheckedExceptions(7);
	}

	public static void main(String[] args) {
		// Program.NumberFormatExceptionTestSteps();
		// Program.TestCheckedException();
		Program.TestUnCheckedException();
	}

}
