package entities;

import java.util.List;

public abstract class Factory {

	public Factory() {	
	}
	
	public abstract boolean isSpawnTime();
	public abstract List <Enemy> factoryMethod();
}
