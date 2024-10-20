# Atividade Extra - POO

## Questão 1
Explique com suas palavras a diferença entre uma classe e um objeto e como  esses dois conceitos se relacionam.

**Classe**: Uma classe é um tipo estruturado que contém atributos (características/dados) e métodos (funções), representando entidades, como Produto ou Cliente. 

**Objeto**: Um objeto é uma instância de uma classe, representando entidades específicas com seus próprios valores de atributos. Os objetos são declarados por meio da alocação dinâmica de memória, usando `new()`.

### Exemplo do Mundo Real
- **Classe**: Banco (representa a estrutura de um banco qualquer)
- **Objeto**: Conta (carrega os atributos `nome` e `saldo` de uma entidade do banco)


---

## Questão 2
De forma breve, conceitue atributos e métodos. Pesquise e exemplifique um objetos ou classes que possuam atributos e métodos.
- **Atributos**: São variáveis que pertencem à classe, representando características ou estados dos objetos. Eles podem ser declarados com visibilidades como `Public`, `Private` ou `Protected`.
  
- **Métodos**: São funções pertencentes à classe, responsáveis por realizar operações, modificar atributos ou retornar valores.

### Exemplo: Classe `Produto`

| **Atributos**      | **Descrição**                                                    |
|--------------------|------------------------------------------------------------------|
| `Nome`             | Nome do produto                                                  |
| `Preço`            | Preço do produto                                                 |
| `Quantidade`       | Quantidade disponível em estoque                                 |

| **Métodos**                    | **Descrição**                                                                 |
|---------------------------------|-------------------------------------------------------------------------------|
| `Adicionar Quantia()`           | Adiciona uma quantidade ao estoque                                            |
| `Remover Quantia()`             | Remove uma quantidade do estoque                                              |
| `Contar valor no estoque()`     | Calcula o valor total dos produtos no estoque com base no preço e na quantidade|
| `Adicionar valor no preço()`    | Incrementa um valor ao preço do produto                                       |
| `Decrementar valor no preço()`  | Diminui um valor no preço do produto                                          |


 
---

## Questão 3

| Atributo                | Sistema em que não é importante        | Sistema em que é moderadamente importante | Sistema em que é essencial               |
|-------------------------|----------------------------------------|------------------------------------------|------------------------------------------|
| CPF                     | Eventos públicos                       | Assinatura de serviços                   | Conta Bancária                           |
| Histórico de saúde       | Exames Simples                         | Internações curto prazo                  | Sistema Hospitalar                       |
| Quantidade de seguidores | Supermercado                           | Redes sociais                            | Pesquisa de Influência                   |
| Habilidade destra        | Matrícula na universidade              | Esportes                                 | Dirigir Carro                            |
| Endereço                 | Praticar Esportes                      | Compras Online                           | Usar Correios                            |
| Saldo em conta           | Site de igreja                         | Compras online                           | Sistema bancário                         |
| Etnia                    | Esportes                               | Políticas públicas                       | Inscrição em cotas em concursos          |


## Questão 4

| Pergunta                                                                                       | Resposta                                                                                                                                                                                 |
|-------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **a. Seria interessante em um sistema bancário um objeto "conta" possuir uma "pessoa" como um atributo interno representando o titular da conta?**  | Sim, pois toda conta precisa de alguém como representante dela, uma vez que saques e depósitos serão feitos ali e precisa de algum supervisor para maior segurança.                       |
| **b. Olhando no sentido inverso, seria interessante uma pessoa possuir mais de uma conta como atributo? Que elemento da programação estruturada melhor representaria o conjunto de contas de uma pessoa?** | Sim, já que não há restrições para uma pessoa ter mais de uma conta em diferentes bancos. Desse modo, ter várias contas ajuda a pessoa a ser beneficiada com as vantagens de cada banco. Ademais, o elemento essencial para representar isso em POO seria um array. |

---

## Questão 5

**Identifique pelo menos 5 objetos de um sistema de controle acadêmico. Ex: aluno.
- **Respostas**: Professor, Sala, Biblioteca, Matérias e Boletim.

---

## Questão 6

**Imagine um jogo qualquer. Identifique o máximo de objetos possíveis e eventuais características (atributos) e comportamentos (métodos) que eles poderiam ter.**

**Resposta**: Jogo de futebol.  
- **Atributos**: jogadores, quantidade de torcedores, situação da partida, juíz, local, placar, bola  
- **Métodos**: iniciar partida, intervalo, pausar partida, encerrar partida, aquecer jogador, instruir jogador, substituir jogador, expulsar jogador, mudar capitão, contar torcedores, animar torcedores, acalmar torcedores, expulsar torcedor, trocar bola, olhar VAR, alterar placar, mudar local.
