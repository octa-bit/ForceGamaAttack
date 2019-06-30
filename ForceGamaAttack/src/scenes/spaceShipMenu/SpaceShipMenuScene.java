package scenes.spaceShipMenu;
import scenes.Scene;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sound;

import java.util.ArrayList;
import constants.WindowConstants;
import jplay.Sprite;

public class SpaceShipMenuScene extends Scene {
	private static final int DISTANCE_TITLE_BUTTON = WindowConstants.HEIGHT/24;
	private static final int DISTANCE_BETWEEN_BUTTONS = WindowConstants.HEIGHT/48;
	
	private Menu selectedMenu;
	
	private GameImage background;
	private Sprite title;
	private Sprite arrow;
	private ArrayList<Sprite> buttons = new ArrayList<Sprite>();
	private Sound backgroundSoundMenu;
	
	protected void initialSetup(){
		selectedMenu = new Menu(new JavaShipState());
		
		keyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.addKey(Keyboard.ENTER_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		System.out.println("L R Keys");
	}
	
	protected void viewSetup(){
		System.out.print("Spaceship select");
		background = new GameImage("src/graphics/img/temporary.png");
		appendButtons();

		arrow = new Sprite("src/graphics/img/seta-up.png");
		arrow.x = 250;
		arrow.y = 10;
		
		backgroundSoundMenu = new Sound("src/sounds/take_on_me.wav");
		//backgroundSoundMenu.setRepeat(true);
		if (game.getSoundStatus()) {
			backgroundSoundMenu.play();
		}
	}
	
	private void appendButtons() {
		Sprite javaButton = new Sprite("src/graphics/img/java-menu.png");
		Sprite cButton = new Sprite("src/graphics/img/c-menu.png");
		Sprite pythonButton = new Sprite("src/graphics/img/python-menu.png");
		
		buttons.add(javaButton);
		buttons.add(cButton);
		buttons.add(pythonButton);
		
		for(OptionMenu option : OptionMenu.values()) {
			int currentButtonIndex = option.ordinal();
			if(currentButtonIndex == 0) {
				buttons.get(currentButtonIndex).x = WindowConstants.WIDTH/2 - javaButton.width/2 - cButton.width/2 - pythonButton.width/2;
				buttons.get(currentButtonIndex).y = WindowConstants.HEIGHT/2 - javaButton.height/2;
			} else {
				buttons.get(currentButtonIndex).y = buttons.get(currentButtonIndex - 1).y;
				buttons.get(currentButtonIndex).x = buttons.get(currentButtonIndex - 1).x + buttons.get(currentButtonIndex - 1).width + DISTANCE_BETWEEN_BUTTONS;
			}
		}
	}
	
	private void checkMenuOption() {
		if (keyboard.keyDown(Keyboard.RIGHT_KEY)){
			selectedMenu.nextState();
		}
		
		if (keyboard.keyDown(Keyboard.LEFT_KEY)){
			selectedMenu.previousState();
		}
	}
	
	private void moveArrow() {
		int currentButtonIndex = this.selectedMenu.getOrdinal().ordinal();
		Sprite currentButton = this.buttons.get(currentButtonIndex);
		
		this.arrow.x = currentButton.x + currentButton.width/2 - arrow.width/2;
		this.arrow.y = currentButton.y + currentButton.height;
		
	}
	
	private void draw() {
		background.draw();
		arrow.draw();
		
		for(Sprite button: this.buttons) {
			button.draw();
		}
	}

	private void checkButtonSelection(){
		if (keyboard.keyDown(Keyboard.ENTER_KEY)){
				backgroundSoundMenu.stop();
				game.transitTo(selectedMenu.getScene());
		}
	}
	
	private void playBackgroundSoundMenu(Sound backgroundSoundMenu) {
		if (!backgroundSoundMenu.isExecuting()) {
			backgroundSoundMenu.play();
			System.out.println("Take Me On");
		}
	}
	
	public void update(){
		checkMenuOption();
		moveArrow();
		checkButtonSelection();
		draw();
	}
	
}
