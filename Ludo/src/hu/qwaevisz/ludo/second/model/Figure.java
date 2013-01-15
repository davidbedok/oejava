package hu.qwaevisz.ludo.second.model;

public class Figure {

	private final Player player;
	private int position;
	private int distance;

	public Figure(Player player) {
		this.player = player;
		this.position = player.getStartPosition();
		this.distance = 0;
	}

	public Player getPlayer() {
		return this.player;
	}

	public int getPosition() {
		return this.position;
	}

	public char getSign() {
		return this.player.getSign();
	}

	public boolean move(int newPosition, int diceValue) {
		boolean isFinish = false;
		this.position = newPosition;
		this.distance += diceValue;
		if (this.distance > Table.MAP_SIZE) {
			isFinish = true;
			this.player.finish();
		}
		return isFinish;
	}

}
