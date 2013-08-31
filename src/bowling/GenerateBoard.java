package bowling;

import java.util.List;

public class GenerateBoard {
	
	public static final String NEWLINE =
			System.getProperty("line.separator");
	
	public static void generate() {
		StringBuilder sb = new StringBuilder();
		sb.append("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
		sb.append(NEWLINE);
		for (Player player : StartGame.players) {
			sb.append(makeSymbolString(player));
			sb.append(makeScoreString(player));
		}
		sb.deleteCharAt(sb.lastIndexOf(NEWLINE));
		System.out.println(sb.toString());
	}

	private static String makeSymbolString(Player player) {
		String name = player.getName();
		List<String> symbol = player.getSymbols();
		StringBuilder symbolString = new StringBuilder();
		symbolString.append("|  ");
		symbolString.append(name);
		symbolString.append(" |");
		for (int i = 0; i < 10; i++) {
			if (symbol.size() > i) {
				symbolString.append(symbolAppender(symbol.get(i)));
			} else {
				symbolString.append("      |");
			}
		}
		symbolString.append(NEWLINE);
		return symbolString.toString();
	}
	
	private static String symbolAppender(String symbol) {
		if (symbol.length()==3) {
			return ("  "+symbol+" |");
		} else if (symbol.length()==1) {
			return ("  "+symbol+"   |");
		} else {
			return (" "+symbol+"|");
		}
	}

	private static String makeScoreString(Player player) {
		List<Integer> score = player.getAddedScores();
		StringBuilder scoreString = new StringBuilder();
		scoreString.append("|      |");
		for (int i = 0; i < 10; i++) {
			if (score.size() > i) {
				scoreString.append(scoreAppender(score.get(i)));
			} else {
				scoreString.append("      |");
			}
		}
		scoreString.append(NEWLINE);
		return scoreString.toString();
	}

	private static String scoreAppender(Integer score) {
		String stringScore = score.toString();
		if (stringScore.length()==3) {
			return ("  "+stringScore+" |");
		} else if (stringScore.length()==2) {
			return ("  "+stringScore+"  |");
		} else {
			return ("  " +stringScore+"   |");
		}
	}
}
