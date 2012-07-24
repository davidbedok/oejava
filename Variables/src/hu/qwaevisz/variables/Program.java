package hu.qwaevisz.variables;

import java.util.Arrays;

public class Program {

	public static void printHeader(String title) {
		System.out.println("\n###########################################");
		System.out.println(title);
		System.out.println("###########################################");
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}

	public static void printFrame() {
		System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
	}

	public static void useValueVariables() {
		Program.printHeader("Value variables - Use int primitive");
		System.out.println("int i;");
		int i;
		System.out.println("IN i --> i = 42");
		i = 42;
		System.out.println("OUT i --> " + i);
		System.out.println("\nHexadecimal literal: int k = '\\u0010'; ");
		int k = '\u0010';
		System.out.println("OUT k --> " + k);
		Program.printFrame();
	}

	public static void printReferenceVariablesInfo(String varname, Object o) {
		System.out.println("  INFO >> " + varname + ".toString() --> " + o.toString());
		System.out.println("  INFO >> " + varname + ".hashCode() --> " + o.hashCode() + " (hex: " + Integer.toHexString(o.hashCode()) + ")");
		System.out.println("  INFO >> " + varname + ".getClass() --> " + o.getClass());
		System.out.println("  INFO >> " + varname + ".getClass().getName() --> " + o.getClass().getName());
	}

	public static void useReferenceVariables() {
		Program.printHeader("Reference variables - Use int[] array.");
		System.out.println("int[] i;");
		int[] i;
		System.out.println("IN i --> new int[3]");
		i = new int[3];
		i[0] = 42;
		i[1] = 30;
		i[2] = 7;
		System.out.println("OUT i --> " + i);
		Program.printReferenceVariablesInfo("i", i);
		System.out.println("OUT i.length --> " + i.length);
		System.out.println("OUT i[0] --> " + i[0]);
		Program.printFrame();
	}

	public static void useValueVariablesWrapperClass() {
		Program.printHeader("Wrapper class of Value variables (AutoBoxing/AutoUnBoxing)");
		System.out.println("int j = 30;");
		int j = 30;
		System.out.println("Integer J = new Integer(j); --> normal way");
		Integer J = new Integer(j);
		System.out.println("OUT J --> " + J);
		Program.printReferenceVariablesInfo("K", J);

		System.out.println("Integer K = j; --> j ==> new Integer(j) --> AutoBoxing");
		Integer K = j;
		System.out.println("OUT K --> " + K);
		Program.printReferenceVariablesInfo("K", K);

		System.out.println("OUT J.intValue() --> " + J.intValue());
		System.out.println("OUT Integer.toHexString(J.intValue()) --> " + Integer.toHexString(J.intValue()));
		System.out.println("OUT Integer.toHexString(J) --> " + Integer.toHexString(J) + " --> J ==> J.intValue() --> AutoUnBoxing");
		Program.printFrame();
	}

	public static void useReferenceVariablesComplex() {
		Program.printHeader("Reference variables - Use int[][] array.");
		System.out.println("int[][] i;");
		System.out.println("IN i --> new int[3][]");
		int[][] i = new int[3][];
		i[0] = new int[2];
		i[1] = new int[3];
		i[2] = new int[2];
		i[0][0] = 42;
		i[0][1] = 30;
		i[1][0] = 10;
		i[1][1] = 12;
		i[1][2] = 4;
		i[2][0] = 1;
		i[2][1] = 50;
		System.out.println("OUT i --> " + i);
		Program.printReferenceVariablesInfo("i", i);
		System.out.println("OUT i.length --> " + i.length);
		System.out.println("OUT i[1] --> " + i[1]);
		System.out.println("OUT i[1].length --> " + i[1].length);
		System.out.println("OUT i[1][2] --> " + i[1][2]);
		Program.printFrame();
	}

	public static void settingValueVariables() {
		Program.printHeader("Value Variables - Setting");
		System.out.println("int i;");
		System.out.println("int j;");
		int i;
		int j;
		System.out.println("IN i --> i = 42");
		System.out.println("IN j --> j = 30");
		i = 42;
		j = 30;
		System.out.println(">> Before ( j = i )");
		System.out.println("OUT i --> " + i);
		System.out.println("OUT j --> " + j);

		System.out.println("j = i;");
		j = i;

		System.out.println(">> After ( j = i )");
		System.out.println("i = 10;");
		System.out.println("j = 20;");
		i = 10;
		j = 20;
		System.out.println("OUT i --> " + i);
		System.out.println("OUT j --> " + j);
		Program.printFrame();
	}

