package scenes.spaceShipMenu;

import player.Gun;
import player.StructureStrategyC;
import player.StructureStrategyJava;
import scenes.Scene;
import scenes.game.GameScene;

public class CShipState implements MenuState {
	private static Scene startLevel;

	@Override
	public void next(Menu menu) {
		menu.setState(new PythonShipState());
	}

	@Override
	public void prev(Menu menu) {
		menu.setState(new JavaShipState());
	}

	@Override
	public void printStatus() {
		System.out.println("C Ship!");
	}
	
	@Override
	public OptionMenu getOrdinal() {
		return OptionMenu.C;
	}
	
	@Override
	public Scene getScene() {
		startLevel = new GameScene(new StructureStrategyC(100, 100), new Gun(111, 15));
		return startLevel;
	}

}
