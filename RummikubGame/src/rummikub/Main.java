package rummikub;

import ui.GameInitialize;

public class Main {

	public static void main(String args[]) throws CloneNotSupportedException {

		Game game = new Game();
		new GameInitialize(game);
		game.start();

	}
}