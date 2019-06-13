package entities;

import jplay.Sprite;
import player.PlayerSpaceship;

import java.awt.Window;

import constants.Constants;
import constants.WindowConstants;

public class Bullet extends Sprite{
	
		int sentido = Constants.STOP;
		
		public Bullet(double x, double y, int sentido) {
			super("src/graphics/img/bullet_player.png", 7);
			
			 this.sentido = sentido;
			 setTotalDuration(700);
	         //Essas variáveis são da classe GameObject que é uma super classe de Sprite.
	         this.x = x;
	         this.y = y;
	         this.sentido = sentido;
			
		}
	
		public void move()
	    {            
	            
	                this.y -= 7;
	            
	    }

	    
}
