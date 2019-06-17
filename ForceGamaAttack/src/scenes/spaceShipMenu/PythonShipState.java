package scenes.spaceShipMenu;

import scenes.Scene;
import scenes.credits.CreditsScene;

public class PythonShipState implements MenuState {
	public static Scene creditsScene;
	
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
		creditsScene = new CreditsScene();
		return creditsScene;
	}

}
