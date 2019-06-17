package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import constants.WindowConstants;

public class FactoryPhase1 extends Factory {

	private int time=300;
	
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
		int sort = r.nextInt(11);
		List<Enemy> wave = new ArrayList<Enemy>();
		
		if (sort < 3) {
			int randPos = r.nextInt(350) + 20;
			wave.add(new Tasker(randPos, -50));
		    wave.add(new Tasker(randPos + 50, -50));
		    wave.add(new Tasker(randPos + 100, -50));
		    
		} else if (sort < 4) {
			int randPos = r.nextInt(300) + 20;
			wave.add(new Tasker(randPos, -50));
		    wave.add(new Tasker(randPos + 50, -50));
		    wave.add(new Tasker(randPos + 100, -50));
		    wave.add(new Tasker(randPos + 150, -50));
		    
		} else if (sort < 7) {
			int randPos = r.nextInt(500) + 50;
			wave.add(new Issuelizer(randPos, -20));
			wave.add(new Issuelizer(randPos, -80));
			wave.add(new Issuelizer(randPos, -140));
			
		} else if (sort < 9) {
			int randPos = r.nextInt(500) + 50;
			wave.add(new Issuelizer(randPos, -20));
			wave.add(new Issuelizer(randPos, -80));
			wave.add(new Issuelizer(randPos, -140));
			wave.add(new Issuelizer(randPos, -170));
			
		} else if (sort < 10 ) {
			wave.add(new Buging(-20, -20));
			wave.add(new Buging(30, -20));
			wave.add(new Buging(80, -20));
			wave.add(new Buging(-20, 30));
			wave.add(new Buging(-20, 80));
			
		} else {
			float limit = (float) WindowConstants.WIDTH;
			wave.add(new Buging(limit + 20, -20));
			wave.add(new Buging(limit - 10, -20));
			wave.add(new Buging(limit - 60, -20));
			wave.add(new Buging(limit + 20, 30));
			wave.add(new Buging(limit + 20, 80));
		}
		
		return wave;
	}
}
