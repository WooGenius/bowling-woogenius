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
	
	public void testLastFrame() throws Exception {
		List<Integer> rolls = new ArrayList<Integer>();
		rolls.add(4);
		rolls.add(6);
		Identifier id = new Identifier(rolls, true);
		assertTrue(id.isSpare());
		
		List<Integer> rolls2 = new ArrayList<Integer>();
		rolls2.add(10);
		rolls2.add(6);
		id = new Identifier(rolls, true);
		assertTrue(id.isStrikeForLastRoll());
	}
	
	public void testFinished() throws Exception {
		List<Integer> rolls = new ArrayList<Integer>();
		rolls.add(10);
		Identifier id = new Identifier(rolls);
		assertTrue(id.isFinished());
		
		List<Integer> rolls2 = new ArrayList<Integer>();
		rolls2.add(3);
		rolls2.add(5);
		id = new Identifier(rolls2);
		assertTrue(id.isFinished());
		
		List<Integer> rolls3 = new ArrayList<Integer>();
		rolls3.add(3);
		rolls3.add(7);
		id = new Identifier(rolls3);
		assertTrue(id.isFinished());
		
		List<Integer> rolls4 = new ArrayList<Integer>();
		rolls4.add(3);
		rolls4.add(7);
		id = new Identifier(rolls4, true);
		assertFalse(id.isFinished());
	}
	
	public void testValid() throws Exception {
		List<Integer> rolls = new ArrayList<Integer>();
		rolls.add(11);
		Identifier id = new Identifier(rolls);
		assertFalse(id.isValid());
		
		List<Integer> rolls2 = new ArrayList<Integer>();
		rolls2.add(5);
		rolls2.add(7);
		id = new Identifier(rolls2);
		assertFalse(id.isValid());
		
		List<Integer> rolls3 = new ArrayList<Integer>();
		rolls3.add(10);
		rolls3.add(7);
		rolls3.add(7);
		id = new Identifier(rolls3, true);
		assertFalse(id.isValid());
	}
	
}
