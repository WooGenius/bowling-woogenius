package bowling;

import java.util.*;

public class Player implements Comparable<Player>{
	
	String name;
	Scanner scanner = new Scanner(System.in);
	BowlingGameable bowlingGame = new BowlingGame();
	List<Integer> scores = bowlingGame.getScores();
	
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
		List<Integer> addedScores = new ArrayList<Integer>();
		for (int i = 0; i < scores.size(); i++) {
			addedScores.add(getAddedScore(i));
		}
		return addedScores;
	}

	private int getAddedScore(int to) {
		int addedScore = 0;
		for (int j = 0; j <= to; j++) {
			addedScore += scores.get(j); 
		}
		return addedScore;
	}
	
	public List<String> getSymbols() {
		return bowlingGame.getSymbols();
	}

	@Override
	public int compareTo(Player player) {
		if (this.getScoreSum()>player.getScoreSum()) {
			return -1;
		} else if (this.getScoreSum()<player.getScoreSum()){
			return 1;
		}
		return 0;
	}

	int getScoreSum() {
		int result = 0;
		for (Integer score : scores) {
			result += score;
		}
		return result;
	}
}
