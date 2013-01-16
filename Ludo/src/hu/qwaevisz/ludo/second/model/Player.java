package hu.qwaevisz.ludo.second.model;

public class Player {

	private static final int NUMBER_OF_FIGURES = 4;

	private final String name;
	private final FigureColor color;
	private final int startPosition;

	private int numOfFigureAtStart;
	private int numOfFigureAtFinish;
	private int numOfHit;
	private int numOfDeath;
	private int winningRound;

	public Player(String name, FigureColor color, int startPosition) {
		this.name = name;
		this.color = color;
		this.startPosition = startPosition;

		this.numOfFigureAtStart = Player.NUMBER_OF_FIGURES;
		this.numOfFigureAtFinish = 0;

		this.numOfHit = 0;
		this.numOfDeath = 0;
		this.winningRound = -1;
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

	public void hit() {
		this.numOfHit++;
	}

	public void death() {
		if (this.numOfFigureAtStart < Player.NUMBER_OF_FIGURES) {
			this.numOfFigureAtStart++;
			this.numOfDeath++;
		}
	}

	public boolean isFinish() {
		return this.numOfFigureAtFinish == Player.NUMBER_OF_FIGURES;
	}

	public void end(int round) {
		this.winningRound = round;
	}

	public int getWinningRound() {
		return this.winningRound;
	}

	public String printStartFigure(int number) {
		String ret = "( )";
		if (this.isStartFigure(number)) {
			ret = "(" + this.getSign() + ")";
		}
		return ret;
	}

	private boolean isStartFigure(int number) {
		return this.numOfFigureAtStart >= number;
	}

	public String printFinishFigure(int number) {
		String ret = "   ";
		if (this.isFinishFigure(number)) {
			ret = " " + this.getSign() + " ";
		}
		return ret;
	}

	private boolean isFinishFigure(int number) {
		return this.numOfFigureAtFinish >= number;
	}

	public String printStart() {
		StringBuilder ret = new StringBuilder(50);
		for (int i = this.numOfFigureAtStart; i < Player.NUMBER_OF_FIGURES; i++) {
			ret.append("[ ]");
		}
		for (int i = 0; i < this.numOfFigureAtStart; i++) {
			ret.append("[" + this.getSign() + "]");
		}
		ret.append(" D: ").append(this.numOfDeath);
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
		ret.append(" H: ").append(this.numOfHit);
		return ret.toString();
	}

	@Override
	public String toString() {
		return this.name + " (" + this.getSign() + ") Hit: " + this.numOfHit + " Death: " + this.numOfDeath;
	}

}
