package rummikub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		String playerName;
		Scanner scanner = new Scanner(System.in);
		boolean replay = false;

		do {
			System.out.println("\n***New Game Start!***\n");
			System.out.println("What's your name?");
			// playerName = scanner.nextLine();
			playerName = "Wing";

			System.out.println("Welcome, " + playerName);

			Player p = new Player(playerName);

			Game game = new Game();
			game.addPlayer(p);
			game.distributeTile();

			do {
				System.out.println("\nPool: ");
				game.printPool();

				System.out.println("\nYour Rack: ");
				System.out.println(p.rack);

				System.out.println("=====================================");
				System.out.println("Please choose your options: ");
				System.out.println("=====================================");
				game.availableOptions();
				System.out.println("-------------------------------------");

				String option = scanner.nextLine();

				switch (option) {
				case "1":
					game.draw(p);
					break;

				case "2":
					boolean endTurn = false;
					do {
						System.out.println("=====================================");
						System.out.println("2: Please choose your play options: ");
						System.out.println("=====================================");
						game.availablePlayOptions();
						System.out.println("-------------------------------------");
						String playOption = scanner.nextLine();

						switch (playOption) {

						case "1":
							// 1. New Set
							System.out.println(
									"Please select the numbers of your tiles you want to play.\n*Note: Seperate by spaces.");
							String input = scanner.nextLine();
							String[] numbers = input.split(" ");
							List<Tile> tmpTiles = new ArrayList<Tile>();
							for (int i = 0; i < numbers.length; i++) {
								try {
									Tile t = p.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
									tmpTiles.add(t);
								} catch (NumberFormatException e) {
									System.out.println("Only numbers are avaliable, please retry.");
								}
							}
							// validate user inputed tiles
							boolean valid = game.checkIfTileSetAvailable(tmpTiles);

							// if validated, add to pool
							if (valid) {
								TileSet set = new TileSet(tmpTiles);
								game.addSetToPool(set);
								// remove the tiles from the player
								p.removeTileSet(tmpTiles);
							}
							break;

						case "2":
							// 2. Add to Set
							System.out.println("Which set in the pool you what to add to?");
							System.out.println(
									"Please select the numbers of your tiles you want to play.\n*Note: Seperate by spaces.");
							input = scanner.nextLine();
							numbers = input.split(" ");
							break;
						case "3":
							// 3. Move tile to new set
							break;
						case "4":
							// 4. Move to set
							break;
						case "5":
							// 5. End Turn
							endTurn = true;
							break;
						default:
							System.out.println("Please input an avaliable option number.");
						}
					} while (!endTurn);
					break;

				case "3":
					p.sortByNumber();
					break;

				case "4":
					p.sortByColor();
					break;

				default:
					System.out.println("Please input an avaliable option number.");
				}
				System.out.println("\n#############################");

			} while (game.notEnd());

			System.out.println("Replay? (y/n)");
			String input = scanner.nextLine();
			switch (input) {
			case "y":
				replay = true;
				break;
			case "n":
				replay = false;
				break;
			default:
				replay = false;
			}
		} while (replay);
	}
}