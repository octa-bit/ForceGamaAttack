package scenes.spaceShipMenu;

enum OptionMenu {  
	Java(0), C(1), Python(2);
	
	private final int value; 
	
	OptionMenu(int option){
		value = option;
	}

	private OptionMenu OptionMenu(int option) {

		switch(option){

		case 0:
			return OptionMenu.Java;
		case 1:
			return OptionMenu.C;
		case 2:
			return OptionMenu.Python;
		}

		return OptionMenu.Java;
	}
	
}
