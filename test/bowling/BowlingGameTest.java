package bowling;

import java.util.List;

import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
	public void testRoll() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		List<String> symbols = bowlingGame.getSymbols();
		assertEquals(4, bowlingGame.frameSize());
		assertEquals(4, symbols.size());
		System.out.println(symbols);
	}
	
	public void testRoll2() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(7);
		bowlingGame.roll(7);		// invalid pin
		bowlingGame.roll(3);
		List<String> symbols = bowlingGame.getSymbols();
		assertEquals(10, bowlingGame.frameSize());
		assertEquals(10, symbols.size());
		System.out.println(symbols);
	}
	
	public void testRoll3() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.roll(5);
		bowlingGame.roll(5);
		bowlingGame.roll(3);
		bowlingGame.roll(7);
		bowlingGame.roll(2);
		bowlingGame.roll(2);
		bowlingGame.roll(0);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(5);
		bowlingGame.roll(7);	// invalid pin
		bowlingGame.roll(3);
		bowlingGame.roll(10);
		bowlingGame.roll(7);
		bowlingGame.roll(3);
		bowlingGame.roll(7);
		bowlingGame.roll(3);
		bowlingGame.roll(3);
		List<String> symbols = bowlingGame.getSymbols();
		assertEquals(10, bowlingGame.frameSize());
		assertEquals(10, symbols.size());
		System.out.println(symbols);
	}
	
	public void testScoreAndSymbol() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.roll(5);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(5);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(3);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(7);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(2);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(2);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(0);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(5);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(7);	// invalid pin
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(3);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(7);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(3);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(7);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(3);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
		bowlingGame.roll(3);
		System.out.println(bowlingGame.getScores().toString());
		System.out.println(bowlingGame.getSymbols().toString());
	}
}
