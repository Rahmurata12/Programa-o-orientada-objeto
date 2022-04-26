package modal;

import java.sql.Date;
import java.util.Calendar;

public class usuario {

	private long id;
	private String nome;
	private String  email;
	private int  telefone;
	private Date data;
	
	

	public usuario(long id, String nome, String email, int telefone, Date data) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.data = new Date(Calendar.getInstance().getTimeInMillis());
	}
	public usuario() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int i) {
		this.telefone = i;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
