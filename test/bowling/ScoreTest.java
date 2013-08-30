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
		score.push(5);
		Score nextScore = score.getNextScore();
		System.out.println(nextScore);
		assertEquals(0, nextScore.getScore());
		assertFalse(nextScore.isFinished());
	}
	
	public void testGetNextStackForSpare() throws Exception {
		Score score = new Score();
		score.push(5);
		score.push(5);
		score.push(3);
		Score nextScore = score.getNextScore();
		nextScore.push(5);
		System.out.println(nextScore);
		assertEquals(8, nextScore.getScore());
		assertTrue(nextScore.isFinished());
	}
}
