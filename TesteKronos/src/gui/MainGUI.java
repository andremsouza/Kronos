package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
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
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.NumberFormatter;
import net.miginfocom.swing.MigLayout;
import javax.swing.UIManager;
import javax.swing.JTable;
import operations.Dates;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4209509555981548583L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroupCat = new ButtonGroup();
	private int cat = 1;
	private final ButtonGroup buttonGroupData = new ButtonGroup();
	private boolean cdata = false;
	private boolean mat = false;
	private final ButtonGroup buttonGroupIntegral = new ButtonGroup();
	private boolean integral = false;
	private JTable table;
	private Dates operations;
	private JTextField textField;
	
	/**
	 * Create the frame.
	 */
	public MainGUI(int privileges) {
		try {
			operations = new Dates();
		} catch(Exception e) {
			
		}
		
		setTitle("Kronos");
		setFont(new Font("Tahoma", Font.PLAIN, 11));
		//this.privileges = privileges;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 390);

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
		mntmCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso cs = new Curso(privileges);
				cs.setVisible(true);
			}
		});
		mnGerenciar.add(mntmCursos);

		JMenuItem mntmDatasEValores = new JMenuItem("Valores");
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
				Contas ct = new Contas(privileges);
				ct.setVisible(true);
			}
		});
		mnGerenciar.add(mntmUsurios);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,center][]", "[][][][][][][][]"));

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
		rdbtnInfantil.setSelected(true);
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
		rdbtnIncioDeCurso.setSelected(true);
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
		rdbtnNo.setSelected(true);
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
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* atualiza objeto caso o arquivo tenha sido modificado */
				try {
					operations = new Dates();
				} catch(Exception f) {
					
				}
				double a = operations.valorProporcional(comboBoxDia.getSelectedIndex() + 1, comboBoxMes.getSelectedIndex() + 1, cat, cdata, integral, mat);
				Double vt = new Double(a);
				Integer q = operations.quantasInteiras(vt, cat, integral);
				Double vpi = new Double(operations.valorParcelaInteira(cat, integral));
				Double v = new Double(q * vpi);
				Double vpp = new Double(operations.valorParcelaProporcional(vt, cat, integral));
				((DefaultTableModel) table.getModel()).setValueAt(q, 0, 1);
				((DefaultTableModel) table.getModel()).setValueAt(vpi, 0, 2);
				((DefaultTableModel) table.getModel()).setValueAt(vpp, 1, 2);
				((DefaultTableModel) table.getModel()).setValueAt(v, 0, 3);
				((DefaultTableModel) table.getModel()).setValueAt(vpp, 1, 3);
				textField.setText("R$ " + (int)a + "," + ((int)(a * 10)) % 10 + ((int)(a * 100)) % 10);
			}
		});

		contentPane.add(btnCalcular, "cell 0 2,growx,aligny center");
		btnCalcular.setToolTipText("Calcula a matr\u00EDcula com valores proporcionais.");

		Object[] headers = new Object[]{"", "Quantas", "Valor da Parcela", "Soma das Parcelas"};
		Object[][] conteudo = new Object[][]{{"Parcelas Inteiras", new Integer(0), new Double(0), new Double(0)}, {"Parcela Proporcional", new Integer(1), new Double(0), new Double(0)}};
		
		//contentPane.add(table, "cell 0 4,grow");
		this.getRootPane().setDefaultButton(btnCalcular);
		table = new JTable(new DefaultTableModel(conteudo, headers)) {
			private static final long serialVersionUID = 1L;
			private DefaultTableCellRenderer formatadorMoeda = new DefaultTableCellRenderer() {
				private static final long serialVersionUID = 1L;
				
				@Override
				protected void setValue(Object o) {
					String dataFormatada = "";
					NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT", "BR"));
					NumberFormatter nff = new NumberFormatter(nf);
					try {
						dataFormatada = nff.valueToString(o);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					super.setValue(dataFormatada);
				}
			};
			
			private DefaultTableCellRenderer formatadorInt = new DefaultTableCellRenderer(); 
			
			{
				formatadorMoeda.setHorizontalAlignment(SwingConstants.LEFT);
				formatadorInt.setHorizontalAlignment(SwingConstants.LEFT);
		    }

			
			@Override
			public TableCellRenderer getCellRenderer(int row, int column) {
				if(column == 1) return formatadorInt;
				if ((column==2 || column==3)) return formatadorMoeda;
				return super.getCellRenderer(row, column);
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (columnIndex==0) return String.class;
				if (columnIndex==1) return Integer.class;
				if (columnIndex==2) return Double.class;
				if (columnIndex==3) return Double.class;
				return null;
			}
		};
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scrollPane = new  JScrollPane(table);
		contentPane.add(scrollPane, "cell 0 3,growx,aligny center");		
		
		JLabel lblValorProporcionalCompleto = new JLabel("Valor Proporcional Completo");
		contentPane.add(lblValorProporcionalCompleto, "cell 0 6");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(textField, "cell 0 7,growx");
		textField.setColumns(10);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI(3);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}