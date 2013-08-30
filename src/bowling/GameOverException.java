package bowling;

public class GameOverException extends Exception{
	BowlingGame bowlingGame;
	
	public GameOverException(BowlingGame bowlingGame) {
		this.bowlingGame = bowlingGame;
		System.out.println(bowlingGame.toString());
		System.out.println("GameOver");
	}	
}
