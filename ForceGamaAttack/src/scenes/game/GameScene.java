package scenes.game;
import scenes.Scene;
import jplay.GameImage;
import jplay.Sprite;
import jplay.Keyboard;

public class GameScene extends Scene {
	private GameImage background;
	private GameImage player;
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
	}
	
	protected void viewSetup(){
		background = new GameImage("src/graphics/img/space_bg.jpg");
		player = new Sprite("src/graphics/img/spaceship.png", 10);
		player.x = 360.0;
		player.y = 550.0;
		player.height = 100;
		player.width = 100;
	}
	
	private void draw() {
		background.draw();
		player.draw();
	}

	public void update(){
		draw();
		((Sprite) player).moveY(10.0);
		((Sprite) player).moveX(10.0);
	}
}
