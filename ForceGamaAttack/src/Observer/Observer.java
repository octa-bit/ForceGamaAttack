package Observer;
import entities.AbstractEnemy;
import entities.AbstractEnemyFactory;
import entities.Boss;

public abstract class Observer {
	public abstract void notifier(AbstractEnemy boss);
}
