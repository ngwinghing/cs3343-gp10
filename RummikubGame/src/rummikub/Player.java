package rummikub;

public class Player {

	String name;
	Rack rack;

	public Player(String name) {
		this.name = name;
		rack = new Rack();
	}

	public String getName() {
		return name;
	}
	
	public void addTileToRack(Tiles t) {
		rack.rackSetUp(t);
	}
}
