package scenes.game;
import scenes.Scene;
import jplay.GameImage;
import jplay.Sprite;
import player.Player;
import jplay.Keyboard;

public class GameScene extends Scene {
	private GameImage background;
	private GameImage playerImage;
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_EVERY_PRESS);
	}
	
	protected void viewSetup(){
		background = new GameImage("src/graphics/img/space_bg.jpg");
		playerImage = new Player(100, 100);
//		playerImage = new Sprite("src/graphics/img/spaceship.png", 10);
		playerImage.x = 360.0;
		playerImage.y = 550.0;
		playerImage.height = 90;
		playerImage.width = 40;
	}
	
	private void draw() {
		background.draw();
		playerImage.draw();
	}

	public void update(){
		draw();
		((Sprite) playerImage).moveY(2.5);
		((Sprite) playerImage).moveX(2.5);
	}
}
