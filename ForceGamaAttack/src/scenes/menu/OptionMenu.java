package scenes.menu;

enum OptionMenu {  
	Start(0), Config(1), Credit(2),  Exit(3);
	
	private final int value; 
	
	OptionMenu(int option){
		value = option;
	}
	
	OptionMenu next(){
		
		int option = value;
		if (value < 3){
			option += 1;
		}
		
		return OptionMenu(option);
	}

	OptionMenu back(){
		
		int option = value;
		if (value > 0){
			option -= 1;
		}
		
		return OptionMenu(option);
	}

	private OptionMenu OptionMenu(int option) {

		switch(option){

		case 0:
			return OptionMenu.Start;
			
		case 1:
			return OptionMenu.Config;
		case 2:
			return OptionMenu.Credit;
		case 3:
			return OptionMenu.Exit;
		}

		return OptionMenu.Start;
	}
	
}
