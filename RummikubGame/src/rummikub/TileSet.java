package rummikub;

import java.util.ArrayList;
import java.util.List;

public class TileSet {
	private List<List<Tile>> sets;
	
	public TileSet(List<Tile> tile) {
		sets = new ArrayList<>();
		sets.add(tile);
	}

	public List<List<Tile>> getSets() {
		return sets;
	}
	
	@Override
	public String toString() {
		String output = "";
		for (List<Tile> t : sets) {
			output += t + " \n";
		}
		if (output == "") {
			return "No Tile.";
		}
		return output;
	}
	
}
