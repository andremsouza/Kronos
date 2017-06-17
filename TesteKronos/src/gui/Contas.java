package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.util.Vector;
import funcionario.Admin;
import javax.swing.table.DefaultTableModel;
import java.awt.GraphicsEnvironment;

public class Contas extends JFrame {
	private static final long serialVersionUID = -4717353666916235985L;
	private JLabel lblAdd;
	private JLabel lblAddUsuario;
	private JLabel lblAddSenha;
	private JLabel lblAddPrivileges;
	private JLabel lblEdit;
	private JLabel lblEditUsuario;
	private JLabel lblEditSenha;
	private JLabel lblEditPrivileges;
	private JLabel lblRem;
	private JLabel lblRemUsuario;
	private JLabel lblTableUsuario;
	private JLabel lblMenuAdm;
	private JTextField tFAddUsuario;
	private JTextField tFAddSenha;
	private JTextField tFEditUsuario;
	private JTextField tFEditSenha;
	private JTextField tFRemUsuario;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnRem;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel contentPane;
	private JPanel panelTable;
	private JPanel panelFunctions;
	private JPanel panelAdd;
	private JPanel panelEdit;
	private JPanel panelRem;
	private JPanel panelAddFields;
	private JPanel panelAddFieldUsuario;
	private JPanel panelAddFieldSenha;
	private JPanel panelAddFieldPrivilegio;
	private JPanel panelEditFields;
	private JPanel panelEditFieldUsuario;
	private JPanel panelEditFieldSenha;
	private JPanel panelRemFieldUsuario;
	private JPanel panelTop;
	private JComboBox<String> comboBoxAdd;
	private Vector<String> cBPrivileges;
	
	/**
	 * Construtor.
	 */
	public Contas(int privileges) {
		initialize(privileges);
	}

	/**
	 * Atualiza o tamanho de alguns componentes de acordo com o tamanho da janela.
	 */
	private void resizeComponents() {
		Rectangle frameRect;
		int columns;
		
		frameRect = getBounds();
		
		if((int)frameRect.getWidth() >= 1100) columns = 20;
		else if((int)frameRect.getWidth() >= 770) columns = 20 - ((1100 - (int)frameRect.getWidth()) / 33) - 1;
		else columns = 20;

		tFAddUsuario.setColumns(columns);
		tFAddSenha.setColumns(columns);
		tFEditUsuario.setColumns(columns);
		tFEditSenha.setColumns(columns);
		tFRemUsuario.setColumns(columns);
	}
	
