import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Tela {

	public static void main(String[] args) {

		JFrame tela = new JFrame("Tela Login");
		JPanel painel1 = new JPanel();
		JPanel painel2 = new JPanel();
		JPanel painel3 = new JPanel();
		JButton btnEnviar = new JButton("Enviar");
		JButton btnSair = new JButton("Sair");
		JLabel labelLogin = new JLabel("Login ");
		JLabel labelSenha = new JLabel("Senha ");
		JTextField campoLogin = new JTextField(20);
		JPasswordField campoSenha = new JPasswordField(20);


		tela.getContentPane().setLayout(new BorderLayout());
		tela.getContentPane().add(painel1, BorderLayout.NORTH);
		tela.getContentPane().add(painel2, BorderLayout.SOUTH);
		tela.getContentPane().add(painel3, BorderLayout.CENTER);

		painel1.setBackground(Color.green);
		painel1.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		painel2.setBackground(Color.YELLOW);
		painel3.setBackground(Color.PINK);
		
		painel3.add(labelLogin);
		painel3.add(campoLogin);
		painel3.add(labelSenha);
		painel3.add(campoSenha);
		painel2.add(btnEnviar);
		painel2.add(btnSair);

		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.pack();
		tela.setSize(700, 700);
		tela.setVisible(true);

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Login = campoLogin.getText();
				@SuppressWarnings("deprecation")
				String Senha = campoSenha.getText();
				System.out.println(Login);
				System.out.print(Senha);
				JOptionPane.showMessageDialog(null, "Login: " + Login + " Senha: " + Senha);
			}
		});
	}
}
