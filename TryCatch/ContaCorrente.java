public final class ContaCorrente extends Conta {

	private double saldoInvestimento;

	public ContaCorrente(Cliente cliente, long numeroConta) {
		super(cliente, numeroConta);
	}

	// design pattern Strategy
	public void investir(Produto produto, double valor) throws SaldoInsuficiente {
		boolean teste = true;
		teste = this.sacar(valor);
		if (teste == true) {
			this.saldoInvestimento += produto.investir(valor);
		}
	}

	public void resgatar(double valor) throws SaldoInsuficiente {
		if (this.saldoInvestimento >= valor) {
			this.saldoInvestimento -= valor;
			this.depositar(valor);
		} else {
			throw new SaldoInsuficiente("Saldo de investimento insuficiente");
		}
	}

	@Override
	public void exibirSaldo() {
		double saldoTotal = this.saldo + this.saldoInvestimento;
		System.out.println("Cliente: " + this.cliente.getNome());
		System.out.println("Saldo conta corrente: R$ " + this.saldo);
		System.out.println("Saldo investimento: R$ " + this.saldoInvestimento);
		System.out.println("Saldo total: R$ " + saldoTotal + "\n");
	}
}
