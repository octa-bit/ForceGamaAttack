|Versão|Autor|Descrição|
|------|-----|---------|
|1.0|Eduardo|Esboço inicial e Introdução|
|1.0|Eduardo|Etapas|
|1.0|Eduardo|Matriz de Probabilidade e Impacto|

## Gerenciamento de Riscos

### 1. Introdução
A função do gerenciamento de riscos num projeto é de aumentar a probabilidade dos riscos positivos a realização do projeto enquanto se minimiza os riscos negativos, com o objetivo final de melhorar as chances de sucesso do projeto.
Esse processo pode ser dividido em 7 passos: 
* **Planejamento do Gerenciamento de Riscos** - como realizar as atividades de gerenciamento de risco ao longo do projeto;
* **Identificação de Riscos** - identificação e documentação dos possíveis riscos e fontes de risco ao projeto;
* **Análise Qualitativa de Riscos** - priorização no tratamento de riscos com base em seu impacto e/ou outras características;
* **Análise Quantitativa de Riscos** - análise embasada no impacto de riscos simultâneos no projeto;
* **Planejamento de Resposta aos Riscos** - estratégias ou alternativas possíveis para reduzir o impacto de riscos;
* **Implementação de Resposta aos Riscos** - aplicação das respostas acima no projeto;
* **Monitoramento de Riscos** - engloba os processos anteriores e também mede a eficiência do processo de gerenciamento de riscos.

### 2. Etapas
#### 2.1  Identificação de Riscos
Usaremos a técnica SWOT (Strengths/Forças, Weaknesses/Fraquezas, Opportunities/Oportunidades & Threats/Ameaças) para melhor identificarmos as possíveis fontes de riscos para o projeto. No método, são avaliadas as forças e fraquezas da equipe como um todo (Strengths/Weaknesses) em comparação das oportunidades que estas características podem afetar o projeto (Opportunities/Threats).

Forças | Fraquezas | Oportunidades | Ameaças
-------|---------- |---------------|------- |
Conhecimento de metodologias | Falta de experiência com Java | Possível continuação do jogo após termino da disciplina | Mudança de escopo no projeto 
Integração da equipe | Criação da engine do jogo | Aplicação de gamificação no desenvolvimento do projeto | Disponibilidade da equipe 
Entusiasmo com o projeto | &nbsp; | &nbsp; | Atrasos e imprevistos
Conhecimento de conceitos de gamificação | &nbsp; | &nbsp; | Calendário acadêmico

#### 2.2 Análise Qualitativa de Riscos
A análise qualitativa de risco, com base no seu escore de probabilidade de ocorrência e impacto, será feita com ajuda de nossa Matriz de Probabilidade X Impacto, tão quanto como pela Estrutura Analítica de Risco (EAR).

#### 2.3 Análise Quantitiva de Riscos
Com base no resultado da análise qualitativa e sua ocorrência no projeto, será feita a análise quantitativa de risco para que sejam otimizadas as prioridades de resposta a riscos.

#### 2.4 Planejamento de Resposta aos Riscos
Antes de serem aplicadas as respostas, estas serão planejadas nesta etapa com base nos resultados posteriores. Assim, serão delegados papéis e responsabilidades acerca às estrategiás e/ou alternativos escolhidas para o devido risco.

#### 2.5 Implentação de Respostas aos Riscos
Esta etapa consiste na aplicação do que foi planejado para os riscos anteriormente.

#### 2.6 Monitoramento de Riscos
Haverá um acompanhamento dos riscos já avaliados caso voltem a ocorrer ou suas respostas não tenham sido suficientes, assim como a identificação de novos riscos, replanejamento e avaliação de todas as etapas anteriores.

### 3. Matriz de Probabilidade e Impacto
![Exemplo de Matriz de Probabilidade e Impacto com pesos](https://i.imgur.com/ubzGmfX.png)

A matriz de probabilidade e impacto será usada para avaliar os riscos quanto a chance daquele risco acontecer (Probabilidade) contra seu impacto para a integridade do projeto (Impacto). Serão priorizados os riscos que obtiverem maiores valores em abas as categorias a fim de otimizar o processo de gerenciamento de riscos.
Para essa avaliação, serão levados em conta critérios como tempo, escopo, custo e qualidade.

#### 3.1 Probabilidade
A probabilidade (P) é estimada pela equipe de gerência de riscos, sendo este a chance de um dado risco vir à tona durante o desenvolvimento do projeto.

Probabilidade | Intervalo (%)| Peso | 
-------|---------- | -------- |
Muito Alta | De 71 a 100 | 5 | 
Alta | De 51 a 70 | 4 | 
Média | De 31 a 50 | 3 | 
Baixa | De 11 a 30 | 2 | 
Muito Baixa | De 0 a 10 | 1 |

#### 3.2 Impacto
O impacto (I) é estimado pela equipe de gerência de riscos, sendo este o impacto de um dado risco à integridade do projeto.

Impacto| Descrição | Intervalo (%)| Peso | 
-------|---------- | ------------ | ------ | 
Muito Alta | Essencial ao funcionamento do projeto | De 51 a 100 | 5 |
Alta | Importante ao projeto, mas não essencial | De 31 a 50 | 4 |
Média | Existe impacto, porém contornável | De 11 a 30 | 3 | 
Baixa | Existe pouco impacto no projeto | De 6 a 10 | 2 |
Muito Baixa | Quase que imperceptível ao projeto | De 0 a 5 | 1 |

#### 3.3 Prioridade 
A prioriadade (P/I) é calculada pelo produto dos pesos de impacto e probabilidade, gerando a matriz de prioridades. 

P/I | Muito Baixo | Baixo | Médio | Alto | Muito Alto | 
--- |------------ | ----- | ----- | ---- | ---------- | 
Muito Baixo | 1 | 2 | 3 | 4 | 5 | 
Baixo | 2 | 4 | 6 | 8 | 10 | 
Média | 3 | 6 | 9 | 12 | 15 |
Alto | 4 | 8 | 12 | 16 | 20 |
Muito Alto| 5 | 10 | 15 | 20 | 25 |

#### 3.4 Nível de Prioridade

Nível de Prioridade | Intervalo | 
------------------- | --------- |
Baixo | De 1 a 4 |
Médio | De 5 a 12 | 
Alto | De 15 a 25 |