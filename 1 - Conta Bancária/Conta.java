public class Conta {
  private double saldo = 0;
  private double limite = 0;
  private Cliente cliente;
  private int numConta;
  private static int numContaAnterior = 1000;

  public Conta(double limite, Cliente cliente) {
    this(0, limite, cliente);
  }

  public Conta(double saldo, double limite, Cliente cliente) {
    this.saldo = saldo;
    this.limite = limite;
    this.cliente = cliente;

    numContaAnterior++;
    this.numConta = numContaAnterior;
  }

  public double getSaldo() {
    return saldo;
  }

  public String getCliente() {
    return cliente.getNome();
  }

  public int getNumConta() {
    return numConta;
  }

  public boolean saque(double valorSaque) {
    if (saldo + limite >= valorSaque) {
      saldo -= valorSaque;
      return true;
    } else {
      return false;
    }
  }

  public void deposito(double valorDeposito) {
    saldo += valorDeposito;
  }

  public void transferencia(double valorTransferencia, Conta contaDestino) {
    boolean saque;
    saque = this.saque(valorTransferencia);
    if (saque == true) {
      contaDestino.deposito(valorTransferencia);
    }
  }
}