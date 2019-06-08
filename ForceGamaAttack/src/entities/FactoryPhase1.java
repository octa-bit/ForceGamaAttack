package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class FactoryPhase1 extends Factory {

	private int time=0;
	
	public FactoryPhase1() {
	}

	
	public boolean isSpawnTime() {
		if (time < 300) {
			time++;
			return false;
		} else {
			time=0;
			return true;
		}
	}
	
	public List<Enemy> factoryMethod() {
		Random r = new Random();
		int sort = r.nextInt(5);
		List<Enemy> wave = new ArrayList<Enemy>();
		
		if (sort < 3) {
			wave.add(new Tasker(100, 0));
			wave.add(new Tasker(150, 0));
			return wave;
		} else {
			wave.add(new Tasker(100, 0));
			return wave;
		}
	}
}
