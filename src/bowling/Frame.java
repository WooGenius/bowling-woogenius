package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
	List<Integer> scores = new ArrayList<Integer>();

	public void pitch(int numOfPin) {
		scores.add(numOfPin);
	}

	public int getScore() {
		int scoreSum = 0;
		for (Integer score : scores) {
			scoreSum += score;
		}
		return scoreSum;
	}

}
