package entities;

import player.Player;
import constants.FileNames;

class Issuelizer extends Enemy {
	
	private int reloadTime = 0;
	
	public Issuelizer (float x, float y) {
		super(FileNames.spritePath + "IssuelizerSprite.png", 1, x, y);
		this.hitPoints = 10;
		this.value = 5;
		this.colisionDamage = 5;
	}
	
	
	public void move() {
		this.y += 0.6;
	}

	
	public boolean isShooting() {
		if (this.reloadTime > 100) {
			this.reloadTime = 0;
			System.out.println("shooted!");
			return true;
		}
		this.reloadTime++;
		return false;
	}
	
	
	public Obstacle shoot() {
		Player target = Player.getInstance();
		
		// Euclidian distance
		Double xDistance = target.x - this.x;
		Double yDistance = target.y - this.y;
		Double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
		
		// Normalization
		Double xNormal = xDistance / distance;
		Double yNormal = yDistance / distance;
		
		return new Obstacle(FileNames.spritePath + "blueLaser.png",
				            this.x, this.y, 10, xNormal*2, yNormal*2);
	}
}
