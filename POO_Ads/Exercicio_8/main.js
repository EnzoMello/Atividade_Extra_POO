import { Conta } from "./banco";

// Criando contas
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
    console.log("Erro ao realizar a transferência:", error.message); // O erro de saldo será feito aqui
}

console.log("\nSaldo final:");
console.log("Conta 1 (Origem): R$".concat(conta1.saldo.toString()));
console.log("Conta 2 (Destino): R$".concat(conta2.saldo.toString()));

