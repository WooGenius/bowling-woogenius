package bowling;

public class GameOverException extends Exception{
	public GameOverException() {
		GenerateBoard.generate();
	}
}
