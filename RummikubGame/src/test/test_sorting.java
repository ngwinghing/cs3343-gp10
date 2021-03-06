package test;

import org.junit.Test;
import rummikub.*;
import tile.*;

import static org.junit.Assert.*;

public class test_sorting {
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
		Tile t1 = new Tile(3, Color.Red);
		Tile t2 = new Tile(2, Color.Red);
		Tile t3 = new Tile(1, Color.Blue);
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

		assertEquals(resv1, t3);
		assertEquals(resv2, t2);
		assertEquals(resv3, t1);
		assertEquals(resv4, t4);
	}

	@Test
	public void test05_colorsort() {
		Rack rackv1 = new Rack();
		Tile t1 = new Tile(1, Color.Blue);
		Tile t2 = new Tile(2, Color.Red);
		Tile t3 = new Tile(3, Color.Red);
		Tile t4 = new Tile(4, Color.Yellow);
		Tile t5 = new Tile(Color.Joker);
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
	public void test_colorsort_06() {
		Rack rackv1 = new Rack();
		Tile t1 = new Tile(Color.Joker);
		Tile t2 = new Tile(2, Color.Red);
		Tile t3 = new Tile(1, Color.Blue);
		Tile t4 = new Tile(4, Color.Yellow);
		Tile t5 = new Tile(3, Color.Red);
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

		assertEquals(resv1, t3);
		assertEquals(resv2, t2);
		assertEquals(resv3, t5);
		assertEquals(resv4, t4);
		assertEquals(resv5, t1);
	}
	
	@Test
	public void test_numbersort_07() {
		Rack rackv1 = new Rack();
		Tile t1 = new Tile(5, Color.Red);
		Tile t2 = new Tile(4, Color.Red);
		Tile t3 = new Tile(3, Color.Red);
		Tile t4 = new Tile(2, Color.Red);
		Tile t5 = new Tile(1, Color.Red);
		rackv1.addTile(t1);
		rackv1.addTile(t2);
		rackv1.addTile(t3);
		rackv1.addTile(t4);
		rackv1.addTile(t5);

		rackv1.sortByNumber();
		Tile resv1 = rackv1.getTile(0);
		Tile resv2 = rackv1.getTile(1);
		Tile resv3 = rackv1.getTile(2);
		Tile resv4 = rackv1.getTile(3);
		Tile resv5 = rackv1.getTile(4);

		assertEquals(resv1, t5);
		assertEquals(resv2, t4);
		assertEquals(resv3, t3);
		assertEquals(resv4, t2);
		assertEquals(resv5, t1);
	}
	
	@Test
	public void test_numbersort_08() {
		Rack rackv1 = new Rack();
		Tile t1 = new Tile(5, Color.Red);
		Tile t2 = new Tile(5, Color.Blue);
		Tile t3 = new Tile(5, Color.Red);
		Tile t4 = new Tile(2, Color.Yellow);
		Tile t5 = new Tile(1, Color.Red);
		rackv1.addTile(t1);
		rackv1.addTile(t2);
		rackv1.addTile(t3);
		rackv1.addTile(t4);
		rackv1.addTile(t5);

		rackv1.sortByNumber();
		Tile resv1 = rackv1.getTile(0);
		Tile resv2 = rackv1.getTile(1);
		Tile resv3 = rackv1.getTile(2);
		Tile resv4 = rackv1.getTile(3);
		Tile resv5 = rackv1.getTile(4);

		assertEquals(resv1, t5);
		assertEquals(resv2, t4);
		assertEquals(resv3, t2);
		assertEquals(resv4, t1);
		assertEquals(resv5, t3);
	}
	
	@Test
	public void test_numbersort_09() {
		Rack rackv1 = new Rack();
		Tile t1 = new Tile(Color.Joker);
		Tile t2 = new Tile(4, Color.Red);
		Tile t3 = new Tile(3, Color.Red);
		Tile t4 = new Tile(2, Color.Red);
		Tile t5 = new Tile(1, Color.Red);
		rackv1.addTile(t1);
		rackv1.addTile(t2);
		rackv1.addTile(t3);
		rackv1.addTile(t4);
		rackv1.addTile(t5);

		rackv1.sortByNumber();
		Tile resv1 = rackv1.getTile(0);
		Tile resv2 = rackv1.getTile(1);
		Tile resv3 = rackv1.getTile(2);
		Tile resv4 = rackv1.getTile(3);
		Tile resv5 = rackv1.getTile(4);

		assertEquals(resv1, t5);
		assertEquals(resv2, t4);
		assertEquals(resv3, t3);
		assertEquals(resv4, t2);
		assertEquals(resv5, t1);
	}
	
	@Test
	public void test_numbersort_10() {
		Rack rackv1 = new Rack();
		Tile t1 = new Tile(Color.Joker);
		Tile t2 = new Tile(4, Color.Red);
		Tile t3 = new Tile(3, Color.Red);
		Tile t4 = new Tile(4, Color.Red);
		Tile t5 = new Tile(1, Color.Red);
		rackv1.addTile(t1);
		rackv1.addTile(t2);
		rackv1.addTile(t3);
		rackv1.addTile(t4);
		rackv1.addTile(t5);

		rackv1.sortByNumber();
		Tile resv1 = rackv1.getTile(0);
		Tile resv2 = rackv1.getTile(1);
		Tile resv3 = rackv1.getTile(2);
		Tile resv4 = rackv1.getTile(3);
		Tile resv5 = rackv1.getTile(4);

		assertEquals(resv1, t5);
		assertEquals(resv2, t3);
		assertEquals(resv3, t2);
		assertEquals(resv4, t4);
		assertEquals(resv5, t1);
	}
	
	
}
