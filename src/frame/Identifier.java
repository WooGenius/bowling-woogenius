package frame;

import java.util.List;

public class Identifier {

	private List<Integer> rolls;
	private boolean isLast = false;

	public Identifier(List<Integer> rolls, boolean isLast) {
		this.rolls = rolls;
		this.isLast = isLast;
	}
	
	public Identifier(List<Integer> rolls) {
		this.rolls = rolls;
	}
	
	public boolean isFinished() {
		if (isLast) {
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
		for (int roll : rolls) {
			if (roll > 10)
				return false;
		}
		
		if (isLast) {
			if (isDoubleStrikeForLastRoll())
				return rollsSum() <= 30;
			if (isStrikeForLastRoll() || isSpare())
				return rollsSum() <= 20;
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
		return (rolls.get(0)==10);
	}
	
	boolean isDoubleStrikeForLastRoll() {
		if (rolls.size() >= 2) {
			return (rolls.get(0)==10) && (rolls.get(1)==10);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Identifier [rolls=" + rolls + ", isFinished()=" + isFinished()
				+ ", isValid()=" + isValid() + "]";
	}

}
