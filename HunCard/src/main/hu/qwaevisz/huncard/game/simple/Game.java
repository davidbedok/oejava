package hu.qwaevisz.huncard.game.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends java.lang.Object {

	private final List<Player>	players;
	private final Deck			gamedeck;

	// For test
	protected Game(Deck gamedeck) {
		this.players = new ArrayList<Player>();
		this.gamedeck = gamedeck;
	}

	public Game(Random rand) {
		this.players = new ArrayList<Player>();
		this.gamedeck = new Deck(rand);
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public void addPlayer(String name) {
		this.players.add(new Player(name));
	}

	private void dropCards() {
		for (Player player : this.players) {
			player.dropCards();
		}
	}

	private void dealer() {
		for (int j = 0; j < Player.NUM_OF_PLAYER_CARDS; j++) {
			for (Player player : this.players) {
				player.addCard(this.gamedeck.getTopCard());
			}
		}
	}

	private Player getWinner() {
		Player winner = null;
		if (this.players.size() > 1) {
			winner = this.players.get(0);
			for (Player player : this.players) {
				if (player.getCardsValue() > winner.getCardsValue()) {
					winner = player;
				}
			}
		}
		return winner;
	}

	private void rotate() {
		this.gamedeck.rotate(Deck.NUM_ROTATE);
	}

	public Player newGame() {
		this.dropCards();
		this.rotate();
		this.dealer();
		return this.getWinner();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(500);
		sb.append("**********************************************\n");
		sb.append("Game :\n");
		int i = 1;
		for (Player player : this.players) {
			sb.append("[").append(i++).append(" player] \n").append(player).append("\n");
		}
		sb.append(this.gamedeck);
		sb.append("**********************************************\n");
		return sb.toString();
	}

}
