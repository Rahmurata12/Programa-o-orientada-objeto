package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbcconnectionFactory.connection;
import modal.usuario;

public class UsuarioDAO {

	private Connection conexao;

	public UsuarioDAO() {

		this.conexao = new connection().conectar();
	}

	public void insert(usuario usuario) throws SQLException {

		String sql = "insert into usuarios(id, nome, email, telefone, data) values (?,?,?,?,?)";

		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setLong(1, usuario.getId());
		stmt.setString(2, usuario.getNome());
		stmt.setString(3, usuario.getEmail());
		stmt.setInt(4, usuario.getTelefone());
		stmt.setDate(5, usuario.getData());

		stmt.execute();
		stmt.close();
	}

	public ArrayList<usuario> select() throws SQLException {

		ArrayList<usuario> usuarios = new ArrayList<usuario>();
		
		String sql = "select * from usuarios order by nome";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();	
		
		while(rs.next()) {
			
			usuario usuario = new usuario();
			
			usuario.setId(rs.getLong("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setEmail(rs.getString("email"));
			usuario.setTelefone(rs.getInt("telefone"));
			usuario.setData(rs.getDate("data"));
		}
		return usuarios;
		
	}
}
