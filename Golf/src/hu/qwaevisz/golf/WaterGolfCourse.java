package hu.qwaevisz.golf;

public class WaterGolfCourse extends GolfCourse {

	public WaterGolfCourse(int length, int targetPosition, int barrierStartPosition, int barrierEndPosition) {
		super(length, targetPosition, barrierStartPosition, barrierEndPosition);
	}

	@Override
	protected char getBarrierChar() {
		return 'w';
	}

}
