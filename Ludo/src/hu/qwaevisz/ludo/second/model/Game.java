package hu.qwaevisz.ludo.second.model;

import java.util.Random;

public class Game {

	public static final int NUMBER_OF_PLAYERS = 4;
	private static final int START_DICE_VALUE = 6;

	private final Dice dice;
	private final Player[] players;
	private final Table table;
	private int playerIndex;
	private int currentPlayerIndex;
	private final Player[] palpitating;
	private int palpitatingIndex;
	private int round;
	private boolean repeat;

	public Game(Random random) {
		this.dice = new Dice(random);
		this.players = new Player[Game.NUMBER_OF_PLAYERS];
		this.table = new Table();
		this.playerIndex = 0;
		this.currentPlayerIndex = 0;
		this.palpitating = new Player[3];
		this.palpitatingIndex = 0;
		this.round = 1;
		this.repeat = false;
	}

	public void addPlayers(String nameA, String nameB, String nameC, String nameD) {
		this.addPlayer(nameA);
		this.addPlayer(nameB);
		this.addPlayer(nameC);
		this.addPlayer(nameD);
	}

	private void addPlayer(String name) {
		if (this.playerIndex < this.players.length) {
			this.players[this.playerIndex] = new Player(name, FigureColor.values()[this.playerIndex], this.table.getPlayersDistance() * this.playerIndex);
			this.playerIndex++;
		}
	}

	private void addItemToPalpitating(Player player) {
		if (this.palpitatingIndex < 3) {
			this.palpitating[this.palpitatingIndex++] = player;
			player.end(this.round);
		}
	}

	public boolean isFinish() {
		return this.palpitatingIndex == 3;
	}

	public String step() {
		StringBuilder info = new StringBuilder(30);
		Player currentPlayer = this.getCurrentPlayer();
		info.append("R-").append(this.round).append(" ");
		info.append(currentPlayer);
		if (!currentPlayer.isFinish()) {
			int diceValue = this.dice.roll();
			info.append(" Dice: ").append(diceValue);

			boolean success = this.checkInitFigure(currentPlayer, diceValue, info);
			if (!success) {
				success = this.table.moveFigure(currentPlayer, diceValue);
				if (success) {
					info.append(" STEP ");
				}
			}
			if (!success) {
				info.append(" EMPTY");
			} else {
				if (currentPlayer.isFinish()) {
					this.addItemToPalpitating(currentPlayer);
				}
			}
			if (diceValue != Game.START_DICE_VALUE) {
				this.nextPlayer();
				this.repeat = false;
			} else {
				this.repeat = true;
			}
		} else {
			info.append(" SKIP");
			this.nextPlayer();
		}
		return info.toString();
	}

	private boolean checkInitFigure(Player player, int diceValue, StringBuilder info) {
		boolean success = false;
		if (diceValue == Game.START_DICE_VALUE && player.hasFiguresAtStart()) {
			success = this.table.initFigure(player);
			if (success) {
				info.append(" START ");
			}
		}
		return success;
	}

	private Player getCurrentPlayer() {
		return this.players[this.currentPlayerIndex];
	}

	public boolean checkCurrentPlayer(String name) {
		return this.players[this.currentPlayerIndex].getName().equals(name);
	}

	public boolean checkLastPlayer(String name) {
		if (this.repeat) {
			return false;
		} else {
			if (this.currentPlayerIndex > 0) {
				return this.players[this.currentPlayerIndex - 1].getName().equals(name);
			} else {
				return this.players[3].getName().equals(name);
			}
		}
	}

	private void nextPlayer() {
		if (this.currentPlayerIndex < Game.NUMBER_OF_PLAYERS - 1) {
			this.currentPlayerIndex++;
		} else {
			this.currentPlayerIndex = 0;
			this.round++;
		}
	}

	public String printPalpitating() {
		StringBuilder info = new StringBuilder(50);
		for (int i = 0; i < this.palpitating.length; i++) {
			info.append("[" + (i + 1) + "] ").append(this.palpitating[i].getName()).append(" R-").append(this.palpitating[i].getWinningRound()).append("\n");
		}
		return info.toString();
	}

	public String printSimple() {
		StringBuilder info = new StringBuilder(100);

		int distance = this.table.getPlayersDistance();
		for (int i = 0; i < this.players.length; i++) {
			info.append(String.format("%-" + distance + "s", this.players[i].getName()));
		}
		info.append("\n");
		for (int i = 0; i < this.players.length; i++) {
			info.append(String.format("%-" + distance + "s", this.players[i].printStart()));
		}
		info.append("\n").append(this.table).append("\n");
		for (int i = 0; i < this.players.length; i++) {
			info.append(String.format("%-" + distance + "s", this.players[i].printEnd()));
		}
		info.append("\n");
		return info.toString();
	}

	@Override
	public String toString() {
		return this.table.print(this.players);
	}

}
