package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class InterfaceDesign {

	public class SrcollListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			final Component component = e.getComponent();
			if (component != null && component.getParent() != null && component.getParent() instanceof JComponent) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						((JComponent) component.getParent()).scrollRectToVisible(component.getBounds());
					}
				});
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
		}
	}

	public static void main(String args[]) {
		InterfaceDesign id = new InterfaceDesign();
		id.getPnlProjectDetail("My Project");
	}

	private SrcollListener l = new SrcollListener();

	public void getPnlProjectDetail(String strProjectName) {
		JPanel pnlPjDetail = new JPanel();
		JPanel pnlPjDetail2 = new JPanel();
		JScrollPane scrPjDetail;
		JScrollPane scrPjDetail2;
		pnlPjDetail.setLayout(null);
		pnlPjDetail.setBounds(0, 0, 200, 250);
		pnlPjDetail2.setLayout(null);
		pnlPjDetail2.setBounds(0, 0, 200, 300);
		JFrame frmtest = new JFrame();
		JInternalFrame interFrame = new JInternalFrame();
		interFrame.setBounds(0, 0, 280, 180);

		frmtest.setBounds(1, 1, 600, 200);
		pnlPjDetail.setPreferredSize(new Dimension(200, 250));
		pnlPjDetail2.setPreferredSize(new Dimension(200, 300));

		JLabel lblFirstName = new JLabel("First Name");
		JLabel lblLastName = new JLabel("Last Name");
		JLabel lblAddress = new JLabel("Address");
		JLabel lblCity = new JLabel("City");
		JLabel lblZipCode = new JLabel("Zip Code");
		JLabel lblPhone = new JLabel("Phone");
		JLabel lblEmailID = new JLabel("Emain Id");

		JTextField tfFirstName = new JTextField();
		JTextField tfLastName = new JTextField();
		JTextField tfAddress = new JTextField();
		JTextField tfCity = new JTextField();
		JTextField tfZipCode = new JTextField();
		JTextField tfPhone = new JTextField();
		JTextField tfEmailID = new JTextField();

		lblFirstName.setBounds(25, 55, 85, 20);
		tfFirstName.setBounds(25, 85, 85, 20);
		tfFirstName.addFocusListener(l);
		pnlPjDetail.add(lblFirstName);
		pnlPjDetail.add(tfFirstName);

		lblLastName.setBounds(25, 115, 85, 20);
		tfLastName.setBounds(25, 145, 85, 20);
		tfLastName.addFocusListener(l);
		pnlPjDetail.add(lblLastName);
		pnlPjDetail.add(tfLastName);

		lblAddress.setBounds(25, 175, 85, 20);
		tfAddress.setBounds(25, 205, 85, 20);
		tfAddress.addFocusListener(l);
		pnlPjDetail.add(lblAddress);
		pnlPjDetail.add(tfAddress);

		lblCity.setBounds(25, 55, 85, 20);
		tfCity.setBounds(25, 85, 85, 20);
		tfCity.addFocusListener(l);
		pnlPjDetail2.add(lblCity);
		pnlPjDetail2.add(tfCity);

		lblZipCode.setBounds(25, 115, 85, 20);
		tfZipCode.setBounds(25, 145, 85, 20);
		tfZipCode.addFocusListener(l);
		pnlPjDetail2.add(lblZipCode);
		pnlPjDetail2.add(tfZipCode);

		lblPhone.setBounds(25, 175, 85, 20);
		tfPhone.setBounds(25, 205, 85, 20);
		tfPhone.addFocusListener(l);
		pnlPjDetail2.add(lblPhone);
		pnlPjDetail2.add(tfPhone);

		lblEmailID.setBounds(25, 235, 85, 20);
		tfEmailID.setBounds(25, 265, 85, 20);
		tfEmailID.addFocusListener(l);
		pnlPjDetail2.add(lblEmailID);
		pnlPjDetail2.add(tfEmailID);

		scrPjDetail = new JScrollPane(pnlPjDetail);
		scrPjDetail2 = new JScrollPane(pnlPjDetail2);

		scrPjDetail.setAutoscrolls(true);

		// frmtest.setContentPane(scrProjectDetail);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrPjDetail, scrPjDetail2);
		splitPane.setDividerLocation(300);
		interFrame.setContentPane(splitPane);
		interFrame.setVisible(true);

		// frmtest.getLayeredPane().add(interFrame);
		frmtest.setContentPane(interFrame);
		// frmtest.add(scrProjectDetail);
		frmtest.setVisible(true);
		frmtest.setResizable(false);
		frmtest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// return pnlPjDetail;
	}
}