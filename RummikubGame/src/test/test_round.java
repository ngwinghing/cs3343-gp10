package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rummikub.*;

public class test_round {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	@Test
	public void test_game_01() throws Exception {
		String str = "Wing";
		InputStream stream = new ByteArrayInputStream(str.getBytes());
		
		Game game = new Game();
		new GameInitialize(game, stream);
		assertTrue(outContent.toString().contains("Welcome, Wing"));
	}
	

	@Test
	public void test_round_option_02() {
		// draw
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		game.distributeTile();

		new CmdDraw(game, p1).execute();

		assertEquals(15, p1.getRackSize());
	}
	
	@Test
	public void test_round_option_03() {
		// end turn
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		game.distributeTile();
		List<Tile> played = new ArrayList<>();

		new CmdEndTurn(game, p1, played).execute();

		assertEquals(15, p1.getRackSize());
	}
	
	@Test
	public void test_round_option_04() {
		// new set
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);
		Tile t3 = new Tile(13, Color.Blue);
		
		p1.addTileToRack(t1);
		p1.addTileToRack(t2);
		p1.addTileToRack(t3);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		new CmdNewSet(game, p1, set).execute();

		assertEquals(set, game.getPool().getTileSetByIndex(0));
		assertEquals(0, p1.getRackSize());
	}
	
	@Test
	public void test_round_option_05() {
		// new set - invalid tile set case
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Yellow);
		Tile t3 = new Tile(13, Color.Blue);
		
		p1.addTileToRack(t1);
		p1.addTileToRack(t2);
		p1.addTileToRack(t3);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		new CmdNewSet(game, p1, set).execute();

		assertEquals(true, game.getPool().isEmpty());
		assertEquals(3, p1.getRackSize());
		assertTrue(errContent.toString().contains("Please input valid set again."));
	}
	
	@Test
	public void test_round_option_06() {
		// Add tile(s) to a Set
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		
		Tile t1 = new Tile(11, Color.Blue);
		Tile t2 = new Tile(12, Color.Blue);
		Tile t3 = new Tile(13, Color.Blue);
		
		TileSet sourceSet = new TileSet();
		sourceSet.addToSet(t1);
		sourceSet.addToSet(t2);
		sourceSet.addToSet(t3);
		
		game.addSetsToPool(sourceSet);
		
		Tile t4 = new Tile(10, Color.Blue);
		p1.addTileToRack(t4);
		
		List<Tile> set = new ArrayList<>();
		set.add(t4);
		
		new CmdAddToSet(game, p1, sourceSet, set).execute();

		assertEquals(false, game.getPool().isEmpty());
		assertEquals(0, p1.getRackSize());
		assertEquals(t4, sourceSet.getTileByIndex(3));
	}
	
	@Test
	public void test_round_option_07() {
		// Move tile to new set
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		
		Tile t1 = new Tile(8, Color.Blue);
		Tile t2 = new Tile(9, Color.Blue);
		Tile t3 = new Tile(10, Color.Blue);
		Tile t4 = new Tile(11, Color.Blue);
		Tile t5 = new Tile(12, Color.Blue);
		Tile t6 = new Tile(13, Color.Blue);
		
		TileSet sourceSet = new TileSet();
		sourceSet.addToSet(t1);
		sourceSet.addToSet(t2);
		sourceSet.addToSet(t3);
		sourceSet.addToSet(t4);
		sourceSet.addToSet(t5);
		sourceSet.addToSet(t6);
		
		game.addSetsToPool(sourceSet);
		
		List<Tile> set = new ArrayList<>();
		set.add(t4);
		set.add(t5);
		set.add(t6);
		
		new CmdMoveToNewSet(game, p1, sourceSet, set).execute();

		assertEquals(false, game.getPool().isEmpty());
		assertEquals(3, sourceSet.getSize());
		assertEquals(set, game.getTileSetByIndex(1).getSets());
	}
	
	@Test
	public void test_round_option_08() {
		// Move Tile(s) in a set to another set
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		
		Tile t1 = new Tile(10, Color.Black);
		Tile t2 = new Tile(10, Color.Yellow);
		Tile t3 = new Tile(10, Color.Blue);
		
		Tile t4 = new Tile(11, Color.Blue);
		Tile t5 = new Tile(12, Color.Blue);
		Tile t6 = new Tile(13, Color.Blue);
		
		TileSet sourceSet = new TileSet();
		sourceSet.addToSet(t1);
		sourceSet.addToSet(t2);
		sourceSet.addToSet(t3);
		
		TileSet destinationSet = new TileSet();
		destinationSet.addToSet(t4);
		destinationSet.addToSet(t5);
		destinationSet.addToSet(t6);
		
		game.addSetsToPool(sourceSet);
		game.addSetsToPool(destinationSet);
		
		List<Tile> set = new ArrayList<>();
		set.add(t3);
		
		new CmdMoveToExitingSet(game, p1, sourceSet, destinationSet, set).execute();

		assertEquals(false, game.getPool().isEmpty());
		assertEquals(2, sourceSet.getSize());
		assertEquals(4, destinationSet.getSize());
		assertEquals(t3, game.getTileSetByIndex(1).getTileByIndex(3));
	}
}
