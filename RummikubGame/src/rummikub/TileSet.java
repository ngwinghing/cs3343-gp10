package rummikub;

import java.util.ArrayList;
import java.util.List;

public class TileSet {
	private List<Tile> sets;
	
	public TileSet(List<Tile> tile) {
		sets = new ArrayList<>();
		boolean run = checkRun(tile);
		boolean group = checkGroup(tile);
		if (run && group)
			System.out.println("error");
		else if (run)
			sets.addAll(tile);
		else if (group)
			sets.addAll(tile);
	}

	private boolean checkRun(List<Tile> tile) {
		return true;
	}
	
	private boolean checkGroup(List<Tile> tile) {
		return true;
	}
}
