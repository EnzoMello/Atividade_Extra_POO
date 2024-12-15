package Exercicio_5.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

    public Conta consultaIndice(int indice){
        if(indice > 0 && indice < contas.size()){
            return contas.get(indice);
        }
        System.out.println("Conta inválida.");
        return null;
    }

    public void excluirConta(int indice){
        contas.remove(consultaIndice(indice));
        System.out.println("Conta removida com sucesso");
    }

    public void atualizarConta(int numeroConta, double novoSaldo) {
        Conta conta = consultaIndice(numeroConta);
        if (conta != null) {
            conta.setSaldo(novoSaldo);
            System.out.println("Saldo da conta atualizado com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void sacar(int numeroConta, double valor) {
        Conta conta = consultaIndice(numeroConta);
        if (conta != null) {
            if (conta.getSaldo() >= valor) {
                conta.sacar(valor);
                System.out.println("Saque realizado.");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void depositar(int numeroConta, double valor) {
        Conta conta = consultaIndice(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
            System.out.println("Depósito feito.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void transferir(String numeroContaOrigem, String numeroContaDestino, double valor) {
        Conta contaOrigem = consultar(numeroContaOrigem);
        Conta contaDestino = consultar(numeroContaDestino);

        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.getSaldo() >= valor) {
                contaOrigem.sacar(valor);
                contaDestino.depositar(valor);
                System.out.println("Transferência realizada com sucesso.");
            } else {
                System.out.println("Saldo insuficiente na conta de origem.");
            }
        } else {
            System.out.println("Uma ou ambas as contas não foram encontradas.");
        }
    }

    public void transferirParaVariasContas(String numeroContaOrigem, String[] numerosContasDestino, double valor) {
        Conta contaOrigem = consultar(numeroContaOrigem);

        if (contaOrigem != null) {
            if (contaOrigem.getSaldo() >= valor * numerosContasDestino.length) {
                for (String numeroContaDestino : numerosContasDestino) {
                    Conta contaDestino = consultar(numeroContaDestino);
                    if (contaDestino != null) {
                        contaOrigem.sacar(valor);
                        contaDestino.depositar(valor);
                        System.out.println("Transferência de " + valor + " realizada para a conta " + numeroContaDestino);
                    } else {
                        System.out.println("Conta de destino " + numeroContaDestino + " não encontrada.");
                    }
                }
            } else {
                System.out.println("Saldo insuficiente na conta de origem para todas as transferências.");
            }
        } else {
            System.out.println("Conta de origem não encontrada.");
        }
    }

    public int quantidadeDeContas() {
        return this.contas.size();
    }

    public double totalDepositos() {
        double total = 0;
        for (Conta conta : this.contas) {
            total += conta.getSaldo();
        }
        return total;
    }

    public double mediaDeSaldos() {
        int quantidade = quantidadeDeContas();
        if (quantidade == 0) return 0; // Evitar divisão por zero
        double total = totalDepositos();
        return total / quantidade;
    }

    public int gerarId(){
        Random random = new Random();
        return random.nextInt(100000000, 900000000);
    }

    public void showMenu() {
        System.out.println("\nBEM-VINDO AO ENZOBANK");
        System.out.println("Escolha uma opção:");
        System.out.println("Contas");
        System.out.println(" 1 - Inserir  2 - Consultar  3 - Sacar 4 - Depositar");
        System.out.println(" 5 - Excluir  6 - Transferir 7 - Totalizar ");
        System.out.println("=========================================================:");
        System.out.println("Opções com clientes:");
        System.out.println(" 8 - Inserir  9 - Consultar 10 - Associar");
        System.out.println("> 0 - Sair");
    }

    public void menuApp(){
        Scanner sc = new Scanner(System.in);
        int escolha;
        do {
            showMenu();
            System.out.print("Escolha uma opção: ");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Número da conta: ");
                    String numeroConta = sc.nextLine();
                    System.out.print("Saldo da conta: ");
                    double saldoInicial = sc.nextDouble();
                    int id = gerarId();
                    Conta novaConta = new Conta(numeroConta, saldoInicial, id);
                    inserir(novaConta);
                    break;

                case 2:
                    System.out.print("Número da conta: ");
                    String numeroConta2 = sc.nextLine();
                    Conta contaEscolhida2 = consultar(numeroConta2);
                    if (contaEscolhida2 != null) {
                        System.out.println("Conta: " + contaEscolhida2.getNumber() + " Saldo: " + contaEscolhida2.getSaldo());
                    } else {
                        System.out.println("Conta inexistente");
                    }
                    break;

                case 3:
                    System.out.print("Número da conta para sacar: ");
                    String numeroConta3 = sc.nextLine();
                    Conta contaEscolhida3 = consultar(numeroConta3);
                    if (contaEscolhida3 != null) {
                        System.out.print("Valor para sacar: ");
                        double valor = sc.nextDouble();
                        contaEscolhida3.sacar(valor);
                    } else {
                        System.out.println("Conta inexistente");
                    }
                    break;

                case 4:
                    System.out.print("Coloque o número da conta: ");
                    String numeroConta4 = sc.nextLine();
                    Conta contaEscolhida4 = consultar(numeroConta4);
                    if (contaEscolhida4 != null) {
                        System.out.print("Valor para depositar: ");
                        double valor = sc.nextDouble();
                        contaEscolhida4.depositar(valor);
                    } else {
                        System.out.println("Conta inexistente");
                    }
                    break;

                case 5:
                    System.out.print("Coloque o número da conta: ");
                    int numeroConta5 = sc.nextInt();
                    excluirConta(numeroConta5);
                    break;

                case 6:
                    System.out.print("Coloque o número da conta origem: ");
                    String numeroOrigem = sc.nextLine();
                    System.out.print("Coloque o número da conta destino: ");
                    String numeroDestino = sc.nextLine();
                    System.out.print("Valor a ser transferido: ");
                    double valor = sc.nextDouble();
                    transferir(numeroOrigem, numeroDestino, valor);
                    break;

                case 7:
                    System.out.println("Contas: " + quantidadeDeContas());
                    break;

                case 8:
                    System.out.print("CPF do cliente: ");
                    String cpf = sc.nextLine();

                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    id = gerarId();

                    LocalDate dataNascimento = null;
                    while (dataNascimento == null) {
                        try {
                            System.out.print("Informe a data de nascimento (dd/MM/yyyy): ");
                            String dataInput = sc.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            dataNascimento = LocalDate.parse(dataInput, formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de data inválido. Tente novamente.");
                        }
                    }

                    Cliente clienteInserir = new Cliente(id,nome,cpf,dataNascimento);
                    inserirCliente(clienteInserir);
                    break;

                case 9:
                    System.out.println("CPF do cliente: ");
                    String cpfCliente = sc.nextLine();
                    Cliente contaCliente = consultarCliente(cpfCliente);
                    if (contaCliente != null) {
                        System.out.println("Nome do cliente: " + contaCliente.getNome() + "\n" +
                                "CPF do cliente: " + contaCliente.getCpf() + "\n" +
                                "Data de nascimento: " + contaCliente.getDataNascimento());

                    } else {
                        System.out.println("Cliente inexistente");
                    }
                    break;

                case 10:
                    System.out.print("Número da Conta do Cliente: ");
                    String numeroConta10 = sc.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpfAssociarConta = sc.nextLine();
                    associarContaCliente(numeroConta10, cpfAssociarConta);
                    break;

                case 0:
                    System.out.println("Você saiu do menu.");
                    break;
                default:
                    System.out.println("Opção não consta no menu");

            }
        } while (escolha != 0);

    }
}
