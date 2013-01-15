package hu.qwaevisz.ludo.second.model;

import java.util.ArrayList;
import java.util.List;

public class Table {

	public static final int MAP_SIZE = 80;

	private final List<Figure> figures;
	private final int playersDistance;

	public Table() {
		this.figures = new ArrayList<Figure>();
		this.playersDistance = Table.MAP_SIZE / Game.NUMBER_OF_PLAYERS;
	}

	public int getPlayersDistance() {
		return this.playersDistance;
	}

	private int calcRealPosition(int position) {
		int realPosition = position;
		if (position >= Table.MAP_SIZE) {
			realPosition = position - Table.MAP_SIZE;
		}
		return realPosition;
	}

	private Figure find(int position) {
		Figure figure = null;
		for (Figure currentFigure : this.figures) {
			if (currentFigure.getPosition() == position) {
				figure = currentFigure;
				break;
			}
		}
		return figure;
	}

	private boolean isValid(int position) {
		return this.find(position) == null;
	}

	private List<Figure> assortment(Player player) {
		List<Figure> figures = new ArrayList<Figure>();
		for (Figure currentFigure : this.figures) {
			if (currentFigure.getPlayer().equals(player)) {
				figures.add(currentFigure);
			}
		}
		return figures;
	}

	public boolean initFigure(Player player) {
		boolean success = false;
		if (this.isValid(player.getStartPosition())) {
			this.figures.add(player.createFigure());
			success = true;
		}
		return success;
	}

	public boolean moveFigure(Player player, int diceValue) {
		boolean success = false;
		List<Figure> playerFigures = this.assortment(player);
		for (Figure currentFigure : playerFigures) {
			int realPosition = this.calcRealPosition(currentFigure.getPosition() + diceValue);
			if (this.isValid(realPosition)) {
				if (currentFigure.move(realPosition, diceValue)) {
					this.figures.remove(currentFigure);
				}
				success = true;
				break;
			}
		}
		return success;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		for (int i = 0; i < Table.MAP_SIZE; i++) {
			info.append(i % 10);
		}
		info.append("\n");
		for (int i = 0; i < Table.MAP_SIZE; i++) {
			Figure figure = this.find(i);
			if (figure != null) {
				info.append(figure.getSign());
			} else {
				info.append('-');
			}
		}
		return info.toString();
	}

}
