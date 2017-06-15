package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.FocusListener;

public class Atualizar extends JFrame {

	private JPanel contentPane;
	private String title;
	private JTextField txtDdmmaaaa;
	private JTextField txtDdmmaaaa_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private int valor = 2000;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atualizar frame = new Atualizar(2);
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
	public Atualizar(int privilegios) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		

		JPanel panel_28 = new JPanel();
		contentPane.add(panel_28, BorderLayout.CENTER);
		panel_28.setLayout(new BorderLayout(0, 20));
		
		JScrollPane scrollPane = new JScrollPane(panel_28);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		
		JPanel panel = new JPanel();
		panel_28.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 15));
		
		JLabel lblDatas = new JLabel("Datas");
		lblDatas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatas.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel.add(lblDatas, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(1, 2, 20, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 5));
		
		JLabel lblIncioDeCurso = new JLabel("In\u00EDcio das Aulas");
		lblIncioDeCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIncioDeCurso.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblIncioDeCurso, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		panel_6.add(panel_5);
		String dia = "15", mes = "06", ano = "2017";
		JLabel lblAtual = new JLabel("Atual:       " + dia + "/" + mes + "/" + ano);
		panel_5.add(lblAtual);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel_6.add(panel_7);
		
		JLabel lblNova = new JLabel("Novo: ");
		panel_7.add(lblNova);
		
		txtDdmmaaaa = new HintTextField("dd/mm/aaaa");
		//txtDdmmaaaa.setText("dd/mm/aaaa");
		panel_7.add(txtDdmmaaaa);
		txtDdmmaaaa.setColumns(10);
		
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 5));
		
		JLabel lblFimDeCurso = new JLabel("Fim das Aulas");
		lblFimDeCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFimDeCurso.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblFimDeCurso, BorderLayout.NORTH);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_9.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEADING);
		panel_8.add(panel_9);
		dia = "26";
		JLabel label_1 = new JLabel("Atual:       " + dia + "/" + mes + "/" + ano);
		panel_9.add(label_1);
		
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_10.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEADING);
		panel_8.add(panel_10);
		
		JLabel label_2 = new JLabel("Novo: ");
		panel_10.add(label_2);
		
		txtDdmmaaaa_1 = new HintTextField("dd/mm/aaaa");
		//txtDdmmaaaa_1.setText("dd/mm/aaaa");
		txtDdmmaaaa_1.setColumns(10);
		panel_10.add(txtDdmmaaaa_1);
		
		JPanel panel_1 = new JPanel();
		panel_28.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 15));
		
		JLabel lblNewLabel = new JLabel("Valores");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11, BorderLayout.SOUTH);
		panel_11.setLayout(new GridLayout(4, 0, 0, 30));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_11.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 5));
		
		JLabel lblTaxaDeMatrcula = new JLabel("Taxa de Matr\u00EDcula(Infantil)");
		panel_12.add(lblTaxaDeMatrcula, BorderLayout.NORTH);
		
		JPanel panel_16 = new JPanel();
		panel_12.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_17 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_17.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEADING);
		panel_16.add(panel_17);
		
		JLabel lblAtual_1 = new JLabel("Atual: R$" + valor + ",00");
		panel_17.add(lblAtual_1);
		
		JPanel panel_18 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_18.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEADING);
		panel_16.add(panel_18);
		
		JLabel lblNovo = new JLabel("Novo: ");
		panel_18.add(lblNovo);
		
		textField_2 = new HintTextField("xxxx,yy");
		panel_18.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_11.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Taxa de Matr\u00EDcula(Fundamental)");
		panel_13.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel panel_19 = new JPanel();
		panel_13.add(panel_19, BorderLayout.SOUTH);
		panel_19.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_20 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_20.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEADING);
		panel_19.add(panel_20);
		
		JLabel label = new JLabel("Atual: R$" + valor + ",00");
		panel_20.add(label);
		
		JPanel panel_21 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_21.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEADING);
		panel_19.add(panel_21);
		
		JLabel label_3 = new JLabel("Novo: ");
		panel_21.add(label_3);
		
		textField_3 = new HintTextField("xxxx,yy");
		textField_3.setColumns(10);
		panel_21.add(textField_3);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_11.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Parcela(Infantil)");
		panel_14.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JPanel panel_22 = new JPanel();
		panel_14.add(panel_22, BorderLayout.SOUTH);
		panel_22.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_23 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_23.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEADING);
		panel_22.add(panel_23);
		
		JLabel label_4 = new JLabel("Atual: R$" + valor + ",00");
		panel_23.add(label_4);
		
		JPanel panel_24 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_24.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEADING);
		panel_22.add(panel_24);
		
		JLabel label_5 = new JLabel("Novo: ");
		panel_24.add(label_5);
		
		textField_4 = new HintTextField("xxxx,yy");
		textField_4.setColumns(10);
		panel_24.add(textField_4);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_11.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 5));
		
		JLabel lblNewLabel_3 = new JLabel("Parcela(Fundamental)");
		panel_15.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_25 = new JPanel();
		panel_15.add(panel_25, BorderLayout.SOUTH);
		panel_25.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_26 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel_26.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEADING);
		panel_25.add(panel_26);
		
		JLabel label_6 = new JLabel("Atual: R$" + valor + ",00");
		panel_26.add(label_6);
		
		JPanel panel_27 = new JPanel();
		FlowLayout flowLayout_11 = (FlowLayout) panel_27.getLayout();
		flowLayout_11.setAlignment(FlowLayout.LEADING);
		panel_25.add(panel_27);
		
		JLabel label_7 = new JLabel("Novo: ");
		panel_27.add(label_7);
		
		textField_5 = new HintTextField("xxxx,yy");
		textField_5.setColumns(10);
		panel_27.add(textField_5);
		
		JButton btnAtualizar = new JButton("Atualizar");
		panel_28.add(btnAtualizar, BorderLayout.SOUTH);
		
		
		/* Diferença entre privilégios */
		title = "Kronos - Atualizar Valores/Datas(";
		switch(privilegios) {
			case 2:	title += "Diretor";	break;
			case 3:	title += "ADMIN";	break;
		}
		title += ")";
		setTitle(title);
	}

}
