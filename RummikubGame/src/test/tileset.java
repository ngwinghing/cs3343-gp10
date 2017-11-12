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
}
