package tile;

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
	
	public int getSize() {
		return set.size();
	}

	@Override
	public String toString() {
		String output = "";
		for (Tile t : set) {
			output += t + " ";
		}
//		if (output == "") {
//			return "No Tile.";
//		}
		return output;
	}

	public void sortByNumber() {
		Collections.sort(set);
	}

	public void sortByColor() {
		Collections.sort(set);
		Collections.sort(set, Tile.TileColorComparator);
	}

	public boolean checkRun() {
		if (set.size() < 3) {
			return false;
		}

		sortByColor();

		int tileValue = 0;
		Color tileColor = null;
		boolean sameColor = true;
		boolean consecutive = true;

		int countJoker = 0;

		for (Tile t : set) {
			if (t.getColor().equals(Color.Joker))
				countJoker++;
		}

		for (int i = 0; i < set.size(); i++) {
			Tile t = set.get(i);
			if (tileValue == 0) {
				tileValue = t.getValue();
				tileColor = t.getColor();
				continue;
			}

			if (!t.getColor().equals(tileColor)) {
				if (t.getColor().equals(Color.Joker)) {
					continue;
				} else {
					sameColor = false;
					break;
				}
			}

			tileValue++;
			if (t.getValue() != tileValue) {
				if (countJoker == 0) {
					consecutive = false;
					break;
				} else {
					countJoker--;
					i--;
				}
			}
		}

		return (sameColor && consecutive);
	}

	public boolean checkGroup() {
		sortByNumber();
		int countJoker = 0;
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

			if (t.getColor() == Color.Joker) {
				countJoker++;
			}
		}

		if (colors.size() < 3) {
			if (countJoker < 2) {
				return false;
			}
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