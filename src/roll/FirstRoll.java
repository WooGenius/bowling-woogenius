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
		} else if (!hitted){ // not hitted
			symbol = '.';
		} else if (isGutter()) {
			symbol = '-';
		} else {
			symbol = Character.forDigit(score, 10);
		}

		return symbol;
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
	
	private boolean isStrike() {
		return (restPin==0);
	}
	
	private boolean isGutter() {
		return ((hitted==true) && score==0);
	}
}
