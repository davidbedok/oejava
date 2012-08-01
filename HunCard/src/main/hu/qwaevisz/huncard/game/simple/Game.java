package hu.qwaevisz.huncard.game.simple;

import hu.qwaevisz.huncard.api.AbstractGame;
import hu.qwaevisz.huncard.api.IDeck;

import java.util.Random;

public class Game extends AbstractGame {

	protected Game(IDeck gamedeck) {
		super(gamedeck);
	}

	public Game(Random rand) {
		super();
		this.gamedeck = new Deck(rand);
	}

	@Override
	public void addPlayer(String name) {
		this.players.add(new Player(name));
	}

}
