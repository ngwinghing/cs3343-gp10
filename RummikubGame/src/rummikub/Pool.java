package rummikub;

import java.util.ArrayList;
import java.util.List;

//a class that contains the tiles that the player played


public class Pool {
	private List<TileSet> sets = new ArrayList<>();
	
	public Pool() {
		
	}
	
	
	
	public void addSetToPool(TileSet set) {
		sets.add(set);
	}
	
	@Override
	public String toString() {
		String output = "";
		int i = 1;
		for (TileSet s : sets) {
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
