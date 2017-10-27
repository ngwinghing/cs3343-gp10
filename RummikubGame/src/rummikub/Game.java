package rummikub;

import java.util.ArrayList;
import java.util.List;

public class Game {
	List<Player> players;
	AllTiles instance = AllTiles.getInstance();
	
	public Game() {
		players = new ArrayList();
	}

	public void setPlayer(String name) {
		Player p = new Player(name);
		players.add(p);
	}
}
