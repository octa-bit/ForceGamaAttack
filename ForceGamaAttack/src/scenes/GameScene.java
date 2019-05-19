package scenes;
import scenes.Scene;
import jplay.GameImage;
import jplay.Keyboard;
import java.util.ArrayList;
import constants.WindowConstants;
import jplay.Sprite;

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
