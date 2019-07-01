package entities;

import java.util.ArrayList;
import java.util.LinkedList;

import constants.WindowConstants;
import jplay.Window;

public class BulletManager {
	private ArrayList<Bullet> objects = new ArrayList<Bullet>();
	
	public void addBullet(String sprite, double x, double y, int floor) {
		Bullet bullet = new Bullet(sprite, x, y, 10);
		bullet.setFloor(floor);
		
		if(objects.size() < 30) {
			objects.add(bullet);
		}else {
			objects.clear();
			objects.add(bullet);
		}
		
	}
	
	public void removeBullets(ArrayList<Bullet> bullets) {
		for (Bullet bullet : bullets) {
			try {
				objects.remove(bullet);
			} catch(Exception e) {
				System.out.println("Error when trying to remove bullet");
			}
		}
	}
	
	public void step(int floor){
		for(int i = 0; i < objects.size(); i++) {
			Bullet bullet = objects.remove(i);
			bullet.move();
			bullet.update();
			
			if ( bullet.x > 1 && bullet.y > 0){
				objects.add(bullet);
			}
			else{
				objects.remove(bullet);
			}
			
		}
	}
	  
	public void draw(){
		for(int i=0; i < objects.size(); i++){
			//System.out.println("Draw: " + objects);
			Bullet bullet = objects.get(i);
			bullet.draw();
		}
	}
	
	public ArrayList<Bullet> getBullets() {
		return objects;
	}
	
	public int getBulletIndex(Bullet bullet) {
		return objects.indexOf(bullet);
	}
	  
}
