package test;

import org.junit.Test;
import rummikub.*;
import static org.junit.Assert.*;

public class gamePlayerRound {
	@Test
	public void test_playerRound_01() {
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);

		Player result = game.getRoundPlayer(1);

		assertEquals(p1, result);
	}
	
	@Test
	public void test_playerRound_02() {
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);

		Player result = game.getRoundPlayer(2);

		assertEquals(p1, result);
	}

	@Test
	public void test_playerRound_03() {
		Player p1 = new Player("Test1");
		Player p2 = new Player("Test2");
		Game game = new Game();
		game.addPlayer(p1);
		game.addPlayer(p2);

		Player result = game.getRoundPlayer(1);

		assertEquals(p1, result);
	}
	
	@Test
	public void test_playerRound_04() {
		Player p1 = new Player("Test1");
		Player p2 = new Player("Test2");
		Game game = new Game();
		game.addPlayer(p1);
		game.addPlayer(p2);

		Player result = game.getRoundPlayer(2);

		assertEquals(p2, result);
	}
	
	@Test
	public void test_playerRound_05() {
		Player p1 = new Player("Test1");
		Player p2 = new Player("Test2");
		Game game = new Game();
		game.addPlayer(p1);
		game.addPlayer(p2);

		Player result = game.getRoundPlayer(3);

		assertEquals(p1, result);
	}
	
	@Test
	public void test_playerRound_06() {
		Player p1 = new Player("Test1");
		Player p2 = new Player("Test2");
		Player p3 = new Player("Test3");
		Game game = new Game();
		game.addPlayer(p1);
		game.addPlayer(p2);
		game.addPlayer(p3);

		Player result = game.getRoundPlayer(3);

		assertEquals(p3, result);
	}
	
	@Test
	public void test_playerRound_07() {
		Player p1 = new Player("Test1");
		Player p2 = new Player("Test2");
		Player p3 = new Player("Test3");
		Game game = new Game();
		game.addPlayer(p1);
		game.addPlayer(p2);
		game.addPlayer(p3);

		Player result = game.getRoundPlayer(4);

		assertEquals(p1, result);
	}
}
