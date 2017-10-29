package rummikub;

import java.util.ArrayList;
import java.util.List;

public class Player {
	String name;
	Rack rack;
	boolean firstMove = true;
	List<Option> options;

	public Player(String name) {
		this.name = name;
		rack = new Rack();
		options = new ArrayList<>();
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
	
	public void addTileToRack(Tiles t) {
		rack.addTile(t);
	}

	public boolean notHavingTilesInRack() {
		if (rack.isEmpty())
			return true;
		return false;
	}
}
