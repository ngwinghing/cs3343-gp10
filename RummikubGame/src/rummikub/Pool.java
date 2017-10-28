package rummikub;

import java.util.ArrayList;
import java.util.List;

//a class that contains the tiles that the player played


public class Pool {
	private List<List<TileSet>> sets = new ArrayList<>();
	
	public Pool() {
		
	}
	
	public void addSetsToPool(List<TileSet> s) {
		sets.add(s);
	}
	
	@Override
	public String toString() {
		String output = "";
		int i = 1;
		for (List<TileSet> s : sets) {
			output += i + ". \t";
			output += s + " \n";
			i++;
		}
		if (output == "") {
			return "No Tile.";
		}
		return output;
	}

}
