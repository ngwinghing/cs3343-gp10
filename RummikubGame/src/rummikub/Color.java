package rummikub;

public enum Color {
	Black, Blue, Red, Yellow, Joker;

	@Override
	public String toString() {
		switch (this) {
		case Black:
			return "Black";
		case Blue:
			return "Blue";
		case Red:
			return "Red";
		case Yellow:
			return "Yellow";
		case Joker:
			return "Joker";
		default:
			return "";
		}
	}
}
