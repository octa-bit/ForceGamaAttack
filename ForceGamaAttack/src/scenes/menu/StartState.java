package scenes.menu;

import scenes.Scene;
import scenes.game.GameScene;

public class StartState implements MenuState {
	private static Scene startLevel;

	@Override
	public void next(Menu menu) {
		menu.setState(new ConfigState());
	}

	@Override
	public void prev(Menu menu) {
		menu.setState(new ExitState());
	}

	@Override
	public void printStatus() {
		System.out.println("StartState!");
	}

	@Override
	public OptionMenu getOrdinal() {
		return OptionMenu.Start;
	}

	@Override
	public Scene getScene() {
		startLevel = new GameScene();
		return startLevel;
	}

}
