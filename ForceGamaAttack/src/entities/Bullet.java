package entities;

import jplay.Sprite;
import player.PlayerSpaceship;

import java.awt.Window;

import constants.Constants;
import constants.WindowConstants;

public class Bullet extends Sprite{
	
	int direction = Constants.STOP;
	private int vely;
	
	public Bullet(double x, double y, int vely) {
		super("src/graphics/img/bullet_player.png");
		
		this.x = x;
		this.y = y - 50;
		this.vely = vely;
		
	}

	public void move()
	{            
		this.y -= 15;    
	}

	    
}
