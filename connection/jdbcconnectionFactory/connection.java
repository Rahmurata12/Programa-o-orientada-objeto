package jdbcconnectionFactory;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class connection {
	
	private String schema = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private String user = JOptionPane.showInputDialog("Digite Usuário: ");
	private String  pass = JOptionPane.showInputDialog("Digite senha: ");
	
	public java.sql.Connection conectar() {
		
		try {
			return DriverManager.getConnection(schema,user,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
