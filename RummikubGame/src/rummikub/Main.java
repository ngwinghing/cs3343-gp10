package rummikub;

public class Main {

	public static void main(String args[]) throws CloneNotSupportedException {

<<<<<<< HEAD
		String playerName;
		Scanner scanner = new Scanner(System.in);
		boolean replay = false;

		System.out.println("\n***New Game Start!***\n");
		System.out.println("What's your name?");
		// playerName = scanner.nextLine();
		playerName = "Wing";

		System.out.println("Welcome, " + playerName);

		Player p = new Player(playerName);

		do {
			Game game = new Game();
			game.addPlayer(p);
			game.distributeTile();

			do {
				System.out.println("\nPool: ");
				game.printPool();

				printRackLine(p);

				System.out.println("=====================================");
				System.out.println("Please choose your options: ");
				System.out.println("=====================================");
				String options = "";
				options += "1. Draw\n";
				options += "2. Play a set\n";
				options += "3. Sort by number\n";
				options += "4. Sort by color\n";
				System.out.println(options);
				System.out.println("-------------------------------------");

				String option = scanner.nextLine();

				switch (option) {
				case "1":
					game.draw(p);
					break;

				case "2":
					boolean endTurn = false;
					boolean moved = false;
					Pool backUpPool = (Pool) game.getPool().clone();
					List<Tile> played = new ArrayList<Tile>();
					System.out.println("backup = " + backUpPool);
					
					//check firstMove sum
					int setSum = 0;
					
					do {
						System.out.println("\nCurrentPool: ");
						game.printPool();
						
						System.out.println("backup = " + backUpPool);

						printRackLine(p);

						System.out.println("=====================================");
						System.out.println("2: Please choose your play options: ");
						System.out.println("=====================================");
						String playOptions = "";
						playOptions += "1. New Set\n";
						playOptions += "2. Add to Set\n";
						playOptions += "3. Move tile to new set\n";
						playOptions += "4. Move to set\n";
						playOptions += "5. Reset\n";
						playOptions += "6. Sort by number\n";
						playOptions += "7. Sort by color\n";
						playOptions += "8. End Turn\n";
						System.out.println(playOptions);
						System.out.println("-------------------------------------");
						String playOption = scanner.nextLine();

						
						
						
						switch (playOption) {

						case "1":
							// 1. New Set
							System.out.println(
									"Which [tile(s)] in the rack? *Note: Seperate by spaces.");
							String input = scanner.nextLine();
							String[] numbers = input.split(" ");
							TileSet tmpTiles = new TileSet();
							for (int i = 0; i < numbers.length; i++) {
								try {
									Tile t = p.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
									tmpTiles.addToSet(t);
									played.add(t);
								} catch (NumberFormatException e) {
									System.err.println("Only numbers are avaliable, please retry.");
								} catch (IndexOutOfBoundsException e) {
									System.err.println("Please retry with available numbers.");
								}
							}
							// validate user inputed tiles
							boolean valid = tmpTiles.checkIfTileSetAvailable();

							// check sum of tiles if it is first move
							if (p.isFirstMove()) {
								setSum += game.calSetValueSum(tmpTiles);
							}

							// if validated, add to pool
							if (valid) {
								game.addSetToPool(tmpTiles);
								// remove the tiles from the player
								p.removeTileSet(tmpTiles);
								moved = true;
							} else {
								System.err.println("Please input valid set again.");
							}
							break;

						case "2":
							// 2. Add tile(s) to a Set
							try {
								System.out.println("Which [set] in the pool you what to add tile(s) to?");
								String interactSetInput = scanner.nextLine();
								TileSet interactSet = game.getTileSetByIndex(Integer.parseInt(interactSetInput) - 1);
								System.out.println("You have chosen " + interactSet);
								System.out.println(
										"Which [tile(s)] in the rack?\n *Note: Seperate by spaces.");
								input = scanner.nextLine();
								numbers = input.split(" ");

								System.out.println("You have chosen: ");
								for (int i = 0; i < numbers.length; i++) {
									Tile t = p.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
									System.out.println(t);
									interactSet.addToSet(t);
									played.add(t);
									p.removeTile(t);
								}

							} catch (NumberFormatException e) {
								System.err.println("Only numbers are avaliable, please retry.");
							} catch (IndexOutOfBoundsException e) {
								System.err.println("Please retry with available numbers.");
							}
							break;
						case "3":
							// 3. Move tile to new set
							System.out.println("Which [set] in the pool you want to move to a new set?");
							String interactSetInput = scanner.nextLine();
							TileSet interactSet = game.getTileSetByIndex(Integer.parseInt(interactSetInput) - 1);
							System.out.println("You have chosen " + interactSet);
							System.out.println("Which [tile(s)] in the set?");
							input = scanner.nextLine();
							numbers = input.split(" ");
							tmpTiles = new TileSet();
							
							System.out.println("You have chosen: ");
							for (int i = 0; i < numbers.length; i++) {
								Tile t = interactSet.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
								played.add(t);
								// add tiles to a new set
								tmpTiles.addToSet(t);
								// remove tiles from old set
								interactSet.removeFromSet(t);
							}
							game.addSetToPool(tmpTiles);
							break;
						case "4":
							// 4. Move to set
							System.out.println("Which [set] in the pool you want to move?");
							interactSetInput = scanner.nextLine();
							interactSet = game.getTileSetByIndex(Integer.parseInt(interactSetInput) - 1);

							System.out.println("Which tile(s) in the set?");
							input = scanner.nextLine();
							numbers = input.split(" ");

							System.out.println("Move to which [set]?");
							interactSetInput = scanner.nextLine();
							TileSet MoveTointeractSet = game
									.getTileSetByIndex(Integer.parseInt(interactSetInput) - 1);

							for (int i = 0; i < numbers.length; i++) {
								Tile t = interactSet.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
								// add tiles to a new set
								MoveTointeractSet.addToSet(t);
								// remove tiles from old set
								interactSet.removeFromSet(t);
							}
							break;
						case "5":
							// 5. Reset
							break;
						case "6":
							// 6. Sort by number
							p.sortByNumber();
							printRackLine(p);
							break;
						case "7":
							// 7. Sort by color
							p.sortByColor();
							printRackLine(p);
							break;
						case "8":
							// 8. End Turn
							endTurn = true;
							boolean firstMoveErr = true;
							System.err.println(setSum);
							if (p.isFirstMove()){
								if (setSum < 30){
									System.err.println("The sum of sll tiles in first move should be larger than 30, please retry.");
								}else{
									p.changeFirstMove();
									firstMoveErr = false;
								}
							}
							if (!game.validPool() || firstMoveErr) {
								List<TileSet> sets = backUpPool.getListSet();
								game.replacePoolTileSets(sets);
								for (Tile t : played) {
									p.addTileToRack(t);
								}
								System.err.println("Invalid pool, please input again next round.");
								
							}
							if (!moved) {
								game.draw(p);
								System.out.println("\n ** As you have not move any tile, draw one tile for this round.");
							}
							
							break;
						default:
							System.err.println("Please input an avaliable option number.");
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
				System.out.println("\n####### --- R O U N D --- #######");

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
=======
		Game game = new Game();
		new GameInitialize(game);
		game.start();
>>>>>>> master

	}
}