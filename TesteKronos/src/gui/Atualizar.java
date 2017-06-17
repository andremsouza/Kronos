package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
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
import java.awt.Rectangle;

public class Atualizar extends JFrame {
	private static final long serialVersionUID = 7011304046253879959L;
	private JLabel lblDatas;
	private JLabel lblAulasInicio;
	private JLabel lblAulasFim;
	private JLabel lblAulasInicioNovo;
	private JLabel lblAulasFimAtual;
	private JLabel lblValores;
	private JLabel lblAulasFimNovo;
	private JLabel lblMatInf;
	private JLabel lblMatInfAtual;
	private JLabel lblMatInfNovo;
	private JLabel lblMatFund;
	private JLabel lblMatFundAtual;
	private JLabel lblParcInf;
	private JLabel lblParcInfAtual;
	private JLabel lblAulasInicioAtual;
	private JLabel lblParcInfNovo;
	private JLabel lblParcFund;
	private JLabel lblParcFundAtual;
	private JLabel lblParcFundNovo;
	private JLabel lblMatFundNovo;
	private HintTextField hTFAulasInicio;
	private HintTextField hTFAulasFim;
	private HintTextField hTFValoresMatInf;
	private HintTextField hTFValoresMatFund;
	private HintTextField hTFValoresParcInf;
	private HintTextField hTFValoresParcFund;
	private JScrollPane scrollPane;
	private JButton btnAtt;
	private JPanel panelAll;
	private JPanel panelDatas;
	private JPanel contentPane;
	private JPanel panelDatasFields;
	private JPanel panelDatasInicio;
	private JPanel panelDatasFieldInicio;
	private JPanel panelDatasFieldInicioAtual;
	private JPanel panelDatasFieldInicioNovo;
	private JPanel panelDatasFim;
	private JPanel panelDatasFieldFim;
	private JPanel panelDatasFieldFimAtual;
	private JPanel panelValores;
	private JPanel panelValoresFields;
	private JPanel panelValoresInfantilMat;
	private JPanel panelValoresInfantilMatFields;
	private JPanel panelValoresInfantilMatAtual;
	private JPanel panelDatasFieldFimNovo;
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
	private FlowLayout fl_panelDatasFieldInicioAtual;
	private FlowLayout fl_panelDatasFieldNovo;
	private FlowLayout fl_panelDatasFieldFimAtual;
	private FlowLayout fl_panelDatasFieldFimNovo;
	private FlowLayout fl_panelValoresInfantilMatAtual;
	private FlowLayout fl_panelValoresInfantilMatNovo;
	private FlowLayout fl_panelValoresFundamentalMatAtual;
	private FlowLayout fl_panelValoresFundamentalMatNovo;
	private FlowLayout fl_panelValoresInfantilParcAtual;
	private FlowLayout fl_panelValoresInfantilParcNovo;
	private FlowLayout fl_panelValoresFundamentalParcAtual;
	private FlowLayout fl_panelValoresFundamentalParcNovo;
	private String title;
	/*private String diaInicio;
	private String mesInicio;
	private String anoInicio;
	private String diaFim;
	private String mesFim;
	private String anoFim;*/
	private String dataInicio;
	private String dataFim;
	private double valorMatInf;
	private double valorMatFund;
	private double valorParcInf;
	private double valorParcFund;
	
	/**
	 * Construtor.
	 */
	public Atualizar(int privileges) {
		/* Chama função do Igor para pegar os valores */
		valorMatInf = 1000;
		valorMatFund = 1100;
		valorParcInf = 1200;
		valorParcFund = 1300;
		dataInicio = "16/06/2017";
		dataFim = "20/06/2017";
		initialize(privileges);
	}

