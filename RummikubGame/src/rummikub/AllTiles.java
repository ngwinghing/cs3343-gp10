package rummikub;

import java.util.Collections;
import java.util.LinkedList;

public class AllTiles {
	
	private LinkedList<Tiles> allTiles = new LinkedList<Tiles>();

	// constructor
	public AllTiles() {
		// 104 tiles
		for (int i = 0; i < 13; i++) {
			for (Color c : Color.values()) {
				if (c == Color.Joker) {
					continue;
				}
				allTiles.add(new Tiles(i % 13 + 1, c));
				allTiles.add(new Tiles(i % 13 + 1, c));
			}
		}

		// 2 Jokers
		for (int i = 0; i < 2; i++) {
			allTiles.add(new Tiles(i + 1, Color.Joker));
		}
		
		Collections.shuffle(allTiles);
	}
	
	public Tiles popFromStack() {
		return allTiles.pop();
	}
	
	public boolean isEmpty() {
		if (allTiles.isEmpty())
			return true;
		return false;
	}
	
	public @Override String toString() {
		for (Tiles t: allTiles) {
			System.out.println(t);
		}
		return "";	
	}
	
}
