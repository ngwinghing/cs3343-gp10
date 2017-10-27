package rummikub;

import java.util.LinkedList;

public class Rack {

	public LinkedList<Tiles> rack;

	public Rack() {
		rack = new LinkedList<Tiles>();
	}
	
	public void rackSetUp(Tiles t) {
		rack.add(t);
	}

	@Override
	public String toString() {
		String output = "[ ";
		for (Tiles t : rack) {
			output += t + " ";
		}
		output += "]";
		return output;
	}
}
