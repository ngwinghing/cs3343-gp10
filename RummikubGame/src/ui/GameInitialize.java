package ui;

import java.io.InputStream;

import rummikub.Game;
import rummikub.Player;

public class GameInitialize extends GameUI {

	public GameInitialize(Game game) {
		super(game);
	}

	public GameInitialize(Game game, InputStream stream) {
		super(game, stream);
	}

	@Override
	public void output() {
		System.out.println("\n***New Game Start!***\n");
		String playerName = greeting();
		Player p = new Player(playerName);
		game.addPlayer(p);
	}

	private String greeting() {
		String playerName;
		System.out.println("What's your name?");
		//playerName = scanner.nextLine();
		playerName = "Wing";

		System.out.println("Welcome, " + playerName);
		return playerName;
	}
}
