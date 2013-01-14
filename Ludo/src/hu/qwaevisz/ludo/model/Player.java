package hu.qwaevisz.ludo.model;

public class Player {

	private static final int NUMBER_OF_FIGURES = 4;

	private final String name;
	private final Figure figure;
	private final int startPosition;
	private int numOfFigureAtStart;
	private int numOfFigureAtFinish;

	public Player(String name, Figure figure, int startPosition) {
		this.name = name;
		this.figure = figure;
		this.startPosition = startPosition;
		this.numOfFigureAtStart = Player.NUMBER_OF_FIGURES;
		this.numOfFigureAtFinish = 0;
	}

	public String getName() {
		return this.name;
	}

	public Figure getFigure() {
		return this.figure;
	}

	public int getStartPosition() {
		return this.startPosition;
	}

	public boolean hasFiguresAtStart() {
		return this.numOfFigureAtStart > 0;
	}

	public void start() {
		if (this.numOfFigureAtStart > 0) {
			this.numOfFigureAtStart--;
		}
	}

	public void finish() {
		if (this.numOfFigureAtFinish < Player.NUMBER_OF_FIGURES) {
			this.numOfFigureAtFinish++;
		}
	}

	public boolean isFinish() {
		return this.numOfFigureAtFinish == Player.NUMBER_OF_FIGURES;
	}

	public boolean isNearBeforeStartPos(int position) {
		return position < this.startPosition || (position > Table.MAP_SIZE + this.startPosition - Dice.MAX_VALUE);
	}

	public boolean isNearAfterStartPos(int position) {
		return position > this.startPosition;
	}

	public String printStart() {
		StringBuilder ret = new StringBuilder(50);
		for (int i = this.numOfFigureAtStart; i < Player.NUMBER_OF_FIGURES; i++) {
			ret.append("[ ]");
		}
		for (int i = 0; i < this.numOfFigureAtStart; i++) {
			ret.append("[" + this.figure.getSign() + "]");
		}
		return ret.toString();
	}

	public String printEnd() {
		StringBuilder ret = new StringBuilder(50);
		for (int i = 0; i < this.numOfFigureAtFinish; i++) {
			ret.append("[" + this.figure.getSign() + "]");
		}
		for (int i = this.numOfFigureAtFinish; i < Player.NUMBER_OF_FIGURES; i++) {
			ret.append("[ ]");
		}
		return ret.toString();
	}

	@Override
	public String toString() {
		return this.name + " (" + this.figure + ")";
	}

}
