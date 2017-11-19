package rummikub;

import java.util.List;

public class CmdEndTurn implements Command {

	Game game;
	Player roundPlayer;
	List<Tile> played;
	boolean needBackup = true;
	
	public CmdEndTurn(Game game, Player roundPlayer, List<Tile> played) {
		this.game = game;
		this.roundPlayer = roundPlayer;
		this.played = played;
	}

	public void execute() {
		if (game.emptyPool()) {
			needBackup = false;
			game.draw(roundPlayer);
			System.out.println("\n ** As you have not move any tile, draw one tile for this round.");
		} else if (roundPlayer.isFirstMove()) {
			int setSum = 0;
			for (Tile t : played) {
				setSum += t.getValue();
			}
			System.out.println(setSum);
			if (setSum < 30) {
				System.err.println("The sum of sll tiles in first move should be larger than 30, please retry.");
			} else {
				roundPlayer.changeFirstMove();
			}
		} else if (!game.validPool()) {
			System.err.println("Invalid pool, please input again next round.");
			game.draw(roundPlayer);
			System.out.println("\n ** As you have not move any tile, draw one tile for this round.");
		}
	}
	
	public boolean getNeedBackup() {
		return needBackup;
	}

}
