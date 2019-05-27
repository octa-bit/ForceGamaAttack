package score;
import entities.AbstractEnemyFactory;

public class Score extends Observer.Observer {
	private int score=0;
	
	private static final Score INSTANCE = new Score();
	
	private Score () {}
	
	public void notifier(AbstractEnemyFactory enemy) {
		score+=enemy.value;
	}
	
	public void addEnemy(AbstractEnemyFactory enemy) {
		enemy.attach(this);
	}
	
	public int getScore() {
		return INSTANCE.score;
	}

}
