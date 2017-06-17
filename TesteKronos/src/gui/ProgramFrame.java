package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ProgramFrame extends JFrame {
	private static final long serialVersionUID = -8697522131010814486L;
	private JPanel contentPane;
	private int privileges;
	private String title;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmSair;
	private JMenu mnEditar;
	private JMenuItem mntmContas;
	private JMenuItem mntmCursos;
	private JMenu mnAtualizar;
	private JMenuItem mntmParcelasdatas;
	private JPanel panel_4;
	private JLabel lblClculo;
	private JPanel panel;
	private JPanel panel_1;
	private JRadioButton rdbtnEnsino;
	private JRadioButton rdbtnNewRadioButton;
	private JPanel panel_2;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JPanel panel_3;
	private JRadioButton rdbtnIncioDeCurso;
	private JRadioButton rdbtnFimDeCurso;
	private JPanel panel_5;
	private JLabel lblNewLabel;
	
	public int getPrivileges() {
		return this.privileges;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramFrame frame = new ProgramFrame(3);
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
	public ProgramFrame(int privileges) {
		this.privileges = privileges;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		
		mntmSair = new JMenuItem("Sair");
		mnNewMenu.add(mntmSair);
		
		mnEditar = new JMenu("Gerenciar");
		menuBar.add(mnEditar);
		
		mntmContas = new JMenuItem("Contas");
		mnEditar.add(mntmContas);
		
		mntmCursos = new JMenuItem("Cursos");

		mnEditar.add(mntmCursos);
		
		mnAtualizar = new JMenu("Atualizar");
		menuBar.add(mnAtualizar);
		
		mntmParcelasdatas = new JMenuItem("Parcelas/Datas");
		mnAtualizar.add(mntmParcelasdatas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 15));
		
		panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.NORTH);
		
		lblClculo = new JLabel("C\u00E1lculo");
		lblClculo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_4.add(lblClculo);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(3, 1, 0, 25));
		
		panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Etapa"));
		//panel_1.setBorder(BorderFactory.createLineBorder(new Color(54)));
		
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdbtnEnsino = new JRadioButton("Ensino Infatil           ");
		panel_1.add(rdbtnEnsino);
		
		rdbtnNewRadioButton = new JRadioButton("Ensino Fundamental");
		panel_1.add(rdbtnNewRadioButton);
		
		panel_2 = new JPanel();
		//panel_2.setBorder(BorderFactory.createLineBorder(new Color(54)));
		panel_2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Taxa de Matrícula Paga?"));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		
		rdbtnNewRadioButton_1 = new JRadioButton("Sim                                  ");
		panel_2.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("N\u00E3o");
		panel_2.add(rdbtnNewRadioButton_2);
		
		panel_3 = new JPanel();
		panel_3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Data"));
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		
		rdbtnIncioDeCurso = new JRadioButton("In\u00EDcio de Curso");
		panel_3.add(rdbtnIncioDeCurso);
		
		rdbtnFimDeCurso = new JRadioButton("Fim de Curso    ");
		panel_3.add(rdbtnFimDeCurso);
		
		panel_5 = new JPanel();
		contentPane.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblNewLabel = new JLabel("Info");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(lblNewLabel);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		/* Diferença entre privilégios */
		title = "Kronos - Cálculo de ?(";
		switch(privileges) {
			case 1:
				title += "Funcionário";
				mntmCursos.setEnabled(false);
				mntmContas.setEnabled(false);
				mntmParcelasdatas.setEnabled(false);
				break;
			case 2:
				title += "Diretor";
				mntmContas.setEnabled(false);
				break;
			case 3:
				title += "ADMIN";
				break;
		}
		title += ")";
		setTitle(title);
	}
}
