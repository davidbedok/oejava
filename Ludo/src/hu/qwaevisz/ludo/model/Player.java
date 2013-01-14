package hu.qwaevisz.ludo.model;

public class Player {

	private static final int NUMBER_OF_FIGURES = 4;

	private final FigureColor color;
	private final String name;
	private final int startPosition;
	private int numOfStartPlayers;
	private int numOfEndPlayers;

	public Player(String name, FigureColor color, int startPosition) {
		this.name = name;
		this.startPosition = startPosition;
		this.numOfStartPlayers = Player.NUMBER_OF_FIGURES;
		this.numOfEndPlayers = 0;
		this.color = color;
	}

	public int getNumOfEndPlayers() {
		return this.numOfEndPlayers;
	}

	public FigureColor getFigure() {
		return this.color;
	}

	public int getStartPosition() {
		return this.startPosition;
	}

	public boolean hasStartPlayer() {
		return this.numOfStartPlayers > 0;
	}

	public void startPlayer() {
		this.numOfStartPlayers--;
	}

	public void endPlayer() {
		this.numOfEndPlayers++;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(50);
		info.append(" > ").append(this.name).append(" ").append(this.color);
		return info.toString();
	}

}
