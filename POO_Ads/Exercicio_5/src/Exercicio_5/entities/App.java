package Exercicio_5.entities;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    private Banco banco;
    private Scanner scanner;

    public App(Banco banco) {
        this.banco = banco;
        this.scanner = new Scanner(System.in);
    }

    // Exibe o menu
    public void menuApp() {
        int opcao;
        do {
            System.out.println("\nBem-vindo ao Banco!\nEscolha uma opção:");

            // Exibindo o menu em formato tabular
            System.out.println("\n╔══════════════╦══════════════════════════════════════════╗");
            System.out.println("║ Contas       ║ Clientes                                  ║");
            System.out.println("╠══════════════╬══════════════════════════════════════════╣");
            System.out.printf("║ 1 - Inserir  ║ 8 - Inserir Cliente                      ║\n");
            System.out.printf("║ 2 - Consultar║ 9 - Consultar Cliente                     ║\n");
            System.out.printf("║ 3 - Sacar    ║ 10 - Associar Cliente à Conta             ║\n");
            System.out.printf("║ 4 - Depositar║ 11 - Criar Poupança                       ║\n");
            System.out.printf("║ 5 - Excluir  ║ 12 - Render Juros                         ║\n");
            System.out.printf("║ 6 - Transferir║ 13 - Criar ContaImposto                  ║\n");
            System.out.printf("║ 7 - Totalizações║14 - Descontar ContaImposto             ║\n");
            System.out.printf("║                 ║ 15 - Carregar contas arquivo            ║\n");
            System.out.println("╠══════════════╬══════════════════════════════════════════╣");
            System.out.printf("║ 0 - Sair     ║                                          ║\n");
            System.out.println("╚══════════════╩══════════════════════════════════════════╝");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Inserir conta
                    inserirConta();
                    break;
                case 2: // Consultar conta
                    consultarConta();
                    break;
                case 3: // Sacar
                    sacar();
                    break;
                case 4: // Depositar
                    depositar();
                    break;
                case 5: // Excluir conta
                    excluirConta();
                    break;
                case 6: // Transferir
                    transferir();
                    break;
                case 7: // Totalizações
                    totalizacao();
                    break;
                case 8: // Inserir cliente
                    inserirCliente();
                    break;
                case 9: // Consultar cliente
                    consultarCliente();
                    break;
                case 10: // Associar cliente à conta
                    associarClienteConta();
                    break;
                case 11: // Criar poupança
                    criarPoupanca();
                    break;
                case 12: // Render juros
                    renderJuros();
                    break;
                case 13: // Criar ContaImposto
                    criarContaImposto();
                    break;
                case 14: // Descontar Imposto
                    descontarImposto();
                    break;
                case 15:
                    carregarContasdoArquivo();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    // Métodos correspondentes às opções do menu

    public void inserirConta() {
        System.out.println("Cadastrar conta");
        System.out.print("Digite o número da conta: ");
        String number = scanner.next();
        System.out.print("Digite o saldo inicial: ");
        double saldo = scanner.nextDouble();
        System.out.print("Digite o id da conta: ");
        int id = scanner.nextInt();

        Conta conta = new Conta(number, saldo, id);
        banco.addConta(conta);
        System.out.println("Conta inserida com sucesso!");
    }

    public void consultarConta() {
        System.out.print("Digite o número da conta: ");
        String number = scanner.next();
        Conta conta = banco.getConta(number);
        if (conta != null) {
            System.out.println(conta);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void sacar() {
        System.out.print("Digite o número da conta: ");
        String number = scanner.next();
        System.out.print("Digite o valor do saque: ");
        double valor = scanner.nextDouble();

        Conta conta = banco.getConta(number);
        if (conta != null && conta.getSaldo() >= valor) {
            conta.sacar(valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou conta não encontrada.");
        }
    }

    public void depositar() {
        System.out.print("Digite o número da conta: ");
        String number = scanner.next();
        System.out.print("Digite o valor do depósito: ");
        double valor = scanner.nextDouble();

        Conta conta = banco.getConta(number);
        if (conta != null) {
            conta.depositar(valor);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void excluirConta() {
        System.out.print("Digite o número da conta: ");
        String number = scanner.next();

        if (banco.removerConta(number)) {
            System.out.println("Conta excluída com sucesso!");
        } else {
            System.out.println("Erro ao excluir conta.");
        }
    }

    public void transferir() {
        System.out.print("Digite o número da conta de origem: ");
        String origem = scanner.next();
        System.out.print("Digite o número da conta de destino: ");
        String destino = scanner.next();
        System.out.print("Digite o valor da transferência: ");
        double valor = scanner.nextDouble();

        Conta contaOrigem = banco.getConta(origem);
        Conta contaDestino = banco.getConta(destino);

        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.transferir(contaDestino, valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void totalizacao() {
        double totalSaldo = banco.totalizarSaldo();
        System.out.println("Saldo total das contas: R$ " + totalSaldo);
    }

    public void inserirCliente() {
        System.out.println("Cadastrar cliente");
        System.out.print("Digite o ID do cliente: ");
        int id = scanner.nextInt();
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.next();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.next();
        System.out.print("Digite a data de nascimento (YYYY-MM-DD): ");
        String dataNascimento = scanner.next();

        Cliente cliente = new Cliente(id, nome, cpf, LocalDate.parse(dataNascimento));
        banco.adicionarCliente(cliente);
        System.out.println("Cliente inserido com sucesso!");
    }

    public void consultarCliente() {
        System.out.print("Digite o ID do cliente: ");
        int id = scanner.nextInt();
        Cliente cliente = banco.buscarClientePorId(id);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void associarClienteConta() {
        System.out.print("Digite o ID do cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.next();

        Cliente cliente = banco.buscarClientePorId(idCliente);
        Conta conta = banco.getConta(numeroConta);

        if (cliente != null && conta != null) {
            conta.setCliente(cliente);
            cliente.getContas().add(conta);
            System.out.println("Cliente associado à conta com sucesso!");
        } else {
            System.out.println("Cliente ou conta não encontrados.");
        }
    }

    public void criarPoupanca() {
        System.out.print("Digite o número da poupança: ");
        String numero = scanner.next();
        System.out.print("Digite o saldo inicial: ");
        double saldo = scanner.nextDouble();
        System.out.print("Digite a taxa de juros (ex: 0.05 para 5%): ");
        double taxaJuros = scanner.nextDouble();

        banco.adicionarPoupanca(numero, saldo, taxaJuros);
    }

    public void renderJuros() {
        System.out.print("Digite o número da poupança: ");
        String numero = scanner.next();
        banco.renderJuros(numero);
    }

    // Criar ContaImposto
    public void criarContaImposto() {
        System.out.print("Digite o número da ContaImposto: ");
        String numero = scanner.next();
        System.out.print("Digite o saldo inicial: ");
        double saldo = scanner.nextDouble();
        System.out.print("Digite a taxa de imposto (ex: 0.02 para 2%): ");
        double taxaImposto = scanner.nextDouble();

        banco.adicionarContaImposto(numero, saldo, taxaImposto);
    }

    // Descontar Imposto
    public void descontarImposto() {
        System.out.print("Digite o número da ContaImposto: ");
        String numero = scanner.next();
        banco.descontarImposto(numero);
    }

    private void carregarContasdoArquivo() {
        System.out.print("Digite o caminho do arquivo: ");
        String caminhoArquivo = scanner.next();
        banco.carregarContasArquivo(caminhoArquivo);
    }

}
