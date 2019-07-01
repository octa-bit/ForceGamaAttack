|Versão|Autor|Descrição|
|------|-----|---------|
|1.0|Rossicler e Lucas|Casos de Usuário 1, 2, 3 e 4|
|1.1|João Lucas| atualização do diagrama UC01 - Menu Principal|
|1.2|João Lucas| atualização do diagrama UC02 - Jogar|
|1.3|Isaac Borges| Detalhamento|

# Casos de Uso
## 1. Introdução
Segundo Ivan Jacobson , podemos dizer que um caso de uso é  um "documento narrativo que descreve a sequência de eventos de um ator que usa um sistema para completar um processo".

Um caso de uso é uma técnica de modelagem usada para descrever o que um novo sistema deve fazer . Ele é construído através de um processo interativo no qual as discussões entre o cliente e os desenvolvedores do sistema conduzem a uma especificação do sistema da qual todos estão de acordo.

Um caso de uso descreve as operações que o sistema deve cumprir para cada usuário. Ele vai ajudar a formalizar as funções que o sistema precisa fazer.

## 2. UC01 - Menu Principal

### 2.1 Diagrama Versão 0.1

![UC01 - Menu Principal](https://i.ibb.co/VYpx6Rx/UC01.png)

### 2.2 Diagrama Versão 1.0

![UC01 - Menu Principal](https://i.ibb.co/Ctmxx2q/UC01.png)

## 3. UC02 - Jogar

### 3.1 Diagrama Versão 0.1

![UC02 - Jogar](https://i.ibb.co/C69sBYv/UC02-Jogar.png)

### 3.2 Diagrama Versão 1.0

![UC02 - Jogar](https://i.ibb.co/3NtMYtx/UC02-V-1-0.png)

### 3.3 Especificação

|  |  |
|  ------: | :------ |
|  **Descrição** | Tem como objetivo permitir ao usuário interagir com as mecânicas do jogo. |
| **Atores** | Usuário |
| **Pré Condições** | O sistema deve estar em pleno funcionamento. |
| **Fluxo Principal** | **FP01 - Começar o jogo**<br>1. Abre a tela inicial do jogo.<br>2. Usuário seleciona a opção start.<br>3. A cena de jogo se inicia.<br>4. Caso de uso encerrado.[FA01][FA02][FA03][FA04]<br>**FP02 - Escolher nome do jogador**<br>1. Abre a tela inicial do jogo.<br>2. Usuário seleciona a opção de escolher nome.<br>3. Usuário confirma nome escolhido<br>4. A cena de jogo se inicia.<br>5. Caso de uso encerrado.[FA01][FA02][FA03][FA04] |
| **Fluxos Alternativos** | **FA01 - Abrir Menu de Pausa**<br>1. Usuário clica no botão de pausa presente na tela de jogo.<br>2. Jogo pausa.<br>3. Jogo mostra opções do menu de pausa.<br>4. Usuário retorna para o quarto passo do fluxo principal.[FA05][FA06][FA07]<br>**FA02 - Atirar**<br>1. Usuário clica no botão de tiro.<br>2. Bala é instanciada na cena.<br>3. Animação de tiro é iniciada.<br>4. Usuário retorna para o quarto passo do fluxo principal.[FA08]<br>**FA03 - Movimentar a nave**<br>1. Usuário clica no botão de moviemento.<br>2. Animação de movimento é iniciada.<br>3. A nave muda de lugar.<br>4. Usuário retorna para o quarto passo do fluxo principal.[FA09][FA10]<br>**FA04 - Silenciar o jogo**<br>1. Usuário clica no botão de mutar o som.<br>2. Som é desativado no jogo.<br>3. Usuário retorna para o quarto passo do fluxo principal.<br>**FA05 - Reiniciar fase**<br>1. Usuário clica na opção de reiniciar a fase.<br>2. Fase é reiniciada.<br>**FA06 - Voltar ao jogo**<br>1. Usuário clica na opção de voltar ao jogo.<br>2. Menu de pausa sai da tela.<br>3. Jogo sai da pausa.<br>4. Retorna ao passo quatro do fluxo principal.<br>**FA07 - Voltar ao menu principal**<br>1. Usuário clica na opção de voltar ao menu principal.<br>2. Jogo sai da tela de jogo.<br>3. Jogo carrega a tela de menu<br>**FA08 - Destruir inimigos**<br>1. Bala entra em contato com inimigo.<br>2. Animação de destruição se inicia.<br>3. Som de destruição se inicia.<br>4. Instância do inimigo é destruída.<br>5. Retorna ao passo quatro do fluxo principal<br>**FA09 - Coletar moedas**<br>1. Moeda é instanciada na cena.<br>2. Nave entra em contato com moeda.<br>3. Som de coleta de moeda se inicia.<br>4. Animação de coleta de moeda se inicia.<br>5. Instância da moeda é destruída.<br>6. Número de moedas coletadas aumenta.<br>7. Retorna ao passo quatro do fluxo principal<br>**FA10 - Coletar power up**<br>1. Power up é instanciado na cena.<br>2. Nave entra em contato com power up.<br>3. Som de coleta de power up se inicia.<br>4. Animação de coleta de power up se inicia.<br>5. Instância do power up é destruída.<br>6. Os atributos da nave mudam de acordo com o power up coletado.<br>7. Retorna ao passo quatro do fluxo principal **FA11 - Silenciar Música de Fundo**<br>1. Usuário clica na opção de silenciar a música.<br>2. A música de fundo deixa de ser tocada.<br> 3. Usuário deve retornar ao passo seis do fluxo alternativo para jogar o jogo sem música.  |
| **Fluxos de Exceção** | Não se aplica. |
| **Pós Condições** | Usuário terá acesso a tela de jogo e opções do jogabilidade. |

## 4. UC03 - Customização

### 4.1 Diagrama

![UC03 - Customização](https://i.ibb.co/3SwxStg/UC03-Customiza-o.png)

### 4.2 Especificação

|  |  |
|  ------: | :------ |
|  **Descrição** | Tem como objetivo permitir ao usuário customizar a nave que utiliza no jogo. |
| **Atores** | Usuário |
| **Pré Condições** | O sistema deve estar em pleno funcionamento. |
| **Fluxo Principal** | **FP01 - Começar o jogo**<br>1. Abre a tela inicial do jogo.<br>2. Usuário seleciona a opção customizar nave.<br>3. A cena de customização carrega.<br>4. Caso de uso encerrado.[FA01][FA02][FA03][FA04] |
| **Fluxos Alternativos** | **FA01 - Customizar propulsores/estruturas**<br>1. Usuário clica na opção de customizar propulsores/estruturas.<br>2. Tela de customização de propulsores/estruturas carrega.<br>3. Jogo mostra opções de customização.<br>4. O usuário escolhe a opção de customização<br>5. Usuário retorna para o quarto passo do fluxo principal.[FA05][FA06][FA07]<br>**FA02 - Customizar armas**<br>1. Usuário clica na opção de customizar armas.<br>2. Tela de customização de armas carrega.<br>3. Jogo mostra opções de customização.<br>4. O usuário escolhe a opção de customização<br>5. Usuário retorna para o quarto passo do fluxo principal.[FA05][FA06][FA07]<br>**FA03 - Customizar escudo**<br>1. Usuário clica na opção de customizar escudo.<br>2. Tela de customização de escudo carrega.<br>3. Jogo mostra opções de customização.<br>4. O usuário escolhe a opção de customização<br>5. Usuário retorna para o quarto passo do fluxo principal.[FA05][FA06][FA07]<br>**FA04 - Customizar especial**<br>1. Usuário clica na opção de customizar especial.<br>2. Tela de customização de especial carrega.<br>3. Jogo mostra opções de customização.<br>4. O usuário escolhe a opção de customização<br>5. Usuário retorna para o quarto passo do fluxo principal.[FA08][FA09][FA10]<br>**FA05 - Opção C**<br>1. Usuário clica na opção de customizar com a opção C.<br>2. Nave é modificada de acordo com a opção selecionada.<br>3. Usuário retorna para o fluxo anterior.<br>**FA06 - Opção Python**<br>1. Usuário clica na opção de customizar com a opção Python.<br>2. Nave é modificada de acordo com a opção selecionada.<br>3. Usuário retorna para o fluxo anterior.<br>**FA07 - Opção Java**<br>1. Usuário clica na opção de customizar com a opção Java.<br>2. Nave é modificada de acordo com a opção selecionada.<br>3. Usuário retorna para o fluxo anterior.<br>**FA08 - Opção Django**<br>1. Usuário clica na opção de customizar com a opção Django.<br>2. Nave é modificada de acordo com a opção selecionada.<br>3. Usuário retorna para o fluxo anterior.<br>**FA09 - Opção Vaadin**<br>1. Usuário clica na opção de customizar com a opção Vaadin.<br>2. Nave é modificada de acordo com a opção selecionada.<br>3. Usuário retorna para o fluxo anterior.<br>**FA10 - Opção C++**<br>1. Usuário clica na opção de customizar com a opção C++.<br>2. Nave é modificada de acordo com a opção selecionada.<br>3. Usuário retorna para o fluxo anterior. |
| **Fluxos de Exceção** | Não se aplica. |
| **Pós Condições** | Nave do jogador customizada de acordo com as especificações. |

## 5. UC04 - Configurações

### 5.1 Diagrama

![UC04 - Configurações](https://i.ibb.co/QbwVK70/UC04-Configura-es.png)

### 5.2 Especificação

|  |  |
|  ------: | :------ |
|  **Descrição** | Tem como objetivo permitir ao usuário editar as configurações do jogo. |
| **Atores** | Usuário |
| **Pré Condições** | O sistema deve estar em pleno funcionamento. |
| **Fluxo Principal** | **FP01 -Abrir as configurações**<br>1. Abre a tela inicial do jogo.<br>2. Usuário seleciona a opção configurações.<br>3. As configurações são listadas na tela.<br>4. Caso de uso encerrado.[FA01][FA02] |
| **Fluxos Alternativos** | **FA01 - Silenciar o jogo**<br>1. Usuário clica na opção de silenciar o jogo.<br>2. O jogo ficará silenciado até que o usuário desative essa opção.<br>**FA02 - Escolher nome do jogador**<br>1. Usuário clica na opção de mudar/escolher o nome do jogador.<br>2. Aparecerá um campo onde o usuário poderá inserir o nome do jogador.<br>3. Usuário insere o nome do jogador.<br>4. Usuário clica no botão de salvar salvar.<br>5. Caso de uso encerrado. |
| **Fluxos de Exceção** | Não se aplica. |
| **Pós Condições** | Usuário terá configurado o jogo de acordo com a sua vontade. |

## 6. Referências
http://www.macoratti.net/net_uml2.htm
