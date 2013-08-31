package bowling;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	public void testCreate() throws Exception {
		Player player = new Player("WJ");
		assertEquals("WJ", player.getName());
	}
	
	public void testStartRoll() throws Exception {
		Player player = new Player("WJ");
		player.startRoll();	// first turn
		System.out.println(1);
		player.startRoll();	// second turn
		System.out.println(2);
		player.startRoll();
		System.out.println(3);
		player.startRoll();
		System.out.println(4);
		player.startRoll();
		System.out.println(5);
		player.startRoll();
		System.out.println(6);
		player.startRoll();
		System.out.println(7);
		player.startRoll();
		System.out.println(8);
		player.startRoll();
		System.out.println(9);
		player.startRoll();
		System.out.println(10);
	}
}
