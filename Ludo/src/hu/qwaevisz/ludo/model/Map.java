package hu.qwaevisz.ludo.model;

public class Map {

	private static final int MAP_SIZE = 40;

	private final int playersDistance;

	private final FigureColor[] map;

	public Map() {
		this.map = new FigureColor[Map.MAP_SIZE];
		this.playersDistance = Map.MAP_SIZE / Game.NUMBER_OF_PLAYERS;
	}

	public int getPlayersDistance() {
		return this.playersDistance;
	}

	public void putFigure(FigureColor figure, int position) {
		this.map[this.calcRealPosition(position)] = figure;
	}

	public void takeUpFigure(int position) {
		this.map[this.calcRealPosition(position)] = null;
	}

	public boolean isValid(int position) {
		return this.map[this.calcRealPosition(position)] == null;
	}

	private int calcRealPosition(int position) {
		int realPosition = position;
		if (position >= Map.MAP_SIZE) {
			realPosition = position - Map.MAP_SIZE;
		}
		return realPosition;
	}

	public boolean initFigure(Player player) {
		boolean success = false;
		if (this.isValid(player.getStartPosition())) {
			this.putFigure(player.getFigure(), player.getStartPosition());
			player.startPlayer();
			success = true;
		}
		return success;
	}

	public boolean moveFigure(Player player, int diceValue) {
		boolean success = false;
		int position = -1;
		while ((!success) && (position != -2) && (position < Map.MAP_SIZE)) {
			position = this.findFigure(player.getFigure(), position);
			if (position != -2) {
				if (this.isValid(position + diceValue)) {
					if (this.calcRealPosition(position) < player.getStartPosition() && this.calcRealPosition(position + diceValue) > player.getStartPosition()) {
						player.endPlayer();
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

	public int findFigure(FigureColor figure, int from) {
		int position = -2;
		int i = from + 1;
		while ((i < this.map.length) && (!figure.equals(this.map[i]))) {
			i++;
		}
		if (i < this.map.length) {
			position = i;
		}
		return position;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		for (int i = 0; i < this.map.length; i++) {
			if (this.map[i] != null) {
				info.append(this.map[i].getSign());
			} else {
				info.append('-');
			}
		}
		// info.append("\n");
		return info.toString();
	}

}
