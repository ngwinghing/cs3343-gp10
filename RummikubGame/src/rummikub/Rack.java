package rummikub;

import java.util.Collections;
import java.util.LinkedList;

public class Rack {

	public LinkedList<Tile> rack;

	public Rack() {
		rack = new LinkedList<Tile>();
	}
	
	public void addTile(Tile t) {
		rack.add(t);
	}
	
	public void removeTile(Tile t) {
		rack.remove(t);
	}
	
	Tile getTile(int index){
		return rack.get(index);
	}
	
	public void setRack(LinkedList<Tile> newRack){
		this.rack = newRack;
	}
	
	public void sortByNumber() {
		Collections.sort(rack);
	}
	
	public void sortByColor() {
		Collections.sort(rack);
		Collections.sort(rack, Tile.TileColorComparator);
	}

	@Override
	public String toString() {
		String output = "";
		int i = 1;
		for (Tile t : rack) {
			output += i + ". \t";
			output += t + " \n";
			i++;
		}
		return output;
	}

	public boolean isEmpty() {
		if (rack.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean overTwentyFour() {
		if (rack.size()==24) {
			return true;
		}
		return false;
	}
}
