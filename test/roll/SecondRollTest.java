package roll;

import junit.framework.TestCase;

public class SecondRollTest extends TestCase {
	public void testGetSymbol() throws Exception {
		Rollable secondRoll = new SecondRoll(5);	// spare
		secondRoll.hit(5);
		assertEquals('/', secondRoll.getSymbol());
		
		Rollable secondRoll2 = new SecondRoll(5);	// normal
		secondRoll2.hit(1);
		assertEquals('1', secondRoll2.getSymbol());

		Rollable secondRoll3 = new SecondRoll(5);	// gutter
		secondRoll3.hit(0);
		assertEquals('-', secondRoll3.getSymbol());
		
		Rollable secondRoll4 = new SecondRoll(5);	// not hitted
		assertEquals('.', secondRoll4.getSymbol());
	}
	
	public void testGetScore() throws Exception {
		Rollable secondRoll = new SecondRoll(5);
		secondRoll.hit(5);
		assertEquals(5, secondRoll.getScore());
		
		Rollable secondRoll2 = new SecondRoll(5);
		assertEquals(0, secondRoll2.getScore());
	}
}
