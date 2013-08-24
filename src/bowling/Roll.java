package bowling;

import junit.framework.TestCase;

public class Roll extends TestCase {
	boolean isFirst;
	int numOfPin;
	int score;
	char symbol;

	public Roll(boolean isFirst, int numOfPin) {
		this.isFirst = isFirst;
		this.numOfPin = numOfPin;
	}

	public void hit(int hittedPin) {
		score = hittedPin;
	}

	public char getSymbol() {
		if (isStrike()) {
			symbol = 'X';
		}
		return symbol;
	}

	private boolean isStrike() {
		return (isFirst==true) && (score==10);
	}

}
