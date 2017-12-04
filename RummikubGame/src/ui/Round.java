package ui;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import command.*;
import tile.*;
import rummikub.*;

public class Round extends GameUI {
	protected Player roundPlayer;

	public boolean endTurn = false;
	boolean moved = false;

	protected Pool backUpPool;
	protected List<Tile> played;

	public Round(Game game) {
		this(game, System.in);
	}

	public Round(Game game, InputStream stream) {
		super(game, stream);
	}

	@Override
	public void output() {
		roundPlayer = game.getRoundPlayer();
		System.out.println("Round Player: " + game.getRoundPlayer().getName());
		
		System.out.println("\nPool: ");
		game.printPool();
		played = new ArrayList<>();
		try {
			backUpPool = game.getPool().clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		printRackLine(roundPlayer);

		do {
			printOptions();
		} while (!endTurn);
	}

	protected void printOptions() {
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
	}

	public void optionSwitch(String option) {
		switch (option) {
		case "1":
			draw();
			break;

		case "2":
			newSet();
			break;
		case "3":
			addTileToSet();
			break;
		case "4":
			moveToSet();
			break;
		case "5":
			moveToExistingSet();
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
			endTurn();
			break;
		default:
			System.out.println("Please input an avaliable option number.");
		}

		System.out.println("\nCurrentPool: ");
		game.printPool();

		printRackLine(roundPlayer);
	}

	private void endTurn() {
		endTurn = true;
		
		CmdEndTurn e = new CmdEndTurn(game, roundPlayer, played);
		e.execute();
		if (e.getNeedBackup()) {
			backup();
		}
		if (e.getNeedDraw()) {
			game.draw(roundPlayer);
			System.out.println("\n ** As you have not move any tile, draw one tile for this round.");
		}
	}

	private void moveToExistingSet() {
		// Move Tile(s) in a set to another set
		System.out.println("Which [set] in the pool you want to move?");
		String sourceSetInput = scanner.nextLine();
		TileSet sourceSet = game.getTileSetByIndex(Integer.parseInt(sourceSetInput) - 1);

		System.out.println("Which tile(s) in the set?");
		String input = scanner.nextLine();
		String[] numbers = input.split(" ");

		List<Tile> set = new ArrayList<>();

		System.out.println("You have chosen: ");
		for (int i = 0; i < numbers.length; i++) {
			Tile t = sourceSet.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
			set.add(t);
		}

		System.out.println("Move to which [set]?");
		String destinationSetInput = scanner.nextLine();
		TileSet destinationSet = game.getTileSetByIndex(Integer.parseInt(destinationSetInput) - 1);

		new CmdMoveToExitingSet(game, roundPlayer, sourceSet, destinationSet, set).execute();
	}

	private void moveToSet() {
		// Move tile to new set
		System.out.println("Which [set] in the pool you want to move to a new set?");
		String sourceSetInput = scanner.nextLine();
		TileSet sourceSet = game.getTileSetByIndex(Integer.parseInt(sourceSetInput) - 1);

		System.out.println("You have chosen " + sourceSet);

		System.out.println("Which [tile(s)] in the set?\n *Note: Seperate by spaces.");
		String input = scanner.nextLine();
		String[] numbers = input.split(" ");

		List<Tile> set = new ArrayList<>();

		System.out.println("You have chosen: ");
		for (int i = 0; i < numbers.length; i++) {
			Tile t = sourceSet.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
			set.add(t);
		}
		new CmdMoveToNewSet(game, roundPlayer, sourceSet, set).execute();
	}

	private void addTileToSet() {
		// Add tile(s) to a Set
		System.out.println("Which [set] in the pool you what to add tile(s) to?");
		String sourceSetInput = scanner.nextLine();
		TileSet sourceSet = game.getTileSetByIndex(Integer.parseInt(sourceSetInput) - 1);
		List<Tile> set = new ArrayList<>();

		System.out.println("You have chosen " + sourceSet);

		System.out.println("Which [tile(s)] in the rack?\n *Note: Seperate by spaces.");
		String input = scanner.nextLine();
		String[] numbers = input.split(" ");

		System.out.println("You have chosen: ");
		for (int i = 0; i < numbers.length; i++) {
			Tile t = roundPlayer.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
			System.out.println(t);
			set.add(t);
			played.add(t);
		}

		new CmdAddToSet(game, roundPlayer, sourceSet, set).execute();
	}

	private void newSet() {
		// New Set
		System.out.println("Which [tile(s)] in the rack?\n *Note: Seperate by spaces.");
		String input = scanner.nextLine();
		String[] numbers = input.split(" ");

		TileSet tmpTiles = new TileSet();

		for (int i = 0; i < numbers.length; i++) {
			Tile t = roundPlayer.getTileByIndex(Integer.parseInt(numbers[i]) - 1);
			tmpTiles.addToSet(t);
			played.add(t);
		}
		
		CmdNewSet e = new CmdNewSet(game, roundPlayer, tmpTiles);
		e.execute();
		
		if (!e.getValid()) {
			for (Tile t: tmpTiles.getSets())
				played.remove(t);
		}
	}

	private void draw() {
		new CmdDraw(game, roundPlayer).execute();
		endTurn = true;
	}

	private void backup() {
		List<TileSet> sets = backUpPool.getListSet();
		game.replacePoolTileSets(sets);
		for (Tile t : played) {
			roundPlayer.addTileToRack(t);
		}
		played.clear();
	}

	private static void printRackLine(Player roundPlayer) {
		System.out.println("\nYour Rack: ");
		System.out.println(roundPlayer.rack);
	}

	public boolean getEndTurn() {
		return endTurn;
	}
}
