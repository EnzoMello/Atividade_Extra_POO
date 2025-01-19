package Exercicio_5.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();
    private int proximoIdCliente = 1;

    // Adicionar cliente
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Buscar cliente por CPF
    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    // Buscar cliente por ID
    public Cliente buscarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    // Adicionar conta
    public void addConta(Conta conta) {
        contas.add(conta);
    }

    // Remover conta por número
    public boolean removerConta(String numero) {
        Conta conta = getConta(numero);
        if (conta != null) {
            contas.remove(conta);
            return true;
        }
        return false;
    }

    // Buscar conta por número
    public Conta getConta(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumber().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    // Exibir todos os clientes
    public void exibirClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    // Exibir todos os saldos
    public void exibirSaldos() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta registrada.");
        } else {
            for (Conta conta : contas) {
                System.out.println(conta);
            }
        }
    }

    // Totalizar o saldo de todas as contas
    public double totalizarSaldo() {
        double total = 0;
        for (Conta conta : contas) {
            total += conta.getSaldo();
        }
        return total;
    }

    // Método para obter o próximo ID de cliente
    public int getProximoIdCliente() {
        return proximoIdCliente++;
    }

    public void adicionarPoupanca(String numero, double saldo, double taxaJuros) {
        int id = getProximoIdCliente();
        Poupanca poupanca = new Poupanca(numero, saldo, id, taxaJuros);
        contas.add(poupanca);
        System.out.println("Poupança criada com sucesso: " + poupanca);
    }


    public void renderJuros(String numero){
        Conta conta = getConta(numero);
        if (conta != null){
            if(conta instanceof Poupanca){
                Poupanca poupanca = (Poupanca) conta;
                poupanca.renderJuros();
                System.out.println("Juros rendendo com sucesso");
            } else {
                System.out.println("A conta não é poupança");
            }
        } else {
            System.out.println("Conta não encontrada");
        }
    }

    // Adicionar uma ContaImposto
    public void adicionarContaImposto(String numero, double saldo, double taxaImposto) {
        int id = getProximoIdCliente();
        ContaImposto contaImposto = new ContaImposto(numero, saldo, id, taxaImposto);
        contas.add(contaImposto);
        System.out.println("ContaImposto criada com sucesso: " + contaImposto);
    }

    // Descontar imposto de uma ContaImposto
    public void descontarImposto(String numero) {
        Conta conta = getConta(numero);
        if (conta != null) {
            if (conta instanceof ContaImposto) {
                ContaImposto contaImposto = (ContaImposto) conta;
                contaImposto.descontarImposto();
            } else {
                System.out.println("A conta informada não é uma ContaImposto.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    // Método para ler dados de um arquivo e incrementar em contas
    public void carregarContasArquivo(String caminho){
        try (BufferedReader arquivo = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = arquivo.readLine()) != null) {
                String[] campos = linha.split(";");

                // Campos das contas
                String tipo = campos[0];
                String numero = campos[1];
                double saldo = Double.parseDouble(campos[2]);
                int id = Integer.parseInt(campos[3]);

                switch (tipo){
                    case "C":
                        Conta conta = new Conta(numero, saldo, id);
                        contas.add(conta);
                        break;
                    case "CP":
                        double taxaJuros = Double.parseDouble(campos[4]);
                        Poupanca poupanca = new Poupanca(numero,saldo,id,taxaJuros);
                        contas.add(poupanca);
                        break;
                    case "CI":
                        double taxaImposto = Double.parseDouble(campos[4]);
                        ContaImposto contaImposto = new ContaImposto(numero,saldo,id,taxaImposto);
                        contas.add(contaImposto);
                        break;
                    default:
                        System.out.println("Tipo de conta desconhecida: " + tipo);
                }
            }
            System.out.println("Arquivo carregado " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo ");
        }
    }
}


