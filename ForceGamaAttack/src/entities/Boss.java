package entities;

import java.util.ArrayList;
import java.util.List;

import Observer.Observer;
import score.Score;

public class Boss extends AbstractEnemy {

	private int health;
	private int shootDamage;
	private int healthDamage;
	private int points;
	
	private float positionX;
	private float positionY;
	private int hitPoints;
	
	public int value;
	private int time = 0;
	private final static String sprite = "src/graphics/img/ship-enemy.png";
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	public Boss(Score score) {
		super(score, sprite, 15);
		this.health = 1000;
		this.shootDamage = 100;
		this.healthDamage = 100;
		this.points = 5000;
		this.attach(score);
	}
	
	@Override
	void getHit(int dmg) {
		this.hitPoints -= dmg;
		if (hitPoints <= 0) {
			this.die();
		}
	}
	@Override
	void die() {
		for (Observer obs: observers) {
			obs.notifier(this);
		}
	}
	@Override
	public void move() {
		this.y += 2;
		this.x += 2;
	}
	
	@Override
	void shoot() {
		// TODO;
	}
}
