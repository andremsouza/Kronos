package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class LoignGUI {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoignGUI window = new LoignGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoignGUI() {
		initialize();
	}
	
	public int ftteste(String us, String pw) {
		String us1 = "vitor";
		String pw1 = "9791285";
		if(us.compareTo(us1) == 0 && pw.compareTo(pw1) == 0) return 3;
		return -1;
	}

	private void initialize() {
		frame = new JFrame("Kronos");
		frame.setResizable(false);
		frame.setBounds(100, 100, 405, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblLogin.setBounds(155, 30, 95, 50);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsurio.setBounds(102, 120, 79, 30);
		frame.getContentPane().add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(102, 190, 79, 30);
		frame.getContentPane().add(lblSenha);
		
		username = new JTextField();
		username.setBounds(102, 155, 200, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(102, 225, 200, 20);
		frame.getContentPane().add(password);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = username.getText();
				String pw = String.valueOf(password.getPassword());
				int privileges = ftteste(un, pw);
				if(privileges == -1) JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
				else {
					frame.dispose();
					ProgramFrame pf = new ProgramFrame(privileges);
					pf.setVisible(true);
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEntrar.setBounds(142, 280, 120, 30);
		frame.getContentPane().add(btnEntrar);
	}

}
