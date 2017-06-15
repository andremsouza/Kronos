package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ProgramFrame extends JFrame {

	private JPanel contentPane;
	private int privileges;
	private String title;
	
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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnNewMenu.add(mntmSair);
		
		JMenu mnEditar = new JMenu("Gerenciar");
		menuBar.add(mnEditar);
		
		JMenuItem mntmContas = new JMenuItem("Contas");
		mnEditar.add(mntmContas);
		
		JMenuItem mntmCursos = new JMenuItem("Cursos");

		mnEditar.add(mntmCursos);
		
		JMenu mnAtualizar = new JMenu("Atualizar");
		menuBar.add(mnAtualizar);
		
		JMenuItem mntmParcelasdatas = new JMenuItem("Parcelas/Datas");
		mnAtualizar.add(mntmParcelasdatas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 15));
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblClculo = new JLabel("C\u00E1lculo");
		lblClculo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_4.add(lblClculo);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(3, 1, 0, 25));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Etapa"));
		//panel_1.setBorder(BorderFactory.createLineBorder(new Color(54)));
		
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton rdbtnEnsino = new JRadioButton("Ensino Infatil           ");
		panel_1.add(rdbtnEnsino);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Ensino Fundamental");
		panel_1.add(rdbtnNewRadioButton);
		
		JPanel panel_2 = new JPanel();
		//panel_2.setBorder(BorderFactory.createLineBorder(new Color(54)));
		panel_2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Taxa de Matrícula Paga?"));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Sim                                  ");
		panel_2.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("N\u00E3o");
		panel_2.add(rdbtnNewRadioButton_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Data"));
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		
		JRadioButton rdbtnIncioDeCurso = new JRadioButton("In\u00EDcio de Curso");
		panel_3.add(rdbtnIncioDeCurso);
		
		JRadioButton rdbtnFimDeCurso = new JRadioButton("Fim de Curso    ");
		panel_3.add(rdbtnFimDeCurso);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Info");
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