	public static void settingReferenceVariables() {
		Program.printHeader("Reference Variables - Setting");
		System.out.println("int i[] = new int[1];");
		System.out.println("int j[] = new int[1];");
		int i[] = new int[1];
		int j[] = new int[1];
		System.out.println("i[0] = 42;");
		System.out.println("j[0] = 30;");
		i[0] = 42;
		j[0] = 30;

		System.out.println(">> Before ( j = i )");
		System.out.println("OUT i --> " + i);
		System.out.println("OUT j --> " + j);
		System.out.println("OUT i[0] --> " + i[0]);
		System.out.println("OUT j[0] --> " + j[0]);

		j = i;
		System.out.println(">> After ( j = i )");

		System.out.println("i[0] = 10;");
		System.out.println("j[0] = 20;");
		i[0] = 10;
		j[0] = 20;

		System.out.println("OUT i --> " + i);
		System.out.println("OUT j --> " + j);
		System.out.println("OUT i[0] --> " + i[0]);
		System.out.println("OUT j[0] --> " + j[0]);
		Program.printFrame();
	}

	public static void compareValueVariables() {
		Program.printHeader("Compare Value Variables");
		System.out.println("int i = 10;");
		System.out.println("int j = 10;");
		int i = 10;
		int j = 10;
		System.out.println("CHECK ( i == j )");
		if (i == j) { // true
			System.out.println("  TRUE i == j");
		} else {
			System.out.println("  FALSE i == j");
		}
		Program.printFrame();
	}

	public static void compareReferenceVariables() {
		Program.printHeader("Compare Reference Variables");
		System.out.println("int i[] = new int[1];");
		System.out.println("int j[] = new int[1];");
		int[] i = new int[1];
		int[] j = new int[1];
		System.out.println("i[0] = 10;");
		System.out.println("j[0] = 10;");
		i[0] = 10;
		j[0] = 10;
		System.out.println("CHECK ( i == j )");
		if (i == j) { // false
			System.out.println("  TRUE i == j");
		} else {
			System.out.println("  FALSE i == j");
		}

		System.out.println("OUT i.hashCode() --> " + i.hashCode());
		System.out.println("OUT j.hashCode() --> " + j.hashCode());
		System.out.println("CHECK ( i.equals(j) )");
		if (i.equals(j)) { // false
			System.out.println("  TRUE i.equals(j)");
		} else {
			System.out.println("  FALSE i.equals(j) --> not the same object");
		}

		System.out.println("! The default equals method if a class does not override it - returns true only if both references point to the same object.");

		System.out.println("\nHow to compare? write own.. or use Arrays class static method :-)");
		System.out.println("CHECK ( Arrays.equals(i, j) )");
		if (Arrays.equals(i, j)) { // true
			System.out.println("  TRUE Arrays.equals(i, j)");
		} else {
			System.out.println("  FALSE Arrays.equals(i, j)");
		}

		System.out.println("\nTry literal pool... (no pool, except in String.. see later)");
		System.out.println("int[] k = { 10 };");
		System.out.println("int[] g = { 10 };");
		int[] k = { 10 };
		int[] g = { 10 };
		System.out.println("CHECK ( k == g )");
		if (k == g) { // false
			System.out.println("  TRUE k == g");
		} else {
			System.out.println("  FALSE k == g");
		}
		Program.printFrame();
	}

