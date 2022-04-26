package teste;
import java.sql.SQLException;

import modal.usuario;
import repository.UsuarioDAO;

public class teste {

	public static void main(String[] args) {
		
		usuario usuario = new usuario();
		UsuarioDAO dao = new UsuarioDAO();
		
		usuario.setId(1L);
		usuario.setNome("Carlos");
		usuario.setEmail("Email@fiap");
		usuario.setTelefone(971724122);
		
		try {
			dao.insert(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
