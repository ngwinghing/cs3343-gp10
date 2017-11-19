package rummikub;

public class CmdNewSet implements Command {

	Game game;
	Player player;
	TileSet tmpTiles;
	boolean valid;
	
	public CmdNewSet(Game game, Player player, TileSet set) {
		this.game = game;
		this.player = player;
		this.tmpTiles = set;
	}
	
	@Override
	public void execute() {
		// validate user inputed tiles
		valid = tmpTiles.checkIfTileSetAvailable();
		
		// if validated, add to pool
		if (valid) {
			game.addSetToPool(tmpTiles);
			// remove the tiles from the player
			player.removeTileSet(tmpTiles);
			//moved = true;
		} else {
			System.err.println("Please input valid set again.");
		}
	}
}
