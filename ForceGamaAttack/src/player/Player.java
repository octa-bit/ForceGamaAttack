package player;

import constants.Constants;
import entities.BulletManager;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;	

public class Player extends Sprite{
	private Player player;
	private int previousDirection;
	private int direction;
	private boolean isDead = false;
	
	public static BulletManager bulletmanager;
	public String bulletimg = "src/graphics/img/bullet_player.png";
	
	public Player(double x, double  y) {
		super("src/graphics/img/spaceship.png", 10);
		this.x = x;
		this.y = y;
		direction = Constants.RIGHT;
        previousDirection = Constants.RIGHT;
	}
	
	public void move(Keyboard teclado) {
		
		//player.moveY(10.0);
		//player.moveX(10.0);
		if ( teclado.keyDown(Keyboard.LEFT_KEY) && this.x > 1 ){
				if (direction != Constants.LEFT){   
					previousDirection = Constants.LEFT;
					direction = Constants.LEFT;
				}
				this.x -= 2;

		}
		else{
			if ( teclado.keyDown(Keyboard.RIGHT_KEY)){
				if (direction != Constants.RIGHT){
					previousDirection = Constants.RIGHT;
					direction = Constants.RIGHT;
				}
				this.x += 2;
			}
			else{                     
				direction = Constants.STOP;
				if (previousDirection == Constants.RIGHT)
					setCurrFrame(17);
				else{
					if (previousDirection == Constants.LEFT)
						setCurrFrame(3);
				}
			}
		}
		if (direction != Constants.STOP) {
			update();
		}
	}
	
	
	public boolean isDead(){
		return isDead;
	}
}
