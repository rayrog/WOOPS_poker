package fr.poker.controller.listener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import fr.poker.controller.*;

public class JTextFieldListenerCreation implements MouseListener, FocusListener{

	private JTextField textField;
	private Ccreation cCrea;
	private String [] texts;
	
	public JTextFieldListenerCreation(Ccreation c, JTextField txt)
	{
		this.textField = txt;
		this.cCrea = c;
	}

	public void mouseClicked(MouseEvent e) {
		cCrea.deleteTxtInField(this.textField);
	}
	
	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {

		
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
	
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void focusLost(FocusEvent e) {
		texts = cCrea.getvCrea().getTextInitiaux();
		if(textField.getText().equals("")){
			switch (textField.getName()) {
			case "pwdSalle":
				textField.setText(texts[1]);
				break;
			case "txtNameSalle":
				textField.setText(texts[0]);
				break;
			case "pwdSalleConfirm":
				textField.setText(texts[2]);
				break;
			default:
				break;
			}
		}
	}
}
