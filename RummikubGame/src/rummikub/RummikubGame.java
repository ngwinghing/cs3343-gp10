package rummikub;

import java.util.Scanner;

public class RummikubGame {
	
	public static void main(String args[]) {
		Game game = new Game();
		
        String playerName;
        Scanner scanner = new Scanner(System.in);
        
		System.out.println("What's your name?");
		playerName = scanner.nextLine();
		
		System.out.println("Welcome, "+playerName);
		
		game.setPlayer(playerName);
		
    }
}
