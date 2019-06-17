package scenes.credits;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sprite;
import scenes.Scene;
import scenes.menu.MenuScene;
import text.Text;

public class CreditsScene extends Scene {
	private GameImage background;
	private ArrayList<Text> texts;
	private Text title;
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.ESCAPE_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.addKey(KeyEvent.VK_BACK_SPACE, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		texts = new ArrayList<Text>();
		title = new Text(275,80,new Font("Comic Sans MS", Font.BOLD, 40), Color.WHITE, "CRÉDITOS");
		Text name1 = new Text(180,150,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "Eduardo Lima - 16/0049458");
		Text name2 = new Text(180,190,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "Filipe Toyoshima - 16/0049971");
		Text name3 = new Text(180,230,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "Gabiel Viana - 16/0120942");
		Text name4 = new Text(180,270,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "Isaac Borges - 11/0121996");
		Text name5 = new Text(180,310,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "João Lucas - 16/0009758");
		Text name6 = new Text(180,350,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "João Vitor - 16/0010195");
		Text name7 = new Text(180,390,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "Lucas Hiroshi - 16/0034591");
		Text name8 = new Text(180,430,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "Lucas Vitor - 16/0052432");
		Text name9 = new Text(180,470,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "Luciano Santos - 16/0013321");
		Text name10 = new Text(180,510,new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30), Color.WHITE, "Rossicler Júnior - 16/0154197");
		texts.add(name1);
		texts.add(name2);
		texts.add(name3);
		texts.add(name4);
		texts.add(name5);
		texts.add(name6);
		texts.add(name7);
		texts.add(name8);
		texts.add(name9);
		texts.add(name10);
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
			game.transitTo(new MenuScene());
		}
	}

	public void update(){
		checkKeyboardPress();
		draw();
	}
}
