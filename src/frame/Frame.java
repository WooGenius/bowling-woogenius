package frame;

import java.util.*;

public class Frame {

	private List<Integer> rolls = new ArrayList<Integer>();
	private int frameOrder;
	private boolean isLast;
	private Identifier id;
	private Symbol symbol;
	private Score score;
	
	public Frame(int frameOrder) {
		this.frameOrder = frameOrder;
		this.isLast = (frameOrder==10);
	}

	public void hit(int hittedPin) {
		rolls.add(hittedPin);
		id = new Identifier(rolls, isLast);
		score = new Score(rolls, frameOrder, isLast);
		symbol = new Symbol(rolls);
	}

	public String getSymbol() {
		return symbol.getSymbol();
	}

	public boolean isFinished() {
		return id.isFinished();
	}

	public boolean isValid() {
		return id.isValid();
	}

	public int getScore() {
		return score.getScore();
	}
	
}
