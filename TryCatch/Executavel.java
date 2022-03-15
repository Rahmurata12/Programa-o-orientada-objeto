public class Executavel {

	public static void main(String[] args) {
		
		CDB cdb = new CDB();

		Cliente clienteRafael = new ClientePF("Rafael", "Avenida Paulista", "27/04/2003", 3886);
		ContaCorrente contaRafael = new ContaCorrente(clienteRafael, 1);

		contaRafael.depositar(10000);
		contaRafael.exibirSaldo();
		
		try {
			contaRafael.investir(cdb, 100);
		} catch (SaldoInsuficiente e) {
			e.printStackTrace();
		}
		
		contaRafael.exibirSaldo();
		
		try {
			contaRafael.sacar(1000000);
		} catch (SaldoInsuficiente e) {
			e.printStackTrace();
		}
	}
}
