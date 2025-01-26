# Atividade POO 8 - (Parte 1)

## Questão 1 - Enumere os 3 tipos mais comuns de tratamento de erros e exemplifique com códigos seus ou pesquisados na internet.

### <u>Resposta:</u>

### 1. Tratamento baseado em retorno de código de erro 
Este método envolve o retorno de códigos específicos por funções para indicar sucesso ou falha.

```c
#include <stdio.h>

int abrirArquivo(const char* nomeArquivo) {
    FILE* arquivo = fopen(nomeArquivo, "r");
    if (arquivo == NULL) {
        return -1; // Código de erro
    }
    fclose(arquivo);
    return 0; // Sucesso
}

int main() {
    if (abrirArquivo("teste.txt") == -1) {
        printf("Erro ao abrir o arquivo.\n");
    } else {
        printf("Arquivo aberto com sucesso.\n");
    }
    return 0;
}
```

### 2. Tratamento com estruturas de exceção (try-catch)

Este método separa o fluxo normal do programa do tratamento de erros, utilizando blocos como `try`, ``catch`` ou ``except``.

```C
try:
    with open("teste.txt", "r") as arquivo:
        conteudo = arquivo.read()
        print("Arquivo lido com sucesso.")
except FileNotFoundError:
    print("Erro: Arquivo não encontrado!")
except Exception as e:
    print(f"Erro inesperado: {e}")
```

### 3. Tratamento com validações explícitas
Neste caso, o código valida condições antes de realizar operações que possam falhar, reduzindo a ocorrência de erros.

```C
#include <stdio.h>
#include <unistd.h> // Para a função access()

int main() {
    if (access("teste.txt", F_OK) != -1) {
        printf("O arquivo existe.\n");
    } else {
        printf("Erro: O arquivo não existe.\n");
    }
    return 0;
}
```

## Questão 2 - Explique por que cada um dos 3 métodos acima possui limitações de uso.
### <u>Resposta:</u>
#### Tratamento baseado em retorno de código de erro 
* Ele exige que o programador faça a manipulação de cada tipo de erro manualmente e, às vezes, pelo esquecimento do programador, isso pode gerar erros silenciosos. Além disso, o uso de muitos códigos de erro pode dificultar a leitura e manutenção do código, especialmente em sistemas mais complexos. A falta de padronização nos retornos também é um dos desafios.

#### Tratamento com estruturas de exceção (try-catch)
* Esse método pode adicionar uma sobrecarga de desempenho, já que lançar e capturar exceções pode ser mais custoso que outras abordagens. Além disso, o uso excessivo ou inadequado de exceções, como lançar exceções para situações previsíveis, pode tornar o código confuso. Em projetos grandes, o rastreamento de onde o erro foi gerado e como ele é tratado pode se tornar difícil se o código não for bem organizado.

#### Tratamento com validações explícitas
* Esse método exige que o programador antecipe todas as possíveis falhas, o que pode ser impraticável em sistemas dinâmicos ou imprevisíveis. Além disso, o código pode se tornar muito verboso devido à necessidade de muitas verificações, comprometendo a legibilidade. Por fim, validações explícitas não protegem contra erros que não podem ser previstos ou que ocorrem em tempo de execução. 

## Questão 3 - Com o código repassado, crie duas contas e teste o método transferir de modo que a conta a ser debitada não possua saldo suficiente. Explique o que ocorreu.

### <u>Resposta:</u>
O código abaixo tenta realizar uma transferência de R$200 da Conta 1 para a Conta 2. No entanto, a Conta 1 possui apenas R$100, o que significa que ela não tem saldo suficiente para concluir a operação. Ao tentar executar a transferência, o código detecta o saldo insuficiente e lança uma exceção. Essa exceção é capturada pelo bloco ``catch``, que então exibe a mensagem: ``"Erro ao realizar a transferência:"``, seguida pela descrição do erro, representada por ``(error as Error).message``
````typescript
import { Conta} from './banco'; // Importação correta

