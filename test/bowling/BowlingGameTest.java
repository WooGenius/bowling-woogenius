package bowling;

import java.util.List;

import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
	public void testHit() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		List<String> symbols = bowlingGame.getSymbols();
		assertEquals(4, bowlingGame.frameSize());
		assertEquals(4, symbols.size());
		System.out.println(symbols);
	}
	
	public void testHit2() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		bowlingGame.hit(7);
		bowlingGame.hit(7);		// invalid pin
		bowlingGame.hit(3);
		List<String> symbols = bowlingGame.getSymbols();
		assertEquals(10, bowlingGame.frameSize());
		assertEquals(10, symbols.size());
		System.out.println(symbols);
	}
	
	public void testHit3() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.hit(5);
		bowlingGame.hit(5);
		bowlingGame.hit(3);
		bowlingGame.hit(7);
		bowlingGame.hit(2);
		bowlingGame.hit(2);
		bowlingGame.hit(0);
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		bowlingGame.hit(5);
		bowlingGame.hit(7);	// invalid pin
		bowlingGame.hit(3);
		bowlingGame.hit(10);
		bowlingGame.hit(7);
		bowlingGame.hit(3);
		bowlingGame.hit(7);
		bowlingGame.hit(3);
		bowlingGame.hit(3);
		List<String> symbols = bowlingGame.getSymbols();
		assertEquals(10, bowlingGame.frameSize());
		assertEquals(10, symbols.size());
		System.out.println(symbols);
	}
}
