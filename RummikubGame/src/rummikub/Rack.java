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
	
	public void sortRackByColor() {
		//sort rack by color then number
	}
	
	public void sortRackByNumber() {
		//sort rack by Number then Rack
	}

	@Override
	public String toString() {
		String output = "";
		int i = 1;
		for (Tiles t : rack) {
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
}
