package test;

import org.junit.Test;
import rummikub.*;
import static org.junit.Assert.*;

public class test {
	@Test
	public void test01_colorsort() {
		Rack rackv1 = new Rack();
		Tile t1 = new Tile(10, Color.Black);
		Tile t2 = new Tile(1, Color.Black);
		rackv1.addTile(t1);
		rackv1.addTile(t2);

		rackv1.sortByColor();
		Tile resv1 = rackv1.getTile(0);
		Tile resv2 = rackv1.getTile(1);

		assertEquals(resv1, t2);
		assertEquals(resv2, t1);
	}

	@Test
	public void test02_colorsort() {
		Rack rackv1 = new Rack();
		Tile t1 = new Tile(1, Color.Blue);
		Tile t2 = new Tile(4, Color.Blue);
		Tile t3 = new Tile(1, Color.Black);
		rackv1.addTile(t1);
		rackv1.addTile(t2);
		rackv1.addTile(t3);

		rackv1.sortByColor();
		Tile resv1 = rackv1.getTile(0);
		Tile resv2 = rackv1.getTile(1);
		Tile resv3 = rackv1.getTile(2);

		assertEquals(resv1, t3);
		assertEquals(resv2, t1);
		assertEquals(resv3, t2);
	}

	@Test
	public void test03_colorsort() {
		Rack rackv1 = new Rack();
		Tile t1 = new Tile(1, Color.Blue);
		Tile t2 = new Tile(1, Color.Red);
		Tile t3 = new Tile(1, Color.Black);
		Tile t4 = new Tile(1, Color.Yellow);
		rackv1.addTile(t1);
		rackv1.addTile(t2);
		rackv1.addTile(t3);
		rackv1.addTile(t4);

		rackv1.sortByColor();
		Tile resv1 = rackv1.getTile(0);
		Tile resv2 = rackv1.getTile(1);
		Tile resv3 = rackv1.getTile(2);
		Tile resv4 = rackv1.getTile(3);

		assertEquals(resv1, t3);
		assertEquals(resv2, t1);
		assertEquals(resv3, t2);
		assertEquals(resv4, t4);
	}

	@Test
	public void test04_colorsort() {
		Rack rackv1 = new Rack();
		Tile t1 = new Tile(1, Color.Blue);
		Tile t2 = new Tile(2, Color.Red);
		Tile t3 = new Tile(3, Color.Red);
		Tile t4 = new Tile(4, Color.Yellow);
		rackv1.addTile(t1);
		rackv1.addTile(t2);
		rackv1.addTile(t3);
		rackv1.addTile(t4);

		rackv1.sortByColor();
		Tile resv1 = rackv1.getTile(0);
		Tile resv2 = rackv1.getTile(1);
		Tile resv3 = rackv1.getTile(2);
		Tile resv4 = rackv1.getTile(3);

		assertEquals(resv1, t1);
		assertEquals(resv2, t2);
		assertEquals(resv3, t3);
		assertEquals(resv4, t4);
	}

	@Test
	public void test05_colorsort() {
		Rack rackv1 = new Rack();
		Tile t1 = new Tile(1, Color.Blue);
		Tile t2 = new Tile(2, Color.Red);
		Tile t3 = new Tile(3, Color.Red);
		Tile t4 = new Tile(4, Color.Yellow);
		Tile t5 = new Tile(1, Color.Joker);
		rackv1.addTile(t1);
		rackv1.addTile(t2);
		rackv1.addTile(t3);
		rackv1.addTile(t4);
		rackv1.addTile(t5);

		rackv1.sortByColor();
		Tile resv1 = rackv1.getTile(0);
		Tile resv2 = rackv1.getTile(1);
		Tile resv3 = rackv1.getTile(2);
		Tile resv4 = rackv1.getTile(3);
		Tile resv5 = rackv1.getTile(4);

		assertEquals(resv1, t1);
		assertEquals(resv2, t2);
		assertEquals(resv3, t3);
		assertEquals(resv4, t4);
		assertEquals(resv5, t5);
	}

	@Test
	public void test06_GroupValid_same1() {
		Tile t1 = new Tile(1, Color.Red);
		Tile t2 = new Tile(1, Color.Blue);
		Tile t3 = new Tile(1, Color.Black);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(true, set.checkIfTileSetAvailable());
	}

	@Test
	public void test07_GroupValid_same1AndsameColor() {
		Tile t1 = new Tile(1, Color.Red);
		Tile t2 = new Tile(1, Color.Blue);
		Tile t3 = new Tile(1, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(false, set.checkIfTileSetAvailable());
	}

	@Test
	public void test08_CheckFirstMoveSumValid() {
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
	public void test09_CheckFirstMoveSumValid() {
		Tile t1 = new Tile(11, Color.Black);
		Tile t2 = new Tile(12, Color.Black);
		Tile t3 = new Tile(13, Color.Black);

		TileSet set = new TileSet();
		Game game = new Game();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(true, game.checkFirstMoveSum(set));
	}

	@Test
	public void test10_Draw() {
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
	public void test12_ExceedTwentyFourTilesInRack() {
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
		
		boolean result = set.checkIfTileSetAvailable();

		assertEquals(true, result);
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
	
	
}
