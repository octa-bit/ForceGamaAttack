package score;
import entities.AbstractEnemy;

public class Score extends Observer.Observer {
	private int score=0;
	
	private static final Score INSTANCE = new Score();
	
	private Score () {}
	
	public void notifier(AbstractEnemy enemy) {
		score+=enemy.value;
	}
	
	public void addEnemy(AbstractEnemy enemy) {
		enemy.attach(this);
	}
	
	public int getScore() {
		return INSTANCE.score;
	}

}
