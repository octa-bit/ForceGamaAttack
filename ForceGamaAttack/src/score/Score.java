package score;
import enemy.Enemy;

public class Score extends Observer.Observer {
	private int score=0;
	
	private static final Score INSTANCE = new Score();
	
	private Score () {}
	
	public void notifier(Enemy enemy) {
		score+=enemy.value;
	}
	
	public void addEnemy(Enemy enemy) {
		enemy.attach(this);
	}
	
	public int getScore() {
		return INSTANCE.score;
	}
}
