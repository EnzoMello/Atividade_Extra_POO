package Questao_03.entities;

public class CalculadoraCientifica extends Calculadora{
    public CalculadoraCientifica(int numero01, int numero02) {
        super(numero01, numero02);
    }

    public int exponenciar(){
        return (int) Math.pow(getNumero01(), 2);
    }
}
