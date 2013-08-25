package bowling;

import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
	public void testInit() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.init();
		assertEquals(10, bowlingGame.frames.size());
	}
	
	public void testHit() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.init();
		bowlingGame.hit(10);
		bowlingGame.hit(5);
		bowlingGame.hit(5);
		bowlingGame.hit(3);
		bowlingGame.hit(4);
		assertEquals("X", bowlingGame.getFrame(0).getSymbol());
		assertEquals("5|/", bowlingGame.getFrame(1).getSymbol());
		assertEquals("3|4", bowlingGame.getFrame(2).getSymbol());
	}
	
	public void testScore() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.init();
		bowlingGame.hit(10);
		assertEquals(10, bowlingGame.getFrameScore(0));
		bowlingGame.hit(5);
		bowlingGame.hit(5);
		bowlingGame.hit(3);
		bowlingGame.hit(4);
		assertEquals(20, bowlingGame.getFrameScore(0));
		assertEquals(33, bowlingGame.getFrameScore(1));
		assertEquals(40, bowlingGame.getFrameScore(2));
	}
	
	public void testGetNextScore() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.init();
		}
	
}
