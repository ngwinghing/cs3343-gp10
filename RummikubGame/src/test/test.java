package test;

import org.junit.Test;
import rummikub.*;
import static org.junit.Assert.*;

public class test {
	@Test
	public void test1_colorsort() {
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
	public void test2_colorsort() {
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
	public void test3_colorsort() {
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
	public void test4_colorsort() {
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
	public void test5_colorsort() {
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
	public void test6_GroupValid_same1() {
		Tile t1 = new Tile(1, Color.Red);
		Tile t2 = new Tile(1, Color.Blue);
		Tile t3 = new Tile(1, Color.Black);
		
		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		assertEquals(true,set.checkIfTileSetAvailable());
	}
	
	@Test
	public void test7_GroupValid_same1AndsameColor() {
		Tile t1 = new Tile(1, Color.Red);
		Tile t2 = new Tile(1, Color.Blue);
		Tile t3 = new Tile(1, Color.Blue);
		
		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		assertEquals(false,set.checkIfTileSetAvailable());
	}
	
	@Test
	public void test8_CheckFirstMoveSumValid(){
		Tile t1 = new Tile(1, Color.Red);
		Tile t2 = new Tile(1, Color.Black);
		Tile t3 = new Tile(1, Color.Blue);
		
		TileSet set= new TileSet();
		Game game=Game.getInstance();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		assertEquals(false,game.checkFirstMoveSum(set));
	}
	
	@Test
<<<<<<< HEAD
	public void test5() {
    	Rack rackv1=new Rack();
    	Tile t1 = new Tile(1,Color.Blue);
    	Tile t2 = new Tile(2,Color.Red);
    	Tile t3 = new Tile(3,Color.Red);
    	Tile t4 = new Tile(4,Color.Yellow);
    	Tile t5 = new Tile(1,Color.Joker);
    	rackv1.addTile(t1);
    	rackv1.addTile(t2);
    	rackv1.addTile(t3);
    	rackv1.addTile(t4);
    	rackv1.addTile(t5);
    	
    	rackv1.sortByColor();
        Tile resv1=rackv1.getTile(0);
        Tile resv2=rackv1.getTile(1);
        Tile resv3=rackv1.getTile(2);
        Tile resv4=rackv1.getTile(3);
        Tile resv5=rackv1.getTile(4);

        assertEquals(resv1, t1);
        assertEquals(resv2, t2);
        assertEquals(resv3, t3);
        assertEquals(resv4, t4);
        assertEquals(resv5, t5);
     }
=======
	public void test9_CheckFirstMoveSumValid(){
		Tile t1 = new Tile(11, Color.Black);
		Tile t2 = new Tile(12, Color.Black);
		Tile t3 = new Tile(13, Color.Black);
		
		TileSet set= new TileSet();
		Game game=Game.getInstance();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		assertEquals(true,game.checkFirstMoveSum(set));
	}
>>>>>>> master
}
