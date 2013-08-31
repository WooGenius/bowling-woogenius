package bowling;

import java.util.*;

public class StartGame {
	
	private static Scanner scanner;
	static List<Player> players = new ArrayList<Player>();

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		System.out.printf("How many people? ");		// init players
		int numOfPeople = scanner.nextInt();
		for (int i = 0; i < numOfPeople; i++) {
			System.out.printf("Input Player%d's name(3 english letters): ",i+1);
			String name = scanner.next();
			players.add(new Player(name));
		}
		
		GenerateBoard.generate();
		for (int i = 0; i < 10; i++) {	// 10 frame
			for (Player player : players) {
				player.startRoll();
			}
		}
	}
}
