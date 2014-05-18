package hu.qwaevisz.golf;

import java.util.Random;

public abstract class GolfCourse {

	private static final int MIN_LENTH = 150;
	private static final int MAX_LENGTH = 500;
	private static final int MIN_BARRIER_LENGTH = 10;
	private static final int MAX_BARRIER_LENGTH = 50;
	private static final int TARGET_LIMIT = 5;

	private final int length;
	private final int targetPosition;
	private final int barrierStartPosition;
	private final int barrierEndPosition;

	public GolfCourse(int length, int targetPosition, int barrierStartPosition, int barrierEndPosition) {
		this.length = length;
		this.targetPosition = targetPosition;
		this.barrierStartPosition = barrierStartPosition;
		this.barrierEndPosition = barrierEndPosition;
	}

	public PutterType getPutterType(int currentPosition) {
		return this.isBarrier(currentPosition) ? PutterType.Sand : PutterType.getPutterType(this.distance(currentPosition));
	}

	public int getPosition(int currentPosition, int hitValue) {
		int result = 0;
		if (currentPosition < this.targetPosition) {
			if (currentPosition + hitValue < this.length) {
				result = currentPosition + hitValue;
			}
		} else {
			if (currentPosition - hitValue > 0) {
				result = currentPosition - hitValue;
			}
		}
		return result;
	}

	private int distance(int currentPosition) {
		return Math.abs(this.targetPosition - currentPosition);
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		for (int i = 0; i < this.length; i += 20) {
			info.append(this.getPositionChar(i));
		}
		info.append(" ").append(
				" Length: " + this.length + ", Target: " + this.targetPosition + ", " + this.getBarrierChar() + ": " + this.barrierStartPosition + "-"
						+ this.barrierEndPosition);
		return info.toString();
	}

	private char getPositionChar(int position) {
		char result = '-';
		if (this.isTarget(position, 10)) {
			result = 'X';
		} else if (this.isBarrier(position)) {
			result = this.getBarrierChar();
		}
		return result;
	}

	private boolean isBarrier(int position) {
		return position > this.barrierStartPosition && position < this.barrierEndPosition;
	}

	protected abstract char getBarrierChar();

	public boolean isTarget(int position) {
		return this.isTarget(position, GolfCourse.TARGET_LIMIT);
	}

	private boolean isTarget(int position, int limit) {
		return Math.abs(position - this.targetPosition) < limit;
	}

	public static GolfCourse create(Random rand) {
		int length = GolfCourse.MIN_LENTH + rand.nextInt(GolfCourse.MAX_LENGTH - GolfCourse.MIN_LENTH);
		int targetPosition = GolfCourse.MIN_LENTH + rand.nextInt(length - GolfCourse.MIN_LENTH);
		int barrierPosition = rand.nextInt(2);
		int barrierStartPosition = GolfCourse.getBarrierStartPosition(rand, length, targetPosition, barrierPosition);
		int barrierEndPosition = barrierStartPosition + GolfCourse.MIN_BARRIER_LENGTH
				+ rand.nextInt(GolfCourse.MAX_BARRIER_LENGTH - GolfCourse.MIN_BARRIER_LENGTH);
		return GolfCourse.getGolfCourse(rand, length, targetPosition, barrierStartPosition, barrierEndPosition);
	}

	private static GolfCourse getGolfCourse(Random rand, int length, int targetPosition, int barrierStartPosition, int barrierEndPosition) {
		GolfCourse course = null;
		int type = rand.nextInt(2);
		switch (type) {
		case 0:
			course = new WaterGolfCourse(length, targetPosition, barrierStartPosition, barrierEndPosition);
			break;
		case 1:
			course = new SandGolfCourse(length, targetPosition, barrierStartPosition, barrierEndPosition);
			break;
		}
		return course;
	}

	private static int getBarrierStartPosition(Random rand, int length, int targetPosition, int barrierPosition) {
		int barrierStartPosition = 0;
		switch (barrierPosition) {
		case 0:
			barrierStartPosition = rand.nextInt(targetPosition - GolfCourse.MAX_BARRIER_LENGTH);
			break;
		case 1:
			barrierStartPosition = targetPosition + rand.nextInt(length - targetPosition);
			break;
		}
		return barrierStartPosition;
	}

}
