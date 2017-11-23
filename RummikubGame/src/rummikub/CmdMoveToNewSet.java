package rummikub;

import java.util.List;

public class CmdMoveToNewSet implements Command {

	Game game;
	Player player;
	TileSet interactSet;
	List<Tile> tmpTiles;
	
	public CmdMoveToNewSet(Game game, Player player, TileSet interactSet, List<Tile> set) {
		this.game = game;
		this.player = player;
		this.interactSet = interactSet;
		this.tmpTiles = set;
	}

	@Override
	public void execute() {
		TileSet tileSet = new TileSet();
		for (Tile t : tmpTiles) {
			interactSet.removeFromSet(t);
			tileSet.addToSet(t);
		}
		game.addSetToPool(tileSet);
	}

}
