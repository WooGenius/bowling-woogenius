package roll;

public class FirstRoll implements Rollable{
	
	int restPin = 10;
	int score;
	boolean hitted = false;
	char symbol;

	@Override
	public char getSymbol() {
		if (isStrike()) {
			symbol = 'X';
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
	public boolean isStrike() {
		return (restPin==0);
	}

	@Override
	public String toString() {
		return "FirstRoll [score=" + score + ", symbol=" + symbol + "]";
	}

	@Override
	public boolean isHitted() {
		return hitted;
	}
	
	@Override
	public int getRestPin() {
		return restPin;
	}

	@Override
	public boolean isSpare() {
		return false;
	}
}
