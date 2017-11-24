package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rummikub.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class test_pool {
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
	public void test_pool_01() {
		// no tile in pool
		Pool p = new Pool();
		
		System.out.println(p);
		assertEquals(true, p.isEmpty());
		assertTrue(outContent.toString().contains("No Tile."));
	}
	
	@Test
	public void test_pool_02() {
		// tile in pool
		Pool p = new Pool();
		
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);
		Tile t3 = new Tile(13, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		p.addSetToPool(set);
		
		System.out.println(p);
		assertEquals(false, p.isEmpty());
		assertTrue(outContent.toString().contains("[ Blue 11 ]"));
		assertTrue(outContent.toString().contains("[ Blue 12 ]"));
		assertTrue(outContent.toString().contains("[ Blue 13 ]"));
	}
	
	@Test
	public void test_pool_03() {
		// valid pool
		Pool p = new Pool();
		
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);
		Tile t3 = new Tile(13, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		p.addSetToPool(set);
		
		assertEquals(true, p.valid());
	}
	
	@Test
	public void test_pool_04() {
		// invalid pool
		Pool p = new Pool();
		
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		
		p.addSetToPool(set);
		
		assertEquals(false, p.valid());
	}
	
	@Test
	public void test_pool_05() {
		// valid set + invalid set
		Pool p = new Pool();
		
		// valid set
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);
		Tile t3 = new Tile(13, Color.Blue);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		p.addSetToPool(set);
		
		// invalid set
		Tile t4 = new Tile(11, Color.Black);
		Tile t5 = new Tile(12, Color.Black);
		Tile t6 = new Tile(13, Color.Yellow);

		TileSet set2 = new TileSet();
		set.addToSet(t4);
		set.addToSet(t5);
		set.addToSet(t6);
		
		p.addSetToPool(set);
		
		assertEquals(false, p.valid());
	}
	
	
}
