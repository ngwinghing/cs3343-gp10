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
	}

	public void addPlayer(Player p) {
		players.add(p);
	}
	
	public void removePlayer(Player p) {
		players.remove(p);
	}

	public Pool getPool() {
		return pool;
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
		options += "5. Undo\n";
		options += "6. Sort by number\n";
		options += "7. Sort by color\n";
		options += "8. End Turn\n";
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

	public void addSetToPool(TileSet set) {
		pool.addSetToPool(set);
		System.out.println("You have added " + set + "to the pool.");
	}

	public static Game getInstance() {
		return instance;
	}

	public void endGame() {
		//reset all
		players.removeAll(players);
		allTiles = new AllTiles();
		pool = new Pool();
	}

	public boolean validPool(Pool p) {
		return p.valid();
	}

	public void replacePoolTileSets(List<TileSet> sets) {
		pool.replaceTileSet(sets);
	}

	public boolean checkFirstMoveSum(TileSet tmpTiles){
		int sum = 0;
		List<Tile> set = tmpTiles.getSets();
		for(Tile t: set){
			sum += t.getValue();
		}
		return sum >= 30;
	}
}