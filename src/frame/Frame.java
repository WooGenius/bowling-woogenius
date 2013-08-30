package frame;

import java.util.*;

public class Frame {

	private int frameOrder;
	private boolean isLast;
	private Identifier id;
	private Symbol symbol;
	
	public Frame(int frameOrder, List<Integer> rolls) {
		this.frameOrder = frameOrder;
		this.isLast = (frameOrder==10);
		id = new Identifier(rolls, isLast);
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

	@Override
	public String toString() {
		return "Frame [frameOrder=" + frameOrder + ", symbol=" + symbol + "]";
	}

}
