package rummikub;


import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		
        String playerName;
        Scanner scanner = new Scanner(System.in);
        
		System.out.println("What's your name?");
		//playerName = scanner.nextLine();
		playerName="Wing";
		
		System.out.println("Welcome, "+playerName);
		
		Player p = new Player(playerName);
		
		Game game = Game.getInstance();
		game.addPlayer(p);
		
		game.distributeTile();
		
		System.out.println("");
		
		do {
		
		System.out.println("\nPool: ");
		game.printPool();

		System.out.println("\nYour Rack: ");
		System.out.println(p.rack);
		
		System.out.println("\nPlease choose your options: ");
		game.availableOptions(p);
		String option = scanner.nextLine();
		
		switch (option) {
		case "1":
			game.draw(p);
			break;
		case "2":
			game.addSetsToPool(p);
			break;
		case "3":
			p.sortByNumber();
			break;	
		case "4":
			p.sortByColor();
			break;
		default:
			System.out.println("Please input an avaliable option number.");
			game.availableOptions(p);
		}
		
		} while (game.notEnd());
    }
}
