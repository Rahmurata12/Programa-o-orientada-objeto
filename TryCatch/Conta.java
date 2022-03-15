//superclass
public abstract class Conta { 

	//atributos
	protected final Cliente cliente; //composição 
	protected final long numeroConta;
	protected double saldo;
	private static long contador; // transforma a variável como sendo da Classe e não do objeto

	
	public static void exibirContador() {
		System.out.println("Contas: " + contador);
	}

	public Conta(Cliente cliente, long numeroConta) {
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		contador++;
	}

	public boolean sacar(double valor) throws SaldoInsuficiente{
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		} else {
			throw new SaldoInsuficiente("Saldo Insuficiente");
		}
	}

	public void depositar(double valor) {
		this.saldo += valor;
		System.out.println("Operação realizada");
	}

	public void transferir(double valor, Conta conta) throws SaldoInsuficiente {
		boolean teste = this.sacar(valor);
		if (teste == true) {
			conta.depositar(valor);
		}
	}

	public abstract void exibirSaldo(); // abstract no método força a reescrita.
}
