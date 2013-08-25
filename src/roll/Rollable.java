package roll;

public interface Rollable {

	public void hit(int hittedPin);
	public int getScore();
	public char getSymbol();
	public boolean isHitted();
	public boolean isStrike();
	public boolean isSpare();
	public int getRestPin();
}
