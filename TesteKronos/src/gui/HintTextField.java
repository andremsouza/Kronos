package gui;

import java.awt.event.FocusListener;
import java.awt.Color;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

public class HintTextField extends JTextField implements FocusListener {
	private static final long serialVersionUID = 6295088376729537740L;
	private String hint;
	private boolean showingHint;

	public HintTextField() {
		super("");
		setForeground(Color.lightGray);
		this.showingHint = false;
		super.addFocusListener(this);
	}
	
	public HintTextField(String hint) {
		super(hint);
		setForeground(Color.lightGray);
		this.hint = hint;
		this.showingHint = true;
		super.addFocusListener(this);
	}

	public boolean showingHint() {
		return showingHint;
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		if(this.getText().isEmpty()) {
			super.setText("");
			setForeground(Color.BLACK);
			showingHint = false;
		}
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		if(this.getText().isEmpty()) {
			super.setText(hint);
			setForeground(Color.lightGray);
			showingHint = true;
		}
	}
	
	public boolean checaData() {
		String data = super.getText();
		if(showingHint || data.length() == 0) return true;
		int[] barras = {2, 5};
		int[] numb = {0, 1, 3, 4, 6, 7, 8, 9};
		if(super.getText().length() == 10) {
			for(int n : barras) if(data.charAt(n) != '/') return false;
			for(int n : numb) if(data.charAt(n) < '0' || data.charAt(n) > '9') return false;
		} else return false;
		return true;
	}
	
	public boolean checaValor() {
		String valor = super.getText();
		if(showingHint || valor.length() == 0) return true;
		if((valor.length() > 3) && (valor.charAt(valor.length() - 3) == ',')) {
			for(int n = 0, length = valor.length(); n < length; n++)
				if(n != (length - 3))
					if(valor.charAt(n) < '0' || valor.charAt(n) > '9')
						return false;
		} else return false;
		return true;
	}
	
	public void setDataHint() {
		this.hint = "dd/mm/aaaa";
		super.setText(hint);
		this.showingHint = true;
	}
	
	public void setValorHint() {
		this.hint = "xxxx,yy";
		super.setText(hint);
		this.showingHint = true;
	}
	
	public void showHint() {
		super.setText(hint);
		this.showingHint = true;
	}
	
	@Override
	public String getText() {
		return showingHint ? "" : super.getText();
	}
}