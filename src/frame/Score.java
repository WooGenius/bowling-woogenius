package frame;

import java.util.List;

public class Score {

	private List<Integer> rolls;
	private int score;
	private boolean isLast;
	private int frameOrder;

	public Score(List<Integer> rolls, int frameOrder, boolean isLast) {
		this.rolls = rolls;
		this.frameOrder = frameOrder;
		this.isLast = isLast;
	}

	public int getScore() {
		return score;
	}

}
