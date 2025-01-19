package Questao_02.entities;

public class
Calculadora {
    private int numero01;
    private int numero02;

    public Calculadora(int numero01, int numero02) {
        this.numero01 = numero01;
        this.numero02 = numero02;
    }

    public int soma() {
        return numero01 + numero02;
    }
}
