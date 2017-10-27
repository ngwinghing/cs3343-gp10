package rummikub;


import java.util.Scanner;

public class RummikubGame {
	
	public static void main(String args[]) {
		
        String playerName;
        Scanner scanner = new Scanner(System.in);
        
		System.out.println("What's your name?");
		playerName = scanner.nextLine();
		
		System.out.println("Welcome, "+playerName);
		
		Player p = new Player(playerName);
		
		Game game = new Game();
		game.setPlayer(p);
		game.distributeTile();
		
		System.out.println("");

		System.out.println("\nYour Rack: ");
		System.out.println(p.rack);

    }
}
