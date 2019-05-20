package scenes.menu;
import scenes.Scene;
import scenes.game.GameScene;
import jplay.GameImage;
import jplay.Keyboard;
import java.util.ArrayList;
import constants.WindowConstants;
import jplay.Sprite;

public class MenuScene extends Scene {
	private static final int DISTANCE_TITLE_BUTTON = WindowConstants.HEIGHT/24;
	private static final int DISTANCE_BETWEEN_BUTTONS = WindowConstants.HEIGHT/48;
	private static Scene startLevel;
	
	private OptionMenu selectedMenuOption = OptionMenu.Start;
	
	private GameImage background;
	private Sprite title;
	private Sprite arrow;
	private ArrayList<Sprite> buttons = new ArrayList<Sprite>();
	
	protected void initialSetup(){
		
		selectedMenuOption = OptionMenu.Start;
		startLevel = new GameScene();
		
		keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
	}
	
	protected void viewSetup(){
		background = new GameImage("src/graphics/img/temporary.png");

		title = new Sprite("src/graphics/img/fga.png");
		title.x = WindowConstants.WIDTH/2 - title.width/2;
		title.y = WindowConstants.HEIGHT/3 - title.height/2;

		appendButtons();

		arrow = new Sprite("src/graphics/img/seta.png");
		arrow.x = 10;
		arrow.y = 10;
	}
	
	private void appendButtons() {
		Sprite startButton = new Sprite("src/graphics/img/new-game.png");
		Sprite settingsButton = new Sprite("src/graphics/img/config.png");
		Sprite quitButton = new Sprite("src/graphics/img/exit.png");
		
		buttons.add(startButton);
		buttons.add(settingsButton);
		buttons.add(quitButton);
		
		for(OptionMenu option : OptionMenu.values()) {
			int currentButtonIndex = option.ordinal();
			if(currentButtonIndex == 0) {
				buttons.get(currentButtonIndex).x = WindowConstants.WIDTH/2 - startButton.width/2;
				buttons.get(currentButtonIndex).y = title.y + title.height + DISTANCE_TITLE_BUTTON;
			} else {
				buttons.get(currentButtonIndex).x = buttons.get(currentButtonIndex - 1).x;
				buttons.get(currentButtonIndex).y = buttons.get(currentButtonIndex - 1).y + buttons.get(currentButtonIndex - 1).height + DISTANCE_BETWEEN_BUTTONS;
			}
		}
	}
	
	private void checkMenuOption() {
				if (keyboard.keyDown(Keyboard.DOWN_KEY)){
					System.out.println("down");
					selectedMenuOption = selectedMenuOption.next();
					System.out.println(selectedMenuOption);
				}
				
				if (keyboard.keyDown(Keyboard.UP_KEY)){
					System.out.println("up");
					selectedMenuOption = selectedMenuOption.back();
					System.out.println(selectedMenuOption);
				}
	}
	
	private void moveArrow() {
		int currentButtonIndex = this.selectedMenuOption.ordinal();
		Sprite currentButton = this.buttons.get(currentButtonIndex);
		
		this.arrow.x = currentButton.x - arrow.width - DISTANCE_BETWEEN_BUTTONS;
		this.arrow.y = currentButton.y;
		
	}
	
	private void draw() {
		background.draw();
		title.draw();
		arrow.draw();
		
		for(Sprite button: this.buttons) {
			button.draw();
		}
	}
	
	public Scene startStage(){
		return startLevel;
	}
	
	public Scene settings(){
		return null;
	}

	private void checkButtonSelection(){
		if (keyboard.keyDown(Keyboard.ENTER_KEY)){
			
			switch(selectedMenuOption){
				case Start:
					game.transitTo(startStage());
					break;
				case Config:
					game.transitTo(settings());
					break;
				case Exit:
					game.quit();
					break;
			}
		}
	}
	
	public void update(){
		checkMenuOption();
		moveArrow();
		checkButtonSelection();
		draw();
	}
}
