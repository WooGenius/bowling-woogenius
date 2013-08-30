package frame;

import java.util.*;

import junit.framework.TestCase;

public class IdentifierTest extends TestCase {
	public void testStrike() throws Exception {
		List<Integer> rolls = new ArrayList<Integer>();
		rolls.add(10);
		Identifier id = new Identifier(rolls);
		assertTrue(id.isStrike());
	}
	
	public void testSpare() throws Exception {
		List<Integer> rolls = new ArrayList<Integer>();
		rolls.add(4);
		rolls.add(6);
		Identifier id = new Identifier(rolls);
		assertTrue(id.isSpare());
	}
}
