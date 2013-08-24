package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
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

	public Roll getRoll(int orderOfRoll) {
		return rolls.get(orderOfRoll-1);
	}

	public void hit(int hittedPin) {
		if(isFirst) {
			rolls.get(0).hit(hittedPin);
			restPin -= hittedPin;
			isFirst = false;
		} else {
			rolls.add(new Roll(isFirst, restPin));
			rolls.get(1).hit(hittedPin);
		}
	}

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
