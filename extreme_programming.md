|Versão|Autor|Descrição|
|------|-----|---------|
|1.0|Luciano Santos|Framework XP|

# Programação Extrema (XP)

## Introdução
O XP, ou Extreme Programming, é uma metodologia de desenvolvimento de software que tem como objetivo principal levar ao extremo boas práticas de programação e boas práticas para o desenvolvimento de software no geral. O XP é uma metodologia baseada em valores, que definem uma maneira harmoniosa de trabalho na equipe de desenvolvimento.

O foco desta metodologia é no desenvolvimento incremental e iterativo de sistemas orientados à objetos nos quais os requisitos são instáveis e/ou incertos e que possua uma equipe pequena ou média.

## Práticas

### Planejamento

Aqui o objetivo é definir o escopo da próxima release, combinando prioridades do négocio e estimativas de técnicas. No XP o planejamento tem que estar presente constantemente durante as fases do projeto.

### Release
Releases são construídas ao longo de iterações. Uma iteração sempre alcança algum objetivo perceptível ao cliente, ou seja, não adianta usarmos uma iteração para projetarmos ou melhorarmos a arquitetura do nosso software se ele não vai agregar absolutamente nenhum valor ao cliente. Nada é feito que não seja imediatamente útil e necessário para não afetar os prazos de desenvolvimento. As iterações são divididas em tarefas que são a menor quantidade de trabalho que pode ser feita até que todos os testes voltem a funcionar. As Tarefas não levam mais que um dia, pois elas devem ser integradas imediatamente assim que o programador finaliza essa tarefa, seja ao final do dia ou antes disso, para que assim os testes sejam executados e verifique-se caso algo errado foi feito. Portanto, uma vez concluídas, tarefas são integradas imediatamente.

### Design Simples
O XP preconiza que a mudança é barata, pois ele utiliza ciclos curtos, projetos simples, refatorações, por isso mantém-se o projeto o mais simples possível, modificando-o quando for necessário suportar mais funcionalidade. Portanto, o XP diz que o melhor e mais simples projeto é aquele que passa em todos os testes, não contém duplicação de funcionalidade, salienta as decisões de projeto importantes e tem o menor número possível de classes e métodos.

### Refatoração
A refatoração significa melhorar o código sem alterar sua funcionalidade. Antes de uma mudança sempre refatoramos o código para facilitar a realização de mudanças. Ou seja, se após a refatoração o código continua funcionando como anteriormente, incluímos as novas mudanças. A refatoração contínua possibilita manter um bom projeto, apesar das mudanças frequentes. O Projeto é uma atividade diária, de responsabilidade de todos.

A refatoração provê um aumento contínuo de qualidade do código.

### Pair Programming
Sugere que todo e qualquer código produzido no projeto seja sempre implementado por duas pessoas juntas, diante do mesmo computador, revezando-se no teclado. Além de parecer ter poucos benefícios, temos a impressão de que ela irá consumir mais recursos ou irá elevar o tempo do desenvolvimento. Porém essa prática é excelente e favorece comunicação e aprendizado. Com essa troca constante de ideias temos como resultado um Projeto de maior qualidade e como estudos comprovam temos maior produtividade e maior qualidade (com padrão de codificação e entendimento do código e partes do código que não eram entendidos).

### Integração Contínua
Todo código deve ser integrado diariamente e todos testes devem passar antes e depois da integração. Se algum problema é encontra do ele deve ser corrigido imediatamente.

### Testes
A prática de teste no XP é bastante técnica, e envolve a presença do cliente no desenvolvimento e na validação de testes. O cliente compartilha com o desenvolvedor sobre o funcionamento do sistema. Os testes também se tornam as especificações da programação, visto que o teste diz o que deve estar de acordo e o que não deve estar de acordo, é como uma especificação.Os testes são escritos antes da funcionalidade, o que também é conhecido como TDD (Test-Driven Design) onde intercala-se a função de testar um pouco e codificar um pouco. Além disso, o TDD impõe o programador à saber o que deve ser verdadeiro no programa e o que não deve ser para que ele funcione corretamente, portanto, pensa-se primeiramente no problema e depois na solução. Dessa forma, os testes são automatizados, diferente de anteriormente onde o desenvolvedor fazia a implementação e entregava para alguém testar. Com os testes automatizados podemos executá-los a qualquer momento, e dessa forma, novas funcionalidade ou alterações podem ser imediatamente testadas para ver se essas mexidas não acarretaram outros problemas. Dessa forma, o teste impõem também confiança ao sistema e dão coragem para altera-lo, pois podemos saber imediatamente se algo introduziu um bug no sistema.

Teste Unitário que automatiza o teste da funcionalidade e tipicamente testa uma classe, ou pequeno grupo de classes.

Teste automatizado é a prática que sustenta e viabiliza muitas outras práticas como Integraç,0
ão contínua, Design Simples, Releases, Refatoração.


### Padrões de Codificação
Durante o projeto todos integrantes irão mexer com o código e por isso é necessário possuir um padrão de codificação, esse padrão de codificação pode ser definido por um stylesheet.

### Cliente Presente
Clientes devem estar presentes para escrevem testes de aceitação, definirem prioridades e histórias para as futuras iterações.

### Reunião diária
É uma prática vinda do SCRUM em que todos fazem uma rápida reunião de pé para discutir o que foi feito no dia anterior, o que será feito no dia atual e se existe algum impedimento.

## Referências

- [Práticas em XP](https://www.devmedia.com.br/praticas-em-xp-extreme-programming/29330)
-  [Programação eXtrema (XP) - PDF](http://periodicos.unesc.net/index.php/sulcomp/article/download/911/900)