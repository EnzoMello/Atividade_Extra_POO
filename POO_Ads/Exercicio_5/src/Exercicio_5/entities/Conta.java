package Exercicio_5.entities;

public class Conta {
    private String number;
    private double saldo;
    private int id;
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conta(String number, double saldo, int id){
        this.number = number;
        this.saldo = saldo;
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double valor){
        this.saldo -= valor;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void transferir(Conta destino, double valor){
        this.sacar(valor);
        destino.depositar(valor);
    }

    public String toString(){
        return "number: " + number + ", balance: R$ " + saldo + "\n";
    }


}
