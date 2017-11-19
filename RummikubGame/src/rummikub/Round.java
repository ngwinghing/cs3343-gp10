package rummikub;

import java.util.ArrayList;
import java.util.List;

public class Round extends GameUI {
	Player roundPlayer;

	boolean endTurn = false;
	boolean moved = false;

	Pool backUpPool;
	List<Tile> played;

	public Round(Game game) {
		super(game);
	}

	@Override
	public void output() {
		System.out.println("\nPool: ");
		game.printPool();
		played = new ArrayList<>();
		try {
			backUpPool = game.getPool().clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		roundPlayer = game.getRoundPlayer();

		printRackLine(roundPlayer);

		do {
			System.out.println("=====================================");
			System.out.println("Please choose your options: ");
			System.out.println("=====================================");
			String options = "";
			options += "1. Draw\n";
			options += "2. New set\n";
			options += "3. Add tile(s) from rack to a set\n";
			options += "4. Move tile(s) in a set to a new set\n";
			options += "5. Move tile(s) in a set to another set\n";
			options += "6. Reset\n";
			options += "7. Sort by number\n";
			options += "8. Sort by color\n";
			options += "9. End Turn\n";
			System.out.println(options);
			System.out.println("-------------------------------------");

			String option = scanner.nextLine();

			optionSwitch(option);
		} while (!endTurn);
	}

	private void optionSwitch(String option) {
		switch (option) {
		case "1":
			new CmdDraw(game, roundPlayer).execute();
			endTurn = true;
			break;

		case "2":
			// New Set
			System.out.println("Which [tile(s)] in the rack?\n *Note: Seperate by spaces.");
			String input = scanner.nextLine();
			String[] numbers = input.split(" ");

			TileSet tmpTiles = new TileSet();

			System.out.println("You have chosen: ");
			for (int i = 0; i < numbers.length; i++) {
				Tile t = roundPlayer.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
				System.out.println(t);
				tmpTiles.addToSet(t);
				played.add(t);
			}

			System.out.println("tmpTiles: " + tmpTiles);
			new CmdNewSet(game, roundPlayer, tmpTiles).execute();
			break;
		case "3":
			// Add tile(s) to a Set
			System.out.println("Which [set] in the pool you what to add tile(s) to?");
			String sourceSetInput = scanner.nextLine();
			TileSet sourceSet = game.getTileSetByIndex(Integer.parseInt(sourceSetInput) - 1);
			List<Tile> set = new ArrayList<>();

			System.out.println("You have chosen " + sourceSet);

			System.out.println("Which [tile(s)] in the rack?\n *Note: Seperate by spaces.");
			input = scanner.nextLine();
			numbers = input.split(" ");

			System.out.println("You have chosen: ");
			for (int i = 0; i < numbers.length; i++) {
				Tile t = roundPlayer.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
				System.out.println(t);
				set.add(t);
				played.add(t);
			}

			new CmdAddToSet(game, roundPlayer, sourceSet, set).execute();
			break;
		case "4":
			// Move tile to new set
			System.out.println("Which [set] in the pool you want to move to a new set?");
			sourceSetInput = scanner.nextLine();
			sourceSet = game.getTileSetByIndex(Integer.parseInt(sourceSetInput) - 1);

			System.out.println("You have chosen " + sourceSet);

			System.out.println("Which [tile(s)] in the set?\n *Note: Seperate by spaces.");
			input = scanner.nextLine();
			numbers = input.split(" ");

			set = new ArrayList<>();

			System.out.println("You have chosen: ");
			for (int i = 0; i < numbers.length; i++) {
				Tile t = sourceSet.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
				set.add(t);
			}
			new CmdMoveToNewSet(game, roundPlayer, sourceSet, set).execute();
			break;
		case "5":
			// Move Tile(s) in a set to another set
			System.out.println("Which [set] in the pool you want to move?");
			sourceSetInput = scanner.nextLine();
			sourceSet = game.getTileSetByIndex(Integer.parseInt(sourceSetInput) - 1);

			System.out.println("Which tile(s) in the set?");
			input = scanner.nextLine();
			numbers = input.split(" ");

			set = new ArrayList<>();

			System.out.println("You have chosen: ");
			for (int i = 0; i < numbers.length; i++) {
				Tile t = sourceSet.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
				set.add(t);
			}

			System.out.println("Move to which [set]?");
			String destinationSetInput = scanner.nextLine();
			TileSet destinationSet = game.getTileSetByIndex(Integer.parseInt(destinationSetInput) - 1);

			new CmdMoveToExitingSet(game, roundPlayer, sourceSet, destinationSet, set).execute();
			break;
		case "6":
			// Reset
			backup();
			break;
		case "7":
			// Sort by number
			roundPlayer.sortByNumber();
			printRackLine(roundPlayer);
			break;
		case "8":
			// Sort by color
			roundPlayer.sortByColor();
			printRackLine(roundPlayer);
			break;
		case "9":
			endTurn = true;
			
			CmdEndTurn e = new CmdEndTurn(game, roundPlayer, played);
			e.execute();
			if (e.getNeedBackup())
				backup();
			break;
		default:
			System.out.println("Please input an avaliable option number.");
		}

		System.out.println("\nCurrentPool: ");
		game.printPool();

		printRackLine(roundPlayer);
	}

	private void backup() {
		List<TileSet> sets = backUpPool.getListSet();
		game.replacePoolTileSets(sets);
		for (Tile t : played) {
			roundPlayer.addTileToRack(t);
		}
	}

	private static void printRackLine(Player roundPlayer) {
		System.out.println("\nYour Rack: ");
		System.out.println(roundPlayer.rack);
	}
}
