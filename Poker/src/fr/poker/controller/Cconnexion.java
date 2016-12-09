package fr.poker.controller;

import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.poker.view.Vconnexion;

public class Cconnexion extends JFrame {
	private Vconnexion fenetreco;
	private Cinscription cins;
	public Cconnexion() {
		// TODO Auto-generated constructor stub
		this.fenetreco = new Vconnexion(this);
	}
	/** Serial UID */
	private static final long serialVersionUID = 8934682278090456214L;

	public void displayConnexion() {
		fenetreco.getFrame().setVisible(true);
	}
	
	public void closeConnexion() {
		fenetreco.dispose();
	}
	
	public void deleteTxtInField(JTextField textField) {
		textField.setText("");
	}
	
	public void fillField(JTextField txtField, String txt) {
		txtField.setText(txt);
	}
	
	public void runInscription() {
		this.cins = new Cinscription(this);
		fenetreco.getFrame().setVisible(false);
		cins.displayInscription();
	}

	public Vconnexion getFenetreco() {
		return fenetreco;
	}

	public void setFenetreco(Vconnexion fenetreco) {
		this.fenetreco = fenetreco;
	}
	
}
