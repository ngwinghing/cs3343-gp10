package ui;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import rummikub.Game;

public class GameUI {
	
	public Scanner scanner;
	public Game game;
	
	public GameUI(Game game) {
		this(game, System.in);
	}
	
	public GameUI(Game game, InputStream in) {
		this.scanner = new Scanner(in);
		this.game = game;
		try {
			output();
		}  catch (NumberFormatException e) {
			System.err.println("Only numbers are avaliable, please retry.");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Please retry with available numbers.");
		} catch (InputMismatchException e) {
			System.err.println("Please retry with available numbers.");
		} catch (NullPointerException e) {
			System.err.println("Please input with correct array number.");
		}
	}

	public void output() {
		
	}
	
}
