package frame;

import java.util.List;

public class Identifier {

	private List<Integer> rolls;

	public Identifier(List<Integer> rolls) {
		this.rolls = rolls;
	}

	public boolean isStrike() {
		return ((rolls.size()==1)&&(rollSum()==10));
	}

	public boolean isSpare() {
		return ((rolls.size()==2)&&(rollSum()==10));
	}
	
	private int rollSum() {
		int sum = 0;
		for (int roll : rolls) {
			sum += roll;
		}
		return sum;
	}


}
