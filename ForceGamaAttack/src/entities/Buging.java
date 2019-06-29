package entities;

import player.Player;
import player.Structure;

import java.lang.Math;

class Buging extends Enemy {

	public Buging (float x, float y) {
		super("src/graphics/img/sprites/BugingSprite.png", 1, x, y);
		this.reset();
	}
	
	public void move() {
		Structure target = Player.getInstance().structure;
		
		// Euclidian distance
		Double xDistance = target.x - this.x;
		Double yDistance = target.y - this.y;
		Double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
		
		// Normalization
		Double xNormal = xDistance / distance;
		Double yNormal = yDistance / distance;
		
		// Move
		this.x += xNormal * 2;
		this.y += yNormal * 2;
		
		// Rotate (calculate angle between (0,1) and target)
		// This is sorcery! And probably a dummy sorcery
		Double yAngle = Math.acos(yNormal);
		if (this.x > target.x) {
			this.setRotation(yAngle);
		} else {
			this.setRotation(-yAngle);
		}
	}

	
	public void reset() {
		this.hitPoints = 10;
		this.value = 5;
		this.colisionDamage = 5;
	}
}
