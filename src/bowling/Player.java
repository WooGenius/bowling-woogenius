package bowling;

import java.util.ArrayList;
import java.util.List;

public class Player {
	String name;
	BowlingGame bowlingGame = new BowlingGame();
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Integer> getScoreList() {
		List<Integer> scores = new ArrayList<Integer>();
		for (int frameOrder = 1; frameOrder <= 10; frameOrder++) {
			scores.add(bowlingGame.getFrameScore(frameOrder));
		}
		return scores;
	}

	public void hit(int hittedPin) {
		bowlingGame.hit(hittedPin);
	}

	public List<String> getSymbolList() {
		List<String> symbols = new ArrayList<String>();
		for (int frameOrder = 1; frameOrder <= 10; frameOrder++) {
			symbols.add(bowlingGame.getFrameSymbol(frameOrder));
		}
		return symbols;
	}
	

}