	/**
	 * Inicializa as variáveis.
	 */
	private void initialize(int privileges) {
		/* Inicializa JLabels */
		lblDatas = new JLabel("Datas");
		lblDatas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatas.setFont(new Font("Tahoma", Font.PLAIN, 26));

		lblAulasInicio = new JLabel("In\u00EDcio das Aulas");
		lblAulasInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAulasInicio.setHorizontalAlignment(SwingConstants.CENTER);

		lblAulasInicioAtual = new JLabel("Atual:       " + dataInicio);

		lblAulasInicioNovo = new JLabel("Novo: ");

		lblAulasFim = new JLabel("Fim das Aulas");
		lblAulasFim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAulasFim.setHorizontalAlignment(SwingConstants.CENTER);

		lblAulasFimAtual = new JLabel("Atual:       " + dataFim);

		lblAulasFimNovo = new JLabel("Novo: ");

		lblValores = new JLabel("Valores");
		lblValores.setHorizontalAlignment(SwingConstants.CENTER);
		lblValores.setFont(new Font("Tahoma", Font.PLAIN, 26));

		lblMatInf = new JLabel("Taxa de Matr\u00EDcula(Infantil)");

		lblMatInfAtual = new JLabel("Atual: R$" + valorMatInf);

		lblMatInfNovo = new JLabel("Novo: ");

		lblMatFund = new JLabel("Taxa de Matr\u00EDcula(Fundamental)");

		lblMatFundAtual = new JLabel("Atual: R$" + valorMatFund);

		lblMatFundNovo = new JLabel("Novo: ");

		lblParcInf = new JLabel("Parcela(Infantil)");

		lblParcInfAtual = new JLabel("Atual: R$" + valorParcInf);

		lblParcInfNovo = new JLabel("Novo: ");

		lblParcFund = new JLabel("Parcela(Fundamental)");

		lblParcFundAtual = new JLabel("Atual: R$" + valorParcFund);

		lblParcFundNovo = new JLabel("Novo: ");
		/* Fim JLabels */
		
		/* Inicializa HintTextField */
		hTFAulasInicio = new HintTextField("dd/mm/aaaa");
		hTFAulasInicio.setColumns(10);
		
		hTFAulasFim = new HintTextField("dd/mm/aaaa");
		hTFAulasFim.setColumns(10);
		
		hTFValoresMatInf = new HintTextField("xxxx,yy");
		hTFValoresMatInf.setColumns(10);

		hTFValoresMatFund = new HintTextField("xxxx,yy");
		hTFValoresMatFund.setColumns(10);

		hTFValoresParcInf = new HintTextField("xxxx,yy");
		hTFValoresParcInf.setColumns(10);

		hTFValoresParcFund = new HintTextField("xxxx,yy");
		hTFValoresParcFund.setColumns(10);
		/* Fim HintTextField */

		/* Inicializa JButton */
		btnAtt = new JButton("Atualizar");
		btnAtt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Checa cada um dos JTextFields */
				
				/* Inicio */
				int[] barras = {2, 5};
				int[] numb = {0, 1, 3, 4, 6, 7, 8, 9};
				
				boolean inicioDataError = false;
				boolean fimDataError = false;
				boolean matInfError = false;
				boolean matFundError = false;
				boolean parcInfError = false;
				boolean parcFundError = false;
				
				String errorMsg = "";
				
				/* Início */
				if(hTFAulasInicio.getText().length() == 10) {
					for(int n : barras) if(hTFAulasInicio.getText().charAt(n) != '/') inicioDataError = true;
					for(int n : numb) if(hTFAulasInicio.getText().charAt(n) < '0' || hTFAulasInicio.getText().charAt(n) > '9') inicioDataError = true;
					if(!inicioDataError) {
						/* chama função do Igor que atualiza */
						lblAulasInicioAtual.setText("Atual:       " + hTFAulasInicio.getText());
					}
				} else if(hTFAulasInicio.getText().length() != 0) inicioDataError = true;
				if(inicioDataError) errorMsg += "Data de início das aulas mal formatada. ";
				
				/* Fim */
				if(hTFAulasFim.getText().length() == 10) {
					for(int n : barras) if(hTFAulasFim.getText().charAt(n) != '/') fimDataError = true;
					for(int n : numb) if(hTFAulasFim.getText().charAt(n) < '0' || hTFAulasFim.getText().charAt(n) > '9') fimDataError = true;
					if(!fimDataError) {
						/* chama função do Igor que atualiza */
						lblAulasFimAtual.setText("Atual:       " + hTFAulasFim.getText());
					}
				} else if(hTFAulasFim.getText().length() != 0) fimDataError = true;
				if(fimDataError) errorMsg += "Data de fim das aulas mal formatada. ";
				
				/* Matricula Infantil */
				if((hTFValoresMatInf.getText().length() > 3) && (hTFValoresMatInf.getText().charAt(hTFValoresMatInf.getText().length() - 3) == ',')) {
					for(int n = 0, length = hTFValoresMatInf.getText().length(); n < length; n++)
						if(n != (length - 3))
							if(hTFValoresMatInf.getText().charAt(n) < '0' || hTFValoresMatInf.getText().charAt(n) > '9')
								matInfError = true;
					if(!matInfError) {
						/* chama função do Igor que atualiza */
						lblMatInfAtual.setText("Atual: R$" + hTFValoresMatInf.getText());
					}
				} else if(hTFValoresMatInf.getText().length() != 0) matInfError = true;
				if(matInfError) errorMsg += "Valor da matrícula para Ensino Infantil mal formatado. ";
				
				/* Matricula Fundamental */
				if((hTFValoresMatFund.getText().length() > 3) && (hTFValoresMatFund.getText().charAt(hTFValoresMatFund.getText().length() - 3) == ',')) {
					for(int n = 0, length = hTFValoresMatFund.getText().length(); n < length; n++)
						if(n != (length - 3))
							if(hTFValoresMatFund.getText().charAt(n) < '0' || hTFValoresMatFund.getText().charAt(n) > '9')
								matFundError = true;
					if(!matFundError) {
						/* chama função do Igor que atualiza */
						lblMatInfAtual.setText("Atual: R$" + hTFValoresMatFund.getText());
					}
				} else if(hTFValoresMatFund.getText().length() != 0) matFundError = true;
				if(matFundError) errorMsg += "Valor da matrícula para Ensino Fundamental mal formatado. ";
				
				/* Parcela Infantil */
				if((hTFValoresParcInf.getText().length() > 3) && (hTFValoresParcInf.getText().charAt(hTFValoresParcInf.getText().length() - 3) == ',')) {
					for(int n = 0, length = hTFValoresParcInf.getText().length(); n < length; n++)
						if(n != (length - 3))
							if(hTFValoresParcInf.getText().charAt(n) < '0' || hTFValoresParcInf.getText().charAt(n) > '9')
								parcInfError = true;
					if(!parcInfError) {
						/* chama função do Igor que atualiza */
						lblMatInfAtual.setText("Atual: R$" + hTFValoresParcInf.getText());
					}
				} else if(hTFValoresParcInf.getText().length() != 0) parcInfError = true;
				if(parcInfError) errorMsg += "Valor da parcela para Ensino Infântil mal formatado. ";
				
				/* Parcela Fundamental */
				if((hTFValoresParcFund.getText().length() > 3) && (hTFValoresParcFund.getText().charAt(hTFValoresParcFund.getText().length() - 3) == ',')) {
					for(int n = 0, length = hTFValoresParcFund.getText().length(); n < length; n++)
						if(n != (length - 3))
							if(hTFValoresParcFund.getText().charAt(n) < '0' || hTFValoresParcFund.getText().charAt(n) > '9')
								parcFundError = true;
					if(!parcFundError) {
						/* chama função do Igor que atualiza */
						lblMatInfAtual.setText("Atual: R$" + hTFValoresParcFund.getText());
					}
				} else if(hTFValoresParcFund.getText().length() != 0) parcFundError = true;
				if(parcFundError) errorMsg += "Valor da parcela para Ensino Fundamental mal formatado. ";
				
				/* Mostra janela de erro */
				if(inicioDataError || fimDataError || matInfError || matFundError || parcInfError || parcFundError) JOptionPane.showMessageDialog(null, errorMsg, "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		/* Fim JButton */

		/* Inicializa JPanel */		
		panelDatasFieldInicioAtual = new JPanel();
		fl_panelDatasFieldInicioAtual = (FlowLayout) panelDatasFieldInicioAtual.getLayout();
		fl_panelDatasFieldInicioAtual.setAlignment(FlowLayout.LEADING);
		panelDatasFieldInicioAtual.add(lblAulasInicioAtual);
		
		panelDatasFieldInicioNovo = new JPanel();
		fl_panelDatasFieldNovo = (FlowLayout) panelDatasFieldInicioNovo.getLayout();
		fl_panelDatasFieldNovo.setAlignment(FlowLayout.LEADING);
		panelDatasFieldInicioNovo.add(lblAulasInicioNovo);
		panelDatasFieldInicioNovo.add(hTFAulasInicio);

		panelDatasFieldInicio = new JPanel();
		panelDatasFieldInicio.setLayout(new GridLayout(2, 1, 0, 0));
		panelDatasFieldInicio.add(panelDatasFieldInicioAtual);
		panelDatasFieldInicio.add(panelDatasFieldInicioNovo);

		panelDatasInicio = new JPanel();
		panelDatasInicio.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelDatasInicio.setLayout(new BorderLayout(0, 5));
		panelDatasInicio.add(lblAulasInicio, BorderLayout.NORTH);
		panelDatasInicio.add(panelDatasFieldInicio, BorderLayout.CENTER);

		panelDatasFieldFimAtual = new JPanel();
		fl_panelDatasFieldFimAtual = (FlowLayout) panelDatasFieldFimAtual.getLayout();
		fl_panelDatasFieldFimAtual.setAlignment(FlowLayout.LEADING);
		panelDatasFieldFimAtual.add(lblAulasFimAtual);

		panelDatasFieldFimNovo = new JPanel();
		fl_panelDatasFieldFimNovo = (FlowLayout) panelDatasFieldFimNovo.getLayout();
		fl_panelDatasFieldFimNovo.setAlignment(FlowLayout.LEADING);
		panelDatasFieldFimNovo.add(lblAulasFimNovo);
		panelDatasFieldFimNovo.add(hTFAulasFim);

		panelDatasFieldFim = new JPanel();
		panelDatasFieldFim.setLayout(new GridLayout(2, 1, 0, 0));
		panelDatasFieldFim.add(panelDatasFieldFimAtual);
		panelDatasFieldFim.add(panelDatasFieldFimNovo);

		panelDatasFim = new JPanel();
		panelDatasFim.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelDatasFim.setLayout(new BorderLayout(0, 5));
		panelDatasFim.add(lblAulasFim, BorderLayout.NORTH);
		panelDatasFim.add(panelDatasFieldFim, BorderLayout.CENTER);

		panelDatasFields = new JPanel();
		panelDatasFields.setLayout(new GridLayout(1, 2, 20, 0));
		panelDatasFields.add(panelDatasInicio);
		panelDatasFields.add(panelDatasFim);

		panelValoresInfantilMatAtual = new JPanel();
		fl_panelValoresInfantilMatAtual = (FlowLayout) panelValoresInfantilMatAtual.getLayout();
		fl_panelValoresInfantilMatAtual.setAlignment(FlowLayout.LEADING);
		panelValoresInfantilMatAtual.add(lblMatInfAtual);

		panelValoresInfantilMatNovo = new JPanel();
		fl_panelValoresInfantilMatNovo = (FlowLayout) panelValoresInfantilMatNovo.getLayout();
		fl_panelValoresInfantilMatNovo.setAlignment(FlowLayout.LEADING);
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
		fl_panelValoresFundamentalMatAtual = (FlowLayout) panelValoresFundamentalMatAtual.getLayout();
		fl_panelValoresFundamentalMatAtual.setAlignment(FlowLayout.LEADING);
		panelValoresFundamentalMatAtual.add(lblMatFundAtual);

		panelValoresFundamentalMatNovo = new JPanel();
		fl_panelValoresFundamentalMatNovo = (FlowLayout) panelValoresFundamentalMatNovo.getLayout();
		fl_panelValoresFundamentalMatNovo.setAlignment(FlowLayout.LEADING);
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
		fl_panelValoresInfantilParcAtual = (FlowLayout) panelValoresInfantilParcAtual.getLayout();
		fl_panelValoresInfantilParcAtual.setAlignment(FlowLayout.LEADING);
		panelValoresInfantilParcAtual.add(lblParcInfAtual);

		panelValoresInfantilParcNovo = new JPanel();
		fl_panelValoresInfantilParcNovo = (FlowLayout) panelValoresInfantilParcNovo.getLayout();
		fl_panelValoresInfantilParcNovo.setAlignment(FlowLayout.LEADING);
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
		fl_panelValoresFundamentalParcAtual = (FlowLayout) panelValoresFundamentalParcAtual.getLayout();
		fl_panelValoresFundamentalParcAtual.setAlignment(FlowLayout.LEADING);
		panelValoresFundamentalParcAtual.add(lblParcFundAtual);

		panelValoresFundamentalParcNovo = new JPanel();
		fl_panelValoresFundamentalParcNovo = (FlowLayout) panelValoresFundamentalParcNovo.getLayout();
		fl_panelValoresFundamentalParcNovo.setAlignment(FlowLayout.LEADING);
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

		panelValoresFields = new JPanel();
		panelValoresFields.setLayout(new GridLayout(4, 0, 0, 30));
		panelValoresFields.add(panelValoresInfantilMat);
		panelValoresFields.add(panelValoresFundamentalMat);
		panelValoresFields.add(panelValoresInfantilParc);
		panelValoresFields.add(panelValoresFundamentalParc);

		panelDatas = new JPanel();
		panelDatas.setLayout(new BorderLayout(0, 15));
		panelDatas.add(lblDatas, BorderLayout.NORTH);
		panelDatas.add(panelDatasFields, BorderLayout.CENTER);

		panelValores = new JPanel();
		panelValores.setLayout(new BorderLayout(0, 15));
		panelValores.add(lblValores, BorderLayout.CENTER);
		panelValores.add(panelValoresFields, BorderLayout.SOUTH);

		panelAll = new JPanel();
		panelAll.setLayout(new BorderLayout(0, 20));
		panelAll.add(panelDatas, BorderLayout.NORTH);
		panelAll.add(panelValores, BorderLayout.CENTER);
		panelAll.add(btnAtt, BorderLayout.SOUTH);
		/* Fim JPanel */

		/* Inicializa JScrollPane */
		scrollPane = new JScrollPane(panelAll);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		/* Fim JScrollPane */

		/* Adiciona FocusListener nos HintTextField */
		/* não funcionou direito
		hTFAulasInicio.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				int actualYVp = scrollPane.getViewport().getViewPosition().y;
				int actualmaxYVp = actualYVp + getBounds().height;
				int compBX = panelDatasInicio.getBounds().x;
				int compBY = panelDatasFields.getBounds().y;
				int compBMaxY = compBY + panelDatasFields.getBounds().height;
				System.out.println("actualYVp: " + actualYVp + " actualmaxYVp: " + actualmaxYVp + " compBX: " + compBX + " compBY: " + compBY + " compBMaxY: " + compBMaxY);
				if(actualmaxYVp < compBY ||  actualYVp > compBMaxY)
					scrollPane.getViewport().setViewPosition(new Point(compBX, compBMaxY - getBounds().height));
			}
			public void focusLost(FocusEvent e) {}
		});
		
		hTFAulasFim.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				int actualYVp = scrollPane.getViewport().getViewPosition().y;
				int actualmaxYVp = actualYVp + getBounds().height;
				int compBX = panelDatasFim.getBounds().x;
				int compBY = panelDatasFields.getBounds().y;
				int compBMaxY = compBY + panelDatasFields.getBounds().height;
				System.out.println("actualYVp: " + actualYVp + " actualmaxYVp: " + actualmaxYVp + " compBX: " + compBX + " compBY: " + compBY + " compBMaxY: " + compBMaxY);
				if(actualmaxYVp < compBY ||  actualYVp > compBMaxY)
					scrollPane.getViewport().setViewPosition(new Point(compBX, compBMaxY - getBounds().height));
			}
			public void focusLost(FocusEvent e) {}
		});

		hTFValoresMatInf.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				int actualYVp = scrollPane.getViewport().getViewPosition().y;
				int actualmaxYVp = actualYVp + getBounds().height;
				int compBX = panelValoresInfantilMat.getBounds().x;
				int compBY = panelValoresInfantilMat.getBounds().y + panelValores.getBounds().y;
				int compBMaxY = compBY + panelValoresInfantilMat.getBounds().height;// + panelValores.getBounds().y;
				System.out.println("actualYVp: " + actualYVp + " actualmaxYVp: " + actualmaxYVp + " compBX: " + compBX + " compBY: " + compBY + " compBMaxY: " + compBMaxY);
				if(actualmaxYVp < compBY ||  actualYVp > compBMaxY)
					scrollPane.getViewport().setViewPosition(new Point(compBX, compBMaxY - getBounds().height));
			}
			public void focusLost(FocusEvent e) {}
		});
		
		hTFValoresMatFund.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				int actualYVp = scrollPane.getViewport().getViewPosition().y;
				int actualmaxYVp = actualYVp + getBounds().height;
				int compBX = panelValoresFundamentalMat.getBounds().x;
				int compBY = panelValoresFundamentalMat.getBounds().y + panelValores.getBounds().y;
				int compBMaxY = compBY + panelValoresFundamentalMat.getBounds().height;// + panelValores.getBounds().y;
				System.out.println("actualYVp: " + actualYVp + " actualmaxYVp: " + actualmaxYVp + " compBX: " + compBX + " compBY: " + compBY + " compBMaxY: " + compBMaxY);
				if(actualmaxYVp < compBY ||  actualYVp > compBMaxY)
					scrollPane.getViewport().setViewPosition(new Point(compBX, compBMaxY - getBounds().height));
			}
			public void focusLost(FocusEvent e) {}
		});
		
		hTFValoresParcInf.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				int actualYVp = scrollPane.getViewport().getViewPosition().y;
				int actualmaxYVp = actualYVp + getBounds().height;
				int compBX = panelValoresInfantilParc.getBounds().x;
				int compBY = panelValoresInfantilParc.getBounds().y + panelValores.getBounds().y;
				int compBMaxY = compBY + panelValoresInfantilParc.getBounds().height;// + panelValores.getBounds().y;
				System.out.println("actualYVp: " + actualYVp + " actualmaxYVp: " + actualmaxYVp + " compBX: " + compBX + " compBY: " + compBY + " compBMaxY: " + compBMaxY);
				if(actualmaxYVp < compBY ||  actualYVp > compBMaxY)
					scrollPane.getViewport().setViewPosition(new Point(compBX, compBMaxY - getBounds().height));
			}
			public void focusLost(FocusEvent e) {}
		});
		
		hTFValoresParcFund.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				int actualYVp = scrollPane.getViewport().getViewPosition().y;
				int actualmaxYVp = actualYVp + getBounds().height;
				int compBX = panelValoresFundamentalParc.getBounds().x;
				int compBY = panelValoresFundamentalParc.getBounds().y + panelValores.getBounds().y;
				int compBMaxY = compBY + panelValoresFundamentalParc.getBounds().height;// + panelValores.getBounds().y;
				System.out.println("actualYVp: " + actualYVp + " actualmaxYVp: " + actualmaxYVp + " compBX: " + compBX + " compBY: " + compBY + " compBMaxY: " + compBMaxY);
				if(actualmaxYVp < compBY ||  actualYVp > compBMaxY)
					scrollPane.getViewport().setViewPosition(new Point(compBX, compBMaxY - getBounds().height));
			}
			public void focusLost(FocusEvent e) {}
		});*/
		/* Fim Focus Listener */
		
		/* Inicializa o JFrame */
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(scrollPane);
		this.setContentPane(contentPane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setMinimumSize(new Dimension(400, 400));
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        setBounds(0,0, 400, bounds.height);
        
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
