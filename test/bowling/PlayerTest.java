package bowling;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	public void testCreate() throws Exception {
		Player player = new Player("WJ");
		assertEquals("WJ", player.getName());
	}
	
	public void testStartRoll() throws Exception {
		Player player = new Player("WJ");
		player.startRoll();
		player.startRoll();
		player.startRoll();
		player.startRoll();
		player.startRoll();
		player.startRoll();
		player.startRoll();
		player.startRoll();
		player.startRoll();
		player.startRoll();
	}
}
