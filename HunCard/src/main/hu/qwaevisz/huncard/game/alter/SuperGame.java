package hu.qwaevisz.huncard.game.alter;

import hu.qwaevisz.huncard.game.simple.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SuperGame {

	private final List<SuperPlayer>	players;
	private final SuperDeck			gamedeck;

	public SuperGame(Random rand) {
		this.players = new ArrayList<SuperPlayer>();
		this.gamedeck = new SuperDeck(rand);
	}

	public void addPlayer(SuperPlayer player) {
		this.players.add(player);
	}

	public void addPlayer(String name) {
		this.players.add(new SuperPlayer(name));
	}

	private void giveCardsBack() {
		for (SuperPlayer player : this.players) {
			this.gamedeck.backCard(player.dropCards());
		}
	}

	private void dealer() {
		for (SuperPlayer player : this.players) {
			for (int j = 0; j < SuperPlayer.NUM_OF_PLAYER_CARDS; j++) {
				player.addCard(this.gamedeck.getTopCard());
			}
		}
	}

	private SuperPlayer getWinner() {
		SuperPlayer winner = null;
		if (this.players.size() > 1) {
			winner = this.players.get(0);
			for (SuperPlayer player : this.players) {
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

	public SuperPlayer newGame() {
		this.giveCardsBack();
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
		for (SuperPlayer player : this.players) {
			sb.append("[").append(i++).append(" player] \n").append(player).append("\n");
		}
		sb.append(this.gamedeck);
		sb.append("**********************************************\n");
		return sb.toString();
	}

}
