package hu.qwaevisz.ludo.second.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Table {

	public static final int MAP_SIZE = 40;

	private static Comparator<Figure> FigureComparator = new Comparator<Figure>() {
		@Override
		public int compare(Figure o1, Figure o2) {
			return o1.getPosition() - o2.getPosition();
		}
	};

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
		Figure figure = this.find(player.getStartPosition());
		if (figure == null || figure.getPlayer() != player) {
			this.figures.add(player.createFigure());
			this.checkHit(player, figure);
			success = true;
		}
		return success;
	}

	private void checkHit(Player player, Figure figure) {
		if (figure != null) {
			player.hit();
			figure.getPlayer().death();
			this.figures.remove(figure);
		}
	}

	public boolean moveFigure(Player player, int diceValue) {
		boolean success = false;
		List<Figure> playerFigures = this.assortment(player);
		Collections.sort(playerFigures, Table.FigureComparator);
		for (Figure currentFigure : playerFigures) {
			int realPosition = this.calcRealPosition(currentFigure.getPosition() + diceValue);

			Figure figure = this.find(realPosition);
			if (figure == null || figure.getPlayer() != player) {
				if (currentFigure.move(realPosition, diceValue)) {
					this.figures.remove(currentFigure);
				}
				this.checkHit(player, figure);
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
			info.append(i % 10).append(" ");
		}
		info.append("\n");
		for (int i = 0; i < Table.MAP_SIZE; i++) {
			Figure figure = this.find(i);
			if (figure != null) {
				info.append(figure.getSign()).append(" ");
			} else {
				info.append("_ ");
			}
		}
		return info.toString();
	}

	public String print(Player[] players) {
		StringBuilder info = new StringBuilder(100);
		for (int i = 0; i < TableView.VIEW.length; i++) {
			for (int j = 0; j < TableView.VIEW[i].length; j++) {
				int current = TableView.VIEW[i][j];
				if (current >= 0) {
					Figure figure = this.find(current);
					if (figure != null) {
						info.append("[").append(figure.getSign()).append("]");
					} else {
						info.append("[ ]");
					}
				} else {
					if (current == TableView.EMPTY) {
						info.append("   ");
					} else {
						int playerIndex = current / -10 - 1;
						int figureIndex = (current % 10) * -1 + 1;
						if (figureIndex < 5) {
							info.append(players[playerIndex].printStartFigure(figureIndex));
						} else {
							info.append(players[playerIndex].printFinishFigure(figureIndex - 5));
						}
					}
				}
			}
			info.append("\n");
		}
		return info.toString();
	}
}
