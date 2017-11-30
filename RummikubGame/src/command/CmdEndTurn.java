package command;

import java.util.List;

import rummikub.*;
import tile.*;

public class CmdEndTurn implements Command {

	Game game;
	Player roundPlayer;
	List<Tile> played;
	boolean needBackup = false;

	public CmdEndTurn(Game game, Player roundPlayer, List<Tile> played) {
		this.game = game;
		this.roundPlayer = roundPlayer;
		this.played = played;
	}

	public void execute() {
		if (game.emptyPool()) {
			drawWithError();
			needBackup = false;
		} else if (played.isEmpty()) {
			drawWithError();
			needBackup = true;
		} else if (!game.validPool()) {
			System.err.println("Invalid pool, please input again next round.");
			drawWithError();
			needBackup = true;
		} else if (roundPlayer.isFirstMove()) {
			int setSum = 0;
			for (Tile t : played) {
				setSum += t.getValue();
			}
			if (setSum < 30) {
				drawWithError();
				System.err.println("The sum of all tiles in first move should be larger than 30, please retry.");
				needBackup = true;
			} else {
				roundPlayer.changeFirstMove();
			}
		}
	}

	private void drawWithError() {
		game.draw(roundPlayer);
		System.out.println("\n ** As you have not move any tile, draw one tile for this round.");
	}

	public boolean getNeedBackup() {
		return needBackup;
	}

}
