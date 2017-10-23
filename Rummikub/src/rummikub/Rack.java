package rummikub;

import java.util.LinkedList;

public class Rack {

	private static LinkedList<Tiles> rack;

	public Rack() {
		for (int i = 0; i < 14; i++) {
			rack.add(AllTiles.popFromStack());
		}
	}

	public LinkedList<Tiles> getInstance() {
		return rack;
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
