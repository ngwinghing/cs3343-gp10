package rummikub;

public enum TileColor {
	RED("Red"),
	BLUE("Blue"),
	ORANGE("Orange"),
	BLACK("Black");
	
	private final String colorText;
	
	private TileColor(String colorText) {
		this.colorText = colorText;
	}
	
	public String getColorText() {
		return colorText;
	}

}
