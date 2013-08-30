package bowling;

import java.util.Stack;


public class Score {
	private Stack<Integer> scoreStack = new Stack<Integer>();
	private int score;

	public void push(int hittedPin) {
		scoreStack.push(hittedPin);
	}

	public int getScore() {
		if (isFinished())
			stackSum();
		return score;
	}

	private void stackSum() {
		for (int score : scoreStack) {
			this.score += score;
		}
	}
	
	public boolean isFinished() {
		if (isStrike() || isSpare()) {
			return scoreStack.size()==3;
		} else {
			return scoreStack.size()==2;
		}
	}
	
	public Score getNextStack() {
		Score nextScore = new Score();
		if (isStrike()) {
			System.out.println(scoreStack.peek());
			nextScore.push(scoreStack.pop());
			System.out.println(scoreStack.peek());
			nextScore.push(scoreStack.pop());
		} else if (isSpare()) {
			nextScore.push(scoreStack.pop());
		}
		return nextScore;
	}
	
	public boolean isSpare() {
		if (scoreStack.size()>=2) {
			int firstScore = scoreStack.get(0);
			int secondScore = scoreStack.get(1);
			return (firstScore+secondScore==10) && (firstScore!=10);
		} else {
			return false;
		}
	}

	public boolean isStrike() {
		if (scoreStack.size()>=1) {
			return scoreStack.get(0)==10;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return scoreStack.toString();
	}

}
