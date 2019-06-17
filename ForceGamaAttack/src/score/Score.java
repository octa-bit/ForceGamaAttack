package score;
import entities.Enemy;

public class Score extends Observer.Observer {
	private int score=0;
	
	public static final Score INSTANCE = new Score();
	
	private Score () {}
	
	public static Score getInstance() {
		return INSTANCE;
	}
	
	public void notifier(Enemy enemy) {
		score+=enemy.getValue();
	}
	
	public void addEnemy(Enemy enemy) {
		enemy.attach(this);
	}
	
	public int getScore() {
		return INSTANCE.score;
	}

}
