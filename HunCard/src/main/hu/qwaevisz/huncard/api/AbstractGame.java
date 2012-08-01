package hu.qwaevisz.huncard.api;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGame implements IGame {

	protected final List<IPlayer>	players;
	protected IDeck					gamedeck;

	// For test
	protected AbstractGame(IDeck gamedeck) {
		this.players = new ArrayList<IPlayer>();
		this.gamedeck = gamedeck;
	}

	public AbstractGame() {
		this.players = new ArrayList<IPlayer>();
	}

	@Override
	public void addPlayer(IPlayer player) {
		this.players.add(player);
	}

	private void dealer() {
		for (int j = 0; j < IPlayer.NUM_OF_PLAYER_CARDS; j++) {
			for (IPlayer player : this.players) {
				player.addCard(this.gamedeck.getTopCard());
			}
		}
	}

	private IPlayer getWinner() {
		IPlayer winner = null;
		if (this.players.size() > 1) {
			winner = this.players.get(0);
			for (IPlayer player : this.players) {
				if (player.getCardsValue() > winner.getCardsValue()) {
					winner = player;
				}
			}
		}
		return winner;
	}

	private void rotate() {
		this.gamedeck.rotate(IDeck.NUM_ROTATE);
	}

	private void giveCardsBack() {
		for (IPlayer player : this.players) {
			this.gamedeck.backCard(player.dropCards());
		}
	}

	@Override
	public IPlayer newGame() {
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
		for (IPlayer player : this.players) {
			sb.append("[").append(i++).append(" player] \n").append(player).append("\n");
		}
		sb.append(this.gamedeck);
		sb.append("**********************************************\n");
		return sb.toString();
	}

}
