package test;

import org.junit.Test;
import rummikub.*;
import static org.junit.Assert.*;

public class game {
	@Test
	public void test01_gameNotEnd() {
		Player p1 = new Player("Test1");
		Player p2 = new Player("Test2");
		Game game = new Game();
		game.addPlayer(p1);
		game.addPlayer(p2);
		game.distributeTile();

		assertEquals(true, game.notEnd());
	}
	
	@Test
	public void test22_calSetValueSum(){
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(11, Color.Red);
		Tile t3 = new Tile(11, Color.Black);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		assertEquals(33, Game.getInstance().calSetValueSum(set));
	}
}
