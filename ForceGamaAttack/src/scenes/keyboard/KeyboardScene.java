package scenes.keyboard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import jplay.GameImage;
import jplay.Keyboard;
import scenes.Scene;
import scenes.configuration.ConfigurationScene;
import text.Text;

public class KeyboardScene extends Scene {
	private GameImage background;
	private ArrayList<Text> texts;
	private Text title;
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.ESCAPE_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.addKey(KeyEvent.VK_BACK_SPACE, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		texts = new ArrayList<Text>();
		title = new Text(275,80,new Font("Comic Sans MS", Font.BOLD, 40), Color.WHITE, "TECLADO");
		Text name1 = new Text(180,150,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "KeyUp - Move a nave para cima");
		Text name2 = new Text(180,190,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "KeyDown - Move a nave para baixo");
		Text name3 = new Text(180,230,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "KeyLeft - Move a nave para a esquerda");
		Text name4 = new Text(180,270,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "KeyRight - Move a nove para a direita");
		Text name5 = new Text(180,310,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "SpaceKey - Atira");
		Text name6 = new Text(180,350,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "P - Pausa/despausa o jogo");
		texts.add(name1);
		texts.add(name2);
		texts.add(name3);
		texts.add(name4);
		texts.add(name5);
		texts.add(name6);
	}
	
	protected void viewSetup(){
		background = new GameImage("src/graphics/img/space_bg.jpg");
	}
	
	private void draw() {
		background.draw();
		title.draw();
		for (Text text : texts) {
			text.draw();
		}
	}
	
	private void checkKeyboardPress() {
		if ( keyboard.keyDown(KeyEvent.VK_BACK_SPACE) || keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
			game.transitTo(new ConfigurationScene());
		}
	}

	public void update(){
		checkKeyboardPress();
		draw();
	}
}
