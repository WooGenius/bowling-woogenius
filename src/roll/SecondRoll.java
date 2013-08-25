package roll;

public class SecondRoll implements Rollable {
	
	int restPin;
	int score;
	boolean hitted = false;
	char symbol;
	
	public SecondRoll(int restPin) {
		this.restPin = restPin;
	}

	@Override
	public char getSymbol() {
		if (isSpare()) {
			symbol = '/';
		} else if (!isHitted()){ // not hitted
			symbol = '.';
		} else if (isGutter()) {
			symbol = '-';
		} else {
			symbol = Character.forDigit(score, 10);
		}

		return symbol;
	}
	
	private boolean isGutter() {
		return ((hitted==true) && score==0);
	}
	
	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void hit(int hittedPin) {
		score = hittedPin;
		restPin -= hittedPin;
		hitted = true;
	}
	
	@Override
	public boolean isSpare() {
		return (restPin==0);
	}

	@Override
	public String toString() {
		return "SecondRoll [score=" + score + ", symbol=" + symbol + "]";
	}

	@Override
	public boolean isHitted() {
		return hitted;
	}

	@Override
	public boolean isStrike() {
		return false;
	}

	@Override
	public int getRestPin() {
		return restPin;
	}
}
