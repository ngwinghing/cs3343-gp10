package test;

import org.junit.Test;
import rummikub.*;
import static org.junit.Assert.*;

public class test {
	@Test
	public void test08_checkFirstMoveSumValid() {
		Tile t1 = new Tile(1, Color.Red);
		Tile t2 = new Tile(1, Color.Black);
		Tile t3 = new Tile(1, Color.Blue);

		TileSet set = new TileSet();
		Game game = new Game();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(false, game.checkFirstMoveSum(set));
	}

	@Test
	public void test09_checkFirstMoveSumValid() {
		Tile t1 = new Tile(11, Color.Black);
		Tile t2 = new Tile(12, Color.Black);
		Tile t3 = new Tile(13, Color.Black);

		TileSet set = new TileSet();
		Game game = new Game();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		boolean result = game.checkFirstMoveSu?m(set);

		assertEquals(true, result);
	}

	@Test
	public void test10_draw() {
		Player p = new Player("Test");
		Game game = new Game();
		Tile first = game.getTileFromAllTiles(0);
		Tile second = game.getTileFromAllTiles(1);
		
		game.addPlayer(p);
		game.draw(p);
		
		assertEquals(first, p.getTileByIndex(0));
		assertEquals(second, game.getTileFromAllTiles(0));
	}

	@Test
	public void test13_distribute() {
		Player p = new Player("Test");
		Game game = new Game();
		game.addPlayer(p);
		Tile first = game.getTileFromAllTiles(0);
		Tile second = game.getTileFromAllTiles(1);
		game.distributeTile();
		
		assertEquals(first, p.getTileByIndex(0));
		assertEquals(second, p.getTileByIndex(1));
	}
	
}
