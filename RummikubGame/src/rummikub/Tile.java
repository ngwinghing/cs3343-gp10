package rummikub;

public class Tile {
	private TileColor color;
	private int value;
	
	public Tile(TileColor color, int value) {
		this.color= color;
		this.value=value;	
	}
	
	public String getColor() {
		return color.getColorText();
	}

	public int getValue() {
		return value;
	}

}
