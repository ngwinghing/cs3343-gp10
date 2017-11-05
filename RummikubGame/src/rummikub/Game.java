package rummikub;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private static List<Player> players;
	private static AllTiles allTiles;
	private static Pool pool;

	public Game() {
		players = new ArrayList<Player>();
		allTiles = new AllTiles();
		pool = new Pool();
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

	public void availableOptions() {
		String options = "";
		options += "1. Draw\n";
		options += "2. Play a set\n";
		options += "3. Sort by number\n";
		options += "4. Sort by color\n";
		System.out.println(options);
	}
	
	public void availablePlayOptions() {
		String options = "";
		options += "1. New Set\n";
		options += "2. Add to Set\n";
		options += "3. Move tile to new set\n";
		options += "4. Move to set\n";
		System.out.println(options);
	}

	public void draw(Player p) {
		p.addTileToRack(allTiles.popFromStack());
	}
	
	public void addSetsToPool(TileSet set) {
		pool.addSetToPool(set);
	}

	public boolean notEnd() {
		if (allTiles.isEmpty()) {
			System.out.println("All tiles were drawn.");
			return false;
		}
		
		for (Player p: players) {
			if (p.notHavingTilesInRack()) {
				System.out.println("Used all tiles from rack, win!");
				return false;
			}
			else if (p.havingTwentyFourTilesInRack()){
				System.out.println("Exceed 24 cards in rack, lose!");
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

	public void addSetToPool(TileSet set) {
		pool.addSetToPool(set);
	}
}