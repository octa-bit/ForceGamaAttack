Versão 1.0

|Versão|Autor|Descrição|
|------|-----|---------|
|1.0|Gabriel Viana|Forma Inicial do GDD|
|2.0|Lucas Hiroshi|Completando tópicos do GDD|

# **Force Gama Attack**
Escrito por OctaBit


## História
Em uma galáxia distante, a constante guerra para vencer na vida obrigou desenvolvedores a utilizarem suas linguagens de programação em armas de combate. Aliados com os seus professores, os objetivos desses desenvolvedores é vencer as etapas da vida.

### Objetivos do Jogo:

* Conceito do jogo:
O jogo se encontra no gênero Space Shooter.

* Visão Geral da História 
A história acompanha um desenvolvedor enquanto ele passa por diferentes estágios.

## Controles do Jogo
### Visão geral

- O jogador pode se movimentar por toda a tela do jogo, para poder desviar dos ataques inimigos ou se posicionar para atirar.
- O jogador pode atirar nos inimigos e chefes. As armas variam de acordo com a customização da nave pelo jogador antes do jogo.
- O jogador pode utilizar especiais, que são habilidades especiais relacionadas à arma que o jogador está utilizando.
- O jogador pode pausar a qualquer momento, caso surja um imprevisto, para poder continuar mais tarde. Quando ele pausar, será aberto um menu de pausa no qual ele terá as opções:
    - Retomar (sai do menu de pausa e continua o jogo normalmente)
    - Reiniciar fase (recomeça a fase desde o começo)
    - Configurações (permite ao jogador configurar o volume do som e o brilho da fase)
    - Sair da fase (retorna o jogador a tela de confirmação da fase)
- O jogador pode ativar os powerups que ele adquiriu coletando do cenário durante o jogo.

- Sumário dos controles
    - W, A, S, D ou as setas do teclado para movimentar a nave
    - Barra de espaço atira
    - J ativa os powerups ativáveis
    - K ativa o especial
    - M muta ou desmuta o jogo
    - P pausa o jogo 

### Requisitos Tecnológicos(Desenvolvimento)
* Ferramentas utilizadas
O jogo será feito em Java utilizando o jplay.

### Front-end
- O menu inicial terá:
    - Música do menu inicial
    - Nome e logo do jogo
    - Fundo temático
    - Opções:
        - Iniciar novo jogo (leva para as opções de jogo)
        - Loja (local no qual o jogador compra itens para customizar a nave)
        - Placar (mostra as melhores pontuações já registradas no jogo)
        - Configurações (mostra as configurações, entre elas volume, brilho da tela e dificuldade)
        - Créditos (mostra os desenvolvedores)
        - Sair (finaliza o jogo)

### Câmeras

- As câmeras ingame devem ser sempre do topo, como normalmente ocorre em jogos Shoot'em Up 2D. Isso forncerá uma boa visão do que ocorre ao redor do jogador.
- O fundo deve rolar em parallax, o que dará ao jogador a sensação de profundidade.
- A câmera se mantém estática enquanto o fundo se move para baixo, dando a impressão de que a nave sempre está indo para frente. O jogador não pode optar por "parar" o fundo. 

### Sistema de HUD
- Se houver alguma cutscene ingame, cada elemento do HUD deverá ser ocultado através de uma animação que o mova para fora da tela pela borda mais próxima. Após o fim da cutscene, todos os elementos deverão voltar através da animação inversa àquela que os ocultou.
- O HUD deverá ser exibido apenas ingame, sendo que menus fora deste escopo não deverão contar com os elementos dele.
- Deverá ser exibida, no canto superior esquerdo, a quantidade de Pontos de Vida do usuário através deuma barra de vida.
    - Esta barra deverá ter seu tamanho total correspondente à Vida Máxima da Configuração da Nave.
    - Se houver algum elemento da nave que seja análogo à Vida, como Pontos de Escudo, esses deverão ser colocados logo abaixo ao indicador de Vida
    - Além dessas barras, também deverá ser incluída uma maneira de informar ao jogador o Status de Especial.
- Deverá ser exibida, no canto superior direito da tela, elementos de pontuação do jogador.
    - Além da pontuação do jogador, deve ser exibida também a diferença entre a pontuação atual do jogador e o recorde atual.

### Nave
A nave é customizável ela é dividida em módulos independentes sendo eles:

#### Armas
Neste módulo o jogador pode escolher quais serão as armas de sua nave.

* Caracteristicas comum às armas
     - Dano
     - Frequência de disparos
     - Velocidade do projétil
     
* Java
<img src="https://i.imgur.com/LSVs8F2.png" height="50" />
     - Dano: Alto
     - Frequência de disparos: Devagar
     - Velocidade do projétil: Média

Dispara 3 projéteis a cada disparo.

* C
<img src="https://i.imgur.com/w7HbA1Y.png" height="50" />
     - Dano: Baixo
     - Frequência de disparos: Alta
     - Velocidade do projétil: Alta

Dispara 1 projétil a cada disparo.

* Python
<img src="https://i.imgur.com/YCYdtem.png" height="50" />
     - Dano: Médio
     - Frequência de disparos: Média
     - Velocidade do projétil: Média

Ele dispara um laser.

##### Especial
Além das armas também é possivel escolher um __framework__ para ser seu especial.

* Django
<img src="https://i.imgur.com/5yLNquV.png" height="50" />
Ao ser ativado este especial um pegasus que auxilia a nave do jogador por um tempo definido.

