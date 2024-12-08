package Exercicio_5;

import Exercicio_5.entities.Banco;
import Exercicio_5.entities.Cliente;
import Exercicio_5.entities.Conta;

import java.util.Date;

public class Main {
    public static void main(String[] args){
        Banco banco = new Banco();
        Conta c1 = new Conta("111-2", 1800);
        Conta c2 = new Conta("125-1", 0);
        Conta c3 = new Conta("981-5", 500);

        banco.inserir(c1);
        banco.inserir(c2);
        banco.inserir(c3);
        System.out.println("Contas inseridas.");
        banco.inserir(c1); // Exibe mensagem de erro porque conta já foi cadastrada

        System.out.println("Lista de contas");
        System.out.println("Contas: " + banco.getContas());

        // Criar clientes
        Cliente enzo = new Cliente(1, "enzo", "12443",new Date());
        Cliente sammya = new Cliente(2, "sammya", "12444",new Date());
        Cliente joao = new Cliente(3, "joao", "12445",new Date());

        banco.inserirCliente(enzo);
        banco.inserirCliente(sammya);
        banco.inserirCliente(joao);
        banco.inserirCliente(enzo); // Exibe mensagem de erro

        // Lista de clientes
        System.out.println("Clientes: " + banco.getClientes());
        banco.associarContaCliente("111-2","12443");
        banco.associarContaCliente("125-1", "12444");
        banco.associarContaCliente("981-5", "12445");

        //Listar contas cliente Enzo
        banco.listarContasCliente("12443");

        // Listar saldo de um cliente
        System.out.println("Total saldo de Enzo");
        double saldoCliente = banco.totalizarSaldoCliente("12443");
        System.out.println("Saldo do Enzo " + saldoCliente);


    }
}
