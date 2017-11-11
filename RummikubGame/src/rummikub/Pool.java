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
	public Object clone() throws CloneNotSupportedException {
		return (Pool) super.clone();
	}

	public boolean valid() {
		boolean valid = true;
		for (TileSet s: sets) {
			if (!s.checkIfTileSetAvailable()) {
				valid = false;
			}
		}
		return valid;
	}

	public List<TileSet> getListSet() {
		return sets;
	}

	public void replaceTileSet(List<TileSet> sets) {
		this.sets = sets;
	}

	public TileSet getTileSetByIndex(int i) {
		return sets.get(i);
	}
}
