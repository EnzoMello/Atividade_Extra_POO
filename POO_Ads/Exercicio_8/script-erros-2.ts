import prompt from "prompt-sync";
import * as fs from 'fs';
do {
    let input =  prompt();
    try {
        let caminho = input("Digite o caminho do arquivo ou digite 0 para sair:");
        if (caminho == '0') {
            break;
        }
        
        const arquivo: string = fs.readFileSync(caminho, 'utf-8');
        console.log("arquivo aberto com sucesso");
        break;
    } catch (e) {
        console.log("Erro ao abrir arquivo. Verifique o caminho digitado");
    }

} while (true);