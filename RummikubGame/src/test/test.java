package test;

import org.junit.Test;
import rummikub.*;
import static org.junit.Assert.*;



public class test {
	@Test
    public void test1() {
    	Rack rackv1=new Rack();
    	Tile t1 = new Tile(10,Color.Black);
    	Tile t2 = new Tile(1,Color.Black);
    	rackv1.addTile(t1);
    	rackv1.addTile(t2);
    	
    	rackv1.sortByColor();
        Tile resv1=rackv1.getTile(0);
        Tile resv2=rackv1.getTile(1);

        assertEquals(resv1, t2);
        assertEquals(resv2, t1);
     }
}
