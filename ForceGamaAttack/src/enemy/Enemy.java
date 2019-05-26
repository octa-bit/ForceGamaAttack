package enemy;
import java.util.ArrayList;
import java.util.List;

import Observer.Observer;
import score.Score;

public abstract class Enemy {
	
	protected float positionX;
	protected float positionY;
	protected int hitPoints;
	public int value;
	
	public Enemy (Score score) {
		this.attach(score);
	}
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer obs) {
		this.observers.add(obs);
	}
	
	public void deattach(Observer obs) {
		this.observers.remove(obs);
	}
	
	public void getHit(int dmg) {
		this.hitPoints -= dmg;
		if (hitPoints <= 0) {
			this.die();
		}
	}
	
	private void die() {
		for (Observer obs: observers) {
			obs.notifier(this);
		}
	}
}