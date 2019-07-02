|Versão|Autor|Descrição|
|------|-----|---------|
|1.0|Lucas Hiroshi|Criação do documento|
|1.1|Filipe Toyoshima|Aplicação do Polimorfismo|

## Polimorfismo

O GRASP associa responsabilidades a conceitos abstratos, e não às suas formas concretas. Isso ajuda a alterar o comportamento conforme necessidade. Isso ocorre em toda a lógica de instanciação da [Enemy, junto aos seus padrões de projeto aplicados](used_gofs.html#enemy-factory--object-pool).

Veja, por exemplo, o construtor da classe `FactoryPhase1`. É responsável por criar listas de `Taskers`, `Issuelizers` e `Bugings`, inimigos definidos o [GDD](gdd.html). Essas listas são passadas a objetos da classe `EnemyPool`.

```java
private EnemyPool taskerPool;
private EnemyPool bugingPool;
private EnemyPool issuelizerPool;

public FactoryPhase1() {
	List<Enemy> taskerList = new ArrayList<Enemy>();
	for (int i=0; i<15; i++) {
		taskerList.add(new Tasker(0, 0));
	}
	this.taskerPool = new EnemyPool(taskerList);
	
	List<Enemy> issuelizerList = new ArrayList<Enemy>();
	for (int i=0; i<15; i++) {
		issuelizerList.add(new Issuelizer(0, 0));
	}
	this.issuelizerPool = new EnemyPool(issuelizerList);
	
	List<Enemy> bugingList = new ArrayList<Enemy>();
	for (int i=0; i<18; i++) {
		bugingList.add(new Buging(0, 0));
	}
	this.bugingPool = new EnemyPool(bugingList);
}
```

Por mais que o construtor da Pool receba `List<Enemy>`, através do polimorfismo é possível passar os objetos concretos, fazendo assim com que cada Pool criada na Factory seja responsável por apenas um tipo de `Enemy`.