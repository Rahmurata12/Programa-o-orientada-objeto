package checkpoint2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class CadastroAluno extends JFrame {
	
	private MaskFormatter ftmTelefone;
	private MaskFormatter ftmData;
	private MaskFormatter ftmRG;
	private MaskFormatter ftmCPF;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField dtNasc;
	private JTextField RG;
	private JTextField CPF;
	private JTextField tel;

	public static void main(String[] args) {
		
		String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
		
		try {
			UIManager.setLookAndFeel(str);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluno frame = new CadastroAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CadastroAluno() {
		
		try {
			ftmTelefone = new MaskFormatter("##-##-#####-####");
			ftmData = new MaskFormatter("##/##/####");
			ftmRG = new MaskFormatter("##.###.###-##");
			ftmCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
       
        
        ftmTelefone.setValidCharacters("0123456789");
        ftmData.setValidCharacters("0123456789");
   
        ftmTelefone.setValidCharacters("0123456789");
        ftmData.setValidCharacters("0123456789");
        
		Aluno Aluno = new Aluno();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setBounds(43, 47, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento: ");
		lblDataDeNascimento.setBounds(43, 85, 129, 14);
		contentPane.add(lblDataDeNascimento);

		JLabel lblRg = new JLabel("RG: ");
		lblRg.setBounds(43, 125, 32, 14);
		contentPane.add(lblRg);

		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(43, 166, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds(43, 208, 61, 14);
		contentPane.add(lblTelefone);

		nome = new JTextField();
		nome.setBounds(86, 40, 86, 24);
		contentPane.add(nome);
		nome.setColumns(10);

		dtNasc = new JFormattedTextField(ftmData);
		dtNasc.setColumns(10);
		dtNasc.setBounds(188, 78, 86, 28);
		contentPane.add(dtNasc);

		RG = new JFormattedTextField(ftmRG);
		RG.setColumns(10);
		RG.setBounds(85, 120, 125, 24);
		contentPane.add(RG);

		CPF = new JFormattedTextField(ftmCPF);
		CPF.setColumns(10);
		CPF.setBounds(86, 160, 124, 26);
		contentPane.add(CPF);

		tel = new JFormattedTextField(ftmTelefone);
		tel.setColumns(10);
		tel.setBounds(103, 202, 107, 26);
		contentPane.add(tel);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Aluno.setNome(nome.getText());
					Aluno.setDtNasc(dtNasc.getText());
					Aluno.setRG(RG.getText());
					Aluno.setCPF(CPF.getText());
					Aluno.setTel(tel.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					JOptionPane.showMessageDialog(null, "Sucesso!");
				}
				
				
			}
		});
		btnSalvar.setBounds(222, 169, 89, 37);
		contentPane.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(321, 169, 103, 37);
		contentPane.add(btnCancelar);

		JButton btnConversor = new JButton("Conversor");
		btnConversor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno.getNome();
				Aluno.getDtNasc();
				Aluno.getRG();
				Aluno.getCPF();
				Aluno.getTel();

				XStream xstream = new XStream(new DomDriver());
				System.out.println(xstream.toXML(Aluno));
				
				PrintWriter writer = null;
				
				try {
					writer = new PrintWriter(nome.getText());
					writer.print(xstream.toXML(Aluno));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					JOptionPane.showMessageDialog(null, "Arquivo Gerado com Sucesso!");
				}
				
				
				writer.close();
			}
		});
		btnConversor.setBounds(321, 102, 103, 37);
		contentPane.add(btnConversor);

	}
}