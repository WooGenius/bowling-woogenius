package bowling;

import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
	public void testInit() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.init();
		assertEquals(10, bowlingGame.size());
	}
}
