package bowling;

import java.util.*;

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
			do {
				System.out.printf("%s's turn : ", name);
				int hittedPin = scanner.nextInt();
				bowlingGame.roll(hittedPin);
				GenerateBoard.generate();
			} while (!currentFrameIsFinished());
		} catch (GameOverException e) {
			System.out.println(name+" Game Over");
		}
	}

	public boolean currentFrameIsFinished() {
		return bowlingGame.currentFrameIsFinished();
	}

	public List<Integer> getAddedScores() {
		List<Integer> scores = bowlingGame.getScores();
		List<Integer> addedScores = new ArrayList<Integer>();
		
		for (int i = 0; i < scores.size(); i++) {
			int addedScore = 0;
			for (int j = 0; j <= i; j++) {
				addedScore += scores.get(j); 
			}
			addedScores.add(addedScore);
		}
		return addedScores;
	}
	
	public List<String> getSymbols() {
		return bowlingGame.getSymbols();
	}
}
