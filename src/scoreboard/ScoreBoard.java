package scoreboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import bowling.*;

public class ScoreBoard {
	List<Player> playerList = new ArrayList<Player>();
	Scanner scanner = new Scanner(System.in);
	
	public ScoreBoard() {
		System.out.printf("How Many People?");
		int numOfPeople = scanner.nextInt();
		
		for (int i = 0; i < numOfPeople; i++) {
			System.out.printf("What's player%d's name?", i+1);
			String name = scanner.next();
			playerList.add(new Player(name));
		}
	}
}
