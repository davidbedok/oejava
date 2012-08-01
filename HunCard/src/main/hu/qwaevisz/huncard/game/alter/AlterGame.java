package hu.qwaevisz.huncard.game.alter;

import hu.qwaevisz.huncard.api.AbstractGame;
import hu.qwaevisz.huncard.api.IDeck;

import java.util.Random;

public class AlterGame extends AbstractGame {

	protected AlterGame(IDeck gamedeck) {
		super(gamedeck);
	}

	public AlterGame(Random rand) {
		super();
		this.gamedeck = new AlterDeck(rand);
	}

	@Override
	public void addPlayer(String name) {
		this.players.add(new AlterPlayer(name));
	}

}
