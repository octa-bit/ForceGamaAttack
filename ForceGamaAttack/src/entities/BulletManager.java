package entities;

import java.util.LinkedList;

import jplay.Window;

public class BulletManager {
	LinkedList<Bullet> objects = new LinkedList<Bullet>();
	
	public void addBullet(double x, double y, int floor) {
		Bullet bullet = new Bullet(x, y);
		bullet.setFloor(floor);
		
		objects.addFirst(bullet);
	}
	
	public void step(int floor){
		for(int i = 0; i < objects.size(); i++) {
			Bullet bullet = objects.removeFirst();
			bullet.move();
			bullet.update();
			
			if ( bullet.x > 1){
				objects.addLast(bullet);
			}
			else{
				System.out.println("erro");
			}
		}
	}
	  
	public void draw(){
		for(int i=0; i < objects.size(); i++){
			System.out.println("Draw: " + objects);
			Bullet bullet = objects.removeFirst();
			bullet.draw();
			objects.addLast(bullet);
		}
	}
	  
}
