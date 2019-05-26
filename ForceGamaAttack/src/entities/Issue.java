package entities;

import java.util.ArrayList;
import java.util.List;

import Observer.Observer;

public class Issue extends AbstractEnemyFactory {
	
	private int health;
	private int shootDamage;
	private int healthDamage;
	private int points;
	
	private float positionX;
	private float positionY;
	private int hitPoints;
	
	public int value;
	private final static String sprite = "src/graphics/img/ship-enemy.png";
	private List<Observer> observers = new ArrayList<Observer>();
	
	public Issue() {
		super(sprite, 10);
		this.health = 2000;
		this.shootDamage = 200;
		this.healthDamage = 200;
		this.points = 800;
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
		this.positionY += 1;
		this.positionX += 2;
	}
	
	@Override
	void shoot() {
		// TODO;
	}
}
