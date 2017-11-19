package test;

import org.junit.Test;
import rummikub.*;
import static org.junit.Assert.*;

public class gameNotEnd {
	@Test
	public void test_gameNotEnd_01() {
		Player p1 = new Player("Test1");
		Player p2 = new Player("Test2");
		Game game = new Game();
		game.addPlayer(p1);
		game.addPlayer(p2);
		game.distributeTile();

		assertEquals(true, game.notEnd());
	}

	@Test
	public void test_gameNotEnd_02() {
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		game.distributeTile();
		Rack r = p1.getRack();
		for (int i = 0; i < r.getsize(); i++) {
			p1.removeTile(r.getTile(i));
		}

		assertEquals(true, game.notEnd());
	}
}
