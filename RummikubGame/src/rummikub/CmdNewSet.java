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

		// check sum of tiles if it is first move
		if (player.isFirstMove() == true) {
			if (game.checkFirstMoveSum(tmpTiles) == false) {
				valid = false;
				System.err.println(
						"The sum of sll tiles in first move should be larger than 30, please retry.");
				return;
			} else {
				// change the first move value to false if the set is valid
				player.changeFirstMove();
			}
		}

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
