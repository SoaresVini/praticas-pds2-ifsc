package ex9;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class atvd8 extends JFrame {

	private JPanel contentPane;
	private JTextField edMatricula;
	private JTextField edNome;
	private JTextField edIdade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atvd8 frame = new atvd8();
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
	public atvd8() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btCad = new JButton("Cadastro");
		btCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+ "aluno" + "?serverTimezone=UTC", "root", "aluno");
					
					String wSQL = "INSERT INTO (`mataricula`,`nome_aluno`,`idade_aluno`)VALUES(?,?,?);"; 
					PreparedStatement  stm = conexao.prepareStatement(wSQL);

					stm.setInt(1, Integer.valueOf(edMatricula.getText()));
					stm.setString(2,edNome.getText());
					stm.setInt(3, Integer.valueOf(edIdade.getText()));
					
					stm.executeUpdate();
					
					stm.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		btCad.setBounds(166, 137, 89, 23);
		contentPane.add(btCad);
		
		edMatricula = new JTextField();
		edMatricula.setBounds(155, 27, 173, 20);
		contentPane.add(edMatricula);
		edMatricula.setColumns(10);
		
		edNome = new JTextField();
		edNome.setColumns(10);
		edNome.setBounds(155, 58, 173, 20);
		contentPane.add(edNome);
		
		edIdade = new JTextField();
		edIdade.setColumns(10);
		edIdade.setBounds(155, 89, 173, 20);
		contentPane.add(edIdade);
		
		JLabel lbMatricula = new JLabel("Matricula: ");
		lbMatricula.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMatricula.setBounds(70, 30, 75, 14);
		contentPane.add(lbMatricula);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNome.setBounds(84, 61, 46, 14);
		contentPane.add(lbNome);
		
		JLabel lbIdade = new JLabel("Idade:");
		lbIdade.setHorizontalAlignment(SwingConstants.RIGHT);
		lbIdade.setBounds(84, 92, 46, 14);
		contentPane.add(lbIdade);
	}
}
