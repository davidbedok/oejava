package hu.qwaevisz.huncard.api;

public interface IGame {

	void addPlayer(IPlayer player);

	void addPlayer(String name);

	IPlayer newGame();

}
