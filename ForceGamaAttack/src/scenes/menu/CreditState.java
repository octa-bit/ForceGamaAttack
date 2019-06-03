package scenes.menu;

import scenes.Scene;
import scenes.credits.CreditsScene;

public class CreditState implements MenuState {
	public static Scene creditsScene;
	
	@Override
	public void next(Menu menu) {
		menu.setState(new ExitState());
	}

	@Override
	public void prev(Menu menu) {
		menu.setState(new ConfigState());
	}

	@Override
	public void printStatus() {
		System.out.println("CreditState!");
	}
	
	@Override
	public OptionMenu getOrdinal() {
		return OptionMenu.Credit;
	}
	
	@Override
	public Scene getScene() {
		creditsScene = new CreditsScene();
		return creditsScene;
	}

}
