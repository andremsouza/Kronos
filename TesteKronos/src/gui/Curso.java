package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.Frame;
import java.awt.event.WindowStateListener;

public class Curso extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblAdicionarConta;
	private JPanel panel_5;
	private JButton btnNewButton;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblNomeDeUsurio;
	private JTextField textField;
	private JLabel lblSenha;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JLabel lblNewLabel_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_3;
	private JPanel panel_12;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JButton btnEditar;
	private JButton btnRemover;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_14;
	private String title;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Curso frame = new Curso(3);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void resizeTextFields() {
		Rectangle frameRect;
		int columns;
		
		frameRect = getBounds();
		
		if((int)frameRect.getWidth() >= 1100) columns = 20;
		else if((int)frameRect.getWidth() >= 770) columns = 20 - ((1100 - (int)frameRect.getWidth()) / 33) - 1;
		else columns = 20;
		
		
		textField.setColumns(columns);
		textField_1.setColumns(columns);
		textField_2.setColumns(columns);
		textField_3.setColumns(columns);
		textField_4.setColumns(columns);
	}
	
	/**
	 * Create the frame.
	 */
	public Curso(int privileges) {
		addWindowStateListener(new WindowStateListener() {
		   public void windowStateChanged(WindowEvent e) {
			   resizeTextFields();
		   }
		});
		
		addComponentListener(new ComponentListener() {
			@Override
			public void componentHidden(ComponentEvent e) {}

			@Override
			public void componentMoved(ComponentEvent e) {}

			@Override
			public void componentShown(ComponentEvent e) {}
			
			@Override
			public void componentResized(ComponentEvent e) {
				resizeTextFields();
			}

		});
		int nCursos = 5;
		
		setMinimumSize(new Dimension(770, 325 + 16  * nCursos));
		//setTitle("Kronos - Gerenciamento de Contas(ADMIN)");
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 40));
		setContentPane(contentPane);

		String[] column_headers = {"Curso", "Valor(R$)"};
		String[][] user = {{"hacking", "1000000000000,00"}, {"cracking", "99999999999,00"}, {"debugging", "inf"}, {"", ""}, {"", ""}};
		
		panel_14 = new JPanel();
		
		contentPane.add(panel_14, BorderLayout.NORTH);
		panel_14.setLayout(new BorderLayout(0, 10));
		
		lblNewLabel_7 = new JLabel("Ger\u00EAncia de Cursos");
		panel_14.add(lblNewLabel_7, BorderLayout.NORTH);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		panel_1 = new JPanel();
		panel_14.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 3, 25, 0));
		
		panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 15));
		
		lblAdicionarConta = new JLabel("Adicionar Curso");
		lblAdicionarConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblAdicionarConta, BorderLayout.NORTH);
		
		panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(2, 1, 0, 0));
		
		panel_6 = new JPanel();
		panel_5.add(panel_6);
		
		lblNomeDeUsurio = new JLabel("Curso: ");
		panel_6.add(lblNomeDeUsurio);
		
		textField = new JTextField();
		panel_6.add(textField);
		textField.setColumns(20);
		
		panel_7 = new JPanel();
		panel_5.add(panel_7);
		
		lblSenha = new JLabel("Valor:  ");
		panel_7.add(lblSenha);
		
		textField_1 = new JTextField();
		panel_7.add(textField_1);
		textField_1.setColumns(20);
		
		btnNewButton = new JButton("Adicionar");
		panel_2.add(btnNewButton, BorderLayout.SOUTH);
		
		panel_3 = new JPanel();
		panel_3.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 15));
		
		lblNewLabel = new JLabel("Editar Curso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel, BorderLayout.NORTH);
		
		panel_8 = new JPanel();
		panel_3.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new GridLayout(2, 1, 0, 0));
		
		panel_9 = new JPanel();
		panel_8.add(panel_9);
		
		lblNewLabel_1 = new JLabel("Curso:          ");
		panel_9.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		panel_9.add(textField_2);
		textField_2.setColumns(20);
		
		panel_10 = new JPanel();
		panel_8.add(panel_10);
		
		lblNewLabel_2 = new JLabel("Novo Valor: ");
		panel_10.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		panel_10.add(textField_3);
		textField_3.setColumns(20);
		
		btnEditar = new JButton("Editar");
		panel_3.add(btnEditar, BorderLayout.SOUTH);
		
		panel_4 = new JPanel();
		panel_4.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 15));
		
		lblNewLabel_3 = new JLabel("Remover Curso");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
		panel_12 = new JPanel();
		panel_4.add(panel_12, BorderLayout.CENTER);
		
		lblNewLabel_4 = new JLabel("Curso: ");
		panel_12.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		panel_12.add(textField_4);
		textField_4.setColumns(20);
		
		btnRemover = new JButton("Remover");
		panel_4.add(btnRemover, BorderLayout.SOUTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 10));
		
		lblNewLabel_6 = new JLabel("Tabela de Cursos");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_6, BorderLayout.NORTH);
		
		table = new JTable(user, column_headers);
		table.setAutoCreateRowSorter(true);
		table.setEnabled(false);
		panel.add(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		/* Diferença entre privilégios */
		title = "Kronos - Gerenciamento de Cursos(";
		switch(privileges) {
			case 2:	title += "Diretor";	break;
			case 3:	title += "ADMIN";	break;
		}
		title += ")";
		setTitle(title);
		
	}
	

}
