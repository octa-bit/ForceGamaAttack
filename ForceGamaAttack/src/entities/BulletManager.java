package entities;

import java.util.ArrayList;
import java.util.LinkedList;

import jplay.Window;

public class BulletManager {
	LinkedList<Bullet> objects = new LinkedList<Bullet>();
	
	public void addBullet(double x, double y, int sentido, int floor) {
		Bullet bullet = new Bullet(x, y, sentido);
		bullet.setFloor(floor);
		
		objects.addFirst(bullet);
		 System.out.println("ADD");
	}
	
	  public void step(int floor){
		  for(int i = 0; i < objects.size(); i++) {
			  Bullet bullet = objects.removeFirst();
			  System.out.println("Step");
			  bullet.move();
			  bullet.update();
			  
			  System.out.println("X: " + bullet.x);
			  
			  
			  if ( bullet.isOnFloor() == false && bullet.x > 1)
              {
                      bullet.fall();
                      objects.addLast(bullet);
                      System.out.println("bulletFall");
              }
              else
              {
                      //O tiro não passou em alguns dos testes .
                      System.out.println("erro");
              }
		  }
	  }
	  
	  public void draw()
	    {
	            for(int i=0; i < objects.size(); i++)
	            {
	                    Bullet bullet = objects.removeFirst();
	                    bullet.draw();
	                    objects.addLast(bullet);
	                    System.out.println("bullettt");
	            }
	    }
	  
}
