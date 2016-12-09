package fr.poker.controller;

import javax.swing.JFrame;
import javax.swing.JTextField;


import fr.poker.controller.bdd.CBconnect;
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
/*	public void login() {
		boolean loginOK=false;
		System.out.println(fenetreCo.getTxtEmail().getText());
		System.out.println(fenetreCo.getPwdMotDePasse().getText()); // temp for debug 
		//CBconnect.connexion();
		//CBconnect.lire();
		// comparer couple login mdp avec la bdd >>>> si Ok : LoginOK a true 
		if (loginOK==true){
			System.out.println("Login OK, ouverture de la page de connection");
			// lancer page de connexion 
		}
		else {
			//JOptionPane.showMessageDialog(null, "Erreur de connexion : ", "InfoBox: " + "Error Login", JOptionPane.INFORMATION_MESSAGE);	
		}

	}*/
	
}

