package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.NumberFormatter;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import operations.Dates;

public class Curso extends JFrame {
	private static final long serialVersionUID = 2595819290806678181L;
	private JLabel lblAdd;
	private JLabel lblAddCurso;
	private JLabel lblEdit;
	private JLabel lblEditCurso;
	private JLabel lblRem;
	private JLabel lblTabelaCurso;
	private JLabel lblGerenciaCursos;
	private JLabel lblAddValor;
	private JLabel lblEditValor;
	private JLabel lblRemCurso;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnRem;
	private JTextField tFAddCurso;
	private HintTextField tFAddValor;
	private JTextField tFEditCurso;
	private HintTextField tFEditValor;
	private JTextField tFRemCurso;
	private JPanel contentPane;
	private JPanel panelFunctions;
	private JPanel panelAdd;
	private JPanel panelEdit;
	private JPanel panelRem;
	private JPanel panelAddFields;
	private JPanel panelAddFieldCurso;
	private JPanel panelAddFieldValor;
	private JPanel panelEditFields;
	private JPanel panelEditFieldCurso;
	private JPanel panelEditFieldValor;
	private JPanel panelRemCurso;
	private JPanel panelTable;
	private JPanel panelTop;
	private String title;
	private Dates operations;
	
	/* Atualiza o tamanho dos componentes de acordo com o tamanho da janela */
	private void resizeComponents() {
		Rectangle frameRect;
		int columns;
		
		frameRect = getBounds();
		
		if((int)frameRect.getWidth() >= 1100) columns = 20;
		else if((int)frameRect.getWidth() >= 770) columns = 20 - ((1100 - (int)frameRect.getWidth()) / 33) - 1;
		else columns = 20;

		tFAddCurso.setColumns(columns);
		tFAddValor.setColumns(columns);
		tFEditCurso.setColumns(columns);
		tFEditValor.setColumns(columns);
		tFRemCurso.setColumns(columns);
	}
	
	/**
	 * Construtor.
	 */
	public Curso(int privileges) {
		try {
			operations = new Dates();
		} catch(Exception e) {
			
		}
		initialize(privileges);	
	}
	
