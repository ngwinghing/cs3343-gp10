package rummikub;

import java.util.ArrayList;
import java.util.List;

//a class that contains the tiles that the player played

public class Pool implements Cloneable {
	private List<TileSet> sets;

	public Pool() {
		sets = new ArrayList<>();
	}

	public void addSetToPool(TileSet set) {
		sets.add(set);
	}
	
	public void addToSet(int setIndex, Tile tile) {
		sets.get(setIndex).addToSet(tile);
	}
	
	public void removeFromSet(int setIndex, Tile tile){
		sets.get(setIndex).removeFromSet(tile);
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

	@Override
	public Pool clone() throws CloneNotSupportedException {
		return (Pool) super.clone();
	}

}
