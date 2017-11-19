package rummikub;

import java.util.List;

public class CmdAddToSet implements Command {

	Game game;
	Player player;
	List<Tile> tmpTiles;
	TileSet interactSet;
	
	public CmdAddToSet(Game game, Player player, TileSet interactSet, List<Tile> set) {
		this.game = game;
		this.player = player;
		this.interactSet = interactSet;
		this.tmpTiles = set;
	}

	@Override
	public void execute() {
		for (Tile t : tmpTiles) {
			interactSet.addToSet(t);
			player.removeTile(t);
		}
	}

}
