package rummikub;

public class CmdDraw implements Command {

	Game game;
	Player player;
	
	public CmdDraw(Game game, Player player) {
		this.game = game;
		this.player = player;
	}
	
	@Override
	public void execute() {
		game.draw(player);
	}

}
