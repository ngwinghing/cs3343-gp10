package test;

import org.junit.Test;
import rummikub.*;
import static org.junit.Assert.*;

public class tileset {
	@Test
	public void test_checkIfTileSetAvailableGroup_01() {
		Tile t1 = new Tile(1, Color.Red);
		Tile t2 = new Tile(1, Color.Blue);
		Tile t3 = new Tile(1, Color.Black);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(true, set.checkGroup());
	}
	
	@Test
	public void test_checkIfTileSetAvailableGroup_02() {
		Tile t1 = new Tile(1, Color.Red);
		Tile t2 = new Tile(1, Color.Blue);
		Tile t3 = new Tile(1, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(false, set.checkGroup());
	}
	
	@Test
	public void test_checkIfTileSetAvailableGroup_03(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(11, Color.Black);
		Tile t3 = new Tile(11, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(false, set.checkGroup());
	}
	
	@Test
	public void test_checkIfTileSetAvailableGroup_04(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Black);
		Tile t3 = new Tile(11, Color.Red);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(false, set.checkGroup());
	}
	
	@Test
	public void test_checkIfTileSetAvailableGroup_05(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(Color.Joker);
		Tile t3 = new Tile(11, Color.Red);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(true, set.checkGroup());
	}
	
	@Test
	public void test_checkIfTileSetAvailableGroup_06(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(11, Color.Red);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);

		assertEquals(false, set.checkGroup());
	}
	
	@Test
	public void test_checkIfTileSetAvailableGroup_07(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(Color.Joker);
		Tile t3 = new Tile(Color.Joker);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(true, set.checkGroup());
	}
	
	@Test
	public void test_checkIfTileSetAvailableRun_08(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);
		Tile t3 = new Tile(13, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(true, set.checkRun());
	}

	@Test
	public void test_checkIfTileSetAvailableRun_09(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Black);
		Tile t3 = new Tile(13, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(false, set.checkRun());
	}
	
	@Test
	public void test_checkIfTileSetAvailableRun_10(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);
		Tile t3 = new Tile(13, Color.Yellow);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		assertEquals(false, set.checkRun());
	}
	
	@Test
	public void test_checkIfTileSetAvailableRun_11(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		
		assertEquals(false, set.checkRun());
	}
	
	@Test
	public void test_checkIfTileSetAvailableRun_12(){
		Tile t1 = new Tile(Color.Joker);
		Tile t2 = new Tile(12, Color.Blue);
		Tile t3 = new Tile(13, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(true, set.checkRun());
	}
	
	@Test
	public void test_checkIfTileSetAvailableRun_13(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(Color.Joker);
		Tile t3 = new Tile(13, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(true, set.checkRun());
	}
	
	@Test
	public void test_checkIfTileSetAvailableRun_14(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);
		Tile t3 = new Tile(Color.Joker);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(true, set.checkRun());
	}
	
	@Test
	public void test_checkIfTileSetAvailableRun_15(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(Color.Joker);
		Tile t3 = new Tile(Color.Joker);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(true, set.checkRun());
	}
	
	@Test
	public void test_checkIfTileSetAvailableBoth_gp_16() {
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
	public void test_checkIfTileSetAvailableBoth_run_17(){
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
<<<<<<< HEAD
	public void test21_checkIfTileSetAvailableGroup(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(11, Color.Red);
=======
	public void test17_checkIfTileSetAvailableBoth_18(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);
		Tile t3 = new Tile(13, Color.Blue);
		Tile t4 = new Tile(11, Color.Blue);
		Tile t5 = new Tile(11, Color.Black);
		Tile t6 = new Tile(11, Color.Red);
>>>>>>> master

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
<<<<<<< HEAD

		assertEquals(false, set.checkIfTileSetAvailable());
	}
=======
		set.addToSet(t3);
		set.addToSet(t4);
		set.addToSet(t5);
		set.addToSet(t6);

		assertEquals(false, set.checkIfTileSetAvailable());
	}
	
	@Test
	public void test_checkIfTileSetAvailableGroup_19() {
		Tile t1 = new Tile(1, Color.Red);
		Tile t2 = new Tile(1, Color.Blue);
		Tile t3 = new Tile(1, Color.Black);
		Tile t4 = new Tile(1, Color.Yellow);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		set.addToSet(t4);
		
		assertEquals(true, set.checkGroup());
	}
	
	@Test
	public void test_checkIfTileSetAvailableRun_20() {
		Tile t1 = new Tile(5, Color.Yellow);
		Tile t2 = new Tile(4, Color.Yellow);
		Tile t3 = new Tile(2, Color.Yellow);
		Tile t4 = new Tile(3, Color.Yellow);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		set.addToSet(t4);
		
		assertEquals(true, set.checkRun());
	}
	
>>>>>>> master
}
