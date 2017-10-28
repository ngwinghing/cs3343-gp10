package rummikub;

import java.util.ArrayList;
import java.util.List;

public class TileSet {
	private List<Tiles> sets;
	
	public TileSet(List<Tiles> tiles) {
		sets = new ArrayList<>();
		boolean run = checkRun(tiles);
		boolean group = checkGroup(tiles);
		if (run && group)
			System.out.println("error");
		else if (run)
			sets.addAll(tiles);
		else if (group)
			sets.addAll(tiles);
	}

	private boolean checkRun(List<Tiles> tiles) {
		return true;
	}
	
	private boolean checkGroup(List<Tiles> tiles) {
		return true;
	}
}
