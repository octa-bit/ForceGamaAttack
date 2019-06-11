package entities;

import jplay.Sprite;
import player.PlayerSpaceship;

public class Bullet extends Sprite{
	private static String imageFile = "src/graphics/img/bullet_player.png";
	public double velocity_x, velocity_y;
	
	public Bullet(String imageFile) {
		super(imageFile);
	}
	
	public Bullet(String imageFile, double x, double y, double velocity_x, double velocity_y) {
		super(imageFile);
		
		 this.x = x;
	     this.y = y - this.height/2.0;
	     this.velocity_x = velocity_x;
	     this.velocity_y = velocity_y;
	}
	
	public void Action(long elapsed) {
		this.Move((double)elapsed/1000.0);
	}

    public void Move(double elapsed) { // You may discover what this method does just reading the method name
    	this.x += velocity_x*elapsed;
	    this.y += velocity_y*elapsed;
    }
}
