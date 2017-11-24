package test;

import org.junit.Test;
import rummikub.*;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class test_round {
	@Rule
	  public final TextFromStandardInputStream systemInMock
	    = emptyStandardInputStream();

	  @Test
	  public void summarizesTwoNumbers() {
	    systemInMock.provideLines("1", "2");
	    //assertEquals(3, Summarize.sumOfNumbersFromSystemIn());
	  }
	  
	@Test
	public void test_round_option_01() {
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		game.distributeTile();
		
//		Round r = new Round(game);
//		systemInMock.provideLines("1");
		//new CmdDraw(game, p1).execute();

//		assertEquals(15, p1.getRackSize());
	}
	
	@Test
	public void test_round_option_02() {
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		game.distributeTile();
		
		new CmdDraw(game, p1).execute();

		assertEquals(15, p1.getRackSize());
	}
	
	@Test
	public void test_round_option_03() {
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		Tile t1 = new Tile(11, Color.Black);
		Tile t2 = new Tile(12, Color.Black);
		Tile t3 = new Tile(13, Color.Black);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);
		
		new CmdNewSet(game,p1, set).execute();

		assertEquals(15, p1.getRackSize());//I dun know how to assert equal
	}
	
	@Test
	public void test_round_option_04() {
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		Tile t1 = new Tile(11, Color.Black);
		Tile t2 = new Tile(12, Color.Black);
		Tile t3 = new Tile(13, Color.Black);
		Tile t4 = new Tile(10, Color.Black);

		TileSet sourceSet = new TileSet();
		sourceSet.addToSet(t1);
		sourceSet.addToSet(t2);
		sourceSet.addToSet(t3);
		
		List<Tile> set = new ArrayList<>();
		set.add(t4);
		
		
		new CmdAddToSet(game,p1, sourceSet, set).execute();

		assertEquals(15, p1.getRackSize());
	}
	
	@Test
	public void test_round_option_05() {
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		Tile t1 = new Tile(11, Color.Black);
		Tile t2 = new Tile(12, Color.Black);
		Tile t3 = new Tile(13, Color.Black);
		Tile t4 = new Tile(10, Color.Black);

		TileSet sourceSet = new TileSet();
		sourceSet.addToSet(t1);
		sourceSet.addToSet(t2);
		sourceSet.addToSet(t3);
		
		List<Tile> set = new ArrayList<>();
		set.add(t4);
		
		
		new CmdMoveToNewSet(game, p1, sourceSet, set).execute();

		assertEquals(15, p1.getRackSize());
	}

}
