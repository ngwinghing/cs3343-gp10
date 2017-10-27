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
	
	

}
