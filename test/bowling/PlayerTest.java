package bowling;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	public void testCreate() throws Exception {
		Player player = new Player("WJ");
		assertEquals("WJ", player.getName());
	}
	
	public void testGetScoreList() throws Exception {
		Player player = new Player("WJ");
		player.hit(10);
		player.hit(10);
		player.hit(10);
		player.hit(5);
		player.hit(3);
		player.hit(5);
		player.hit(5);
		System.out.println(player.getScoreList().toString());
	}
	
	public void testGetSymbolList() throws Exception {
		Player player = new Player("WJ");
		player.hit(10);
		player.hit(10);
		player.hit(10);
		player.hit(5);
		player.hit(3);
		player.hit(5);
		player.hit(5);
		System.out.println(player.getSymbolList().toString());
	}

}
