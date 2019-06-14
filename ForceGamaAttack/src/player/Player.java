package player;

import constants.Constants;
import entities.BulletManager;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;	

public class Player extends Sprite{
	private Player player;
	private int sentidoAnterior;
	private int sentido;
	private boolean isDead = false;
	
	public static BulletManager bulletmanager;
	public String bulletimg = "src/graphics/img/bullet_player.png";
	
	public Player(double x, double  y) {
		super("src/graphics/img/spaceship.png", 10);
		this.x = x;
		this.y = y;
		sentido = Constants.RIGHT;
        sentidoAnterior = Constants.RIGHT;
	}
	
	public void move(Keyboard teclado) {
		
		//player.moveY(10.0);
		//player.moveX(10.0);
		if ( teclado.keyDown(Keyboard.LEFT_KEY) && this.x > 1 ){
				if (sentido != Constants.LEFT){   
					sentidoAnterior = Constants.LEFT;
					sentido = Constants.LEFT;
				}
				this.x -= 2;

		}
		else{
			if ( teclado.keyDown(Keyboard.RIGHT_KEY)){
				if (sentido != Constants.RIGHT){
					sentidoAnterior = Constants.RIGHT;
					sentido = Constants.RIGHT;
				}
				this.x += 2;
			}
			else{                     
				sentido = Constants.STOP;
				if (sentidoAnterior == Constants.RIGHT)
					setCurrFrame(17);
				else{
					if (sentidoAnterior == Constants.LEFT)
						setCurrFrame(3);
				}
			}
		}
		if (sentido != Constants.STOP) {
			update();
		}
	}
	
	
	public boolean isDead(){
		return isDead;
	}
}
