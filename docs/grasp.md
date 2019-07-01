|Versão|Autor|Descrição|
|------|-----|---------|
|1.0|Lucas Hiroshi|Introdução aos GRASP e Criador|

# GRASP
Os padrões GRASP (General responsibility assignment software patterns), são orientações para atribuir responsabilidade a classes e objetos em projeto orientado a objetos estes patterns disponibilizam uma série de recomendações que procuram favorecer a obtenção de sistemas melhor estruturados.

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

## Especialista

```Java

```

## Alta Coesão

```Java

```

## Baixo Acoplamento

```Java

```

## Polimorfismo

```Java

```

## Fabricação Pura

```Java

```

## Variações Protegidas

```Java

```

## Controlador

```Java

```
