package rummikub;

import java.util.ArrayList;
import java.util.List;

public class TileSet {
	private List<Tile> sets;
	
	public TileSet(List<Tile> tile) {
		sets = new ArrayList<>();
		sets.addAll(tile);
	}
	
	public void addToSet(Tile tile) {
		sets.add(tile);
	}
	
	public void removeFromSet(Tile tile) {
		sets.remove(tile);
	}
	
	public List<Tile> getSets() {
		return sets;
	}
	
	@Override
	public String toString() {
		String output = "";
		for (Tile t : sets) {
			output += t + " ";
		}
		if (output == "") {
			return "No Tile.";
		}
		return output;
	}

	
}
