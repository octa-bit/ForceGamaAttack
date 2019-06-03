package scenes.configuration;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyEvent;

import jplay.GameImage;
import jplay.Keyboard;
import scenes.Scene;
import scenes.menu.MenuScene;
import text.Text;

public class ConfigurationScene extends Scene {
	private GameImage background;
	private Text title;
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.ESCAPE_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.addKey(KeyEvent.VK_BACK_SPACE, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		title = new Text(235,80,new Font("Comic Sans MS", Font.BOLD, 40), Color.WHITE, "CONFIGURAÇÕES");
	}
	
	protected void viewSetup(){
		background = new GameImage("src/graphics/img/space_bg.jpg");
	}
	
	private void draw() {
		background.draw();
		title.draw();
	}
	
	private void checkKeyboardPress() {
		if ( keyboard.keyDown(KeyEvent.VK_BACK_SPACE) || keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
			game.transitTo(new MenuScene());
		}
	}

	public void update(){
		checkKeyboardPress();
		draw();
	}
}

