package roll;

import junit.framework.TestCase;

public class FirstRollTest extends TestCase {
	public void testGetSymbol() throws Exception {
		Rollable firstRoll = new FirstRoll();	// strike
		firstRoll.hit(10);
		assertEquals('X', firstRoll.getSymbol());
		
		Rollable firstRoll2 = new FirstRoll();	// normal
		firstRoll2.hit(5);
		assertEquals('5', firstRoll2.getSymbol());

		Rollable firstRoll3 = new FirstRoll();	// gutter
		firstRoll3.hit(0);
		assertEquals('-', firstRoll3.getSymbol());
		
		Rollable firstRoll4 = new FirstRoll();	// not hitted
		assertEquals('.', firstRoll4.getSymbol());
	}
	
	public void testGetScore() throws Exception {
		Rollable firstRoll = new FirstRoll();
		firstRoll.hit(10);
		assertEquals(10, firstRoll.getScore());
		
		Rollable firstRoll2 = new FirstRoll();
		assertEquals(0, firstRoll2.getScore());
	}
}
