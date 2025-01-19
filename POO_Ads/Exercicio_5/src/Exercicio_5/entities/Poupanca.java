package Exercicio_5.entities;

public class Poupanca extends Conta{
    private double taxaJuros;

    public Poupanca(String numero, double saldo, int id, double taxaJuros) {
        super(numero, saldo, id);
        this.taxaJuros = taxaJuros;
    }

    public void renderJuros() {
        double juros = getSaldo() * taxaJuros;
        depositar(juros); // Adiciona os juros ao saldo
        System.out.println("Juros de R$ " + juros + " aplicados na poupança.");
    }

    // Sobrescrevendo o método toString para incluir a taxa de juros
    @Override
    public String toString() {
        return super.toString() + " | Taxa de juros: " + taxaJuros;
    }
}
