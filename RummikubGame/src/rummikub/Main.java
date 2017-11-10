package rummikub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws CloneNotSupportedException {

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

			Game game = Game.getInstance();
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
					Pool tmpPool = (Pool) game.getPool().clone();
					System.out.println("tmpPool = "+tmpPool);
					do {
						System.out.println("\nCurrentPool: ");
						game.printPool();
						
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
							TileSet tmpTiles = new TileSet();
							for (int i = 0; i < numbers.length; i++) {
								try {
									Tile t = p.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
									tmpTiles.addToSet(t);
								} catch (NumberFormatException e) {
									System.out.println("Only numbers are avaliable, please retry.");
								}
							}
							// validate user inputed tiles
							boolean valid = tmpTiles.checkIfTileSetAvailable();
							
							// check sum of tiles if it is first move
							if (p.isFirstMove() == true){
								if (game.checkFirstMoveSum(tmpTiles) == false){
									valid = false;
									System.out.println("The sum of sll tiles in first move should be larger than 30, please retry.");
								}else if (valid){
									// change the first move value to false if the set is valid
									p.changeFirstMove();
								}
							}
							
							// if validated, add to pool
							if (valid) {
								game.addSetToPool(tmpTiles);
								// remove the tiles from the player
								p.removeTileSet(tmpTiles);
							}
							break;

						case "2":
							// 2. Add to Set
							try {
								System.out.println("Which set in the pool you what to add to?");
								String interactSetInput = scanner.nextLine();
								TileSet interactSet = tmpPool.getTileSetByIndex(Integer.parseInt(interactSetInput) - 1);
								System.out.println(
										"Please select the numbers of your tiles you want to play.\n*Note: Seperate by spaces.");
								input = scanner.nextLine();
								numbers = input.split(" ");
								tmpTiles = (TileSet) interactSet.clone();
								for (int i = 0; i < numbers.length; i++) {
										Tile t = p.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
										tmpTiles.addToSet(t);
										if (tmpTiles.checkIfTileSetAvailable()) {
											
										}
								}
							} catch (NumberFormatException e) {
								System.out.println("Only numbers are avaliable, please retry.");
							}
							break;
						case "3":
							// 3. Move tile to new set
							break;
						case "4":
							// 4. Move to set
							break;
						case "5":
							// 5. Reset
							break;	
						case "6":
							// 6. End Turn
							endTurn = true;
							if (game.validPool(tmpPool)) {
								List<TileSet> sets = tmpPool.getListSet();
								game.replacePoolTileSets(sets);
							} else {
								System.out.println("Invalid pool, please input again next round.");
							}
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
			game.endGame();

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