package test;

import org.junit.Test;
import rummikub.*;
import static org.junit.Assert.*;

public class tileset {
	@Test
	public void test06_groupValid_same1() {
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
	public void test07_groupValid_same1AndsameColor() {
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
		Tile t2 = new Tile(Color.Joker);
		Tile t3 = new Tile(11, Color.Red);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(true, set.checkIfTileSetAvailable());
	}
	
	@Test
	public void test21_checkIfTileSetAvailableGroup(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(11, Color.Red);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);

		assertEquals(false, set.checkIfTileSetAvailable());
	}
}
