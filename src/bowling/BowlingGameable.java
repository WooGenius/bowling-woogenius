package bowling;

import java.util.List;

public interface BowlingGameable {
	void roll(int hittedPin) throws GameOverException;
	List<String> getSymbols();
	List<Integer> getScores();
}
