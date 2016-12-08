package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import fr.poker.controller.Cinscription;
import fr.poker.view.Vinscription;

public class CinscriptionListener implements ActionListener, MouseListener, FocusListener{
	private JTextField textField;
	public CinscriptionListener(JTextField txt)
	{
		this.textField = txt;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Inscription") {
				System.out.println("On essaye de se connecter");
				
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Cinscription.deleteTxtInField(this.textField);
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
		// TODO Auto-generated method stub
		if (textField.getText().equals("txtLastName")) {
			System.out.println("Je perds le focus sur le champ Nom");
			textField.setText("Nom");
			
		}
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		switch (textField.getName()) {
		case "pwdAccount":
			textField.setText("Mot de passe");
			break;
		case "pwdConfirm":
			textField.setText("Confirmer");
			break;
		case "txtLastName":
			textField.setText("Nom");
			break;
		case "txtFirstName":
			textField.setText("Pr\u00E9nom");
			break;
		case "txtPseudo":
			textField.setText("Pseudo");
			break;
		case "txtEmail":
			textField.setText("E-mail");
			break;
		case "txtPhoneNumber":
			textField.setText("N\u00B0 T\u00E9l\u00E9phone");
			break;

		default:
			break;
		}
	}
}
