package test;

import org.junit.Test;
import rummikub.*;
import static org.junit.Assert.*;

public class game {
	@Test
	public void test01_gameNotEnd() {
		Player p1 = new Player("Test1");
		Player p2 = new Player("Test2");
		Game game = new Game();
		game.addPlayer(p1);
		game.addPlayer(p2);
		game.distributeTile();

		assertEquals(true, game.notEnd());
	}
}
