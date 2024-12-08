# Exercício 02 

# 1. Diferença entre Tipagem Dinâmica e Tipagem Estática

| **Tipagem**            | **Tipagem Estática**                                                                 | **Tipagem Dinâmica**                                                             |
|------------------------|--------------------------------------------------------------------------------------|----------------------------------------------------------------------------------|
| **Quando o tipo é definido** | Em tempo de **compilação**                                                        | Em tempo de **execução**                                                         |
| **Mudança de tipo**    | Não permitida – o tipo é fixo durante a execução                                     | Permitida – variáveis podem mudar de tipo                                        |
| **Exemplos de Linguagens** | Java, C, C++, Swift                                                               | Python, JavaScript, Ruby, PHP                                                    |

## Vantagens e Desvantagens

| **Tipagem**            | **Vantagens**                                                                       | **Desvantagens**                                                                |
|------------------------|--------------------------------------------------------------------------------------|----------------------------------------------------------------------------------|
| **Estática**           | - Segurança: erros detectados em compilação <br> - Melhor performance              | - Menos flexível <br> - Exige declarações de tipo explícitas                    |
| **Dinâmica**           | - Flexibilidade: variáveis mudam de tipo <br> - Menos código necessário            | - Erros de tipo apenas em execução <br> - Possível menor performance            |

--- 

## 2. Qual o principal problema do uso de tipagem dinâmica?

| **Pergunta** | **Resposta** |
|--------------|--------------|
| **Principal problema da tipagem dinâmica** | A tipagem dinâmica permite que o tipo de uma variável mude em tempo de execução, o que pode causar **erros inesperados** que só são detectados quando o programa está sendo executado. Isso dificulta a depuração, especialmente em programas complexos, já que erros de tipo, como operações inválidas entre tipos diferentes, podem não ser detectados até o momento da execução. |

---

## 4. Por que C possui tipagem fraca, mesmo com tipagem estática?

| **Pergunta** | **Resposta** |
|--------------|--------------|
| **C possui tipagem fraca?** | Sim, C é considerado uma linguagem de **tipagem fraca** mesmo com **tipagem estática**. Isso ocorre porque C permite **conversões implícitas entre tipos** diferentes. Por exemplo, é possível somar um `int` com um `float` sem causar erro, o que pode resultar em perda de precisão ou resultados inesperados. |


---

## 5. A tipagem do TypeScript é fraca?

| **Pergunta** | **Resposta** |
|--------------|--------------|
| **A tipagem do TypeScript é considerada fraca?** | Não, a tipagem do TypeScript não é considerada fraca por permitir que uma variável `number` aceite tanto **inteiros quanto números de ponto flutuante**. Essa característica é normal em várias linguagens e não implica que a tipagem seja fraca, pois não há conversão automática entre tipos incompatíveis, e TypeScript mantém uma tipagem rigorosa entre tipos distintos. |

---
