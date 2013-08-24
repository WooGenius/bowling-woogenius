package bowling;

import junit.framework.TestCase;

public class Roll extends TestCase {
	boolean isFirst;
	boolean hitted = false;
	int restPin;
	Integer score = 0;
	char symbol;

	public Roll(boolean isFirst, int restPin) {
		this.isFirst = isFirst;
		this.restPin = restPin;
	}

	public void hit(int hittedPin) {
		hitted = true;
		score = hittedPin;
		restPin -= hittedPin;
	}

	public char getSymbol() {
		if (isStrike()) {
			symbol = 'X';
		} else if (isSpare()) {
			symbol = '/';
		} else if (isGutter()) {
			symbol = '-';
		} else if (notHitted()) {
			symbol = '.';
		} else {
			symbol = Character.forDigit(score, 10);
		}
		
		return symbol;
	}

	private boolean notHitted() {
		return hitted==false;
	}

	private boolean isGutter() {
		return ((hitted==true) && (score==0));
	}

	boolean isSpare() {
		return ((isFirst==false) && (restPin==0));
	}

	boolean isStrike() {
		return ((isFirst==true) && (restPin==0));
	}

	public int getScore() {
		return score;
	}

}
