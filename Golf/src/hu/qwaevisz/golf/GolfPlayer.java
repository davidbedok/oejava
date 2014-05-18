package hu.qwaevisz.golf;

import java.util.Random;

public abstract class GolfPlayer {

	private final Random rand;

	public GolfPlayer(Random rand) {
		this.rand = rand;
	}

	public int hit(PutterType type, int windForce) {
		double windForceMultipler = (double) windForce / 100 + 1;
		return (int) Math.round(type.hit(this.rand, this.getModifierMultipler(type)) * this.getWindMultiplier(type, windForceMultipler));
	}

	protected abstract double getModifierMultipler(PutterType type);

	protected abstract double getWindMultiplier(PutterType type, double windForceMultipler);

}
