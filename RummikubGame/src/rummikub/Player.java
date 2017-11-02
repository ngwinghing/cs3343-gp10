package rummikub;

import java.util.List;

public class Player {
	String name;
	Rack rack;
	boolean firstMove = true;

	public Player(String name) {
		this.name = name;
		rack = new Rack();
	}

	public String getName() {
		return name;
	}
	
	public void changeFirstMove() {
		firstMove = false;
	}
	
	public boolean isFirstMove() {
		return firstMove;
	}
	
	public void addTileToRack(Tile t) {
		rack.addTile(t);
	}

	public boolean notHavingTilesInRack() {
		if (rack.isEmpty())
			return true;
		return false;
	}

	public void sortByNumber() {
		rack.sortByNumber();
	}
	
	public void sortByColor() {
		rack.sortByColor();
	}

	public Tile getTileByIndex(int i) {
		return rack.getTile(i);
	}
	
	public void removeTileFromRack(Tile t) {
		rack.removeTile(t);
	}
	
	
}
