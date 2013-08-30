package bowling;

import junit.framework.TestCase;

public class ScoreTest extends TestCase {
	public void testStrike() throws Exception {
		Score score = new Score();
		score.push(10);
		assertEquals(0, score.getScore());
		score.push(10);
		assertEquals(0, score.getScore());
		score.push(10);
		assertTrue(score.isFinished());
		assertTrue(score.isStrike());
		assertEquals(30, score.getScore());
	}
	
	public void testSpare() throws Exception {
		Score score = new Score();
		score.push(5);
		assertEquals(0, score.getScore());
		score.push(5);
		assertEquals(0, score.getScore());
		score.push(10);
		assertTrue(score.isFinished());
		assertTrue(score.isSpare());
		assertEquals(20, score.getScore());
	}
	
	public void testNormal() throws Exception {
		Score score = new Score();
		score.push(5);
		assertEquals(0, score.getScore());
		score.push(3);
		assertTrue(score.isFinished());
		assertEquals(8, score.getScore());
	}
	
	public void testGetNextStackForStrike() throws Exception {
		Score score = new Score();
		score.push(10);
		score.push(10);
		score.push(10);
		Score nextScore = score.getNextStack();
		nextScore.push(10);
		System.out.println(nextScore);
		assertEquals(30, nextScore.getScore());
		assertTrue(nextScore.isFinished());
	}
	
	public void testGetNextStackForSpare() throws Exception {
		Score score = new Score();
		score.push(5);
		score.push(5);
		score.push(3);
		Score nextScore = score.getNextStack();
		nextScore.push(5);
		System.out.println(nextScore);
		assertEquals(8, nextScore.getScore());
		assertTrue(nextScore.isFinished());
	}
}
