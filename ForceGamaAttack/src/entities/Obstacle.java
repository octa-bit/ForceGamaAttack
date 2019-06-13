package entities;

import jplay.Sprite;

public class Obstacle extends Sprite {

	private int collisionDamage;
	private Double spdX, spdY;
	
	public Obstacle(String fileName, Double x, Double y, int dmg, Double spdX, Double spdY) {
		super(fileName);
		this.x = x;
		this.y = y;
		this.collisionDamage = dmg;
		this.spdX = spdX;
		this.spdY = spdY;
		
		Double totalSpd = Math.sqrt(spdX * spdX + spdY + spdY);
		Double normalY = spdY / totalSpd;
		
		Double yAngle = Math.acos(normalY);
		if (x < spdX) {
			this.setRotation(yAngle);
		} else {
			this.setRotation(-yAngle);
		}
		
		System.out.println("created!");
	}
	
	public void move() {
		this.x += this.spdX;
		this.y += this.spdY;
	}
	
	public int getDamage() {
		return this.collisionDamage;
	}

}
