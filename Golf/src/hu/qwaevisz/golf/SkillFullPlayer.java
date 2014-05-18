package hu.qwaevisz.golf;

import java.util.Random;

public class SkillFullPlayer extends GolfPlayer {

	public SkillFullPlayer(Random rand) {
		super(rand);
	}

	@Override
	protected double getModifierMultipler(PutterType type) {
		return 1;
	}

	@Override
	protected double getWindMultiplier(PutterType type, double windForceMultipler) {
		double result = windForceMultipler;
		switch (type) {
		case Big:
			if (windForceMultipler < 1) {
				result = 1;
			}
			break;
		case Medium:
			if (windForceMultipler > 1) {
				result = 1;
			}
			break;
		}
		return result;
	}

	@Override
	public String toString() {
		return "SkillFull";
	}

}
