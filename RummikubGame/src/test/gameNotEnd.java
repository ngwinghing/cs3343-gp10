package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rummikub.*;
import tile.*;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class gameNotEnd {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
	
	@Test
	public void test_gameNotEnd_01() {
		// game not end
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
		// game end with no tile in player's rack
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		game.distributeTile();
		Rack r = p1.getRack();
		
		TileSet set = new TileSet();
		
		for (int i = 0; i < r.getsize(); i++) {
			set.addToSet(r.getTile(i));
		}
		
		p1.removeTileSet(set);
		boolean result = game.notEnd();

		assertTrue(outContent.toString().contains("Used all tiles from rack, win!"));
		assertEquals(false, result);
	}
	
	@Test
	public void test_gameNotEnd_03() {
		// game end with draw all tiles
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		
		for (int i = 0; i < 106; i++) {
			game.draw(p1);
		}
		
		boolean result = game.notEnd();

		assertTrue(outContent.toString().contains("All tiles were drawn."));
		assertEquals(false, result);
	}
}
