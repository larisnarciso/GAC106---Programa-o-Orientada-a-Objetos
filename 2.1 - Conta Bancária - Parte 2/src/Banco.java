import java.util.Scanner;
import java.util.ArrayList;

public class Banco {
  private Scanner entrada;
  private ArrayList<Conta> contas;

  public Banco() {
    contas = new ArrayList<>();
    entrada = new Scanner(System.in);
  }

  public void executarMenu() {
    int op;
    do {
      System.out.println("-- Menu Banco --");
      System.out.println("-- Digite uma opção --");
      exibeMenu();

      op = Integer.parseInt(entrada.nextLine());

      trataMenu(op);
    } while (op != 0);
  }

  public void exibeMenu() {
    System.out.println("1 - Criar Conta");
    System.out.println("2 - Criar Conta com deposito");
    System.out.println("3 - Consultar Saldo");
    System.out.println("4 - Depositar");
    System.out.println("5 - Sacar");
    System.out.println("6 - Transferir");
    System.out.println("7 - Lista Contas Criadas");
    System.out.println("8 - Remover Conta");
    System.out.println("0 - Sair");
  }

  private void trataMenu(int op) {
    switch (op) {
      case 0:
        System.out.println("-- Saindo --");
        break;

      case 1:
        criarConta();
        break;

      case 2:
        criarContaDeposito();
        break;

      case 3:
        consultarSaldo();
        break;

      case 4:
        depositarConta();
        break;

      case 5:
        saqueConta();
        break;

      case 6:
        transferirConta();
        break;

      case 7:
        listaConta();
        break;

      case 8:
        removerConta();
        break;

      default:
        System.out.println("-- Opção inválida --");
        break;
    }
  }

  private void listaConta() {
    for (int i = 0; i < contas.size(); i++) {
      System.out.println((i + 1) + " - Nome do cliente: " + contas.get(i).getCliente() + " - Número da conta: "
          + contas.get(i).getNumConta());
    }
  }

  private Cliente pedirCliente() {
    Cliente cliente;

    System.out.println("Nome do Cliente: ");
    String nomeCliente = entrada.nextLine();

    System.out.println("CPF do Cliente: ");
    String cpfCliente = entrada.nextLine();

    cliente = new Cliente(nomeCliente, cpfCliente);

    return cliente;
  }

  private Conta encontrarConta() {
    System.out.println("Número da Conta: ");
    int numeroConta = Integer.parseInt(entrada.nextLine());

    for (Conta conta : contas) {
      if (conta.getNumConta() == numeroConta) {
        return conta;
      }
    }
    System.out.println("Número da conta inválida ou não existe.");
    return null;
  }

  private void criarConta() {
    System.out.println("-- Criar Conta --");

    for (int i = 0; i < 2; i++) {
      System.out.println("-- Insira os dados --");

      Cliente cliente = pedirCliente();

      System.out.println("Limite: ");
      double limite = Double.parseDouble(entrada.nextLine());

      if (i == 0) {

        Conta conta = new Conta(limite, cliente);
        contas.add(conta);
        System.out.println("Número da conta: " + contas.get(contas.size() - 1).getNumConta());

      } else {

        System.out.println("-- Dados da segunda conta --");
        Conta conta = new Conta(limite, cliente);
        contas.add(conta);
        System.out.println("Número da conta: " + contas.get(contas.size() - 1).getNumConta());

      }
    }
    System.out.println("-- Contas criadas com sucesso!");
  }

  private void criarContaDeposito() {
    System.out.println("-- Criar Conta com Deposito Inicial --");

    for (int i = 0; i < 2; i++) {
      System.out.println("-- Insira os dados --");

      Cliente cliente = pedirCliente();

      System.out.println("Limite: ");
      double limite = Double.parseDouble(entrada.nextLine());

      System.out.println("Valor do deposito inicial: ");
      double saldo = Double.parseDouble(entrada.nextLine());

      if (i == 0) {
        Conta conta = new Conta(saldo, limite, cliente);
        contas.add(conta);
        System.out.println("Número da conta: " + contas.get(contas.size() - 1).getNumConta());

      } else {
        System.out.println("-- Dados da segunda conta --");
        Conta conta = new Conta(saldo, limite, cliente);
        contas.add(conta);
        System.out.println("Número da conta: " + contas.get(contas.size() - 1).getNumConta());

      }
    }

    System.out.println("-- Contas criadas com sucesso!");
  }

  private void consultarSaldo() {

    System.out.println("-- Consultar Saldo --");

    Conta conta = encontrarConta();
    if (conta != null) {
      System.out.println("Cliente: " + conta.getCliente());
      System.out.println("Saldo: " + conta.getSaldo());
      if (conta.getSaldo() < 0) {
        System.out.println("Conta está utilizando o limite especial");
      }
    }
  }

  private void depositarConta() {
    System.out.println("-- Deposito --");

    Conta conta = encontrarConta();

    if (conta != null) {
      System.out.println("Valor: ");
      double valorDeposito = Double.parseDouble(entrada.nextLine());
      conta.deposito(valorDeposito);
      System.out.println("-- Valor depositado com sucesso--");
    }
  }

  private void saqueConta() {
    System.out.println("-- Sacar --");

    Conta conta = encontrarConta();

    if (conta != null) {
      System.out.println("Valor: ");
      double valorSaque = Double.parseDouble(entrada.nextLine());
      boolean sucesso;

      sucesso = conta.saque(valorSaque);

      if (sucesso) {
        System.out.println("Valor sacado com sucesso!");
      } else {
        System.out.println("Erro! O valor é maior que o saldo!");
      }
    }
  }

  private void transferirConta() {
    System.out.println("-- Transferir --");

    System.out.println("-- Origem --");
    Conta contaOrigem = encontrarConta();

    if (contaOrigem != null) {
      Conta contaDestino = encontrarConta();
      System.out.println("-- Destino --");

      if (contaDestino != null) {
        System.out.println("Valor: ");
        double valor = Double.parseDouble(entrada.nextLine());
        contaOrigem.transferencia(valor, contaDestino);
      }
    }
  }

  private void removerConta() {
    System.out.println("-- Remover Conta --");

    Conta conta = encontrarConta();

    if (conta != null) {
      if (conta.getSaldo() > 0) {
        System.out.println("Erro! A conta possui saldo de " + conta.getSaldo()
            + " , não sendo possível cancelar contas com saldo disponível");
      } else if (conta.getSaldo() < 0) {
        System.out.println("Erro! A conta possui saldo negativo de " + conta.getSaldo()
            + " , não sendo possível cancelar contas em débito");
      } else {
        contas.remove(conta);
        System.out.println("Conta de número " + conta.getNumConta() + " removido.");
      }
    }
  }
}