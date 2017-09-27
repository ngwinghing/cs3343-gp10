package rummikub;

public enum Color {
	RED("Red"),
	BLUE("Blue"),
	ORANGE("Orange"),
	BLACK("Black");
	
	private final String colorText;
	
	private Color(String colorText) {
		this.colorText = colorText;
	}
	
	public String getColorText() {
		return colorText;
	}

}
