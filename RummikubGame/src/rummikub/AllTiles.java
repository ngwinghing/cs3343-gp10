package rummikub;

import java.util.Collections;
import java.util.LinkedList;

public class AllTiles {

	// singleton
	private static LinkedList<Tiles> allTiles;

	// constructor
	public AllTiles() {
		allTiles = new LinkedList<Tiles>();

		// 104 tiles
		for (int i = 0; i < 26; i++)
			for (Color c : Color.values()) {
				if (c == Color.Joker)
					continue;
				allTiles.add(new Tiles(i % 13 + 1, c));
			}

		// 2 Jokers
		for (int i = 0; i < 2; i++)
			allTiles.add(new Tiles(i + 1, Color.Joker));

		Collections.shuffle(allTiles);
	}

	public static LinkedList<Tiles> getInstance() {
		return allTiles;

	}
	
	public static Tiles popFromStack(){
		return allTiles.pop();
	}
//ignore
    //ffff
}
