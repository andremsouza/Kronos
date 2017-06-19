package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JComponent;
import operations.Dates;
import java.io.IOException;

public class Atualizar extends JFrame {
	private static final long serialVersionUID = 7011304046253879959L;
	private JLabel lblValores;
	private JLabel lblMatInf;
	private JLabel lblMatInfAtual;
	private JLabel lblMatInfNovo;
	private JLabel lblMatFund;
	private JLabel lblMatFundAtual;
	private JLabel lblParcInf;
	private JLabel lblParcInfAtual;
	private JLabel lblParcInfNovo;
	private JLabel lblParcFund;
	private JLabel lblParcFundAtual;
	private JLabel lblParcFundNovo;
	private JLabel lblMatFundNovo;
	private JLabel lblInt;
	private JLabel lblIntAtual;
	private JLabel lblIntNovo;
	private HintTextField hTFValoresMatInf;
	private HintTextField hTFValoresMatFund;
	private HintTextField hTFValoresParcInf;
	private HintTextField hTFValoresParcFund;
	private HintTextField hTFValoresInt;
	private JScrollPane scrollPane;
	private JButton btnAtt;
	private JPanel contentPane;
	private JPanel panelValores;
	private JPanel panelValoresFields;
	private JPanel panelValoresInfantilMat;
	private JPanel panelValoresInfantilMatFields;
	private JPanel panelValoresInfantilMatAtual;
	private JPanel panelValoresInfantilMatNovo;
	private JPanel panelValoresFundamentalMat;
	private JPanel panelValoresFundamentalMatFields;
	private JPanel panelValoresFundamentalMatAtual;
	private JPanel panelValoresFundamentalMatNovo;
	private JPanel panelValoresInfantilParc;
	private JPanel panelValoresInfantilParcFields;
	private JPanel panelValoresInfantilParcAtual;
	private JPanel panelValoresInfantilParcNovo;
	private JPanel panelValoresFundamentalParc;
	private JPanel panelValoresFundamentalParcFields;
	private JPanel panelValoresFundamentalParcAtual;
	private JPanel panelValoresFundamentalParcNovo;
	private JPanel panelValorIntegral;
	private JPanel panelValorIntegralFields;
	private JPanel panelValorIntegralAtual;
	private JPanel panelValorIntegralNovo;
	private String title;
	private double valorMatInf;
	private double valorMatFund;
	private double valorParcInf;
	private double valorParcFund;
	private double valorInt;
	private Dates operations;
	
	/**
	 * Construtor.
	 */
	public Atualizar(int privileges) {
		try {
			operations = new Dates();
		} catch(Exception e) {
			
		}
		valorMatInf = operations.valor(4);
		valorMatFund = operations.valor(5);
		valorParcInf = operations.valor(1);
		valorParcFund = operations.valor(2);
		valorInt = operations.valor(3);
		initialize(privileges);
	}
	
	private String doubleToString(double x) {
		String d = "";
		d += ((int)x);
		d += ',';
		d += ((int)(x * 10)) % 10;
		d += ((int)(x * 100)) % 10;
		return d;
	}

