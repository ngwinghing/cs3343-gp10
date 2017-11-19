package rummikub;

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

	public Tile getTileByIndex(int i) {
		return rack.getTile(i);
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

	public void removeTileSet(TileSet set) {
		for (Tile t: set.getSets())
			rack.removeTile(t);
	}

	public int getRackSize() {
		return rack.getsize();
	}

	public void removeTile(Tile t) {
		rack.removeTile(t);
	}

	public Rack getRack() {
		return rack;
	}
}
