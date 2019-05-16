package src;

import jplay.Window;
import jplay.GameImage;

public class Game {
	GameState state;
	Window window;
	GameImage background;
	
	public enum GameState{
		Running, Paused, Stopped;
	}
	
	public Game() {
		this.window = new Window(800,600);
		this.background = new GameImage("src/graphics/img/temporary.png");
		this.state = GameState.Running;
	}
	
	public void runGame() {
		while(this.state == GameState.Running) {
			this.background.draw();
			this.window.update();
		}
	}

}
