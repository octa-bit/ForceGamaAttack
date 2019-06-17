package entities;

import jplay.Sprite;

public class Obstacle extends Sprite {

	private int collisionDamage;
	private Double spdX, spdY;
	
	public Obstacle(String fileName, int frameNumber, Double x, Double y, int dmg, Double spdX, Double spdY) {
		super(fileName, frameNumber);
		this.x = x;
		this.y = y;
		this.collisionDamage = dmg;
		this.spdX = spdX;
		this.spdY = spdY;
	}
	
	public void move() {
		this.x += this.spdX;
		this.y += this.spdY;
		
		this.update();
	}
	
	public int getDamage() {
		return this.collisionDamage;
	}
}
