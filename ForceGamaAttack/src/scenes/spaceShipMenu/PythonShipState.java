package scenes.spaceShipMenu;

import player.Gun;
import player.StructureStrategyJava;
import player.StructureStrategyPython;
import scenes.Scene;
import scenes.credits.CreditsScene;
import scenes.game.GameScene;

public class PythonShipState implements MenuState {
	private static Scene startLevel;

	@Override
	public void next(Menu menu) {
		menu.setState(new JavaShipState());
	}

	@Override
	public void prev(Menu menu) {
		menu.setState(new CShipState());
	}

	@Override
	public void printStatus() {
		System.out.println("Python Ship!");
	}
	
	@Override
	public OptionMenu getOrdinal() {
		return OptionMenu.Python;
	}
	
	@Override
	public Scene getScene() {
		startLevel = new GameScene(new StructureStrategyPython(100, 100), new Gun(222, 30));
		return startLevel;
	}

}
