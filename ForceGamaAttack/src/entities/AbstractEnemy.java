package entities;

import java.util.ArrayList;
import java.util.List;
import Observer.Observer;
import jplay.Sprite;
import score.Score;

public abstract class AbstractEnemy extends Sprite{
		
//  // Sprite already has an attribute X
//	private float positionX;
//	private float positionY;

	private int hitPoints;
	
	public int value;
	private static String sprite = "";
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	
	public AbstractEnemy(Score score, String sprite, int size, float x, float y) {
		super(sprite, size);
		this.x = x;
		this.y = y;
		this.attach(score);
	}

	
  // Position should not be changed by another class
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	
	public double getX () {
		return this.x;
	}
	
	
	public double getY () {
		return this.y;
	}
	
	
	public void setSize(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	
	public void attach(Observer obs) {
		this.observers.add(obs);
	}
	
	
	public void deattach(Observer obs) {
		this.observers.remove(obs);
	}
	
	
	public void getHit(int dmg) {
		this.hitPoints -= dmg;
		
		if (this.hitPoints <= 0) {
			this.die();
		}
	}
	
	
	private void die() {
		for (Observer obs: observers) {
			obs.notifier(this);
		}
	}
	
	
	public void move() {}
	void shoot() {}
}
