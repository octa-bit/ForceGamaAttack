package scenes.configuration;

import scenes.Scene;

public class ConfigurationMenu {
	private ConfigurationMenuState state;
	
	public ConfigurationMenu(ConfigurationMenuState menu) {
		state = menu;
	}
	
	public void setState(ConfigurationMenuState menu) {
		state = menu;
	}
	
	public ConfigurationMenuState getState() {
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