	/**
	 * Inicializa as variáveis.
	 */
	private void initialize(int privileges) {
		/* Inicializa JLabel */
		lblGerenciaCursos = new JLabel("Ger\u00EAncia de Cursos");
		lblGerenciaCursos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciaCursos.setFont(new Font("Tahoma", Font.PLAIN, 26));

		lblAdd = new JLabel("Adicionar Curso");
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblAddCurso = new JLabel("Curso: ");
		lblAddCurso.setHorizontalAlignment(SwingConstants.LEADING);
		lblAddCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblAddValor = new JLabel("Valor:  ");
		lblAddValor.setHorizontalAlignment(SwingConstants.LEADING);
		lblAddValor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblEdit = new JLabel("Editar Curso");
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblEditCurso = new JLabel("Curso:         ");
		lblEditCurso.setHorizontalAlignment(SwingConstants.LEADING);
		lblEditCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblEditValor = new JLabel("Novo Valor: ");
		lblEditValor.setHorizontalAlignment(SwingConstants.LEADING);
		lblEditValor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblRem = new JLabel("Remover Curso");
		lblRem.setHorizontalAlignment(SwingConstants.CENTER);
		lblRem.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblRemCurso = new JLabel("Curso: ");
		lblRemCurso.setHorizontalAlignment(SwingConstants.LEADING);
		lblRemCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblTabelaCurso = new JLabel("Tabela de Cursos");
		lblTabelaCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTabelaCurso.setHorizontalAlignment(SwingConstants.CENTER);
		/* Fim JLabel */

		/* Inicializa JButton */
		btnAdd = new JButton("Adicionar");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		if(privileges != 1)
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curso = tFAddCurso.getText().toLowerCase();
				String valor = tFAddValor.getText();
				int i , rowCount;
				rowCount = ((DefaultTableModel) table.getModel()).getRowCount();
				i = rowCount;
				if(curso.length() != 0)
					for(i = 0; i < rowCount; i++)
						if(((String)((DefaultTableModel)table.getModel()).getValueAt(i, 0)).compareTo(curso) == 0) break;
				if(i != rowCount) {
					JOptionPane.showMessageDialog(null, "Curso já existe.", "Erro", JOptionPane.ERROR_MESSAGE);
				} else if(curso.length() < 3) {
					JOptionPane.showMessageDialog(null, "Curso precisa ter no mínimo 3 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
				} else if(valor.length() == 0 || tFAddValor.showingHint() || !tFAddValor.checaValor()) {
					JOptionPane.showMessageDialog(null, "Valor mal formatado.", "Erro", JOptionPane.ERROR_MESSAGE);	
				} else {
					operations.adicionaCurso (curso, Double.parseDouble(valor.replace(',', '.')));
					JOptionPane.showMessageDialog(null, "Curso '" + curso + "' criado com sucesso.", "Operação sucedida", JOptionPane.INFORMATION_MESSAGE);
					Object[] newRow = {curso, new Double(Double.parseDouble(valor.replace(',', '.')))};
					((DefaultTableModel) table.getModel()).addRow(newRow);
					tFAddCurso.setText("");
					tFAddValor.showHint();
				}
				
				try {
					operations.fimDePrograma();
				} catch(Exception f) {
					
				}
			}
		});

		btnEdit = new JButton("Editar");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		if(privileges != 1)
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curso = tFEditCurso.getText().toLowerCase();
				String novoValor = tFEditValor.getText();
				int i, rowCount;
				rowCount = ((DefaultTableModel) table.getModel()).getRowCount();
				for(i = 0; i < rowCount; i++) if(((String)((DefaultTableModel)table.getModel()).getValueAt(i, 0)).compareTo(curso) == 0) break;
				if(i == rowCount) {
					JOptionPane.showMessageDialog(null, "Curso inexistente.", "Erro", JOptionPane.ERROR_MESSAGE);
				} else if(novoValor.length() == 0 || tFEditValor.showingHint() || !tFEditValor.checaValor()) {
						JOptionPane.showMessageDialog(null, "Valor mal formatado.", "Erro", JOptionPane.ERROR_MESSAGE);	
				} else {
					operations.adicionaCurso(curso, Double.parseDouble(novoValor.replace(',', '.')));
					JOptionPane.showMessageDialog(null, "Curso '" + curso + "' editado com sucesso.", "Operação sucedida", JOptionPane.INFORMATION_MESSAGE);
					((DefaultTableModel) table.getModel()).setValueAt(new Double(Double.parseDouble(novoValor.replace(',', '.'))), i, 1);
					tFEditCurso.setText("");
					tFEditValor.showHint();
				}
				try {
					operations.fimDePrograma();
				} catch(Exception f) {
					
				}
			}
		});
	
		btnRem = new JButton("Remover");
		btnRem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		if(privileges != 1)
		btnRem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curso = tFRemCurso.getText().toLowerCase();
				int i, rowCount;
				rowCount = ((DefaultTableModel) table.getModel()).getRowCount();
				for(i = 0; i < rowCount; i++) if(((String)((DefaultTableModel)table.getModel()).getValueAt(i, 0)).compareTo(curso) == 0) break;
				if(i == rowCount) {
					JOptionPane.showMessageDialog(null, "Curso inexistente.", "Erro", JOptionPane.ERROR_MESSAGE);
				} else {
					operations.RemoveCurso(curso);
					JOptionPane.showMessageDialog(null, "Curso '" + curso + "' removido com sucesso.", "Operação sucedida", JOptionPane.INFORMATION_MESSAGE);
					((DefaultTableModel) table.getModel()).removeRow(i);
					tFRemCurso.setText("");
				}
				
				try {
					operations.fimDePrograma();
				} catch(Exception f) {
					
				}
			}
		});
		/* Fim JButton */
		
		/* Inicializa JTextField */
		FocusListener flAdd = new FocusListener() {
			public void focusGained(FocusEvent e) {
				getRootPane().setDefaultButton(btnAdd);
			}
			public void focusLost(FocusEvent e) {}
		};
		
		FocusListener flEdit = new FocusListener() {
			public void focusGained(FocusEvent e) {
				getRootPane().setDefaultButton(btnEdit);
			}
			public void focusLost(FocusEvent e) {}
		};
		
		FocusListener flRem = new FocusListener() {
			public void focusGained(FocusEvent e) {
				getRootPane().setDefaultButton(btnRem);
			}
			public void focusLost(FocusEvent e) {}
		};
		
		tFAddCurso = new JTextField();
		tFAddCurso.addFocusListener(flAdd);
		
		tFAddValor = new HintTextField();
		tFAddValor.setValorHint();
		tFAddValor.addFocusListener(flAdd);
		
		tFEditCurso = new JTextField();
		tFEditCurso.addFocusListener(flEdit);
		
		tFEditValor = new HintTextField();
		tFEditValor.setValorHint();
		tFEditValor.addFocusListener(flEdit);
		
		tFRemCurso = new JTextField();
		tFRemCurso.addFocusListener(flRem);
		
		if(privileges == 1) { // Funcionario nao poderam alterar cursos, apenas ver
			tFAddCurso.setEnabled(false);
			tFAddValor.setEnabled(false);
			tFEditCurso.setEnabled(false);
			tFEditValor.setEnabled(false);
			tFRemCurso.setEnabled(false);
		}
		/* Fim JTextField */

		/* Inicializa JTable */
		table = new JTable(new DefaultTableModel(operations.getCursos(), new Object[]{"Curso", "Valor"})) {
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
			@Override
			public TableCellRenderer getCellRenderer(int row, int column) {
				if (column==1) return formatadorMoeda;
				return super.getCellRenderer(row, column);
			}
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (columnIndex==0) return String.class;
				if (columnIndex==1) return Double.class;
				if (columnIndex==2) return null;
				return null;
			}
		};
		table.setAutoCreateRowSorter(true);
		table.setEnabled(false);
		/* Fim JTable */

		/* Incializa JScrollPane */
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		/* Fim JScrollPane */

		/* Inicializa JPanel */		
		panelAddFieldCurso = new JPanel();
		panelAddFieldCurso.add(lblAddCurso);
		panelAddFieldCurso.add(tFAddCurso);

		panelAddFieldValor = new JPanel();
		panelAddFieldValor.add(lblAddValor);
		panelAddFieldValor.add(tFAddValor);

		panelAddFields = new JPanel();
		panelAddFields.setLayout(new GridLayout(2, 1, 0, 0));
		panelAddFields.add(panelAddFieldCurso);
		panelAddFields.add(panelAddFieldValor);

		panelAdd = new JPanel();
		panelAdd.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		panelAdd.setLayout(new BorderLayout(0, 15));
		panelAdd.add(lblAdd, BorderLayout.NORTH);
		panelAdd.add(panelAddFields, BorderLayout.CENTER);
		panelAdd.add(btnAdd, BorderLayout.SOUTH);

		panelEditFieldCurso = new JPanel();
		panelEditFieldCurso.add(lblEditCurso);
		panelEditFieldCurso.add(tFEditCurso);

		panelEditFieldValor = new JPanel();
		panelEditFieldValor.add(lblEditValor);
		panelEditFieldValor.add(tFEditValor);

		panelEditFields = new JPanel();
		panelEditFields.setLayout(new GridLayout(2, 1, 0, 0));
		panelEditFields.add(panelEditFieldCurso);
		panelEditFields.add(panelEditFieldValor);

		panelEdit = new JPanel();
		panelEdit.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		panelEdit.setLayout(new BorderLayout(0, 15));
		panelEdit.add(lblEdit, BorderLayout.NORTH);
		panelEdit.add(panelEditFields, BorderLayout.CENTER);
		panelEdit.add(btnEdit, BorderLayout.SOUTH);

		panelRemCurso = new JPanel();
		panelRemCurso.add(lblRemCurso);
		panelRemCurso.add(tFRemCurso);

		panelRem = new JPanel();
		panelRem.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		panelRem.setLayout(new BorderLayout(0, 15));
		panelRem.add(lblRem, BorderLayout.NORTH);
		panelRem.add(panelRemCurso, BorderLayout.CENTER);
		panelRem.add(btnRem, BorderLayout.SOUTH);

		panelFunctions = new JPanel();
		panelFunctions.setLayout(new GridLayout(1, 3, 25, 0));
		panelFunctions.add(panelAdd);
		panelFunctions.add(panelEdit);
		panelFunctions.add(panelRem);

		panelTop = new JPanel();
		panelTop.setLayout(new BorderLayout(0, 10));
		panelTop.add(lblGerenciaCursos, BorderLayout.NORTH);
		panelTop.add(panelFunctions, BorderLayout.CENTER);

		panelTable = new JPanel();
		panelTable.setLayout(new BorderLayout(0, 10));
		panelTable.add(lblTabelaCurso, BorderLayout.NORTH);
		panelTable.add(scrollPane, BorderLayout.CENTER);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 40));
		contentPane.add(panelTop, BorderLayout.NORTH);
		contentPane.add(panelTable, BorderLayout.CENTER);
		/* Fim JPanel */
		
		/* Inicializa JFrame */
		this.setMinimumSize(new Dimension(770, 329));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setContentPane(contentPane);
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        
        if(((DefaultTableModel)table.getModel()).getRowCount() * 16 + 329 > bounds.height) setBounds(0,0, 770, bounds.height);
        else setBounds(0,0, 770, ((DefaultTableModel)table.getModel()).getRowCount() * 16 + 329);

		addWindowStateListener(new WindowStateListener() {	public void windowStateChanged(WindowEvent e) { resizeComponents(); }	});
		addComponentListener(new ComponentListener() {
			public void componentHidden(ComponentEvent e) {}
			public void componentMoved(ComponentEvent e) {}
			public void componentShown(ComponentEvent e) {}
			public void componentResized(ComponentEvent e) { resizeComponents(); }
		});

		/* Diferença entre privilégios(Título) */
		title = "Kronos - Gerenciamento de Cursos(";
		switch(privileges) {
			case 1:	title += "Funcionário";	break;
			case 2:	title += "Diretor";		break;
			case 3:	title += "ADMIN";		break;
		}
		title += ")";
		setTitle(title);
		/* Fim JFrame */
	}
	
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
}
