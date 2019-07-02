|Versão|Autor|Descrição|
|------|-----|---------|
|1.0|Lucas Hiroshi|Criador|

## Criador

Delegar a responsabilidade de criação de objetos é um dos mais comuns dentro da orientação de objetos. Nele basicamente uma classe B tem a responsabilidade de criar instâncias de uma classe A.

```Java
public abstract class Factory {

	public Factory() {}
	
	public abstract boolean isSpawnTime();
	public abstract void sendBack(Enemy enemy);
	public abstract List <Enemy> factoryMethod();
}
```