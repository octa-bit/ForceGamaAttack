package scenes.configuration;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyEvent;
import constants.WindowConstants;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sprite;
import scenes.Scene;
import scenes.menu.MenuScene;
import text.Text;
import jplay.Mouse;

public class ConfigurationScene extends Scene {
	private GameImage background;
	private Text title;
	private Sprite soundImg;
	private Mouse mouse;
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.ESCAPE_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.addKey(KeyEvent.VK_BACK_SPACE, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		mouse = game.getMouse();
		title = new Text(235,80,new Font("Comic Sans MS", Font.BOLD, 40), Color.WHITE, "CONFIGURAÇÕES");
	}
	
	protected void viewSetup(){
		background = new GameImage("src/graphics/img/space_bg.jpg");
		drawConfigButtons();
		soundImg.x = WindowConstants.WIDTH/2 - soundImg.width/2;
		soundImg.y = WindowConstants.HEIGHT/2 - soundImg.height/2 + 50;
	}
	
	private void draw() {
		background.draw();
		soundImg.draw();
		title.draw();
	}

	private void drawConfigButtons() {
		if (game.getSoundStatus()) {
			soundImg = new Sprite("src/graphics/guiPack/white_musicOff.png");
		} else {
			soundImg = new Sprite("src/graphics/guiPack/white_musicOn.png");
		}
		soundImg.x = WindowConstants.WIDTH/2 - soundImg.width/2;
		soundImg.y = WindowConstants.HEIGHT/2 - soundImg.height/2 + 50;
	}

	private void checkUserEntry() {
		if (keyboard.keyDown(KeyEvent.VK_BACK_SPACE) || keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
			game.transitTo(new MenuScene());
		}
		if(mouse.isLeftButtonPressed()) {
			if (mouse.isOverObject(soundImg)) {
				game.changeSoundStatus();
				drawConfigButtons();
			}
		}
	}

	public void update(){
		checkUserEntry();
		draw();
	}
}

