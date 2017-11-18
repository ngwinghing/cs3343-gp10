package rummikub;

import java.util.Scanner;

public class GameUI {
	
	Scanner scanner = new Scanner(System.in);
	Game game;
	
	public GameUI(Game game) {
		this.game = game;
		try {
			output();
		}  catch (NumberFormatException e) {
			System.err.println("Only numbers are avaliable, please retry.");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Please retry with available numbers.");
		} 
//			catch (NullPointerException e) {
//			System.err.println("Please input with correct array number.");
//		}
	}

	public void output() {
		
	}
	
}
