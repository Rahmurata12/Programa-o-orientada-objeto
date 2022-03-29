import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface {

	public static void main(String[] args) {
		
		JFrame janela = new JFrame("Interface");
		JPanel tela = new JPanel();
		JButton btnSair = new JButton("Sair"); 
		JLabel label = new JLabel("Primeiro Label");	
		
		janela.setSize(500, 500);
		btnSair.setSize(40, 40);
		label.setSize(50, 100);
		
		btnSair.setBackground(Color.red);
		tela.add(label);
		janela.add(tela);
		tela.add(btnSair);
		
		janela.setVisible(true);
	}

}
