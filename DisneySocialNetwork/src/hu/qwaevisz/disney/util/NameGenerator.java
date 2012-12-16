package hu.qwaevisz.disney.util;

import java.util.Random;

public class NameGenerator {

	private final static String[] prefixes = { "Al", "Ba", "Da", "Di", "Du", "Eu" };
	private final static String[] middleParts = { "bi", "be", "bo", "gu", "da", "fri", "gus" };
	private final static String[] suffixes = { "tus", "lus", "lius", "nus", "es", "cus", "tor", "cio" };

	private final static String[] area = { "+36-20-", "+36-30-", "+36-70-", "+36-1-", "+36-88-" };

	public static String randomName(Random rand) {
		String prefix = NameGenerator.randElement(rand, NameGenerator.prefixes);
		String middle = NameGenerator.randElement(rand, NameGenerator.middleParts);
		String suffix = NameGenerator.randElement(rand, NameGenerator.suffixes);
		return prefix + middle + suffix;
	}

	private static String randElement(Random rand, String[] array) {
		return array[rand.nextInt(array.length)];
	}

	public static String randomNumber(Random rand) {
		String area = NameGenerator.randElement(rand, NameGenerator.area);
		int part1 = rand.nextInt(900) + 100;
		int part2 = rand.nextInt(900) + 100;
		return area + part1 + "-" + part2;
	}

}
