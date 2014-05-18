package hu.qwaevisz.golf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GolfGame {

	private static final int MIN_WIND_FORCE_PERCENT = -30;
	private static final int MAX_WIND_FORCE_PERCENT = 30;

	private static final int NUMBER_OF_COURSES = 9;

	private final Random rand;
	private final List<GolfCourse> courses;
	private final StrongGolfPlayer strong;
	private final SkillFullPlayer skillFull;

	public GolfGame(Random rand) {
		this.rand = rand;
		this.courses = new ArrayList<GolfCourse>();
		for (int i = 0; i < GolfGame.NUMBER_OF_COURSES; i++) {
			this.courses.add(GolfCourse.create(rand));
		}
		this.strong = new StrongGolfPlayer(rand);
		this.skillFull = new SkillFullPlayer(rand);
	}

	public int play(GolfCourse course, GolfPlayer player, int windForce) {
		int result = 0;
		int position = 0;
		do {
			PutterType type = course.getPutterType(position);
			position = course.getPosition(position, player.hit(type, windForce));
			result++;
		} while (!course.isTarget(position));
		return result;
	}

	public GolfPlayer simulate() {
		List<Integer> strongPoints = new ArrayList<Integer>();
		List<Integer> skillFullPoints = new ArrayList<Integer>();
		for (int i = 0; i < GolfGame.NUMBER_OF_COURSES; i++) {
			GolfCourse course = this.courses.get(i);
			int windForce = this.rand.nextInt(MAX_WIND_FORCE_PERCENT - MIN_WIND_FORCE_PERCENT) + MIN_WIND_FORCE_PERCENT;
			strongPoints.add(this.play(course, this.strong, windForce));
			skillFullPoints.add(this.play(course, this.skillFull, windForce));
		}
		int sumStrong = this.sum(strongPoints);
		System.out.println("Strong (sum: " + sumStrong + ")");
		int sumSkillFull = this.sum(skillFullPoints);
		System.out.println("SkillFull (sum: " + sumSkillFull + ")");
		return sumStrong < sumSkillFull ? this.skillFull : this.strong;
	}

	private int sum(List<Integer> points) {
		int result = 0;
		for (Integer point : points) {
			result += point;
			System.out.print(point + ", ");
		}
		System.out.println();
		return result;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		for (int i = 0; i < GolfGame.NUMBER_OF_COURSES; i++) {
			info.append(this.courses.get(i)).append('\n');
		}
		return info.toString();
	}

}
