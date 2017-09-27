package rummikub;

public class Card {
	private Color color;

	private int value;
	
	public Card(Color color, int value) {
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
