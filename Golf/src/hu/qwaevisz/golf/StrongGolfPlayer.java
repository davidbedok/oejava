package hu.qwaevisz.golf;

import java.util.Random;

public class StrongGolfPlayer extends GolfPlayer {

	public StrongGolfPlayer(Random rand) {
		super(rand);
	}

	@Override
	protected double getModifierMultipler(PutterType type) {
		double result = 1;
		switch (type) {
		case Big:
			result = 1.2;
			break;
		case Medium:
			result = 1.1;
			break;
		}
		return result;
	}

	@Override
	protected double getWindMultiplier(PutterType type, double windForceMultipler) {
		return windForceMultipler;
	}

	@Override
	public String toString() {
		return "Strong";
	}

}
