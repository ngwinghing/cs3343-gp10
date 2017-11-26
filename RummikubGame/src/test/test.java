package test;

import org.junit.Test;

import command.*;
import rummikub.*;
import tile.*;
import ui.*;

import static org.junit.Assert.*;

public class test {
	@Test
	public void test_draw() {
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
	public void test_distribute() {
		Player p = new Player("Test");
		Game game = new Game();
		game.addPlayer(p);
		Tile first = game.getTileFromAllTiles(0);
		Tile second = game.getTileFromAllTiles(1);
		game.distributeTile();
		
		assertEquals(first, p.getTileByIndex(0));
		assertEquals(second, p.getTileByIndex(1));
	}
	
	@Test
	public void test_calSetValueSum_01(){
		Player p = new Player("Test");
		Game game = new Game();
		game.addPlayer(p);
		
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(11, Color.Red);
		Tile t3 = new Tile(11, Color.Black);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		game.addSetsToPool(set);

		CmdEndTurn e = new CmdEndTurn(game, p, set.getSets());
		e.execute();
		
		assertEquals(false, p.isFirstMove());
		assertEquals(false, e.getNeedBackup());
	}	
}
