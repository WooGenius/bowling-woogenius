package bowling;

import java.util.List;
import java.util.Scanner;

public class Player {
	
	String name;
	Scanner scanner = new Scanner(System.in);
	BowlingGameable bowlingGame = new BowlingGame();
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void startRoll() {
		try {
			while (true) {
				int hittedPin = scanner.nextInt();
				bowlingGame.roll(hittedPin);
				System.out.println(getScores());
				System.out.println(getSymbols());
				System.out.println(currentFrameIsFinished());
			}
		} catch (GameOverException e) {
			System.out.println(name+" Game Over");
			e.printStackTrace();
		}
	}

	public boolean currentFrameIsFinished() {
		return bowlingGame.currentFrameIsFinished();
	}

	public List<Integer> getScores() {
		return bowlingGame.getScores();
	}
	
	public List<String> getSymbols() {
		return bowlingGame.getSymbols();
	}
}
