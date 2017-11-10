package rummikub;

import java.util.ArrayList;
import java.util.List;

public class TileSet {
	private List<Tile> sets;
	
	public TileSet() {
		sets = new ArrayList<>();
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
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (TileSet) super.clone();
	}

	private boolean checkRun() {
		return true;
	}
	
	private boolean checkGroup() {
		return false;
	}
	
	public boolean checkIfTileSetAvailable() {
		boolean run = checkRun();
		boolean group = checkGroup();
		if (run && group)
			return false;
		else if (run)
			return true;
		else if (group)
			return true;
		else
			return false;
	}
}
