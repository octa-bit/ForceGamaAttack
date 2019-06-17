package scenes.spaceShipMenu;

import scenes.Scene;
import scenes.game.GameScene;

public class JavaShipState implements MenuState {
	private static Scene startLevel;

	@Override
	public void next(Menu menu) {
		menu.setState(new CShipState());
	}

	@Override
	public void prev(Menu menu) {
		menu.setState(new PythonShipState());
	}

	@Override
	public void printStatus() {
		System.out.println("Java Ship!");
	}

	@Override
	public OptionMenu getOrdinal() {
		return OptionMenu.Java;
	}

	@Override
	public Scene getScene() {
		startLevel = new GameScene();
		return startLevel;
	}

}
