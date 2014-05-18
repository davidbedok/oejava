package hu.qwaevisz.golf;

public class SandGolfCourse extends GolfCourse {

	public SandGolfCourse(int length, int targetPosition, int barrierStartPosition, int barrierEndPosition) {
		super(length, targetPosition, barrierStartPosition, barrierEndPosition);
	}

	@Override
	protected char getBarrierChar() {
		return 's';
	}

}
