package frame;

import java.util.*;

import junit.framework.TestCase;

public class SymbolTest extends TestCase {
	public void testStrike() throws Exception {
		List<Integer> rolls = new ArrayList<Integer>();
		rolls.add(10);
		Symbol symbol = new Symbol(rolls);
		assertEquals("X", symbol.getSymbol());
	}
	
	public void testSpare() throws Exception {
		List<Integer> rolls = new ArrayList<Integer>();
		rolls.add(3);
		rolls.add(7);
		Symbol symbol = new Symbol(rolls);
		assertEquals("3|/", symbol.getSymbol());
	}
	
	public void testGutter() throws Exception {
		List<Integer> rolls = new ArrayList<Integer>();
		rolls.add(0);
		rolls.add(10);
		Symbol symbol = new Symbol(rolls);
		assertEquals("-|/", symbol.getSymbol());
	}
	
	public void testNormal() throws Exception {
		List<Integer> rolls = new ArrayList<Integer>();
		rolls.add(5);
		rolls.add(3);
		Symbol symbol = new Symbol(rolls);
		assertEquals("5|3", symbol.getSymbol());
	}
	
	public void testLastFrame() throws Exception {
		List<Integer> rolls = new ArrayList<Integer>();
		rolls.add(10);
		rolls.add(10);
		rolls.add(10);
		Symbol symbol = new Symbol(rolls);
		assertEquals("X|X|X", symbol.getSymbol());
		
		List<Integer> rolls2 = new ArrayList<Integer>();
		rolls2.add(3);
		rolls2.add(7);
		rolls2.add(10);
		Symbol symbol2 = new Symbol(rolls2);
		assertEquals("3|/|X", symbol2.getSymbol());
	}
}
