import java.util.Scanner;

public class Banco {
  private Conta conta1;
  private Conta conta2;
  private Scanner entrada;

  public Banco() {
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

      default:
        System.out.println("-- Opção inválida --");
        break;
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

  private int encontrarConta() {
    System.out.println("Número da Conta: ");
    int numeroConta = Integer.parseInt(entrada.nextLine());

    if (numeroConta == conta1.getNumConta()) {
      return 1;
    } else if (numeroConta == conta2.getNumConta()) {
      return 2;
    } else {
      System.out.println("Número de conta não encontrado");
      return -1;
    }
  }

  private void criarConta() {
    System.out.println("-- Criar Conta --");

    for (int i = 0; i < 2; i++) {
      System.out.println("-- Insira os dados --");

      Cliente cliente = pedirCliente();

      System.out.println("Limite: ");
      double limite = Double.parseDouble(entrada.nextLine());

      if (i == 0) {
        conta1 = new Conta(limite, cliente);
      } else {
        System.out.println("-- Dados da segunda conta --");

        conta2 = new Conta(limite, cliente);
      }
    }

    System.out.println("Número da 1ª conta: " + conta1.getNumConta());
    System.out.println("Número da 2ª conta: " + conta2.getNumConta());
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
        conta1 = new Conta(saldo, limite, cliente);
      } else {
        System.out.println("-- Dados da segunda conta --");

        conta2 = new Conta(saldo, limite, cliente);
      }
    }

    System.out.println("Número da 1ª conta: " + conta1.getNumConta());
    System.out.println("Número da 2ª conta: " + conta2.getNumConta());
    System.out.println("-- Contas criadas com sucesso!");
  }

  private void consultarSaldo() {
    System.out.println("-- Consultar Saldo --");

    int conta = encontrarConta();
    if (conta == 1) {
      System.out.println("Cliente: " + conta1.getCliente());
      System.out.println("Saldo: " + conta1.getSaldo());
      System.out.println("Conta está utilizando o limite especial");
    } else {
      System.out.println("Cliente: " + conta2.getCliente());
      System.out.println("Saldo: " + conta2.getSaldo());
      if (conta2.getSaldo() < 0) {
        System.out.println("Conta está utilizando o limite especial");
      }
    }
  }

  private void depositarConta() {
    System.out.println("-- Deposito --");

    int conta = encontrarConta();

    if (conta > 0) {
      System.out.println("Valor: ");
      double valorDeposito = Integer.parseInt(entrada.nextLine());

      if (conta == 1) {
        conta1.deposito(valorDeposito);
        System.out.println("-- Valor depositado com sucesso--");
      } else {
        conta2.deposito(valorDeposito);
        System.out.println("-- Valor depositado com sucesso--");
      }
    }
  }

  private void saqueConta() {
    System.out.println("-- Sacar --");

    int conta = encontrarConta();

    if (conta > 0) {
      System.out.println("Valor: ");
      double valorSaque = Integer.parseInt(entrada.nextLine());

      boolean sucesso;
      if (conta == 1) {
        sucesso = conta1.saque(valorSaque);
      } else {
        sucesso = conta2.saque(valorSaque);
      }

      if (sucesso == true) {
        System.out.println("Valor sacado com sucesso!");
      } else {
        System.out.println("Erro! O valor é maior que o saldo!");
      }
    }
  }

  private void transferirConta() {
    System.out.println("-- Transferir --");

    System.out.print("Origem: ");
    int contaOrigem = encontrarConta();

    if (contaOrigem > 0) {
      System.out.print("Destino: ");
      int contaDestino = encontrarConta();

      if (contaDestino > 0) {
        System.out.println("Valor: ");
        double valor = Integer.parseInt(entrada.nextLine());

        if (contaOrigem == 1) {
          conta1.transferencia(valor, conta2);
        } else {
          conta2.transferencia(valor, conta1);
        }
      }
    }
  }
}
