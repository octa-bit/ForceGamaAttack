package src.controller;

import src.scenes.Scene;
import jplay.Keyboard;

public class Controller {
	
	public Scene currentScene = null;
	public Keyboard keyboard = null;
	private boolean isRunning = true; 
	
	public void transitTo(Scene scene) {	
		
		if(scene == null || keyboard == null) 
		  return;
		
		else if(currentScene != null){
			currentScene.destroy();
		}

		scene.configure(this);
		currentScene = scene;
	}
	public boolean update(){
		if (currentScene != null){
			currentScene.update();
		}

		return isRunning; 
	}
	
	public void quit(){
		isRunning = false;
	}
}
