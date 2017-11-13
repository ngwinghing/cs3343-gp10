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
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(false, set.checkFirstMoveSum());
	}

	@Test
	public void test09_checkFirstMoveSumValid() {
		Tile t1 = new Tile(11, Color.Black);
		Tile t2 = new Tile(12, Color.Black);
		Tile t3 = new Tile(13, Color.Black);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		assertEquals(true, set.checkFirstMoveSum());
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
	public void test11_havingTwentyFourTilesInRack() {
		Player p = new Player("Test");
		Game game = new Game();
		game.addPlayer(p);
		
		for (int i = 0; i<24;i++)
			game.draw(p);
		
		assertEquals(true, p.havingTwentyFourTilesInRack());
	}
	
	@Test
	public void test12_exceedTwentyFourTilesInRack() {
		Player p = new Player("Test");
		Game game = new Game();
		game.addPlayer(p);
		
		for (int i = 0; i<25;i++)
			game.draw(p);
		
		assertEquals(24, p.getRackSize());
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
	
	@Test
	public void test14_checkIfTileSetAvailableRun(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);
		Tile t3 = new Tile(13, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		assertEquals(true, set.checkIfTileSetAvailable());
	}

	@Test
	public void test15_checkIfTileSetAvailableRun(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Black);
		Tile t3 = new Tile(13, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(false, set.checkIfTileSetAvailable());
	}
	
	@Test
	public void test16_checkIfTileSetAvailableGroup(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(11, Color.Black);
		Tile t3 = new Tile(11, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(false, set.checkIfTileSetAvailable());
	}
	
	@Test
	public void test17_checkIfTileSetAvailableBoth(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);
		Tile t3 = new Tile(13, Color.Blue);
		Tile t4 = new Tile(11, Color.Blue);
		Tile t5 = new Tile(11, Color.Black);
		Tile t6 = new Tile(11, Color.Red);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		set.addToSet(t4);
		set.addToSet(t5);
		set.addToSet(t6);

		assertEquals(false, set.checkIfTileSetAvailable());
	}
	
	@Test
	public void test18_checkIfTileSetAvailableRun(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);
		Tile t3 = new Tile(13, Color.Yellow);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		assertEquals(false, set.checkIfTileSetAvailable());
	}
	
	@Test
	public void test19_checkIfTileSetAvailableGroup(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Black);
		Tile t3 = new Tile(11, Color.Red);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(false, set.checkIfTileSetAvailable());
	}
	
	@Test
	public void test20_checkIfTileSetAvailableGroup(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(1, Color.Joker);
		Tile t3 = new Tile(11, Color.Red);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(true, set.checkIfTileSetAvailable());
	}
	
}
