
import jplay.Window; 

import java.awt.Color;

import constants.WindowConstants;
import scenes.Scene;
import scenes.menu.MenuScene;
import controller.Controller;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("It's running!");  
		Window window = new Window(WindowConstants.WIDTH,WindowConstants.HEIGHT);
		
		Controller game = new Controller();
		game.keyboard = window.getKeyboard();
		
		Scene scene = new MenuScene();
		game.transitTo(scene);
		
		boolean isRunning = true;
		
		while(isRunning) {
			window.delay(16);
			window.clear(Color.black);
			isRunning = game.update();
			window.update();
		
		}
		window.exit();
	}
}
