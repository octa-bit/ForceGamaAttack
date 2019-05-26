package entities;

import java.util.ArrayList;
import java.util.List;

import Observer.Observer;

public class Boss extends AbstractEnemyFactory {

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
	
	public Boss() {
		super(sprite, 15);
		this.health = 1000;
		this.shootDamage = 100;
		this.healthDamage = 100;
		this.points = 5000;
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
	void move() {
		this.positionY += 2;
		this.positionX += 0;
	}
	
	@Override
	void shoot() {
		// TODO;
	}
}
