package score;
import java.util.ArrayList;
import java.util.List;

import Observer.Observer;
import entities.Enemy;

public class Score extends Observer {
	private int score=0;
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
	public void notifyObservers() {
		for(Observer ob: observers) {
			System.out.println(ob);
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

}
