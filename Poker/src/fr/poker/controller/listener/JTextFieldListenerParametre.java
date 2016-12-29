package fr.poker.controller.listener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import fr.poker.controller.*;

public class JTextFieldListenerParametre implements MouseListener, FocusListener{
	private JTextField textField;
	private Cparametre cPara;
	private String [] texts;
	
	public JTextFieldListenerParametre(Cparametre c, JTextField txt)
	{
		this.textField = txt;
		this.cPara = c;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		cPara.deleteTxtInField(this.textField);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		texts = cPara.getvParam().getTextInitiaux();
		if(textField.getText().equals("")){
			switch (textField.getName()) {
			case "pwdAccount":
				textField.setText(texts[0]);
				break;
			case "pwdConfirm":
				textField.setText(texts[1]);
				break;
			case "txtLastName":
				textField.setText(texts[2]);
				break;
			case "txtFirstName":
				textField.setText(texts[3]);
				break;
			case "txtPseudo":
				textField.setText(texts[4]);
				break;
			case "txtEmail":
				textField.setText(texts[5]);
				break;
			case "txtPhoneNumber":
				textField.setText(texts[6]);
				break;
			case "txtMoney":
				textField.setText(texts[7]);
				break;
				
			default:
				break;
			}
		}
	}
}
