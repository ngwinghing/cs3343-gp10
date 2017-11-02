package rummikub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		String playerName;
		Scanner scanner = new Scanner(System.in);

		System.out.println("What's your name?");
		// playerName = scanner.nextLine();
		playerName = "Wing";

		System.out.println("Welcome, " + playerName);

		Player p = new Player(playerName);

		Game game = Game.getInstance();
		game.addPlayer(p);

		game.distributeTile();

		System.out.println("");

		do {

			System.out.println("\nPool: ");
			game.printPool();

			System.out.println("\nYour Rack: ");
			System.out.println(p.rack);
			System.out.println("----------------------");

			System.out.println("\nPlease choose your options: ");
			game.availableOptions(p);
			String option = scanner.nextLine();

			switch (option) {
			case "1":
				game.draw(p);
				break;
			case "2":
				System.out.println("\nPlease select the numbers of your tiles you want to play.");
				String input = scanner.nextLine();    // get the entire line after the prompt 
				String[] numbers = input.split(" "); // split by spaces
				List<Tile> tmpTiles = new ArrayList<Tile>();
				for (int i=0; i<numbers.length;i++) {
					System.out.println("Numbers: "+numbers[i]);
					Tile t = p.getTileByIndex(Integer.parseInt(numbers[i])-1);//Integer.parseInt(numbers[i])
					System.out.println("Tile selected: "+t);
					tmpTiles.add(t);
				}
				//validate user inputed tiles
				boolean valid = game.checkIfTileSetAvailable(tmpTiles);
				System.out.println("Valid? "+valid);
				
				//if validated, add to pool
				if (valid) {
					TileSet set = new TileSet(tmpTiles);
					game.addSetToPool(set);
				}
				//remove the tiles from the player
				
				break;
			case "3":
				p.sortByNumber();
				break;
			case "4":
				p.sortByColor();
				break;
			default:
				System.out.println("Please input an avaliable option number.");
				game.availableOptions(p);
			}
			System.out.println("#############################");
		} while (game.notEnd());
	}
}
