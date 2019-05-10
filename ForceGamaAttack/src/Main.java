import jplay.Window;
import jplay.GameImage;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("It's running!");
		
		Window window = new Window(800,600);
		
		GameImage background = new GameImage("src/graphics/img/temporary.png");
		
		//basic game loop		
		while(true) {
			
			background.draw();
			window.update();
		}
	}
}