// Criando duas contas
let conta1 = new Conta(1, "123", 100); // Conta com saldo insuficiente
let conta2 = new Conta(2, "456", 500); // Conta de destino

// Exibindo os saldos iniciais
console.log("Saldo inicial:");
console.log(`Conta 1 (Origem): R$${conta1.saldo}`);
console.log(`Conta 2 (Destino): R$${conta2.saldo}`);

// Tentando realizar a transferência
try {
    console.log("\nTentando transferir R$200 da Conta 1 para a Conta 2...");
    conta1.transferir(conta2, 200);
} catch (error) {
    console.log("Erro ao realizar a transferência:", (error as Error).message);
}

// Exibindo os saldos finais
console.log("\nSaldo final:");
console.log(`Conta 1 (Origem): R$${conta1.saldo}`);
console.log(`Conta 2 (Destino): R$${conta2.saldo}`);
````

## Questão 4 - Instancie uma classe App e, caso necessário, crie duas contas. Acesse a opção de transferir com valor alto o suficiente para lançar uma exceção/erro. Verifique que o lançamento da exceção foi “propagado” para o método conta.transferir(), banco.transferir() e App.menu()? Como você avalia a confiabilidade dessa implementação.
### <u>Resposta:</u>
A implementação está funcional, mas a propagação de exceções poderia ser mais controlada. A falta de validações mais robustas e de controle transacional nas transferências pode causar problemas em casos de erro. Melhorias nesses pontos tornariam o sistema mais confiável.
```typescript
let app = new App();

let conta1 = new Conta(1, '12345', 1000);  
let conta2 = new Conta(2, '67890', 500);   

app._banco.inserirConta(conta1);
app._banco.inserirConta(conta2);

try {
    console.log("Tentando transferir 1500 da conta1 para conta2...");
    app.transferir();
} catch (e: any) {
    console.log("Exceção capturada no App.menu(): " + e.message);
}
```

## Questão 5 - Crie um método chamado validaValor(valor) na que lance um erro caso o valor repassado seja menor ou igual a zero ou em formato inválido. Chame o método no construtor da classe conta para validar o saldo inicial. Chame o método também nos métodos sacar e depositar. Reexecute a classe App e chame as opções de menu que aceitam valores referentes a saldo, débito, crédito e transferir. Avalie o tratamento do erro.
### <u>Resposta:</u>

````typescript
import { Conta } from "./banco";

class Main {
    public static main(): void {
        console.log("\n=== Testes Simples ===");

        try {
            console.log("\nTentando criar uma conta com saldo inválido...");
            const contaInvalida = new Conta(1, "123", -50); // Deve lançar erro
        } catch (error) {
            console.error("Erro ao criar conta:", (error as Error).message);
        }

        let conta1 = new Conta(2, "456", 200); // declaração única
        let conta2 = new Conta(3, "789", 300); // declaração única

        console.log("\nCriando duas contas com saldo válido...");
        console.log("Contas criadas com sucesso!");

        try {
            console.log("\nTentando realizar um depósito inválido...");
            conta1.depositar(-50); // Deve lançar erro
        } catch (error) {
            console.error("Erro ao realizar depósito:", (error as Error).message);
        }

        try {
            console.log("\nTentando realizar um saque inválido...");
            conta1.sacar(0); // Deve lançar erro
        } catch (error) {
            console.error("Erro ao realizar saque:", (error as Error).message);
        }

        try {
            console.log("\nTentando realizar uma transferência inválida...");
            const conta3 = new Conta(4, "111", 100); // criando novas instâncias
            const conta4 = new Conta(5, "222", 50); // criando novas instâncias
            conta3.transferir(conta4, -50); // Deve lançar erro
        } catch (error) {
            console.error("Erro ao realizar transferência:", (error as Error).message);
        }

        console.log("\n=== Testes Finalizados ===");
    }
}

Main.main();
````