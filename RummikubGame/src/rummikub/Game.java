package rummikub;

import java.util.ArrayList;
import java.util.List;

import tile.*;
import ui.*;

public class Game {
	private static List<Player> players;
	private AllTiles allTiles;
	private Pool pool;
	private int round = 0;

	public Game() {
		players = new ArrayList<Player>();
		allTiles = new AllTiles();
		pool = new Pool();
	}

	public void addPlayer(Player p) {
		players.add(p);
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

	public Player getRoundPlayer() {
		return getRoundPlayer(round);
	}

	public Player getRoundPlayer(int round) {
		int numberOfPlayers = players.size();
		int playerIndex = (round % numberOfPlayers);
		if (playerIndex == 0) {
			playerIndex = numberOfPlayers - 1;
		} else {
			playerIndex--;
		}
		Player roundPlayer = players.get(playerIndex);
		return roundPlayer;
	}

	public void draw(Player p) {
		p.addTileToRack(allTiles.popFromStack());
	}

	public void addSetsToPool(TileSet set) {
		pool.addSetToPool(set);
	}

	public boolean notEnd() {
		for (Player p : players) {
			if (p.notHavingTilesInRack()) {
				System.out.println("Used all tiles from rack, win!");
				return false;
			}
		} 
		
		if (allTiles.isEmpty()) {
			System.out.println("All tiles were drawn.");
			return false;
		}
		return true;
	}

	public void addSetToPool(TileSet set) {
		pool.addSetToPool(set);
		System.out.println("You have added " + set + "to the pool.");
	}

	public Tile getTileFromAllTiles(int i) {
		return allTiles.getTile(i);
	}

	public void start() {
		distributeTile();
		do {
			System.out.println("\n################ ROUND ################");	
			round++;
			new Round(this);
		} while (notEnd());
	}

	public boolean validPool() {
		return pool.valid();
	}
	
	public boolean emptyPool() {
		return pool.isEmpty();
	}

	public void replacePoolTileSets(List<TileSet> sets) {
		pool.replaceTileSet(sets);
	}

	public TileSet getTileSetByIndex(int i) {
		return pool.getTileSetByIndex(i);
	}
}