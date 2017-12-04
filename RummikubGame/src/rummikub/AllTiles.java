package rummikub;

import java.util.Collections;
import java.util.LinkedList;

import tile.Color;
import tile.Tile;

public class AllTiles {
	
	protected LinkedList<Tile> allTiles = new LinkedList<Tile>();

	// constructor
	public AllTiles() {
		// 104 tiles
		for (int i = 0; i < 13; i++) {
			for (Color c : Color.values()) {
				if (c == Color.Joker) {
					continue;
				}
				allTiles.add(new Tile(i % 13 + 1, c));
				allTiles.add(new Tile(i % 13 + 1, c));
			}
		}

		// 2 Jokers
		for (int i = 0; i < 2; i++) {
			allTiles.add(new Tile(Color.Joker));
		}
		
		Collections.shuffle(allTiles);
	}
	
	public Tile popFromStack() {
		return allTiles.pop();
	}
	
	public boolean isEmpty() {
		if (allTiles.isEmpty())
			return true;
		return false;
	}

	public Tile getTile(int i) {
		return allTiles.get(i);
	}
	
}
