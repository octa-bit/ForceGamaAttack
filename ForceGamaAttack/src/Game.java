import jplay.Window;
import jplay.GameImage;
import jplay.Mouse;
import java.awt.Point;

public class Game {
	GameState state;
	Window window;
	GameImage background;
	GameImage startButton;
	Mouse mouse;
	
	public enum GameState{
		Running, Paused, Stopped;
	}
	
	public Game() {
		this.window = new Window(800,600);
		this.background = new GameImage("src/graphics/img/temporary.png");
		this.state = GameState.Running;
		this.startButton = new GameImage("src/graphics/img/start_btn.png");
		this.startButton.x = 300;
		this.startButton.y = 150;
		this.mouse = window.getMouse();
	}
	
	public void runGame() {
		while(this.state == GameState.Running) {
			this.background.draw();
			this.startButton.draw();
			this.window.update();
			
			if (mouse.isLeftButtonPressed() && mouse.isOverObject(startButton))  
            {  
                System.out.println("Starting game!!");
            	window.exit();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																													
            }
		}
	}

}
