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
	
	private boolean isSpare() {
		return (restPin==0);
	}
	
	private boolean isGutter() {
		return ((hitted==true) && score==0);
	}

}
