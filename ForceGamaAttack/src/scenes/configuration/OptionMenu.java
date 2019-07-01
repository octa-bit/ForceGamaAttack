package scenes.configuration;

enum OptionMenu {
	Sound(0), Keyboard(1);
	
	private final int value; 
	
	OptionMenu(int option){
		value = option;
	}

	private OptionMenu OptionMenu(int option) {

		switch(option){

		case 0:
			return OptionMenu.Sound;
		case 1:
			return OptionMenu.Keyboard;
		}
		
		return OptionMenu.Sound;
	}
}
