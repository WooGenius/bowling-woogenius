package bowling;

import java.util.*;

import frame.*;

public class BowlingGame {
	private List<Integer> rolls = new ArrayList<Integer>();
	public static List<Frame> frames = new ArrayList<Frame>();
	private int frameOrder = 1;
	private boolean isLast;
	private Identifier id;

	public void hit(int hittedPin) {
		rolls.add(hittedPin);
		isLast = (frameOrder == 10);
		id = new Identifier(rolls, isLast);
		if (!id.isValid()) {
			System.out.println("Invalid Pin!");
			rolls.remove(rolls.size()-1);	// remove last integer
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
		return symbols;
	}
	
}