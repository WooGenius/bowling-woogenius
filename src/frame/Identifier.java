package frame;

import java.util.List;

public class Identifier {

	private List<Integer> rolls;
	private boolean lastRoll = false;

	public Identifier(List<Integer> rolls, boolean lastRoll) {
		this.rolls = rolls;
		this.lastRoll = lastRoll;
	}
	
	public Identifier(List<Integer> rolls) {
		this.rolls = rolls;
	}
	
	public boolean isFinished() {
		if (lastRoll) {
			if (isStrikeForLastRoll() || 
					isDoubleStrikeForLastRoll() || isSpare())
				return rolls.size()==3;
		} else {
			if (isStrike())
				return rolls.size()==1;
		}
		return rolls.size()==2;
	}

	public boolean isValid() {
		if (lastRoll) {
			if (isStrikeForLastRoll() || isSpare())
				return rollsSum() <= 20;
			if (isDoubleStrikeForLastRoll())
				return rollsSum() <= 30;
		}
		return rollsSum() <= 10;
	}
	
	private int rollsSum() {
		int rollsSum = 0;
		for (int roll : rolls)
			rollsSum += roll;
		return rollsSum;
	}

	public boolean isStrike() {
		return rolls.size()==1 && rolls.contains(10);
	}

	public boolean isSpare() {
		if (rolls.size()>=2) {
			return rolls.get(0)+rolls.get(1)==10;
		}
		return false;
	}

	boolean isStrikeForLastRoll() {
		return (rolls.get(0)==10) && (rolls.get(1)!=10);
	}
	
	boolean isDoubleStrikeForLastRoll() {
		return (rolls.get(0)==10) && (rolls.get(1)==10);
	}

}
