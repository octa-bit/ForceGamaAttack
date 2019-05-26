package entities;

import java.util.ArrayList;
import java.util.List;

import Observer.Observer;

public class Bug extends AbstractEnemyFactory {
	
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
	
	public Bug() {
		super(sprite, 5);
		this.health = 100;
		this.shootDamage = 10;
		this.healthDamage = 10;
		this.points = 500;
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
		this.positionX += 1;
	}
	
	@Override
	void shoot() {
		// TODO;
	}
}
