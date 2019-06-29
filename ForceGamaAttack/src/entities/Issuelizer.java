package entities;

import player.Player;
import player.Structure;
import constants.FileNames;

class Issuelizer extends Enemy {
	
	private int reloadTime = 0;
	public static int health = 100;
	
	public Issuelizer (float x, float y) {
		super(FileNames.spritePath + "IssuelizerSprite.png", 1, x, y, health);
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
			return true;
		}
		this.reloadTime++;
		return false;
	}
	
	
	public Obstacle shoot() {
		// get the Target
		Structure target = Player.getInstance().getStructure();
		
		// Euclidean distance
		Double xDistance = target.x - this.x;
		Double yDistance = target.y - this.y;
		Double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
		
		// Normalization of distance
		Double xNormal = xDistance / distance;
		Double yNormal = yDistance / distance;
		
		// Speed of the bullet
		Double bulletSpd = 2.0;
		
		// Instantiate the bullet
		Obstacle obj = new Obstacle(FileNames.spritePath + "fireShoot.png", 2,
				                    this.x, this.y, 10, xNormal*bulletSpd, yNormal*bulletSpd);
		obj.setTotalDuration(20);
		
		return obj;
	}
}
