
import jplay.Window;
import jplay.GameImage;
import jplay.Mouse;


public class Game {
	public enum GameState{
		Running, Paused, Stopped;
	}
	GameState state;
	Window window;
	GameImage background;
	GameImage startButton;
	GameImage spaceBackground;
	Mouse mouse;
	
	
	
	public Game() {
		this.window = new Window(800,600);
		this.background = new GameImage("src/graphics/img/temporary.png");
		this.state = GameState.Running;
		this.startButton = new GameImage("src/graphics/img/start_btn.png");
		this.spaceBackground = new GameImage("src/graphics/img/space_bg.jpg");
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
            	this.startGame();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												
            }
		}
	}
	
	public void startGame() {
		System.out.println("Inicio!!");
		this.background = new GameImage("src/graphics/img/space_bg.jpg");
		this.window.update();
		System.out.println("Fim!!");
	}

}
