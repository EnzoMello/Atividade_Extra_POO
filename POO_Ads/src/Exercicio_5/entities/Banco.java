package Exercicio_5.entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco(){
        this.contas = new ArrayList<Conta>();
        this.clientes = new ArrayList<>();
    }

    public void inserir(Conta conta){
        this.contas.add(conta);
    }

    public Conta consultar(String number){
        Conta contaEncontrada = null;
        for(Conta contaAtual : this.contas){
            if(contaAtual.getNumber().equals(number)){
                contaEncontrada = contaAtual;
            }
        }
        return contaEncontrada;
    }

    public List<Conta> getContas(){
        return this.contas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void inserirCliente(Cliente cliente){
        if(clientIdOuCpfJaExiste(cliente)){
            System.out.println("cliente ja cadastrado");
            return;
        }
        this.clientes.add(cliente);
    }

    private boolean clientIdOuCpfJaExiste(Cliente cliente) {
        for(Cliente clienteAtual : this.clientes){
            if(clienteAtual.getId() == cliente.getId() || clienteAtual.getCpf().equals(cliente.getCpf())){
                return true;
            }
        }
        return false;
    }

    public Cliente consultarCliente(String cpf){
        Cliente clienteEncontrado = null;
        for(Cliente clienteAtual : this.clientes){
            if(clienteAtual.getCpf().equals(cpf)){
                clienteEncontrado = clienteAtual;
            }
        }

        return clienteEncontrado;
    }

    public void associarContaCliente(String numeroConta, String cpfCliente){
        // Acessar o obj cliente
        Cliente clienteEncontrado = consultarCliente( cpfCliente);
        // Acessar o obj conta
        Conta contaEncontrada = consultar(numeroConta);

        List<Conta> contasDoCliente =clienteEncontrado.getContas();
        List<Conta> contasIguais = contasDoCliente.stream()
                .filter(conta -> conta.equals(contaEncontrada)).toList();

        if(contasIguais.size() > 0) {
            System.out.println("sai fora dd, ja tem essa conta");
            return;
        }
        // Associa conta na lista de contas do cliente
        clienteEncontrado.getContas().add(contaEncontrada);
    }

    public List<Conta> listarContasCliente(String cpf){
        Cliente cliente = consultarCliente(cpf);
        return cliente.getContas();
    }

    public double totalizarSaldoCliente(String cpf){
        List<Conta> contasCliente = listarContasCliente(cpf);
        double total = 0;
        for(Conta contaAtual : contasCliente){
            total += contaAtual.getSaldo();
        }
        return total;

    }

}
