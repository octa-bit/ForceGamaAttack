package scenes.game;
import scenes.Scene;
import jplay.GameImage;
import jplay.Sprite;
import jplay.Keyboard;
import player.Player;

public class GameScene extends Scene {
	private GameImage background;
	private GameImage player;
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_EVERY_PRESS);
	}
	
	protected void viewSetup(){
		background = new GameImage("src/graphics/img/space_bg.jpg");
		player = new Player(100, 100);
//		player = new Sprite("src/graphics/img/spaceship.png", 10);
		player.x = 360.0;
		player.y = 550.0;
		player.height = 90;
		player.width = 40;
	}
	
	private void draw() {
		background.draw();
		player.draw();
	}

	public void update(){
		draw();
		((Sprite) player).moveY(2.5);
		((Sprite) player).moveX(2.5);
	}
}
