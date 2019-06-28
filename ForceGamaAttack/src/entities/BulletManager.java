package entities;

import java.util.ArrayList;
import java.util.LinkedList;

import jplay.Window;

public class BulletManager {
	private ArrayList<Bullet> objects = new ArrayList<Bullet>();
	
	public void addBullet(double x, double y, int floor) {
		Bullet bullet = new Bullet(x, y, 10);
		bullet.setFloor(floor);
		
		if(objects.size() < 30) {
			objects.add(bullet);
		}else {
			objects.clear();
			objects.add(bullet);
		}
		
	}
	
	public void removeBullets(ArrayList<Integer> indexes) {
		for (int index : indexes) {
			objects.remove(index);
		}
	}
	
	public void step(int floor){
		for(int i = 0; i < objects.size(); i++) {
			Bullet bullet = objects.remove(i);
			bullet.move();
			bullet.update();
			
			if ( bullet.x > 1){
				objects.add(bullet);
			}
			else{
				System.out.println("erro");
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