	/**
	 * Inicializa as variáveis.
	 */
	private void initialize(int privileges) {
		/* Inicializa JLabel */
		lblMenuAdm = new JLabel("Menu de Administrador");
		lblMenuAdm.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuAdm.setFont(new Font("Tahoma", Font.PLAIN, 26));

		lblAdd = new JLabel("Adicionar Conta");
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblAddUsuario = new JLabel("Usu\u00E1rio: ");
		lblAddUsuario.setHorizontalAlignment(SwingConstants.LEADING);
		lblAddUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblAddSenha = new JLabel("Senha:  ");
		lblAddSenha.setHorizontalAlignment(SwingConstants.LEADING);
		lblAddSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblAddPrivileges = new JLabel("Privilégios: ");
		lblAddPrivileges.setHorizontalAlignment(SwingConstants.LEADING);
		lblAddPrivileges.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblEdit = new JLabel("Editar Senha");
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblEditUsuario = new JLabel("Usu\u00E1rio:        ");
		lblEditUsuario.setHorizontalAlignment(SwingConstants.LEADING);
		lblEditUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblEditSenha = new JLabel("Nova Senha: ");
		lblEditSenha.setHorizontalAlignment(SwingConstants.LEADING);
		lblEditSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblEditPrivileges = new JLabel();
		lblEditPrivileges.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditPrivileges.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEditPrivileges.setEnabled(false);

		lblRem = new JLabel("Remover Conta");
		lblRem.setHorizontalAlignment(SwingConstants.CENTER);
		lblRem.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblRemUsuario = new JLabel("Usu\u00E1rio: ");
		lblRemUsuario.setHorizontalAlignment(SwingConstants.LEADING);
		lblRemUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblTableUsuario = new JLabel("Tabela de Usu\u00E1rios");
		lblTableUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		/* Fim JLabel */

		/* Inicializa JButton */
		btnAdd = new JButton("Adicionar");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin adm = new Admin("", "");
				int privileges = comboBoxAdd.getSelectedIndex() + 1;
				String login = tFAddUsuario.getText();
				String senha = tFAddSenha.getText();
				if(login.length() < 4 || senha.length() < 4) {
					JOptionPane.showMessageDialog(null, "Usuários/senhas precisam ter no mínimo 4 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);	
				} else {
					switch(privileges) {
						case 1:
							adm.criaSecretario(login, senha);
							break;
						case 2:
							adm.criaSecretario(login, senha);
							break;
						case 3:
							adm.criaAdmin(login, senha);
							break;
					}
					JOptionPane.showMessageDialog(null, "Usuário '" + login + "' criado com sucesso.", "Operação sucedida", JOptionPane.INFORMATION_MESSAGE);
					String[] newRow = {login, Admin.hashSenha(senha), comboBoxAdd.getItemAt(comboBoxAdd.getSelectedIndex())};
					((DefaultTableModel) table.getModel()).addRow(newRow);
					tFAddUsuario.setText("");
					tFAddSenha.setText("");
				}
			}
		});

		btnEdit = new JButton("Editar");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin adm = new Admin("", "");
				String login = tFEditUsuario.getText();
				String novaSenha = tFEditSenha.getText();
				int i, rowCount;
				// procura o login na tabela
				rowCount = ((DefaultTableModel) table.getModel()).getRowCount();
				for(i = 0; i < rowCount; i++) if(((String)((DefaultTableModel)table.getModel()).getValueAt(i, 0)).compareTo(login) == 0) break;
				if(i == rowCount) {
					JOptionPane.showMessageDialog(null, "Usuário inexistente.", "Erro", JOptionPane.ERROR_MESSAGE);	
				} else if(novaSenha.length() < 4) {
					JOptionPane.showMessageDialog(null, "Senhas precisam ter no mínimo 4 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);	
				} else {
					switch(privileges) {
						case 1:
							adm.mudarSenha(login, novaSenha);
							break;
						case 2:
							adm.mudarSenha(login, novaSenha);
							break;
						case 3:
							adm.mudarSenha(login, novaSenha);
							break;
					}
					JOptionPane.showMessageDialog(null, "Usuário '" + login + "' editado com sucesso.", "Operação sucedida", JOptionPane.INFORMATION_MESSAGE);
					((DefaultTableModel) table.getModel()).setValueAt(Admin.hashSenha(""), i, 1);
					tFEditUsuario.setText("");
					tFEditSenha.setText("");
				}
			}
		});

		btnRem = new JButton("Remover");
		btnRem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin adm = new Admin("", "");
				String login = tFRemUsuario.getText();
				int i, rowCount;
				// procura o login na tabela
				rowCount = ((DefaultTableModel) table.getModel()).getRowCount();
				for(i = 0; i < rowCount; i++) if(((String)((DefaultTableModel)table.getModel()).getValueAt(i, 0)).compareTo(login) == 0) break;
				if(i == rowCount) {
					JOptionPane.showMessageDialog(null, "Usuário inexistente.", "Erro", JOptionPane.ERROR_MESSAGE);
				} else {
					switch(privileges) {
						case 1:
							adm.removeUsuario(login);
							break;
						case 2:
							adm.removeUsuario(login);
							break;
						case 3:
							adm.removeUsuario(login);
							break;
					}
					JOptionPane.showMessageDialog(null, "Usuário '" + login + "' removido com sucesso.", "Operação sucedida", JOptionPane.INFORMATION_MESSAGE);
					((DefaultTableModel) table.getModel()).removeRow(i);
					tFRemUsuario.setText("");
				}
			}
		});
		/* Fim JButton */

		/* Inicializa JTextField */
		tFAddUsuario = new JTextField();
		tFAddUsuario.addFocusListener(new FocusListener() { public void focusGained(FocusEvent e) { getRootPane().setDefaultButton(btnAdd); } public void focusLost(FocusEvent e) {}});
		
		tFAddSenha = new JTextField();
		tFAddSenha.addFocusListener(new FocusListener() { public void focusGained(FocusEvent e) { getRootPane().setDefaultButton(btnAdd); } public void focusLost(FocusEvent e) {}});
		
		tFEditUsuario = new JTextField();
		tFEditUsuario.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				getRootPane().setDefaultButton(btnEdit);
			}
			public void focusLost(FocusEvent e) {
				int i, rowCount;
				rowCount = ((DefaultTableModel) table.getModel()).getRowCount();
				for(i = 0; i < rowCount; i++) if(((String)((DefaultTableModel)table.getModel()).getValueAt(i, 0)).compareTo(tFEditUsuario.getText()) == 0) break;
				if(i != rowCount) {
					if(((String)((DefaultTableModel)table.getModel()).getValueAt(i, 2)).compareTo("Secretaria") == 0) {
						lblEditPrivileges.setText("Secretaria");
					} else if(((String)((DefaultTableModel)table.getModel()).getValueAt(i, 2)).compareTo("Diretoria") == 0) {
						lblEditPrivileges.setText("Diretoria");
					} else if(((String)((DefaultTableModel)table.getModel()).getValueAt(i, 2)).compareTo("Admin") == 0) {
						lblEditPrivileges.setText("Admin");
					}
					lblEditPrivileges.setEnabled(true);
				}
			}
		});
		
		tFEditSenha = new JTextField();
		tFEditSenha.addFocusListener(new FocusListener() { public void focusGained(FocusEvent e) { getRootPane().setDefaultButton(btnEdit); } public void focusLost(FocusEvent e) {}});
		
		tFRemUsuario = new JTextField();
		tFRemUsuario.addFocusListener(new FocusListener() { public void focusGained(FocusEvent e) { getRootPane().setDefaultButton(btnRem); } public void focusLost(FocusEvent e) {}});
		/* Fim JTextField */
		
		/* Inicializa JTable */
		table = new JTable(new DefaultTableModel((new Admin("", "")).retornaContas(), new Object[]{"Usuário", "Senha(Hash)", "Privilégios"}));
		table.setAutoCreateRowSorter(true);
		table.setEnabled(false);
		/* Fim JTable */

		/* Inicializa JScrollPane */
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		/* Fim JScrollPane */

		/* Inicializa JComboBox */
		cBPrivileges = new Vector<String>(3);
		cBPrivileges.add("Secretaria");
		cBPrivileges.add("Diretoria");
		cBPrivileges.add("Admin");
		comboBoxAdd = new JComboBox<String>(cBPrivileges);
		comboBoxAdd.addFocusListener(new FocusListener() { public void focusGained(FocusEvent e) { getRootPane().setDefaultButton(btnAdd); } public void focusLost(FocusEvent e) {}});
		/* Fim JComboBox */
		
		/* Inicializa JPanel */
		panelAddFieldUsuario = new JPanel();
		panelAddFieldUsuario.add(lblAddUsuario);
		panelAddFieldUsuario.add(tFAddUsuario);

		panelAddFieldSenha = new JPanel();
		panelAddFieldSenha.add(lblAddSenha);
		panelAddFieldSenha.add(tFAddSenha);

		panelAddFieldPrivilegio = new JPanel();
		panelAddFieldPrivilegio.add(lblAddPrivileges);
		panelAddFieldPrivilegio.add(comboBoxAdd);
		
		panelAddFields = new JPanel();
		panelAddFields.setLayout(new GridLayout(3, 1, 0, 0));
		panelAddFields.add(panelAddFieldUsuario);
		panelAddFields.add(panelAddFieldSenha);
		panelAddFields.add(panelAddFieldPrivilegio);

		panelAdd = new JPanel();
		panelAdd.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		panelAdd.setLayout(new BorderLayout(0, 15));
		panelAdd.add(lblAdd, BorderLayout.NORTH);
		panelAdd.add(panelAddFields, BorderLayout.CENTER);
		panelAdd.add(btnAdd, BorderLayout.SOUTH);

		panelEditFieldUsuario = new JPanel();
		panelEditFieldUsuario.add(lblEditUsuario);
		panelEditFieldUsuario.add(tFEditUsuario);

		panelEditFieldSenha = new JPanel();
		panelEditFieldSenha.add(lblEditSenha);
		panelEditFieldSenha.add(tFEditSenha);

		panelEditFields = new JPanel();
		panelEditFields.setLayout(new GridLayout(3, 1, 0, 0));
		panelEditFields.add(panelEditFieldUsuario);
		panelEditFields.add(panelEditFieldSenha);
		panelEditFields.add(lblEditPrivileges);

		panelEdit = new JPanel();
		panelEdit.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		panelEdit.setLayout(new BorderLayout(0, 15));
		panelEdit.add(lblEdit, BorderLayout.NORTH);
		panelEdit.add(panelEditFields, BorderLayout.CENTER);
		panelEdit.add(btnEdit, BorderLayout.SOUTH);

		panelRemFieldUsuario = new JPanel();
		panelRemFieldUsuario.add(lblRemUsuario);
		panelRemFieldUsuario.add(tFRemUsuario);

		panelRem = new JPanel();
		panelRem.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		panelRem.setLayout(new BorderLayout(0, 15));
		panelRem.add(lblRem, BorderLayout.NORTH);
		panelRem.add(panelRemFieldUsuario, BorderLayout.CENTER);
		panelRem.add(btnRem, BorderLayout.SOUTH);

		panelFunctions = new JPanel();
		panelFunctions.setLayout(new GridLayout(1, 3, 25, 0));
		panelFunctions.add(panelAdd);
		panelFunctions.add(panelEdit);
		panelFunctions.add(panelRem);

		panelTop = new JPanel();
		panelTop.setLayout(new BorderLayout(0, 10));
		panelTop.add(lblMenuAdm, BorderLayout.NORTH);
		panelTop.add(panelFunctions, BorderLayout.SOUTH);

		panelTable = new JPanel();		
		panelTable.setLayout(new BorderLayout(0, 10));
		panelTable.add(lblTableUsuario, BorderLayout.NORTH);
		panelTable.add(scrollPane, BorderLayout.CENTER);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 40));
		contentPane.add(panelTop, BorderLayout.NORTH);
		contentPane.add(panelTable, BorderLayout.CENTER);
		this.setContentPane(contentPane);
		/* Fim JPanel */

		/* Inicializa o JFrame */
		this.setMinimumSize(new Dimension(770, 384));
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        if(((DefaultTableModel)table.getModel()).getRowCount() * 16 + 384 > bounds.height) setBounds(0,0, 770, bounds.height);
        else setBounds(0,0, 770, ((DefaultTableModel)table.getModel()).getRowCount() * 16 + 384);
		this.setTitle("Kronos - Gerenciamento de Contas(ADMIN)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Se mudar o estado da janela, atualiza o tamanho dos JTextField */
		addWindowStateListener(new WindowStateListener() {
		   public void windowStateChanged(WindowEvent e) {
			   resizeComponents();
		   }
		});

		/* Se alterar o tamanho da janela, atualiza o tamnho dos JTextField */
		addComponentListener(new ComponentListener() {
			public void componentHidden(ComponentEvent e) {}
			public void componentMoved(ComponentEvent e) {}
			public void componentShown(ComponentEvent e) {}
			public void componentResized(ComponentEvent e) {
				resizeComponents();
			}
		});
	}
	
	/**
	 * Teste sah porra
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contas frame = new Contas(3);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
