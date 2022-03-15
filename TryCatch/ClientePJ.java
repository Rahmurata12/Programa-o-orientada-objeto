public final class ClientePJ extends Cliente {

	private final long CNPJ;
	private final String razaoSocial;

	public ClientePJ(String nome, String razaoSocial, String endereco, String dataNasc, long cnpj) {
		super(nome, endereco, dataNasc);
		this.razaoSocial = razaoSocial;
		this.CNPJ = cnpj;
	}

	public long getCnpj() {
		return CNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}
}
