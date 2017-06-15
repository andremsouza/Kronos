package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private int privileges;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public MainGUI(int privileges) {
		setTitle("Kronos");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.privileges = privileges;
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
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		mnArquivo.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[leading]", "[baseline][baseline]"));
		
		JPanel panelParam = new JPanel();
		panelParam.setBorder(new TitledBorder(null, "Par\u00E2metros para C\u00E1lculo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
		contentPane.add(panelParam, "cell 0 1,alignx leading,aligny baseline");
		panelParam.setLayout(new MigLayout("", "[150px,grow]", "[71px][56px][70px][37px][14.00,baseline]"));
		
		JPanel panelCategoria = new JPanel();
		panelCategoria.setBorder(new TitledBorder(null, "Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParam.add(panelCategoria, "cell 0 0,growx,aligny baseline");
		panelCategoria.setLayout(new MigLayout("", "[98px,grow,fill]", "[24px][24px]"));
		
		JRadioButton rdbtnInfantil = new JRadioButton("Infantil");
		buttonGroup.add(rdbtnInfantil);
		panelCategoria.add(rdbtnInfantil, "cell 0 0,alignx left,aligny top");
		
		JRadioButton rdbtnFundamental = new JRadioButton("Fundamental");
		buttonGroup.add(rdbtnFundamental);
		panelCategoria.add(rdbtnFundamental, "cell 0 1,alignx left,aligny top");
		
		JPanel panelMatricula = new JPanel();
		panelMatricula.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Status da Matr\u00EDcula", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelParam.add(panelMatricula, "cell 0 1,growx,aligny baseline");
		panelMatricula.setLayout(new MigLayout("", "[126px,grow,fill]", "[26px]"));
		
		JToggleButton tglbtnMatrculaPaga = new JToggleButton("Matr\u00EDcula Paga");
		tglbtnMatrculaPaga.setToolTipText("Define se a matr\u00EDcula foi paga ou n\u00E3o.");
		panelMatricula.add(tglbtnMatrculaPaga, "cell 0 0,growx,aligny top");
		
		JPanel panelDataCurso = new JPanel();
		panelDataCurso.setBorder(new TitledBorder(null, "Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParam.add(panelDataCurso, "cell 0 2,growx,aligny baseline");
		panelDataCurso.setLayout(new MigLayout("", "[109px,grow,leading]", "[23px][24px]"));
		
		JRadioButton rdbtnIncioDeCurso = new JRadioButton("In\u00EDcio de Curso");
		buttonGroup_1.add(rdbtnIncioDeCurso);
		panelDataCurso.add(rdbtnIncioDeCurso, "cell 0 0,alignx left,aligny top");
		
		JRadioButton rdbtnFimDeCurso = new JRadioButton("Fim de Curso");
		buttonGroup_1.add(rdbtnFimDeCurso);
		panelDataCurso.add(rdbtnFimDeCurso, "cell 0 1,alignx left,aligny top");
		
		JPanel panelDataTerm = new JPanel();
		panelDataTerm.setBorder(new TitledBorder(null, "Data de T\u00E9rmino", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParam.add(panelDataTerm, "cell 0 3,growx,aligny baseline");
		panelDataTerm.setLayout(new MigLayout("", "[grow][grow]", "[][]"));
		
		JComboBox<String> comboBoxDia = new JComboBox<String>();
		comboBoxDia.setToolTipText("Dia.");
		comboBoxDia.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		panelDataTerm.add(comboBoxDia, "cell 0 1,growx");
		
		JComboBox<String> comboBoxMes = new JComboBox<String>();
		comboBoxMes.setToolTipText("M\u00EAs.");
		comboBoxMes.setModel(new DefaultComboBoxModel<String>(new String[] {"JANEIRO", "FEVEREIRO", "MAR\u00C7O", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO"}));
		panelDataTerm.add(comboBoxMes, "cell 1 1,growx");
		
		JPanel panelCalculate = new JPanel();
		panelCalculate.setBorder(new LineBorder(new Color(0, 128, 0)));
		panelParam.add(panelCalculate, "cell 0 4,growx,aligny baseline");
		panelCalculate.setLayout(new MigLayout("", "[grow]", "[][]"));
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setToolTipText("Calcula a matr\u00EDcula com valores proporcionais.");
		panelCalculate.add(btnCalcular, "cell 0 0,growx");
	}

}
