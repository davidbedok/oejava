package hu.qwaevisz.demo;

import java.util.EnumSet;

public class Program {

	public static void testSimpleEdgeType() {

		System.out.println("# Test Simple Edge Type");

		final SimpleEdgeType edgeType = SimpleEdgeType.NORMAL;
		System.out.println(edgeType + " - " + edgeType.ordinal());

		final SimpleEdgeType test = SimpleEdgeType.values()[2];
		System.out.println(test + " - " + test.ordinal());

		final SimpleEdgeType reset = SimpleEdgeType.valueOf("RESET");
		System.out.println(reset + " - " + reset.ordinal());

		final SimpleEdgeType inhibitor = Enum.valueOf(SimpleEdgeType.class, "INHIBITOR");
		System.out.println(inhibitor + " - " + inhibitor.ordinal());

		final SimpleEdgeType[] enums = SimpleEdgeType.values();
		for (int i = 0; i < enums.length; i++) {
			System.out.println(enums[i] + " - " + enums[i].ordinal());
		}

		final EnumSet<SimpleEdgeType> enumSet = EnumSet.range(SimpleEdgeType.NORMAL, SimpleEdgeType.RESET);
		for (final SimpleEdgeType simEdgeType : enumSet) {
			System.out.println(simEdgeType + " - " + simEdgeType.ordinal());
		}
		// EnumMap
	}

	public static void testEdgeType() {
		System.out.println("# Test Edge Type");

		final EdgeType reset = EdgeType.getEnumByLabel("Reset arc");
		System.out.println(reset + " - " + reset.ordinal());
		System.out.println("Label: " + reset.getLabel());
		System.out.println("MagicValue: " + reset.getMagicValue());

		System.out.println("EdgeType isEnum? " + EdgeType.NORMAL.getClass().isEnum());
		System.out.println("AbstractEdgeType isEnum? " + AbstractEdgeType.NORMAL.getClass().isEnum());
	}

	public static void main(final String[] args) {
		Program.testSimpleEdgeType();
		Program.testEdgeType();
	}

}
