## Questão 1 - Enumere os 3 tipos mais comuns de tratamento de erros e exemplifique com códigos seus ou pesquisados na internet.

### 1. Tratamento baseado em retorno de código de erro 
Este método retorna códigos ou objetos de erro para sinalizar problemas. É útil quando o tratamento de erros precisa ser feito em diferentes partes do sistema.

```typescript
function conectarBanco(status: boolean): { sucesso: boolean; mensagem: string } {
    if (!status) {
        return { sucesso: false, mensagem: "Erro: Banco de dados indisponível" };
    }
    return { sucesso: true, mensagem: "Conexão bem-sucedida" };
}

const resultado = conectarBanco(false);
console.log(resultado); // Saída: { sucesso: false, mensagem: "Erro: Banco de dados indisponível" }

```

### 2. Tratamento com estruturas de exceção (try-catch)

O bloco try-catch serve para verificar exceções durante a execução do código, evitando falhas inesperadas. Um bloco finally também pode ser adicionado para executar código, independentemente de ocorrer erro.
```typescript
function dividirNumeros(a: number, b: number): number {
    if (b === 0) {
        throw new Error("Erro: Divisão por zero não é permitida.");
    }
    return a / b;
}

try {
    const resultado = dividirNumeros(10, 0); // Tentando dividir por zero
    console.log(`Resultado: ${resultado}`);
} catch (error) {
    console.error("Erro capturado:", error.message); // Trata o erro de forma amigável
} finally {
    console.log("Operação finalizada."); // Sempre executa, independente de sucesso ou erro
}

```

### 3. Tratamento com validações explícitas
A validação antecipada é usada para verificar condições antes da execução do código, prevenindo erros de forma mais eficiente.

```typescript
function calcularMedia(notas: number[]): number | string {
    if (notas.length === 0) {
        return "Erro: Nenhuma nota fornecida.";
    }

    const soma = notas.reduce((acumulador, nota) => acumulador + nota, 0);
    return soma / notas.length;
}

// Testando a função
const media1 = calcularMedia([8, 9, 7]);
console.log(`Média: ${media1}`); // Média: 8

const media2 = calcularMedia([]);
console.log(media2); // Erro: Nenhuma nota fornecida.

```

## Questão 2 - Explique por que cada um dos 3 métodos acima possui limitações de uso.
#### Tratamento baseado em retorno de código de erro 
Esse método depende de valores específicos (geralmente inteiros) retornados por funções para indicar o sucesso ou falha. Sua limitação está no fato de que a interpretação dos códigos de erro pode ser confusa, e o código pode se tornar difícil de manter e propenso a erros humanos, especialmente em sistemas grandes. Além disso, a lógica de verificação de erros precisa ser realizada manualmente em cada ponto de chamada.

#### Tratamento com estruturas de exceção (try-catch)
A estrutura try-catch captura exceções em tempo de execução, oferecendo uma maneira de lidar com erros de forma centralizada. Porém, seu uso excessivo pode resultar em um desempenho inferior e aumentar a complexidade do código. Além disso, é possível que exceções não sejam tratadas de forma adequada, deixando falhas passarem despercebidas. Em casos de falhas frequentes, o código pode se tornar difícil de debugar.

#### Tratamento com validações explícitas
Nesse método, verificações preventivas (como condições if) são feitas para garantir que os dados ou operações estejam corretos antes da execução. A limitação aqui é que essas validações podem gerar redundâncias e código excessivo, além de não capturarem falhas que ocorrem em tempo de execução. Como as validações acontecem de forma antecipada, falhas inesperadas não são bem tratadas, podendo levar a um design de sistema mais frágil.
## Questão 3 - Com o código repassado, crie duas contas e teste o método transferir de modo que a conta a ser debitada não possua saldo suficiente. Explique o que ocorreu.

O erro ocorre quando a conta de origem não possui saldo suficiente para realizar a transferência. Ao tentar transferir um valor superior ao saldo disponível, o método transferir lança uma exceção com a mensagem "Saldo insuficiente". Esse erro é capturado pelo bloco catch, que impede a transferência e exibe a mensagem de erro, sem alterar os saldos das contas. Portanto, a transferência não é realizada e os saldos permanecem inalterados.
````typescript
import { Conta } from "./banco";

var conta1 = new banco_1.Conta(1, "123", 50); 
var conta2 = new banco_1.Conta(2, "456", 300); 

console.log("Saldo inicial:");
console.log("Conta 1 (Origem): R$".concat(conta1.saldo.toString()));
console.log("Conta 2 (Destino): R$".concat(conta2.saldo.toString()));

try {
    console.log("\nTentando transferir R$100 da Conta 1 para a Conta 2...");
    conta1.transferir(conta2, 100);  
}
catch (error) {
    console.log("Erro ao realizar a transferência:", error.message); // O erro será capturado nesse catch
}

console.log("\nSaldo final:");
console.log("Conta 1 (Origem): R$".concat(conta1.saldo.toString()));
console.log("Conta 2 (Destino): R$".concat(conta2.saldo.toString()));

````

## Questão 4 - Instancie uma classe App e, caso necessário, crie duas contas. Acesse a opção de transferir com valor alto o suficiente para lançar uma exceção/erro. Verifique que o lançamento da exceção foi “propagado” para o método conta.transferir(), banco.transferir() e App.menu()? Como você avalia a confiabilidade dessa implementação.
### <u>Resposta:</u>
A propagação da exceção está sendo realizada corretamente. Quando ocorre um erro de saldo insuficiente, a exceção é propagada de Conta para Banco e finalmente capturada e tratada no App. A implementação é funcional e confiável para este caso simples, mas poderia ser expandida com tratamentos mais detalhados e melhorias na gestão de erros.
```typescript
class App {
    private _banco: Banco;

    constructor() {
        this._banco = new Banco();
    }

    menu() {
        let conta1 = new Conta(1, '123', 3500);  
        let conta2 = new Conta(2, '456', 1200);    

        this._banco.inserirConta(conta1);
        this._banco.inserirConta(conta2);

        try {
            console.log("Tentando transferir 4000 da conta1 para conta2...");
            this._banco.transferir(conta1, conta2, 4000); 
        } catch (e: any) {
            console.log("Exceção capturada no App.menu(): " + e.message); // A exceção será capturada aqui
        }
    }
}

let app = new App();
app.menu();
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
            const contaInvalida = new Conta(1, "321", -20); // Deve lançar erro
        } catch (error) {
            console.error("Erro ao criar conta:", (error as Error).message);
        }

        let conta1 = new Conta(2, "45678", 500); // conta1 com saldo válido
        let conta2 = new Conta(3, "87654", 1000); // conta2 com saldo válido

        console.log("\nCriando duas contas com saldo válido...");
        console.log("Contas criadas com sucesso!");

        try {
            console.log("\nTentando realizar um depósito inválido...");
            conta1.depositar(-30); // Deve lançar erro
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
            const conta3 = new Conta(4, "11223", 150); // criando nova conta
            const conta4 = new Conta(5, "44556", 300); // criando nova conta
            conta3.transferir(conta4, -50); // Deve lançar erro
        } catch (error) {
            console.error("Erro ao realizar transferência:", (error as Error).message);
        }

        console.log("\n=== Testes Finalizados ===");
    }
}

// Chamando o método main para rodar os testes
Main.main();
````
