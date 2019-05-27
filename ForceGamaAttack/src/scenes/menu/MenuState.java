package scenes.menu;

import scenes.Scene;

public interface MenuState {
	void next(Menu menu);
    void prev(Menu menu);
    void printStatus();
    OptionMenu getOrdinal();
    Scene getScene();
}
