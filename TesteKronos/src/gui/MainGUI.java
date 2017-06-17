package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.UIManager;

public class MainGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4209509555981548583L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroupCat = new ButtonGroup();
	private int cat = -1;
	private final ButtonGroup buttonGroupData = new ButtonGroup();
	private boolean cdata = false;
	private boolean mat = false;
	private final ButtonGroup buttonGroupIntegral = new ButtonGroup();
	private boolean integral = false;

	/**
	 * Create the frame.
	 */
	public MainGUI(int privileges) {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Kronos");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setFont(new Font("Tahoma", Font.PLAIN, 11));
		//this.privileges = privileges;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('a');
		menuBar.add(mnArquivo);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setSelectedIcon(new ImageIcon(MainGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
		mntmSair.setIcon(new ImageIcon(MainGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mntmSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		mnArquivo.add(mntmSair);

		JMenu mnGerenciar = new JMenu("Gerenciar");
		mnGerenciar.setMnemonic('g');
		menuBar.add(mnGerenciar);

		JMenuItem mntmCursos = new JMenuItem("Cursos");
		mntmCursos.setEnabled(privileges >= 2);
		mntmCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso cs = new Curso(privileges);
				cs.setVisible(true);
			}
		});
		mnGerenciar.add(mntmCursos);

		JMenuItem mntmDatasEValores = new JMenuItem("Datas e Valores");
		mntmDatasEValores.setEnabled(privileges >= 2);
		mntmDatasEValores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atualizar at = new Atualizar(privileges);
				at.setVisible(true);
			}
		});
		mnGerenciar.add(mntmDatasEValores);
		

		JMenuItem mntmUsurios = new JMenuItem("Usu\u00E1rios");
		mntmUsurios.setEnabled(privileges == 3);
		mntmUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contas ct = new Contas();
				ct.setVisible(true);
			}
		});
		mnGerenciar.add(mntmUsurios);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[center]", "[][][][]"));

		JLabel lblKronosTitle = new JLabel("Kronos - C\u00E1lculo de Matr\u00EDcula com Valores Proporcionais");
		lblKronosTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(lblKronosTitle, "cell 0 0,alignx center,aligny center");

		JPanel panelParam = new JPanel();
		panelParam.setBorder(new TitledBorder(null, "Par\u00E2metros para C\u00E1lculo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
		contentPane.add(panelParam, "cell 0 1,alignx leading,aligny top");
		panelParam.setLayout(new MigLayout("", "[150px][][][][grow]", "[71px,grow,center]"));

		JPanel panelCategoria = new JPanel();
		panelCategoria.setBorder(new TitledBorder(null, "Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParam.add(panelCategoria, "cell 0 0,grow");
		panelCategoria.setLayout(new MigLayout("", "[98px,grow,fill]", "[24px][24px]"));

		JRadioButton rdbtnInfantil = new JRadioButton("Infantil");
		rdbtnInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cat = 1;
			}
		});
		buttonGroupCat.add(rdbtnInfantil);
		panelCategoria.add(rdbtnInfantil, "cell 0 0,alignx left,aligny top");

		JRadioButton rdbtnFundamental = new JRadioButton("Fundamental");
		rdbtnFundamental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cat = 2;
			}
		});
		buttonGroupCat.add(rdbtnFundamental);
		panelCategoria.add(rdbtnFundamental, "cell 0 1,alignx left,aligny top");

		JPanel panelMatricula = new JPanel();
		panelMatricula.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Status da Matr\u00EDcula", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelParam.add(panelMatricula, "cell 1 0,grow");
		panelMatricula.setLayout(new MigLayout("", "[126px,grow,fill]", "[26px,grow]"));

		JToggleButton tglbtnMatrculaPaga = new JToggleButton("Matr\u00EDcula Paga");
		tglbtnMatrculaPaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mat = tglbtnMatrculaPaga.isSelected();
			}
		});
		tglbtnMatrculaPaga.setToolTipText("Define se a matr\u00EDcula foi paga ou n\u00E3o.");
		panelMatricula.add(tglbtnMatrculaPaga, "cell 0 0,alignx center,aligny center");

		JPanel panelDataCurso = new JPanel();
		panelDataCurso.setBorder(new TitledBorder(null, "Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParam.add(panelDataCurso, "cell 2 0,grow");
		panelDataCurso.setLayout(new MigLayout("", "[109px,grow,leading]", "[23px][24px]"));

		JRadioButton rdbtnIncioDeCurso = new JRadioButton("In\u00EDcio de Curso");
		rdbtnIncioDeCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdata = false;
			}
		});
		buttonGroupData.add(rdbtnIncioDeCurso);
		panelDataCurso.add(rdbtnIncioDeCurso, "cell 0 0,alignx left,aligny top");

		JRadioButton rdbtnFimDeCurso = new JRadioButton("Fim de Curso");
		rdbtnFimDeCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdata = true;
			}
		});
		buttonGroupData.add(rdbtnFimDeCurso);
		panelDataCurso.add(rdbtnFimDeCurso, "cell 0 1,alignx left,aligny top");

		JPanel panelDataTerm = new JPanel();
		panelDataTerm.setBorder(new TitledBorder(null, "Data de T\u00E9rmino", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParam.add(panelDataTerm, "cell 3 0,grow");
		panelDataTerm.setLayout(new MigLayout("", "[grow][grow]", "[center][]"));

		JLabel lblDia = new JLabel("Dia");
		panelDataTerm.add(lblDia, "cell 0 0");

		JLabel lblMs = new JLabel("M\u00EAs");
		panelDataTerm.add(lblMs, "cell 1 0");

		JComboBox<String> comboBoxDia = new JComboBox<String>();
		comboBoxDia.setToolTipText("Dia.");
		comboBoxDia.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		panelDataTerm.add(comboBoxDia, "cell 0 1,alignx center,growy");

		JComboBox<String> comboBoxMes = new JComboBox<String>();
		comboBoxMes.setToolTipText("M\u00EAs.");
		comboBoxMes.setModel(new DefaultComboBoxModel<String>(new String[] {"JANEIRO", "FEVEREIRO", "MAR\u00C7O", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO"}));
		panelDataTerm.add(comboBoxMes, "cell 1 1,alignx center,aligny center");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Integral", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelParam.add(panel, "cell 4 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[][]"));
		
		JRadioButton rdbtnNo = new JRadioButton("N\u00E3o");
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				integral = false;
			}
		});
		buttonGroupIntegral.add(rdbtnNo);
		panel.add(rdbtnNo, "cell 0 0");
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				integral = true;
			}
		});
		buttonGroupIntegral.add(rdbtnSim);
		panel.add(rdbtnSim, "cell 0 1");

		JButton btnCalcular = new JButton("Calcular");

		contentPane.add(btnCalcular, "cell 0 2,growx,aligny center");
		btnCalcular.setToolTipText("Calcula a matr\u00EDcula com valores proporcionais.");
	}

}
