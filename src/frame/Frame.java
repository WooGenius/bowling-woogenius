package frame;

import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
	List<Roll> rolls = new ArrayList<Roll>();
	int restPin = 10;
	boolean isFirst = true;
	boolean isFinished = false;
	
	public Frame() {
		rolls.add(new Roll(isFirst, 10));
	}
	
	public int getScore() {
		int score = 0;
		for (Roll roll : rolls) {
			score += roll.getScore();
		}
		return score;
	}

	public abstract void hit(int hittedPin);

	public String getSymbol() {
		StringBuilder sb = new StringBuilder();
		for (Roll roll : rolls) {
			char rollSymbol = roll.getSymbol();
			sb.append(rollSymbol);
			sb.append("|");
		}
		sb.deleteCharAt(sb.lastIndexOf("|"));
		return sb.toString();
	}

	public boolean isFinished() {	// strike or turn finished
		return ((restPin==0)||isFinished);
	}

	public boolean isStrike() {
		return rolls.get(0).isStrike();
	}

	public int getFirstScore() {
		return rolls.get(0).getScore();
	}

	public boolean isSpare() {
		if (rolls.size()==2) {
			return rolls.get(1).isSpare();
		}
		return false;
	}

}
