# Atividade Extra - POO

## Questão 1. Assinale verdadeiro ou falso:
- ( F ) Objetos são modelos para classes;
- ( F ) Atributos de uma classe devem ser obrigatoriamente inicializados para que as
classes compilem;
- ( F ) Uma variável declarada dentro de um método deve ser inicializada para que a
classe seja compilável;
- ( V ) Uma variável que seja uma classe declarada em um método é automaticamente
inicializada com undefined;
- ( V ) Construtores são rotinas especiais que servem para inicializar e configurar os
objetos no momento da instanciação;
- ( V ) Construtores não possuem tipo de retorno e podem ou não ter parâmetros;
- ( V ) Uma classe pode ter várias instâncias.

## 2. Suponha uma classe Hotel que sirva apenas para guardar a quantidade de
### Classe Hotel

A classe `Hotel` serve para guardar a quantidade de solicitações de reservas feitas. Abaixo está a implementação inicial:

```typescript
class Hotel {
    quantReservas: number;

    adicionarReserva(): void {
        this.quantReservas++;
    }
}
```
- Na compilação, não haverá erro, pois o typescript não tem problemas com uma variável undefined na compilação. Um possível erro, será no tempo de execução, já que não é possível incrementar uma variável com undefined. Assim, deve-se iniciar a variável em um construtor.

## 4. Considere a classe Radio e as instruções que fazem seu uso abaixo:
### Classe Radio

```typescript
class Radio {
    volume: number;

    constructor(volume: number) {
        this.volume = volume;
    }
}

let r: Radio = new Radio(); // Erro de compilação
r.volume = 10; // Esta linha não será executada devido ao erro acima
```

- O erro acontece quando o autor cria um construtor com inicialização obrigatória de atributo e, ao instanciar o construtor, ele não passa o atributo obrigatório.

## 5. Considerando o uso da classe Conta apresentada em aula e seu uso abaixo:
### Classe Conta

A classe `Conta` representa uma conta bancária e permite realizar operações como saque, transferência e consulta de saldo. Abaixo está um exemplo de uso da classe `Conta`:

```typescript
let c1: Conta = new Conta("1", 100); // Criação da primeira conta com ID "1" e saldo inicial de 100
let c2: Conta = new Conta("2", 100); // Criação da segunda conta com ID "2" e saldo inicial de 100
let c3: Conta; // Declaração de uma terceira conta sem inicialização

c1 = c2; // c1 agora referencia a conta c2
c3 = c1; // c3 agora também referencia a conta c2

c1.sacar(10); // Realiza um saque de 10 na conta c2 (agora referenciada por c1)
c1.transferir(c2, 50); // Tenta transferir 50 da conta c2 para ela mesma (c2)

console.log(c1.consultarSaldo()); // Imprime o saldo de c2 (que é 40 após o saque)
console.log(c2.consultarSaldo()); // Imprime o saldo de c2 (que é 40 após o saque)
console.log(c3.consultarSaldo()); //
```
- O código não irá imprimar nada, pois ocorrem erros de execução devido ao fato dos métodos sacar(), transferir() e consultarSaldo() não terem sidos criados.

  
