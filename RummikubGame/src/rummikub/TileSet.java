package rummikub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileSet implements Cloneable {
	private List<Tile> set;

	public TileSet() {
		set = new ArrayList<>();
	}

	public Tile getTileByIndex(int i) {
		return set.get(i);
	}

	public void addToSet(Tile tile) {
		set.add(tile);
	}

	public void removeFromSet(Tile tile) {
		set.remove(tile);
	}

	public List<Tile> getSets() {
		return set;
	}

	@Override
	public String toString() {
		String output = "";
		for (Tile t : set) {
			output += t + " ";
		}
		if (output == "") {
			return "No Tile.";
		}
		return output;
	}

	public void sortByNumber() {
		Collections.sort(set);
	}

	public void sortByColor() {
		Collections.sort(set);
		Collections.sort(set, Tile.TileColorComparator);
	}

	// check each tile color sort by color->check color same?-> check difference by
	// 1? 123
	private boolean checkRun() {
		if (set.size() < 3) {
			return false;
		}

		sortByColor();

		int tileValue = 0;
		Color tileColor = null;
		boolean sameColor = true;
		boolean consecutive = true;

		for (Tile t : set) {
			if (tileValue == 0) {
				tileValue = t.getValue();
			}

			if (tileColor == null) {
				tileColor = t.getColor();
			}

			if (t.getValue() != tileValue++) {
				consecutive = false;
				break;
			}

			if (tileColor != t.getColor()) {
				sameColor = false;
				break;
			}

		}
		return sameColor && consecutive;
	}

	private boolean checkGroup() {
		sortByNumber();
		
		int tileValue = 0;
		List<Color> colors = new ArrayList<>();

		for (Tile t : set) {
			if (tileValue == 0) {
				tileValue = t.getValue();
			}

			if (t.getValue() != tileValue) {
				if (t.getColor() != Color.Joker) {
					return false;
				}
			}

			if (!colors.contains(t.getColor())) {
				colors.add(t.getColor());
			}
		}

		if (colors.size() < 3) {
			return false;
		}

		return true;
	}

	public boolean checkIfTileSetAvailable() {
		boolean run = checkRun();
		boolean group = checkGroup();
		return (run || group);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		TileSet copy = new TileSet();
		for (Tile t : set)
			copy.addToSet(t);
		return copy;
	}
}