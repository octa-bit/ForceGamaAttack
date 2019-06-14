package entities;

import jplay.Sprite;
import player.PlayerSpaceship;

import java.awt.Window;

import constants.Constants;
import constants.WindowConstants;

public class Bullet extends Sprite{
	
	int sentido = Constants.STOP;
	
	public Bullet(double x, double y) {
		super("src/graphics/img/bullet_player.png", 1);
		
		this.x = x;
		this.y = y;
		
	}

	public void move()
	{            
		this.y -= 15;    
	}

	    
}
