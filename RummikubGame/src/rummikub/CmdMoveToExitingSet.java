package rummikub;

import java.util.List;

public class CmdMoveToExitingSet implements Command {

	Game game;
	Player player;
	TileSet sourceSet;
	TileSet destinationSet;
	List<Tile> tmpTiles;

	public CmdMoveToExitingSet(Game game, Player player, TileSet sourceSet, TileSet destinationSet, List<Tile> set) {
		this.game = game;
		this.player = player;
		this.sourceSet = sourceSet;
		this.destinationSet = destinationSet;
		this.tmpTiles = set;
	}

	@Override
	public void execute() {
		for (Tile t : tmpTiles) {
			destinationSet.addToSet(t);
			// remove tiles from old set
			sourceSet.removeFromSet(t);
		}
	}

}