	public static void useString() {
		Program.printHeader("Use String - Some special behavior");
		System.out.println("String s = \"alma\"; --> use literal");
		String s = "alma";
		System.out.println("OUT s --> " + s);
		Program.printReferenceVariablesInfo("s", s);
		System.out.println("OUT s.length() --> " + s.length());

		System.out.println("\nString u = new String(\"alma\");");
		String u = new String("alma");
		System.out.println("OUT u --> " + u);
		Program.printReferenceVariablesInfo("u", u);

		System.out.println("\nComparing String-s - use object creation..");
		System.out.println("\nString d = new String(\"a\");");
		System.out.println("String f = new String(\"a\");");
		String d = new String("a");
		String f = new String("a");
		System.out.println("OUT d hashCode() --> " + d.hashCode());
		System.out.println("OUT f hashCode() --> " + f.hashCode());
		System.out.println("CHECK (d == f)");
		if (d == f) { // false
			System.out.println("  TRUE d == f");
		} else {
			System.out.println("  FALSE d == f --> normal way (new String() -> no String pool)");
		}
		System.out.println("CHECK (d.hashCode() == f.hashCode())");
		if (d.hashCode() == f.hashCode()) { // true
			System.out.println("  TRUE d.hashCode() == f.hashCode() --> BUT not suggested to use!");
		} else {
			System.out.println("  FALSE d.hashCode() == f.hashCode()");
		}
		System.out.println("CHECK (d.equals(f))");
		if (d.equals(f)) { // true
			System.out.println("  TRUE d.equals(f) --> suggested way");
		} else {
			System.out.println("  FALSE d.equals(f)");
		}

		System.out.println("\nComparing String-s - use String literals..");
		System.out.println("\nString h = \"a\";");
		System.out.println("String k = \"a\";");
		String h = "a";
		String k = "a";
		System.out.println("OUT h hashCode() --> " + h.hashCode());
		System.out.println("OUT k hashCode() --> " + k.hashCode());
		System.out.println("CHECK (h == k)");
		if (h == k) { // true !
			System.out.println("  TRUE h == k --> SPEC behavior ==> use String pool in String literals!");
		} else {
			System.out.println("  FALSE h == k");
		}
		System.out.println("! String pool: increase performance and decrease memory overhead; string literal pool not eligible for garbage collection\n");

		System.out.println("CHECK (h.hashCode() == k.hashCode())");
		if (h.hashCode() == k.hashCode()) { // true
			System.out.println("  TRUE h.hashCode() == j.hashCode() --> BUT not suggested to use!");
		} else {
			System.out.println("  FALSE h.hashCode() == j.hashCode()");
		}
		System.out.println("CHECK (h.equals(k))");
		if (h.equals(k)) { // true
			System.out.println("  TRUE h.equals(k) --> suggested way");
		} else {
			System.out.println("  FALSE h.equals(k)");
		}

		System.out.println("\nExamples 1");
		d = "a";
		f = "ab";
		d = "a" + "b";
		if (d == f) { // true
			System.out.println("  TRUE d == f (use String pool)");
		} else {
			System.out.println("  FALSE d == f");
		}

		System.out.println("\nExamples 2");
		d = "a";
		f = "ab";
		d = "a" + new String("b");
		if (d == f) { // false
			System.out.println("  TRUE d == f");
		} else {
			System.out.println("  FALSE d == f (not use String pool)");
		}

		System.out.println("\nExamples 3 - use intern()");
		String q1 = "ab";
		String q2 = new String("ab");
		String q3 = q2.intern();
		if (q1 == q2) { // false
			System.out.println("  TRUE q1 == q2");
		} else {
			System.out.println("  FALSE q1 == q2");
		}
		if (q1 == q3) { // true
			System.out.println("  TRUE q1 == q3 --> because intern()!");
		} else {
			System.out.println("  FALSE q1 == q3");
		}

		System.out.println("\nNo operator overload in JAVA, but except in String + operator --> SPEC behavior");
		System.out.println("\nString ts1 = \"szilva\";");
		System.out.println("String ts2 = \" palinka\";");
		String ts1 = "szilva";
		String ts2 = " palinka";
		System.out.println("String ts3 = ts1 + ts2;");
		String ts3 = ts1 + ts2;
		System.out.println("OUT ts1 = '" + ts1 + "'");
		System.out.println("OUT ts2 = '" + ts2 + "'");
		System.out.println("OUT ts3 = '" + ts3 + "'");
		Program.printFrame();
	}

	public static void main(String[] args) {
		// Program.useValueVariables();
		// Program.useReferenceVariables();
		// Program.useValueVariablesWrapperClass();
		// Program.useReferenceVariablesComplex();
		// Program.settingValueVariables();
		// Program.settingReferenceVariables();
		// Program.compareValueVariables();
		// Program.compareReferenceVariables();
		Program.useString();
	}

}
