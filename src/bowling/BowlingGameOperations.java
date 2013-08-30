package bowling;

import java.util.List;

public interface BowlingGameOperations {
	void roll(int hittedPin) throws GameOverException;
	public List<String> getSymbols();
	public List<Integer> getScores();
}
