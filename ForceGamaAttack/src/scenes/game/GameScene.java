package scenes.game;
import scenes.Scene;
import jplay.GameImage;
import jplay.GameObject;
import jplay.Keyboard;
import player.Player;

public class GameScene extends Scene {
	private GameImage background;
	private GameImage player;
	private GameObject player1;
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
	}
	
	protected void viewSetup(){
		background = new GameImage("src/graphics/img/space_bg.jpg");
		player = new GameImage("src/graphics/img/SpaceshipWhiteNoT.gif");
		player.x = 360.0;
		player.y = 550.0;
		player.height = 40;
		player.width = 40;
	}
	

	private void draw() {
		background.draw();
		player.draw();
	}

	public void update(){
		draw();
	}
	
}
