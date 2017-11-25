package rummikub;

import java.util.ArrayList;
import java.util.List;

import tile.Tile;
import tile.TileSet;

//a class that contains the tiles that the player played

public class Pool {
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

	public void removeFromSet(int setIndex, Tile tile) {
		sets.get(setIndex).removeFromSet(tile);
	}

	public boolean valid() {
		for (TileSet s : sets) {
			if (!s.checkIfTileSetAvailable()) {
				return false;
			}
		}
		return true;
	}

	public boolean isEmpty() {
		if (sets.isEmpty())
			return true;
		return false;
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

	@Override
	public Pool clone() throws CloneNotSupportedException {
		Pool pool = new Pool();
		for (TileSet set : sets)
			pool.addSetToPool((TileSet) set.clone());
		return pool;
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
