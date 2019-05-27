package scenes.menu;

import scenes.Scene;

public class Menu {
	private MenuState state;
	
	public Menu(MenuState menu) {
		state = menu;
	}
	
	public void setState(MenuState menu) {
		state = menu;
	}
	
	public MenuState getState() {
		return state;
	}
	
	public void previousState() {
		state.prev(this);
	}
	
	public void nextState() {
		state.next(this);
	}
	
	public void printStatus() {
        state.printStatus();
    }
	
	public OptionMenu getOrdinal() {
		return state.getOrdinal();
	}
	
	public Scene getScene() {
		return state.getScene();
	}
}
