package command;

import rummikub.Game;
import rummikub.Player;

public class CmdDraw implements Command {

	Game game;
	Player player;
	
	public CmdDraw(Game game, Player player) {
		this.game = game;
		this.player = player;
	}

	public void execute() {
		game.draw(player);
	}

}
