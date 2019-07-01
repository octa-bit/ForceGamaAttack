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

public class ConfigurationScene extends Scene {
	private GameImage background;
	private Sprite arrow;
	private Text title;
	private Text sound, soundStatus, keyboardConfiguration;
	private String configOption;
	private ConfigurationMenu selectedMenu;
	
	protected void initialSetup() {
		selectedMenu = new ConfigurationMenu(new SoundState());
		
		keyboard.setBehavior(Keyboard.ESCAPE_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.addKey(KeyEvent.VK_BACK_SPACE, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.addKey(Keyboard.ENTER_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		title = new Text(235,80,new Font("Comic Sans MS", Font.BOLD, 40), Color.WHITE, "CONFIGURAÇÕES");
		sound = new Text(180,180,new Font("Comic Sans MS", Font.BOLD, 35), Color.WHITE, "SOM: ");
		keyboardConfiguration = new Text(180,240,new Font("Comic Sans MS", Font.BOLD, 35), Color.WHITE, "CONFIGURAÇÃO DO TECLADO");
		configOption = "sound";
	}
	
	private void moveArrow() {
		int currentButtonIndex = this.selectedMenu.getOrdinal().ordinal();
		if (currentButtonIndex == 0) {
			arrow.x = 135;
			arrow.y = 150;
		} else {
			arrow.x = 135;
			arrow.y = 210;
		}
		
	}
	
	protected void viewSetup(){
		background = new GameImage("src/graphics/img/space_bg.jpg");
		arrow = new Sprite("src/graphics/img/seta.png");
		arrow.x = 135;
		arrow.y = 150;
		drawConfigButtons();
	}
	
	private void draw() {
		background.draw();
		title.draw();
		sound.draw();
		keyboardConfiguration.draw();
		drawConfigButtons();
	}

	private void drawConfigButtons() {
		if (game != null) {
			if (game.getSoundStatus()) {
				soundStatus = new Text(280,180,new Font("Comic Sans MS", Font.BOLD, 35), Color.WHITE, "LIGADO");
			} else {
				soundStatus = new Text(280,180,new Font("Comic Sans MS", Font.BOLD, 35), Color.WHITE, "DESLIGADO");
			}
			if (soundStatus != null && arrow != null) {
				soundStatus.draw();
				moveArrow();
				arrow.draw();
			}
		}
	}

	private void checkUserEntry() {
		if (keyboard.keyDown(KeyEvent.VK_BACK_SPACE) || keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
			game.transitTo(new MenuScene());
		} else if (keyboard.keyDown(Keyboard.DOWN_KEY)){
			selectedMenu.nextState();
		} else if (keyboard.keyDown(Keyboard.UP_KEY)){
			selectedMenu.previousState();
		} else if (keyboard.keyDown(Keyboard.ENTER_KEY)){
			if(selectedMenu.getOrdinal().ordinal() == 0) {
				if(configOption.indexOf("sound") !=-1) {
					game.changeSoundStatus();
				}
			} else {
				game.transitTo(selectedMenu.getScene());
			}
		}
	}

	public void update(){
		checkUserEntry();
		draw();
	}
}

