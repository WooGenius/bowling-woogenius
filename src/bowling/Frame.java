package bowling;

import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
	List<Roll> rolls = new ArrayList<Roll>();
	int score = 0;
	int restPin = 10;
	boolean isFirst = true;
	
	public Frame() {
		rolls.add(new Roll(isFirst, 10));
	}
	
	public int getScore() {
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

}
