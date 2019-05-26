package Observer;
import entities.AbstractEnemyFactory;

public abstract class Observer {
	public abstract void notifier(AbstractEnemyFactory enemy);
}
