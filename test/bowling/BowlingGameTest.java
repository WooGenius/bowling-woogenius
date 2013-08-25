package bowling;

import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
	public void testInit() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		assertEquals(10, bowlingGame.size());
		System.out.println(bowlingGame);
	}
	
	public void testHit() throws Exception {
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
		bowlingGame.hit(10);
		bowlingGame.hit(10);
		System.out.println(bowlingGame);
		
		BowlingGame bowlingGame2 = new BowlingGame();
		bowlingGame2.hit(5);
		bowlingGame2.hit(5);
		bowlingGame2.hit(3);
		bowlingGame2.hit(3);
		bowlingGame2.hit(10);
		bowlingGame2.hit(10);
		bowlingGame2.hit(10);
		bowlingGame2.hit(10);
		bowlingGame2.hit(10);
		bowlingGame2.hit(10);
		bowlingGame2.hit(10);
		bowlingGame2.hit(5);
		bowlingGame2.hit(5);
		bowlingGame2.hit(10);
		bowlingGame2.hit(10);
		System.out.println(bowlingGame2);
	}
	
	public void testNextScore() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.hit(4);
		bowlingGame.hit(5);
		bowlingGame.hit(10);
		bowlingGame.hit(5);
		bowlingGame.hit(3);
		assertEquals(5, bowlingGame.getNextScore(1,1));
		assertEquals(10, bowlingGame.getNextScore(1,2));
		assertEquals(5, bowlingGame.getNextScore(2,1));
	}
	
	public void testHaveNextRoll() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.hit(4);
		bowlingGame.hit(5);
		bowlingGame.hit(10);
		bowlingGame.hit(5);
		bowlingGame.hit(3);
		assertTrue(bowlingGame.hasNextRoll(1,1));
		assertFalse(bowlingGame.hasNextRoll(1,2));
		assertFalse(bowlingGame.hasNextRoll(2,1));
	}
	
	public void testGetFrameScore() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.hit(5);
		bowlingGame.hit(5);
		bowlingGame.hit(10);
		bowlingGame.hit(5);
		bowlingGame.hit(3);
		assertEquals(20, bowlingGame.getFrameScore(1));
		assertEquals(18, bowlingGame.getFrameScore(2));
		assertEquals(8, bowlingGame.getFrameScore(3));
	}
}
