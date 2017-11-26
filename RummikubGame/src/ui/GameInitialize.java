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
		System.out.println("=====================================");
		System.out.println("=====================================");
		System.out.println("");
		System.out.println("\t *** RUMMIKUB GAME ***");
		System.out.println("");
		System.out.println("=====================================");
		System.out.println("=====================================");
		System.out.println("");
		System.out.println("\n***New Game Start!***\n");

		boolean invalid = true;
		do {
			System.out.println("\nHow many players do you have? (1-4)");
			int numberOfPlayer = scanner.nextInt();
			
			if (numberOfPlayer > 0 && numberOfPlayer < 5) {
				invalid = false;
				for (int i = 0; i < numberOfPlayer; i++) {
					System.out.println("\nHello Player " + (i + 1) + ", what's your name?");
					String playerName = scanner.next();
					Player p = new Player(playerName);
					game.addPlayer(p);
					System.out.println("\nWelcome, " + playerName);
				}
			} else {
				System.err.println("Please retry with available numbers.");
			}
		} while (invalid);
	}
}
