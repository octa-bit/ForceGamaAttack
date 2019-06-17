package controller;

import scenes.Scene;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
	private boolean soundStatus = getSoundConfig();
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
		saveSoundConfig(soundStatus);
	}
	
	public void changeSoundStatus(ArrayList<Sound> sounds) {
		changeSoundStatus();
		for (Sound sound : sounds) {
			if (soundStatus && sound != null) {
				sound.play();
			} else if(sound != null) {
				sound.stop();
			}
		}
	}

	public void saveSoundConfig(boolean sound) {
		try {
			BufferedWriter file = new BufferedWriter(new FileWriter("src/config/Config.txt"));
			if(sound) {
				file.write("Sound: True");
			} else {
				file.write("Sound: False");
			}
			file.close();
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read Config.txt");
			e.printStackTrace();
		}
	}
	
	public boolean getSoundConfig() {
		String line = null;
		boolean soundStatus = false;
		try {
			BufferedReader file = new BufferedReader(new FileReader("src/config/Config.txt"));
			// soundStatus = !soundStatus;
			while((line = file.readLine()) != null) {
					if(line.indexOf("Sound") !=-1) {
							soundStatus = line.equals("Sound: True");
							file.close();
							break;
					}
			}   
			file.close();
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read Config.txt");
			e.printStackTrace();
		}
		return soundStatus;
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
