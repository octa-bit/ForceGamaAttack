package entities;

import player.Player;
import java.lang.Math;

class Buging extends Enemy {

	public Buging (float x, float y) {
		super("src/graphics/img/sprites/BugingSprite.png", 1, x, y);
		this.hitPoints = 10;
		this.value = 5;
		this.colisionDamage = 5;
	}
	
	public void move() {
		Player target = Player.getInstance();
		
		// Euclidian distance
		Double xDistance = target.x - this.x;
		Double yDistance = target.y - this.y;
		Double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
		
		// Normalization
		Double xNormal = xDistance / distance;
		Double yNormal = yDistance / distance;
		
		// Move
		this.x += xNormal * 3;
		this.y += yNormal * 3;
	}

}
