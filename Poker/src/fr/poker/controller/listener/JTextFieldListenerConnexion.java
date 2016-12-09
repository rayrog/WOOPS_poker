package fr.poker.controller.listener;

import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import fr.poker.controller.Cconnexion;


public class JTextFieldListenerConnexion implements MouseListener, FocusListener {
	private JTextField textField;
	private Cconnexion ccon;
	public JTextFieldListenerConnexion(Cconnexion c, JTextField txt) {
		// TODO Auto-generated constructor stub
		this.textField = txt;
		this.ccon = c;
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(textField.getText().equals("")){
			switch (textField.getName()) {
			case "pwdMotDePasse":
				textField.setText("Mot de passe");
				break;
			case "txtEmail":
				textField.setText("E-mail");
				break;
			default:
				break;
			}
		}	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		ccon.deleteTxtInField(textField);
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
