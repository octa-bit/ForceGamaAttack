package entities;

import java.util.ArrayList;
import java.util.List;
import Observer.Observer;
import jplay.Sprite;
import score.Score;

public abstract class Enemy extends Sprite{
		
//  // Sprite already has an attribute X
//	private float positionX;
//	private float positionY;

	protected int hitPoints;
	protected int value;
	protected int colisionDamage;
	private int health;
	
	private static String sprite = "";
	private List<Observer> observers = new ArrayList<Observer>();
	private static final Score s = Score.getInstance();
	
	protected Enemy(String sprite, int size, float x, float y, int health) {
		super(sprite, size);
		this.x = x;
		this.y = y;
		this.health = health;
		this.attach(s);
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
	
	
	public int getColisionDmg() {
		return this.colisionDamage;
	}
	
	
	private void die() {
		for (Observer obs: observers) {
			obs.notifier(this);
		}
	}
	
	public int getValue() {
		return this.value;
	}
	
	
	public abstract void move();
	
	
	public Obstacle shoot() {
		return null;
	}
	
	
	public boolean isShooting() {
		return false;
	}
	

	public abstract void reset();
	
	
	public void takeDamage(int damage) {
		health -= damage;
	}
	
	
	public int getHealth() {
		return health;
	}
}
