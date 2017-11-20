package test;

import org.junit.Test;
import rummikub.*;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

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

}
