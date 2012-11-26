package hu.qwaevisz.huncard;

import java.util.Random;

public class Game {

	private static final int MAX_PLAYER = 5;

	private final Deck deck;
	private final Player[] players;
	private int numberOfPlayers;

	public Game(Random rand) {
		this.deck = new Deck(rand);
		this.players = new Player[Game.MAX_PLAYER];
		this.numberOfPlayers = 0;
	}

	private void addPlayer(Player player) {
		if (this.numberOfPlayers < this.players.length) {
			this.players[this.numberOfPlayers++] = player;
		}
	}

	public void addPlayer(String name) {
		this.addPlayer(new Player(name));
	}

	public Player play() {
		this.deck.rotate();
		this.deal();
		return this.winner();
	}

	private void deal() {
		for (int i = 0; i < Player.NUM_OF_CARDS; i++) {
			for (int j = 0; j < this.numberOfPlayers; j++) {
				this.players[j].addCard(this.deck.topCard());
			}
		}
	}

	private Player winner() {
		Player winner = null;
		if (this.numberOfPlayers > 0) {
			winner = this.players[0];
			int maxCardValues = this.players[0].cardValues();
			for (int i = 1; i < this.numberOfPlayers; i++) {
				int cardValues = this.players[i].cardValues();
				if (maxCardValues < cardValues) {
					maxCardValues = cardValues;
					winner = this.players[i];
				}
			}
		}
		return winner;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		info.append("<< Game >>").append("\n");
		for (int i = 0; i < this.numberOfPlayers; i++) {
			info.append("[").append((i + 1)).append("] ");
			info.append(this.players[i]).append("\n");
		}
		info.append(this.deck).append("\n");
		return info.toString();
	}

}
