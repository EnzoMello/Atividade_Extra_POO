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
