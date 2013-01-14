package hu.qwaevisz.ludo.model;

import java.util.Random;

public class Game {

	private static final int START_DICE_VALUE = 6;
	public static final int NUMBER_OF_PLAYERS = 4;
	private static final int MAP_SIZE = 40;

	private final Dice dice;
	private final Player[] players;
	private int playerIndex;
	private final Map map;

	private int currentPlayerIndex;

	private final int playersDistance;

	public Game(Random random) {
		this.dice = new Dice(random);
		this.players = new Player[Game.NUMBER_OF_PLAYERS];
		this.playerIndex = 0;
		this.playersDistance = Game.MAP_SIZE / Game.NUMBER_OF_PLAYERS;
		this.currentPlayerIndex = 0;
		this.map = new Map();
	}

	public void addPlayer(String name) {
		if (this.playerIndex < this.players.length) {
			this.players[this.playerIndex] = new Player(name, FigureColor.values()[this.playerIndex], this.playersDistance * this.playerIndex);
			this.playerIndex++;
		}
	}

	public String step() {
		StringBuilder info = new StringBuilder(30);
		Player currentPlayer = this.getCurrentPlayer();
		info.append(currentPlayer);
		int diceValue = this.dice.roll();
		info.append(" diceValue: ").append(diceValue);

		boolean success = false;
		if (diceValue == Game.START_DICE_VALUE && currentPlayer.hasStartPlayer()) {
			success = this.map.initFigure(currentPlayer);
			if (success) {
				info.append(" START ");
			}
		}
		if (!success) {
			success = this.map.moveFigure(currentPlayer, diceValue);
			if (success) {
				info.append(" STEP ");
			}
		}
		info.append(" END : " + currentPlayer.getNumOfEndPlayers());
		return info.toString();
	}

	public Player getCurrentPlayer() {
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

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		info.append("Game\n");
		for (int i = 0; i < this.playerIndex; i++) {
			info.append(this.players[i]);
		}

		return info.toString();
	}

	public String printMap() {
		return this.map.toString();
	}

}
