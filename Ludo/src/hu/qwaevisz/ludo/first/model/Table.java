package hu.qwaevisz.ludo.first.model;

public class Table {

	public static final int MAP_SIZE = 80;

	private final FigureColor[] fields;
	private final int playersDistance;

	public Table() {
		this.fields = new FigureColor[Table.MAP_SIZE];
		this.playersDistance = Table.MAP_SIZE / Game.NUMBER_OF_PLAYERS;
	}

	public int getPlayersDistance() {
		return this.playersDistance;
	}

	private void putFigure(FigureColor figure, int position) {
		this.fields[this.calcRealPosition(position)] = figure;
	}

	private void takeUpFigure(int position) {
		this.fields[this.calcRealPosition(position)] = null;
	}

	private boolean isValid(int position) {
		return this.fields[this.calcRealPosition(position)] == null;
	}

	private int calcRealPosition(int position) {
		int realPosition = position;
		if (position >= Table.MAP_SIZE) {
			realPosition = position - Table.MAP_SIZE;
		}
		return realPosition;
	}

	public boolean initFigure(Player player) {
		boolean success = false;
		if (this.isValid(player.getStartPosition())) {
			this.putFigure(player.getFigure(), player.getStartPosition());
			player.start();
			success = true;
		}
		return success;
	}

	public boolean moveFigure(Player player, int diceValue) {
		boolean success = false;
		int position = -1;
		while ((!success) && (position != -2) && (position < Table.MAP_SIZE)) {
			position = this.findFigure(player.getFigure(), position);
			if (position != -2) {
				if (this.isValid(position + diceValue)) {
					if (player.isNearBeforeStartPos(position) && player.isNearAfterStartPos(position + diceValue)) {
						player.finish();
						this.takeUpFigure(position);
						success = true;
					} else {
						this.takeUpFigure(position);
						this.putFigure(player.getFigure(), position + diceValue);
						success = true;
					}
				}
			}
		}
		return success;
	}

	private int findFigure(FigureColor figure, int from) {
		int position = -2;
		int i = from + 1;
		while ((i < this.fields.length) && (!figure.equals(this.fields[i]))) {
			i++;
		}
		if (i < this.fields.length) {
			position = i;
		}
		return position;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		for (int i = 0; i < this.fields.length; i++) {
			info.append(i % 10);
		}
		info.append("\n");
		for (int i = 0; i < this.fields.length; i++) {
			if (this.fields[i] != null) {
				info.append(this.fields[i].getSign());
			} else {
				info.append('-');
			}
		}
		return info.toString();
	}

}
