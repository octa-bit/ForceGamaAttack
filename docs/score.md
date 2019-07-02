|Versão|Autor|Descrição|
|------|-----|---------|
|1.0|João Vítor|Score|

## Score: Singleton + Observer

O Score funciona da seguinte forma: quando o jogador acerta um tiro ele ganha 5 pontos, independente da nave que ele acertar. Quando ele perde o jogo, a pontuação dele é salva no High Score.

O Score do jogo foi implementado a partir de dois padrões de projeto diferentes: o **Singleton** e o **Observer**.
O **Singleton** foi utilizado na criação da classe, enquanto o **Observer** foi usado para estabelecer a conexão entre o que ocorre durante o jogo com o score. Isso pode ser evidenciado no diagrama de classes da seginte forma:

![Score](https://i.imgur.com/BlyBKXO.jpg)

### Imagem do score

![Score2](https://i.imgur.com/UAGCfjp.jpg)
