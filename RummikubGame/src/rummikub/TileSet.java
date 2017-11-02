package rummikub;

import java.util.ArrayList;
import java.util.List;

public class TileSet {
	private List<Tile> sets;
	
	public TileSet() {
		sets = new ArrayList<>();
	}
	
	public void addTileToSet(Tile t) {
		sets.add(t);
	}

	public List<Tile> getSets() {
		return sets;
	}
}
