package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import funcionario.Admin;

public class LoginGUI extends JFrame {
	private static final long serialVersionUID = -1330368441037488617L;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JLabel lblLogin;
	private JLabel lblUsurio;

	private JLabel lblSenha;
	private JTextField username;

	private JPasswordField password;
	private JPanel panel;
	private JPanel panelUsername;
	private JPanel panelPw;

	private JPanel panelButton;
	private FlowLayout flowLayoutUsername;

	private FlowLayout flowLayoutPw;

	private JButton btnEntrar;

	public LoginGUI() {
		initialize();
	}

	private void initialize() {

		/* Inicializa as JLabel */
		lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));

		lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setHorizontalAlignment(SwingConstants.LEADING);
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.LEADING);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));

		/* Inicializa as JTextField */
		username = new JTextField();
		username.setColumns(20);

		password = new JPasswordField();
		password.setColumns(20);

		/* Inicializa JButton */
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int privileges;
				Admin adm = new Admin(username.getText(), String.valueOf(password.getPassword()));
				privileges = adm.validaUsuario(username.getText(), String.valueOf(password.getPassword()));
				if (privileges == -1) {
					JOptionPane.showMessageDialog(null, "Usu�rio/senha incorreto", "Erro", JOptionPane.ERROR_MESSAGE);
				} else {
					dispose();
					MainGUI pf = new MainGUI(privileges);
					pf.setVisible(true);
				}
			}
		});

		/* Inicializa os JPanel */
		panel = new JPanel();
		panelUsername = new JPanel();
		panelPw = new JPanel();
		panelButton = new JPanel();

		/*
		 * panel: panelUsername panelPw
		 */

		/* panelUsername */
		flowLayoutUsername = (FlowLayout) panelUsername.getLayout();
		flowLayoutUsername.setAlignment(FlowLayout.LEADING);
		panelUsername.add(lblUsurio);
		panelUsername.add(username);

		/* panelPw */
		flowLayoutPw = (FlowLayout) panelPw.getLayout();
		flowLayoutPw.setAlignment(FlowLayout.LEADING);
		panelPw.add(lblSenha);
		panelPw.add(password);

		/* panel */
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		panel.add(panelUsername);
		panel.add(panelPw);
		panelButton.add(btnEntrar);

		/* Inicializa o Frame */
		this.setTitle("Kronos");
		this.setResizable(false);
		this.setBounds(100, 100, 240, 280);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// coloca BorderLayout no ContentPane
		this.getContentPane().setLayout(new BorderLayout(0, 25));

		/*
		 * ContentPane: North - lblLogin Center - panel South - panelButton(para
		 * o button)
		 */
		this.getContentPane().add(lblLogin, BorderLayout.NORTH);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.getContentPane().add(panelButton, BorderLayout.SOUTH);

		this.getRootPane().setDefaultButton(btnEntrar);

	}

}
