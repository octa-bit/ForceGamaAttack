package player;
import jplay.Keyboard;

import constants.Constants;
import entities.BulletManager;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;	

public class Player extends Sprite{
	private Player player;
	double speed;
	private Structure structure;
	static String sprite = "src/graphics/img/spaceship.png";
	private Keyboard keyboard;
	private int previousDirection;
	private int direction;
	private boolean isDead = false;
	
	private static final Player INSTANCE = new Player(360, 550, sprite);
	
	public Player(int x, int y, String sprite) {	
		super(sprite, 10);
		this.x = x;
		this.y = y;
		this.speed = 10.0;
		direction = Constants.RIGHT;
        previousDirection = Constants.RIGHT;
	}
	
	public static Player getInstance() {
		return INSTANCE;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	
	
	public void move(Keyboard keyboard) {
		
		//player.moveY(10.0);
		//player.moveX(10.0);
		if ( keyboard.keyDown(Keyboard.LEFT_KEY) && this.x > 1 ){
				if (direction != Constants.LEFT){   
					previousDirection = Constants.LEFT;
					direction = Constants.LEFT;
				}
				this.x -= 2;

		}
		else{
			if ( keyboard.keyDown(Keyboard.RIGHT_KEY)){
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
