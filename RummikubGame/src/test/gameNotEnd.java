package test;

import org.junit.Test;
import rummikub.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

public class gameNotEnd {
	@Test
	public void test_gameNotEnd_01() {
		Player p1 = new Player("Test1");
		Player p2 = new Player("Test2");
		Game game = new Game();
		game.addPlayer(p1);
		game.addPlayer(p2);
		game.distributeTile();

		assertEquals(true, game.notEnd());
	}

	@Test
	public void test_gameNotEnd_02() {
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		game.distributeTile();
		Rack r = p1.getRack();
		for (int i = 0; i < r.getsize(); i++) {
			p1.removeTile(r.getTile(i));
		}

		assertEquals(true, game.notEnd());
	}
	
	@Test
	public void test_gameNotEnd_03() {
		Player p1 = new Player("Test1");
		Game game = new Game();
		AllTiles alltile=new AllTiles();
		/*class AllTilesStub extends AllTiles{
			LinkedList<Tile> allTiles = new LinkedList<Tile>();
		}
		AllTilesStub alltilesstub=new AllTilesStub();*/
		game.addPlayer(p1);
		game.distributeTile();
		for (int i=0;i<=104;i++){
			alltile.popFromStack();
		}
		

		assertEquals(false, game.notEnd());
	}
}
