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
		System.out.println(bowlingGame2);
	}
}
