package hu.qwaevisz.ludo.first.model;

import java.util.Random;

public class Game {

	public static final int NUMBER_OF_PLAYERS = 4;
	private static final int START_DICE_VALUE = 6;

	private final Dice dice;
	private final Player[] players;
	private final Table table;
	private int playerIndex;
	private int currentPlayerIndex;
	private final String[] palpitating;
	private int palpitatingIndex;

	public Game(Random random) {
		this.dice = new Dice(random);
		this.players = new Player[Game.NUMBER_OF_PLAYERS];
		this.table = new Table();
		this.playerIndex = 0;
		this.currentPlayerIndex = 0;
		this.palpitating = new String[3];
		this.palpitatingIndex = 0;
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
			this.palpitating[this.palpitatingIndex++] = player.getName();
		}
	}

	public boolean isFinish() {
		return this.palpitatingIndex == 3;
	}

	public String step() {
		StringBuilder info = new StringBuilder(30);
		Player currentPlayer = this.getCurrentPlayer();
		info.append(currentPlayer);
		if (!currentPlayer.isFinish()) {
			int diceValue = this.dice.roll();
			info.append(" Dice: ").append(diceValue);

			boolean success = false;
			if (diceValue == Game.START_DICE_VALUE && currentPlayer.hasFiguresAtStart()) {
				success = this.table.initFigure(currentPlayer);
				if (success) {
					info.append(" START ");
				}
			}
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
		} else {
			info.append(" SKIP");
		}
		return info.toString();
	}

	private Player getCurrentPlayer() {
		Player player = this.players[this.currentPlayerIndex];
		this.nextPlayer();
		return player;
	}

	private void nextPlayer() {
		if (this.currentPlayerIndex < Game.NUMBER_OF_PLAYERS - 1) {
			this.currentPlayerIndex++;
		} else {
			this.currentPlayerIndex = 0;
		}
	}

	public String printPalpitating() {
		StringBuilder info = new StringBuilder(50);
		info.append("[1st] place: ").append(this.palpitating[0]).append("\n");
		info.append("[2nd] place: ").append(this.palpitating[1]).append("\n");
		info.append("[3rd] place: ").append(this.palpitating[2]).append("\n");
		return info.toString();
	}

	@Override
	public String toString() {
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

}
