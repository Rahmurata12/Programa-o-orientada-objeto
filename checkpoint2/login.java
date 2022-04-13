package checkpoint2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;
	private int contador = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
			
		try {
			UIManager.setLookAndFeel(str);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Iniciar Sess\u00E3o");
		lblNewLabel.setBounds(27, 24, 111, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Logo");
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setBounds(51, 52, 104, 54);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario");
		lblNewLabel_3.setBounds(61, 144, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Senha");
		lblNewLabel_3_1.setBounds(61, 181, 46, 14);
		contentPane.add(lblNewLabel_3_1);
		
		user = new JTextField();
		user.setBounds(117, 141, 139, 25);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(117, 178, 139, 25);
		contentPane.add(pass);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					contador++;
					if (user.getText().equals("ROOT") && pass.getText().equals("ROOT")) {
						JOptionPane.showMessageDialog(null, "Suceffuly!");
					} else {
						JOptionPane.showMessageDialog(null, "Senha ou usuário incorreto");
						if (contador == 3) {
							JOptionPane.showMessageDialog(null, "ERRO", "Warning",
							        JOptionPane.WARNING_MESSAGE);
							System.exit(0);
						}
					}
			}
		});
		btnEntrar.setBounds(57, 220, 98, 23);
		contentPane.add(btnEntrar);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(167, 220, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnNewPass = new JButton("<html><u>Esqueci minha senha</u></html>");
		btnNewPass.setContentAreaFilled(false);
		
		btnNewPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog("Digite seu Email");
			}
		});
		btnNewPass.setBounds(73, 274, 161, 23);
		contentPane.add(btnNewPass);
		
		JButton btnNewUser = new JButton("<html><u>Novo usuário</u></html>");
		btnNewUser.setContentAreaFilled(false);
		
		btnNewUser.setBounds(152, 50, 104, 28);
		contentPane.add(btnNewUser);
	}
}
