// 1. Testando allowUnreachableCode: código inalcançável não gera erro
function testeAlcance(): number {
    return 1;
    console.log("Esta linha é inalcançável"); // Não gera erro devido à configuração
}

// 2. Testando noImplicitAny: Erro se uma variável não tiver tipo explícito
function somar(x: number, y) { // Erro: 'y' precisa de um tipo explícito
    return x + y;
}

// 3. Testando target ES3 com uma classe (ela será transpilada para uma versão mais antiga de JavaScript)
class Pessoa {
    nome: string;
    constructor(nome: string) {
        this.nome = nome;
    }
    dizerOi() {
        return `Olá, ${this.nome}!`;
    }
}
const pessoa = new Pessoa("Enzo");
console.log(pessoa.dizerOi());

// 4. Testando strictNullChecks: impede que variáveis null sejam passadas como valores não-null
let nome: string | null = null;
nome = null; // Aceito, pois 'nome' pode ser string ou null

function saudar(pessoa: string) {
    console.log(`Olá, ${pessoa}!`);
}

saudar(nome); // Erro: `nome` pode ser null; strictNullChecks impede.

// 5. Com sourceMap ativado, você poderá ver o TypeScript original ao depurar no navegador ou editor
console.log("Depuração ativa com sourceMap");
