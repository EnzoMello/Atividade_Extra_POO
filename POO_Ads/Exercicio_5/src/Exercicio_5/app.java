package Exercicio_5;

import Exercicio_5.entities.App;
import Exercicio_5.entities.Banco;

public class app {
    public static void main(String[] args) {
        Banco banco = new Banco();
        App app = new App(banco);
        app.menuApp();
    }
}
