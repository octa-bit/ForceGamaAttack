package score;
import java.util.ArrayList;
import java.util.List;

import Observer.Observer;
import entities.Enemy;

public class Score extends Observer {
	public static int score=0;
	private List<Observer> observers = new ArrayList<Observer>();
	
	public static final Score INSTANCE = new Score();
	
	public Score () {
		super();
		this.addObserver(INSTANCE);
	}
	
	public static Score getInstance() {
		return INSTANCE;
	}
	
	public void notifier(Enemy enemy) {
		score+=enemy.getValue();
	}
	
	public void addEnemy(Enemy enemy) {
		enemy.attach(this);
		System.out.println("aaaaaa");
	}
	
	public int getScore() {
		return INSTANCE.score;
	}


	@Override
	public void notifyObservers(Enemy enemy) {
		for(Observer ob: observers) {
			score=score+enemy.getValue();
		}
	}

	@Override
	public void addObserver(Observer o) {
		this.observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		this.observers.remove(o);
	}
	
	public void clearScore() {
		score=0;
	}

}
