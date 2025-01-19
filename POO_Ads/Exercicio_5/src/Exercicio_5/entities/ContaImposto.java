package Exercicio_5.entities;

public class ContaImposto extends Conta {
    private double taxaImposto;

    public ContaImposto(String number, double saldo, int id, double taxaImposto) {
        super(number, saldo, id);
        this.taxaImposto = taxaImposto;
    }


    public void descontarImposto() {
        double imposto = getSaldo() * taxaImposto;
        if (getSaldo() >= imposto) {
            sacar(imposto);
            System.out.println("Imposto = " + imposto + "da conta " + getNumber());
        } else {
            System.out.println("Saldo insuficiente para descontar imposto");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Taxa de imposto: " + taxaImposto;
    }
}
