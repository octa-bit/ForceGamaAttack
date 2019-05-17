package scenes;
import controller.Controller;
import jplay.Keyboard;;

public abstract class Scene {
	
	protected Controller game;
	protected Keyboard keyboard; 
	
    public abstract void update();
    
    public void configure(Controller game){
    	this.game = game;
    	this.keyboard = game.keyboard;
    	
    	System.out.println("keyboard: " + keyboard);
    	
    	initialSetup();
    	viewSetup();
    }
		
	protected abstract void initialSetup();
	protected abstract void viewSetup();
	
	public void destroy(){
		this.game = null;
		this.keyboard = null;
	}
	
}
