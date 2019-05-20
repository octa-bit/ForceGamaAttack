package scenes.game;
import scenes.Scene;
import jplay.GameImage;
import jplay.Keyboard;

public class GameScene extends Scene {
	private GameImage background;
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
	}
	
	protected void viewSetup(){
		background = new GameImage("src/graphics/img/space_bg.jpg");
	}

	private void draw() {
		background.draw();
	}

	public void update(){
		draw();
	}
}