	/**
	 * Inicializa as variáveis.
	 */
	private void initialize(int privileges) {
		/* Inicializa JLabels */
		lblValores = new JLabel("Valores");
		lblValores.setHorizontalAlignment(SwingConstants.CENTER);
		lblValores.setFont(new Font("Tahoma", Font.PLAIN, 26));

		lblMatInf = new JLabel("Taxa de Matr\u00EDcula(Infantil)");

		lblMatInfAtual = new JLabel("Atual: R$" + doubleToString(valorMatInf));

		lblMatInfNovo = new JLabel("Novo: ");

		lblMatFund = new JLabel("Taxa de Matr\u00EDcula(Fundamental)");

		lblMatFundAtual = new JLabel("Atual: R$" + doubleToString(valorMatFund));

		lblMatFundNovo = new JLabel("Novo: ");

		lblParcInf = new JLabel("Parcela(Infantil)");

		lblParcInfAtual = new JLabel("Atual: R$" + doubleToString(valorParcInf));

		lblParcInfNovo = new JLabel("Novo: ");

		lblParcFund = new JLabel("Parcela(Fundamental)");

		lblParcFundAtual = new JLabel("Atual: R$" + doubleToString(valorParcFund));

		lblParcFundNovo = new JLabel("Novo: ");
		
		lblInt = new JLabel("Valor Integral");
		
		lblIntAtual = new JLabel("Atual: R$" + doubleToString(valorInt));
		
		lblIntNovo = new JLabel("Novo: ");
		/* Fim JLabels */
		
		/* Inicializa HintTextField */
		FocusListener flhTF = new FocusListener() {
	        public void focusGained(FocusEvent e) {
	        	JComponent component = (JComponent)e.getComponent();
	        	((JComponent)component.getParent().getParent().getParent().getParent()).scrollRectToVisible(component.getParent().getParent().getParent().getBounds());
	        }
	        public void focusLost( FocusEvent e ) {}
	    };
		
		hTFValoresMatInf = new HintTextField();
		hTFValoresMatInf.setValorHint();
		hTFValoresMatInf.setColumns(10);
		hTFValoresMatInf.addFocusListener(flhTF);
		
		hTFValoresMatFund = new HintTextField();
		hTFValoresMatFund.setValorHint();
		hTFValoresMatFund.setColumns(10);
		hTFValoresMatFund.addFocusListener(flhTF);
		
		hTFValoresParcInf = new HintTextField();
		hTFValoresParcInf.setValorHint();
		hTFValoresParcInf.setColumns(10);
		hTFValoresParcInf.addFocusListener(flhTF);
		
		hTFValoresParcFund = new HintTextField();
		hTFValoresParcFund.setValorHint();
		hTFValoresParcFund.setColumns(10);
		hTFValoresParcFund.addFocusListener(flhTF);
		
		hTFValoresInt = new HintTextField();
		hTFValoresInt.setValorHint();
		hTFValoresInt.setColumns(10);
		hTFValoresInt.addFocusListener(flhTF);
		/* Fim HintTextField */

		/* Inicializa JButton */
		btnAtt = new JButton("Atualizar");
		btnAtt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtt.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
	        	JComponent component = (JComponent)e.getComponent();
	        	((JComponent)component.getParent()).scrollRectToVisible(component.getBounds());
	        }
	        public void focusLost(FocusEvent e) {}
		});
		btnAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Checa cada um dos JTextFields */
				String errorMsg = "";
				boolean printError = false;
				
				/* Matricula Infantil */
				if(!hTFValoresMatInf.showingHint() && hTFValoresMatInf.getText().length() != 0)
					if(hTFValoresMatInf.checaValor()) {
						operations.atualizarMatriculaInfantil((valorMatInf = Double.parseDouble(hTFValoresMatInf.getText().replace(',', '.'))));
						lblMatInfAtual.setText("Atual: R$" + doubleToString(valorMatInf));
						hTFValoresMatInf.setText("");
					} else {
						errorMsg += "Valor da matrícula para Ensino Infantil mal formatado. ";
						printError = true;
					}
				
				/* Matricula Fundamental */
				if(!hTFValoresMatFund.showingHint() && hTFValoresMatFund.getText().length() != 0)
					if(hTFValoresMatFund.checaValor()) {
						operations.atualizarMatriculaFundamental((valorMatFund = Double.parseDouble(hTFValoresMatFund.getText().replace(',', '.'))));
						lblMatFundAtual.setText("Atual: R$" + doubleToString(valorMatFund));
						hTFValoresMatFund.setText("");
					} else {
						errorMsg += "Valor da matrícula para Ensino Fundamental mal formatado. ";
						printError = true;
					}
				
				/* Parcela Infantil */
				if(!hTFValoresParcInf.showingHint() && hTFValoresParcInf.getText().length() != 0)
					if(hTFValoresParcInf.checaValor()) {
						operations.atualizarValorInfantil((valorParcInf = Double.parseDouble(hTFValoresParcInf.getText().replace(',', '.'))));
						lblParcInfAtual.setText("Atual: R$" + doubleToString(valorParcInf));
						hTFValoresParcInf.setText("");
					} else {
						errorMsg += "Valor da parcela para Ensino Infântil mal formatado. ";
						printError = true;
					}
				
				/* Parcela Fundamental */
				if(!hTFValoresParcFund.showingHint() && hTFValoresParcFund.getText().length() != 0)
					if(hTFValoresParcFund.checaValor()) {
						operations.atualizarValorFundamental((valorParcFund = Double.parseDouble(hTFValoresParcFund.getText().replace(',', '.'))));
						lblParcFundAtual.setText("Atual: R$" + doubleToString(valorParcFund));
						hTFValoresParcFund.setText("");
					} else {
						errorMsg += "Valor da parcela para Ensino Fundamental mal formatado. ";
						printError = true;
					}
				
				/* Valor Integral */
				if(!hTFValoresInt.showingHint() && hTFValoresInt.getText().length() != 0)
					if(hTFValoresInt.checaValor()) {
						operations.atualizarIntegral((valorInt = Double.parseDouble(hTFValoresInt.getText().replace(',', '.'))));
						lblIntAtual.setText("Atual: R$" + doubleToString(valorInt));
						hTFValoresInt.setText("");
					} else {
						errorMsg += "Valor Integral mal formatado. ";
						printError = true;
					}
				
				/* Mostra janela de erro */
				if(printError) JOptionPane.showMessageDialog(null, errorMsg, "Erro", JOptionPane.ERROR_MESSAGE);
				
				try {
					operations.fimDePrograma();
				} catch(IOException f) {
					// aceitaaa
				}
			}
		});
		/* Fim JButton */

		/* Inicializa JPanel */		

		panelValoresInfantilMatAtual = new JPanel();
		((FlowLayout) panelValoresInfantilMatAtual.getLayout()).setAlignment(FlowLayout.LEADING);
		panelValoresInfantilMatAtual.add(lblMatInfAtual);

		panelValoresInfantilMatNovo = new JPanel();
		((FlowLayout) panelValoresInfantilMatNovo.getLayout()).setAlignment(FlowLayout.LEADING);
		panelValoresInfantilMatNovo.add(lblMatInfNovo);
		panelValoresInfantilMatNovo.add(hTFValoresMatInf);

		panelValoresInfantilMatFields = new JPanel();
		panelValoresInfantilMatFields.setLayout(new GridLayout(0, 1, 0, 0));
		panelValoresInfantilMatFields.add(panelValoresInfantilMatAtual);
		panelValoresInfantilMatFields.add(panelValoresInfantilMatNovo);

		panelValoresInfantilMat = new JPanel();
		panelValoresInfantilMat.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelValoresInfantilMat.setLayout(new BorderLayout(0, 5));
		panelValoresInfantilMat.add(lblMatInf, BorderLayout.NORTH);
		panelValoresInfantilMat.add(panelValoresInfantilMatFields, BorderLayout.CENTER);

		panelValoresFundamentalMatAtual = new JPanel();
		((FlowLayout) panelValoresFundamentalMatAtual.getLayout()).setAlignment(FlowLayout.LEADING);
		panelValoresFundamentalMatAtual.add(lblMatFundAtual);

		panelValoresFundamentalMatNovo = new JPanel();
		((FlowLayout) panelValoresFundamentalMatNovo.getLayout()).setAlignment(FlowLayout.LEADING);
		panelValoresFundamentalMatNovo.add(lblMatFundNovo);
		panelValoresFundamentalMatNovo.add(hTFValoresMatFund);

		panelValoresFundamentalMatFields = new JPanel();
		panelValoresFundamentalMatFields.setLayout(new GridLayout(0, 1, 0, 0));
		panelValoresFundamentalMatFields.add(panelValoresFundamentalMatAtual);
		panelValoresFundamentalMatFields.add(panelValoresFundamentalMatNovo);

		panelValoresFundamentalMat = new JPanel();
		panelValoresFundamentalMat.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelValoresFundamentalMat.setLayout(new BorderLayout(0, 5));
		panelValoresFundamentalMat.add(lblMatFund, BorderLayout.NORTH);
		panelValoresFundamentalMat.add(panelValoresFundamentalMatFields, BorderLayout.SOUTH);

		panelValoresInfantilParcAtual = new JPanel();
		((FlowLayout) panelValoresInfantilParcAtual.getLayout()).setAlignment(FlowLayout.LEADING);
		panelValoresInfantilParcAtual.add(lblParcInfAtual);

		panelValoresInfantilParcNovo = new JPanel();
		((FlowLayout) panelValoresInfantilParcNovo.getLayout()).setAlignment(FlowLayout.LEADING);
		panelValoresInfantilParcNovo.add(lblParcInfNovo);
		panelValoresInfantilParcNovo.add(hTFValoresParcInf);

		panelValoresInfantilParcFields = new JPanel();
		panelValoresInfantilParcFields.setLayout(new GridLayout(0, 1, 0, 0));
		panelValoresInfantilParcFields.add(panelValoresInfantilParcAtual);
		panelValoresInfantilParcFields.add(panelValoresInfantilParcNovo);

		panelValoresInfantilParc = new JPanel();
		panelValoresInfantilParc.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelValoresInfantilParc.setLayout(new BorderLayout(0, 5));
		panelValoresInfantilParc.add(lblParcInf, BorderLayout.NORTH);
		panelValoresInfantilParc.add(panelValoresInfantilParcFields, BorderLayout.SOUTH);

		panelValoresFundamentalParcAtual = new JPanel();
		((FlowLayout) panelValoresFundamentalParcAtual.getLayout()).setAlignment(FlowLayout.LEADING);
		panelValoresFundamentalParcAtual.add(lblParcFundAtual);

		panelValoresFundamentalParcNovo = new JPanel();
		((FlowLayout) panelValoresFundamentalParcNovo.getLayout()).setAlignment(FlowLayout.LEADING);
		panelValoresFundamentalParcNovo.add(lblParcFundNovo);
		panelValoresFundamentalParcNovo.add(hTFValoresParcFund);

		panelValoresFundamentalParcFields = new JPanel();
		panelValoresFundamentalParcFields.setLayout(new GridLayout(0, 1, 0, 0));
		panelValoresFundamentalParcFields.add(panelValoresFundamentalParcAtual);
		panelValoresFundamentalParcFields.add(panelValoresFundamentalParcNovo);

		panelValoresFundamentalParc = new JPanel();
		panelValoresFundamentalParc.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelValoresFundamentalParc.setLayout(new BorderLayout(0, 5));
		panelValoresFundamentalParc.add(lblParcFund, BorderLayout.NORTH);
		panelValoresFundamentalParc.add(panelValoresFundamentalParcFields, BorderLayout.SOUTH);

		panelValorIntegralAtual = new JPanel();
		((FlowLayout) panelValorIntegralAtual.getLayout()).setAlignment(FlowLayout.LEADING);
		panelValorIntegralAtual.add(lblIntAtual);
		
		panelValorIntegralNovo = new JPanel();
		((FlowLayout) panelValorIntegralNovo.getLayout()).setAlignment(FlowLayout.LEADING);
		panelValorIntegralNovo.add(lblIntNovo);
		panelValorIntegralNovo.add(hTFValoresInt);
		
		panelValorIntegralFields = new JPanel();
		panelValorIntegralFields.setLayout(new GridLayout(0, 1, 0, 0));
		panelValorIntegralFields.add(panelValorIntegralAtual);
		panelValorIntegralFields.add(panelValorIntegralNovo);
		
		panelValorIntegral = new JPanel();
		panelValorIntegral.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelValorIntegral.setLayout(new BorderLayout(0, 5));
		panelValorIntegral.add(lblInt, BorderLayout.NORTH);
		panelValorIntegral.add(panelValorIntegralFields, BorderLayout.SOUTH);
		
		panelValoresFields = new JPanel();
		panelValoresFields.setLayout(new GridLayout(5, 0, 0, 30));
		panelValoresFields.add(panelValoresInfantilMat);
		panelValoresFields.add(panelValoresFundamentalMat);
		panelValoresFields.add(panelValoresInfantilParc);
		panelValoresFields.add(panelValoresFundamentalParc);
		panelValoresFields.add(panelValorIntegral);

		panelValores = new JPanel();
		panelValores.setLayout(new BorderLayout(0, 15));
		panelValores.add(lblValores, BorderLayout.NORTH);
		panelValores.add(panelValoresFields, BorderLayout.CENTER);
		panelValores.add(btnAtt, BorderLayout.SOUTH);
		/* Fim JPanel */

		/* Inicializa JScrollPane */
		scrollPane = new JScrollPane(panelValores);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		/* Fim JScrollPane */
		
		/* Inicializa o JFrame */
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(scrollPane);
		this.setContentPane(contentPane);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setMinimumSize(new Dimension(400, 400));
        this.getRootPane().setDefaultButton(btnAtt);
		title = "Kronos - Atualizar Valores/Datas(";
		switch(privileges) {
			case 2:	title += "Diretor";	break;
			case 3:	title += "ADMIN";	break;
		}
		title += ")";
		setTitle(title);
	}
	
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

}
