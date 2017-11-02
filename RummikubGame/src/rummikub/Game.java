package rummikub;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private static List<Player> players;
	private static AllTiles allTiles;
	private static Pool pool;
	private static Game instance = new Game();

	private Game() {
		players = new ArrayList<Player>();
		allTiles = new AllTiles();
		pool = new Pool();
		//System.out.println("\nNew Game Start!");
	}
	
	public static Game getInstance() {
		return instance;
	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	public void printPool() {
		System.out.println(pool);
	}

	public void distributeTile() {
		for (Player p : players) {
			for (int i = 0; i < 14; i++) {
				p.addTileToRack(allTiles.popFromStack());
			}
		}
	}

	public void availableOptions(Player p) {
		String options = "";
		options += "1. Draw\n";
		options += "2. Play a set\n";
		options += "3. Sort by number\n";
		options += "4. Sort by color\n";
		System.out.println(options);
	}

	public void draw(Player p) {
		p.addTileToRack(allTiles.popFromStack());
	}
	
	public void addSetsToPool(Player p, List<Integer> num) {
		
		for (int i: num) {
			
		}
		TileSet ts = new TileSet();
		pool.addSetsToPool(ts);
	}

	public boolean notEnd() {
		if (allTiles.isEmpty()) {
			return false;
		}
		for (Player p: players) {
			if (p.notHavingTilesInRack()) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkRun(List<Tile> tile) {
		return true;
	}
	
	private boolean checkGroup(List<Tile> tile) {
		return false;
	}
	
	public boolean checkIfTileSetAvailable(List<Tile> tiles) {
		boolean run = checkRun(tiles);
		boolean group = checkGroup(tiles);
		if (run && group)
			return false;
		else if (run)
			return true;
		else if (group)
			return true;
		else
			return false;
	}
}
