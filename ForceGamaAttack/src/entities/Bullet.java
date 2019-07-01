package entities;

import jplay.Sprite;
import player.PlayerSpaceship;

import java.awt.Window;

import constants.Constants;
import constants.WindowConstants;

public class Bullet extends Sprite{
	
	int direction = Constants.STOP;
	private int vely;
	
	public Bullet(String sprite, double x, double y, int vely) {
		super(sprite);
		
		this.x = x;
		this.y = y - 50;
		this.vely = vely;
		
	}

	public void move()
	{   
		if(y > -10) {
			this.y -= 15;
		}else {
			return;
		}
		
	}

	    
}
