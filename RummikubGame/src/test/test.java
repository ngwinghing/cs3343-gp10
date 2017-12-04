package test;

import org.junit.Test;

import command.*;
import rummikub.*;
import tile.*;

import static org.junit.Assert.*;

public class test {
	@Test
	public void test_draw_01() {
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
	public void test_distribute_02() {
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
