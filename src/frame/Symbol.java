package frame;

import java.util.List;

public class Symbol {
	
	private final String STRIKE_SYMBOL = "X";
	private final String SPARE_SYMBOL = "/";
	private final String DIVISION_SYMBOL = "|";
	private final String GUTTER_SYMBOL = "-";
	private List<Integer> rolls;
	private StringBuilder symbol = new StringBuilder();

	public Symbol(List<Integer> rolls) {
		this.rolls = rolls;
	}

	public String getSymbol() {
		Identifier id = new Identifier(rolls);
		if (id.isSpare()) {
			symbol.append(makeSymbol(0));
			symbol.append(DIVISION_SYMBOL);
			symbol.append(SPARE_SYMBOL);
			if (rolls.size()==3) {	// for last frame
				symbol.append(DIVISION_SYMBOL);
				symbol.append(makeSymbol(2));
			}
		} else {
			for (int i = 0; i < rolls.size(); i++) {
				symbol.append(makeSymbol(i));
				symbol.append(DIVISION_SYMBOL);
			}
			symbol.deleteCharAt(symbol.lastIndexOf(DIVISION_SYMBOL));
		}
		return symbol.toString();
	}

	private String makeSymbol(int i) {
		String symbol;
		if (rolls.get(i)==0) {
			symbol = GUTTER_SYMBOL;
		} else if (rolls.get(i)==10){
			symbol = STRIKE_SYMBOL;
		} else {
			symbol = rolls.get(i).toString();
		}
		return symbol;
	}
}
