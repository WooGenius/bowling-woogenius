package bowling;

import java.util.*;

import frame.*;

public class BowlingGame {
	private List<Integer> rolls = new Stack<Integer>();
	private List<Integer> scores = new ArrayList<Integer>();
	private List<Frame> frames = new ArrayList<Frame>();
	
	private int frameOrder = 1;
	private boolean isLast;
	private Identifier id;
	private Score score = new Score();

	public void hit(int hittedPin) {
		rolls.add(hittedPin);
		isLast = (frameOrder == 10);
		generateScore(hittedPin);
		organizeFrame(rolls, isLast);
	}

	private void generateScore(int hittedPin) {
		score.push(hittedPin);
		if (score.isFinished()) {
			scores.add(score.getScore());
			score = score.getNextScore();
		}
	}

	private void organizeFrame(List<Integer> rolls, boolean isLast) {
		id = new Identifier(rolls, isLast);
		if (!id.isValid()) {
			System.out.println("Invalid Pin!");
			score.pop();
			((Stack<Integer>) rolls).pop();	// remove last integer
		} else if (curretFrameIsFinished()) {
			frames.add(new Frame(frameOrder, rolls));
			rolls.clear();
			frameOrder++;
		}
	}

	private boolean curretFrameIsFinished() {
		return id.isFinished();
	}

	public int frameSize() {
		return frames.size();
	}

	public List<String> getSymbols() {
		List<String> symbols = new ArrayList<String>();
		for (Frame frame : frames) {
			symbols.add(frame.getSymbol());
		}
		
		if (!rolls.isEmpty()) {
			symbols.add(getRollSymbol());
		}
		return symbols;
	}

	private String getRollSymbol() {
		Symbol symbol = new Symbol(rolls);
		return symbol.getSymbol();
	}

	public List<Integer> getScores() {
		return scores;
	}
	
}