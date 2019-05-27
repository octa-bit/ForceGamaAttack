package entities;

import java.util.ArrayList;
import java.util.List;
import Observer.Observer;
import jplay.Sprite;
import score.Score;

public abstract class AbstractEnemy extends Sprite{
	private int health;
	private int shootDamage;
	private int healthDamage;
	private int points;
	private static Score score;
	
	private float positionX;
	private float positionY;
	private int hitPoints;
	
	public int value;
	private int time = 0;
	private static String sprite = "";
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	
	public AbstractEnemy(int health, int shootDamage, int healthDamage, int points) {
		super(sprite, 10);
		this.health = health;
		this.shootDamage = shootDamage;
		this.healthDamage = healthDamage;
		this.points = points;
	}
	
	public AbstractEnemy(Score score, String sprite, int size) {
		super(sprite, size);
		this.attach(score);
	}
	
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
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
	
	void getHit(int dmg) {}
	void die() {}
	public void move() {}
	void shoot() {}
}
