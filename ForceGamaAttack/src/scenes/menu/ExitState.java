package scenes.menu;

import scenes.Scene;

public class ExitState implements MenuState {

	@Override
	public void next(Menu menu) {
		menu.setState(new StartState());
	}

	@Override
	public void prev(Menu menu) {
		menu.setState(new CreditState());
	}

	@Override
	public void printStatus() {
		System.out.println("ExitState!");		
	}
	
	@Override
	public OptionMenu getOrdinal() {
		return OptionMenu.Exit;
	}
	
	@Override
	public Scene getScene() {
		return null;
	}
	
}
