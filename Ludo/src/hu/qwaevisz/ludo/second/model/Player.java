package hu.qwaevisz.ludo.second.model;

public class Player {

	private static final int NUMBER_OF_FIGURES = 4;

	private final String name;
	private final FigureColor color;
	private final int startPosition;

	private int numOfFigureAtStart;
	private int numOfFigureAtFinish;

	public Player(String name, FigureColor color, int startPosition) {
		this.name = name;
		this.color = color;
		this.startPosition = startPosition;

		this.numOfFigureAtStart = Player.NUMBER_OF_FIGURES;
		this.numOfFigureAtFinish = 0;
	}

	public String getName() {
		return this.name;
	}

	public Figure createFigure() {
		this.start();
		return new Figure(this);
	}

	public char getSign() {
		return this.color.getSign();
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

	public String printStart() {
		StringBuilder ret = new StringBuilder(50);
		for (int i = this.numOfFigureAtStart; i < Player.NUMBER_OF_FIGURES; i++) {
			ret.append("[ ]");
		}
		for (int i = 0; i < this.numOfFigureAtStart; i++) {
			ret.append("[" + this.getSign() + "]");
		}
		return ret.toString();
	}

	public String printEnd() {
		StringBuilder ret = new StringBuilder(50);
		for (int i = 0; i < this.numOfFigureAtFinish; i++) {
			ret.append("[" + this.getSign() + "]");
		}
		for (int i = this.numOfFigureAtFinish; i < Player.NUMBER_OF_FIGURES; i++) {
			ret.append("[ ]");
		}
		return ret.toString();
	}

	@Override
	public String toString() {
		return this.name + " (" + this.color + ")";
	}

}
