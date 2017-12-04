package command;

import java.util.List;

import rummikub.*;
import tile.*;

public class CmdEndTurn implements Command {

	Game game;
	Player roundPlayer;
	List<Tile> played;
	boolean needBackup = false;
	boolean needDraw = false;

	public CmdEndTurn(Game game, Player roundPlayer, List<Tile> played) {
		this.game = game;
		this.roundPlayer = roundPlayer;
		this.played = played;
	}

	public void execute() {
		if (game.emptyPool()) {
			needDraw = true;
			needBackup = false;
		} else if (played.isEmpty()) {
			needDraw = true;
			needBackup = true;
		} else if (!game.validPool()) {
			System.err.println("Invalid pool, please input again next round.");
			needDraw = true;
			needBackup = true;
		} else if (roundPlayer.isFirstMove()) {
			int setSum = 0;
			for (Tile t : played) {
				setSum += t.getValue();
			}
			if (setSum < 30) {
				needDraw = true;
				System.err.println("The sum of all tiles in first move should be larger than 30, please retry.");
				needBackup = true;
			} else {
				roundPlayer.changeFirstMove();
			}
		}
	}

	public boolean getNeedBackup() {
		return needBackup;
	}
	
	public boolean getNeedDraw() {
		return needDraw;
	}

}