* C++
<img src="https://i.imgur.com/C2l0noc.png" height="50" />
A frequência dos seus disparos aumenta assim como o seu dano por um tempo definido.

* Vaadin
<img src="https://i.imgur.com/pj4xhdM.png" height="50" />
Ao ser utilizado este especial dispara pontos azuis e rosa por um tempo definido.

#### Estrutura e Propulsor
* Caracteristicas comum
     - Velocidade
     - Resistência
     - Tamanho

* Java
<img src="https://i.imgur.com/LSVs8F2.png" height="50" />
     - Velocidade: Lenta
     - Resistência: Alta
     - Tamanho: Grande
     
* C
<img src="https://i.imgur.com/w7HbA1Y.png" height="50" />
     - Velocidade: Alta
     - Resistência: Pequena (qualquer coisa quebra)
     - Tamanho: Pequeno
     
* Python
<img src="https://i.imgur.com/YCYdtem.png" height="50" />
     - Velocidade: Média
     - Resistência: Média
     - Tamanho: Médio
     

#### Escudos
* Caracteristicas comum
     - Resistência
     - Tipo de Recarga

* Java
<img src="https://i.imgur.com/LSVs8F2.png" height="50" />
     - Resistência: Alta
     - Tipo de Recarga: Tempo
     
* C
<img src="https://i.imgur.com/w7HbA1Y.png" height="50" />
     - Resistência: Baixa
     - Tipo de Recarga: Instantânea
     
* Python
<img src="https://i.imgur.com/YCYdtem.png" height="50" />
     - Resistência: Média
     - Tipo de Recarga: Tempo

#### Powerups

* Rocha
    Ao ser ativado, a nave do jogador se torna ágil, aumentando a velocidade de movimento e de disparo da nave.

* MauMi
    São dois itens encontrados separadamente ao longo do jogo. Quando um é adquirido e já se tem o outro, eles se juntam como um só, tornando-se ativável apenas após isso. Ativá-lo causará um dano massivo em todos os inimigos na tela.

* IHCS2
    Os inimigos ficam lentos ao ser ativado.

* TEP
    Ao ser ativado a pontuação que o jogador recebe é multiplicado por 2x, mas a vida e o dano dos inimigos e multiplicado por 1,5x 

* Hapiness
    Ele é ativado ao ser coletado a tela fica colorida e brilhando e uma música feliz começa a tocar.

### Métricas do jogador

**Pontos de Vida:** Descreve a integridade da estrutura da nave. O máximo varia de acordo com o SetUp escolhido pelo jogador.

**Escudo:** Quantidade de proteção regenerativa anterior aos pontos de vida.

### Recompensas

Ao final de cada tentativa, a pontuação será convertida em uma moeda de troca para que o jogador possa comprar equipamentos para sua nave.

### Pontuação

Cada inimigo derrotado concederá ao jogador uma pontuação dentro da escala de Fibonacci, num intervalo de 1 a 2584.

A pontuação deverá ser salva localmente para elaboração de um 

### Progressão do Jogo

A progressão do jogo é definida pelos incrementos que são realizados entre as partidas.

### Mecânicas do jogo

Uma vez que os Pontos de Vida do jogador se tornam 0, o jogo acaba, recompensando o jogador pelo progresso adquirido com as moedas para que sejam trocadas posteriormente na loja de equipamentos.

Caso o desempenho do jogador seja maior que os 5 melhores registrados, ele deverá registrar um nome no Ranking.

### Descrição dos Estágios 
O jogo é dividio em 3 estágios e cada estágio é divido em 2 fases.

* Ensino Médio
* Faculdade
* Mercado de Trabalho


### Inimigos
Os inimigos são bugs eles se diferenciam pela cor e pelo seu compartamento.

* Caracteristicas comum
     - Velocidade
     - Resistência
     - Tamanho
     - Dano
     - Tipo de ataque

Os inimigos são diferenciáveis pela cor.

- Violeta 
     - Velocidade:
     - Resistência:
     - Tamanho:
     - Dano:
     - Tipo de ataque:

- Indigo 
     - Velocidade:
     - Resistência:
     - Tamanho:
     - Dano:
     - Tipo de ataque:
     
- Azul 
     - Velocidade:
     - Resistência:
     - Tamanho:
     - Dano:
     - Tipo de ataque:

- Verde
     - Velocidade:
     - Resistência:
     - Tamanho:
     - Dano:
     - Tipo de ataque:

- Amarelo 
     - Velocidade:
     - Resistência:
     - Tamanho:
     - Dano:
     - Tipo de ataque:

- Laranja 
     - Velocidade:
     - Resistência:
     - Tamanho:
     - Dano:
     - Tipo de ataque:

- Vermelho
     - Velocidade:
     - Resistência:
     - Tamanho:
     - Dano:
     - Tipo de ataque:


### Chefes
Existem chefes em cada estágio:

No Ensino Médio temos o ENEM, o ENEM é um inimigo que possui um padrão de ataques aleatorio ele pode avançar na direção da nave do jogador ou disparar laser no jogador.

Durante a Faculdade o TCC é o chefe ele possui muitos pontos de vida e requer que o jogador mantenha ataques constantes.

No Mercado de trabalho temos último chefe a APOSENTADORIA.

![](https://i.imgur.com/nSHZyXo.png)

# Referências
Scott Rogers, Level Up the Guide to Great Game Design, 2010. John Wiley & Sons.