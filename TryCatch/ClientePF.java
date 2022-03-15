public final class ClientePF extends Cliente {  //final pro�be a heran�a desta classe

	private final long CPF; 
	

	public ClientePF(String nome, String endereco, String dataNasc, long cpf) {
		super(nome, endereco, dataNasc);
		this.CPF = cpf;
	}

	public long getCpf() {
		return CPF;
	}
	
}
