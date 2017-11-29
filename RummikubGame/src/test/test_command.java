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

import command.CmdAddToSet;
import command.CmdDraw;
import command.CmdEndTurn;
import command.CmdMoveToExitingSet;
import command.CmdMoveToNewSet;
import command.CmdNewSet;
import rummikub.*;
import tile.Color;
import tile.Tile;
import tile.TileSet;
import ui.GameInitialize;
import ui.Round;

public class test_command {

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
		String str = "1 \n Test1";
		InputStream stream = new ByteArrayInputStream(str.getBytes());

		Game game = new Game();
		new GameInitialize(game, stream);
		assertTrue(outContent.toString().contains("Welcome, Test1"));
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
		// end turn - empty pool
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		game.distributeTile();
		List<Tile> played = new ArrayList<>();

		new CmdEndTurn(game, p1, played).execute();
		assertTrue(outContent.toString().contains("As you have not move any tile, draw one tile for this round."));
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
		assertEquals(t4, sourceSet.getTileByIndex(0));
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

	@Test
	public void test_round_option_09() {
		// end turn - <30
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		List<Tile> played = new ArrayList<>();

		Tile t1 = new Tile(8, Color.Blue);
		Tile t2 = new Tile(9, Color.Blue);
		Tile t3 = new Tile(10, Color.Blue);

		played.add(t1);
		played.add(t2);
		played.add(t3);

		TileSet sourceSet = new TileSet();
		sourceSet.addToSet(t1);
		sourceSet.addToSet(t2);
		sourceSet.addToSet(t3);

		game.addSetsToPool(sourceSet);

		new CmdEndTurn(game, p1, played).execute();
		assertEquals(1, p1.getRackSize());
		assertTrue(errContent.toString()
				.contains("The sum of all tiles in first move should be larger than 30, please retry."));
	}

	@Test
	public void test_round_option_10() {
		// end turn - >30
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		List<Tile> played = new ArrayList<>();

		Tile t1 = new Tile(10, Color.Blue);
		Tile t2 = new Tile(11, Color.Blue);
		Tile t3 = new Tile(12, Color.Blue);

		played.add(t1);
		played.add(t2);
		played.add(t3);

		TileSet sourceSet = new TileSet();
		sourceSet.addToSet(t1);
		sourceSet.addToSet(t2);
		sourceSet.addToSet(t3);

		game.addSetsToPool(sourceSet);

		new CmdEndTurn(game, p1, played).execute();
		assertEquals(0, p1.getRackSize());
	}

	@Test
	public void test_round_option_11() {
		// end turn - invalid pool
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		List<Tile> played = new ArrayList<>();

		// one valid set in pool
		Tile t1 = new Tile(10, Color.Blue);
		Tile t2 = new Tile(11, Color.Blue);
		Tile t3 = new Tile(12, Color.Joker);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		game.addSetsToPool(set);

		// player have 3 tiles in rack
		Tile t4 = new Tile(10, Color.Yellow);
		Tile t5 = new Tile(11, Color.Yellow);
		Tile t6 = new Tile(11, Color.Yellow);

		TileSet set2 = new TileSet();
		set2.addToSet(t4);
		set2.addToSet(t5);
		set2.addToSet(t6);

		game.addSetsToPool(set2);

		played.add(t4);
		played.add(t5);
		played.add(t6);

		new CmdEndTurn(game, p1, played).execute();
		assertTrue(outContent.toString().contains("As you have not move any tile, draw one tile for this round."));
		assertEquals(1, p1.getRackSize());
		assertTrue(errContent.toString().contains("Invalid pool, please input again next round."));
	}

	@Test
	public void test_round_option_12() {
		// end turn - not empty pool, player do not play a tile in the round
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		game.distributeTile();
		List<Tile> played = new ArrayList<>();

		// one valid set in pool
		Tile t1 = new Tile(10, Color.Blue);
		Tile t2 = new Tile(11, Color.Blue);
		Tile t3 = new Tile(12, Color.Joker);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		game.addSetsToPool(set);

		new CmdEndTurn(game, p1, played).execute();

		assertEquals(15, p1.getRackSize());
		assertTrue(outContent.toString().contains("As you have not move any tile, draw one tile for this round."));
	}

	@Test
	public void test_round_option_13() {
		// end turn - not empty pool, player play a set in the round, not first move,
		// valid set
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);
		game.distributeTile();
		List<Tile> played = new ArrayList<>();
		p1.changeFirstMove();

		// one valid set in pool
		Tile t1 = new Tile(10, Color.Blue);
		Tile t2 = new Tile(11, Color.Blue);
		Tile t3 = new Tile(12, Color.Joker);

		TileSet set = new TileSet();
		set.addToSet(t1);
		set.addToSet(t2);
		set.addToSet(t3);

		game.addSetsToPool(set);

		// player played a valid set
		Tile t4 = new Tile(1, Color.Yellow);
		Tile t5 = new Tile(2, Color.Yellow);
		Tile t6 = new Tile(3, Color.Yellow);

		TileSet set2 = new TileSet();
		set2.addToSet(t4);
		set2.addToSet(t5);
		set2.addToSet(t6);

		game.addSetsToPool(set2);

		played.add(t4);
		played.add(t5);
		played.add(t6);

		new CmdEndTurn(game, p1, played).execute();

		assertEquals(14, p1.getRackSize());
	}

	@Test
	public void test_round_14() throws Exception {
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);

		class RoundStub extends Round {
			public RoundStub(Game game, InputStream stream) {
				super(game, stream);
			}

			@Override
			public void output() {
				printOptions();
			}
		}

		String str = "1234";
		InputStream stream = new ByteArrayInputStream(str.getBytes());

		new RoundStub(game, stream);
		assertTrue(outContent.toString().contains("Please input an avaliable option number."));
	}

	@Test
	public void test_round_optionSwitch_15() throws Exception {
		Player p1 = new Player("Test1");
		Game game = new Game();
		game.addPlayer(p1);

		Tile t1 = new Tile(10, Color.Blue);
		p1.addTileToRack(t1);

		class RoundStub extends Round {
			public RoundStub(Game game) {
				super(game);
			}

			@Override
			public void output() {
				roundPlayer = game.getRoundPlayer();
			}
		}

		Round r = new RoundStub(game);

		r.optionSwitch("1");
		assertEquals(2, p1.getRackSize());
		assertEquals(true, r.getEndTurn());
	}

	@Test
	public void test_game_16() throws Exception {
		String str = "0 \n 1 \n Wing \n";
		InputStream stream = new ByteArrayInputStream(str.getBytes());

		Game game = new Game();
		new GameInitialize(game, stream);
		assertTrue(errContent.toString().contains("Please retry with available numbers."));
	}

	@Test
	public void test_game_17() throws Exception {
		String str = "8 \n 1 \n Wing \n";
		InputStream stream = new ByteArrayInputStream(str.getBytes());

		Game game = new Game();
		new GameInitialize(game, stream);
		assertTrue(errContent.toString().contains("Please retry with available numbers."));
	}

	@Test
	public void test_game_18() throws Exception {
		String str = "i \n 1 \n Wing \n";
		InputStream stream = new ByteArrayInputStream(str.getBytes());

		Game game = new Game();
		new GameInitialize(game, stream);
		assertTrue(errContent.toString().contains("Please retry with available numbers."));
	}
}
