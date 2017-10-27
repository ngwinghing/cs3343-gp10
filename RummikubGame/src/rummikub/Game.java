package rummikub;

import java.util.ArrayList;
import java.util.List;

public class Game {
	List<Player> players = new ArrayList<Player>();
	AllTiles allTiles = new AllTiles();
	
	public Game() {
		System.out.println("\nNew Game Start!");
		System.out.println("\nList of Tiles: ");
		System.out.println(allTiles.toString());
	}
	
	public void setPlayer(Player p) {
		players.add(p);
	}
	
	public void distributeTile() {
		for (Player p: players) {
			for (int i=0;i<14;i++) {
				p.addTileToRack(allTiles.popFromStack());
			}
		}
	}
}
