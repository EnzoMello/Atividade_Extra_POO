public class Conta{
    private String numero;
    private double saldo;

    public Conta(String numero, int saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public void sacar(double valor){
        if(valor <= saldo){
            saldo -= valor;
        }else{
            Systemn.out.println("Saldo insuficiente.")
        }
    }

    public void depositar(double valor){
        saldo += valor
    }

    public double consultarSaldo(){
        return saldo;
    }

    public static void main(String[] args){
        Conta conta = new Conta("12345", 1000);

        conta.depositar(500.00);
        System.out.println("Valor após depósito: " + conta.consultarSaldo());

        conta.sacar(500);
        System.out.println("Valor após saque: " + conta.consultarSaldo());

        conta.sacar(200);
        System.out.println("Valor após saque: " + conta.consultarSaldo());

    }
}