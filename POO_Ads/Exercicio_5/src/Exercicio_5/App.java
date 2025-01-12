package Exercicio_5;

import Exercicio_5.entities.Banco;

// Classe APP para chamar o menu e escolher entre os métodos do banco
public class App {
    public static void main(String[] args){
        Banco banco = new Banco();
        banco.menuApp();
    }
}
