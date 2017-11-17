package rummikub;

import java.util.Comparator;

public class Tile implements Comparable<Tile> {

	private int value;
	private Color color;
	
	public Tile(Color color) {
		this.value = 100;
		this.color = color;
	}

	public Tile(int value, Color color) {
		this.value = value;
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public int getValue() {
		return this.value;
	}

	public @Override String toString() {
		if (this.color.equals(Color.Joker)) {
			return "[ " + color + " ] ";
		} else {
			return "[ " + color + " " + value + " ] ";
		}
	}

	@Override
	public int compareTo(Tile t) {
		return this.getValue() - t.getValue();
	}

	public static Comparator<Tile> TileColorComparator = new Comparator<Tile>() {

		public int compare(Tile tile1, Tile tile2) {

			Color tileColor1 = tile1.getColor();
			Color tileColor2 = tile2.getColor();

			// ascending order
			return tileColor1.compareTo(tileColor2);
		}

	};

}
