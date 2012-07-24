package hu.qwaevisz.card;

import java.util.ArrayList;
import java.util.List;

public class Game extends java.lang.Object {

	private final List<Player> players;
	private final Deck gamedeck;

	public Game() {
		this.players = new ArrayList<Player>();
		this.gamedeck = new Deck();
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public void addPlayer(String name) {
		this.players.add(new Player(name));
	}

	private void dealer() {
		for (Player p : this.players) {
			p.dropCards();
			for (int j = 0; j < Player.NUM_OF_PLAYER_CARDS; j++) {
				p.addCard(this.gamedeck.getTopCard());
			}
		}
	}

	private Player getWinner() {
		Player winner = null;
		if (this.players.size() > 1) {
			winner = this.players.get(0);
			for (Player p : this.players) {
				if (p.getCardsValue() > winner.getCardsValue()) {
					winner = p;
				}
			}
		}
		return winner;
	}

	private void rotate() {
		this.gamedeck.rotate(Deck.NUM_ROTATE);
	}

	public Player newGame() {
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
		for (Player p : this.players) {
			sb.append("[").append(i++).append(" player] \n").append(p).append("\n");
		}
		sb.append(this.gamedeck);
		sb.append("**********************************************\n");
		return sb.toString();
	}

}
