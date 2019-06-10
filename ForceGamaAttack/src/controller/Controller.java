package controller;

import scenes.Scene;

import java.util.ArrayList;

import jplay.Keyboard;
import jplay.Mouse;
import jplay.Window;
import jplay.Sound;

public class Controller {
	
	public Scene currentScene = null;
	public Keyboard keyboard = null;
	private boolean isRunning = true; 
	private boolean isPaused = false;
	private boolean soundStatus = true;
	private Mouse mouse;
	private Window window;
	
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
	
	public void pressPause() {
		isPaused = !isPaused;
	}
	
	public boolean getIsPaused() {
		return isPaused;
	}
	
	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}
	
	public Mouse getMouse() {
		return mouse; 
	}
	
	public void changeSoundStatus() {
		soundStatus = !soundStatus;
	}
	
	public void changeSoundStatus(ArrayList<Sound> sounds) {
		changeSoundStatus();
		for (Sound sound : sounds) {
			if (soundStatus) {
				sound.play();
			} else {
				sound.stop();
			}
		}
	}
	
	public boolean getSoundStatus() {
		return soundStatus;
	}
	
	public Window getWindow() {
		return window;
	}
	
	public void setWindow(Window window) {
		this.window = window;
	}
}
