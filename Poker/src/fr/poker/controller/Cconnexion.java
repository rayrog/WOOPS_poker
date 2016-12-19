package fr.poker.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import fr.poker.controller.bdd.CBconnect;
import fr.poker.view.Vconnexion;

public class Cconnexion extends JFrame {

	private Vconnexion fenetreco;
	private Cinscription cins;
	private Caccueil cacc;
	private CBconnect cbcon;
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
		fenetreco.getFrame().dispose();
	}

	
	public void login() {
		int IDMail=-1;
		int IDPass=-1;
		System.out.println(fenetreco.getTxtEmail().getText());
		System.out.println(fenetreco.getPwdMotDePasse().getText()); // temp for debug 
		// comparer couple login mdp avec la bdd >>>> si Ok : LoginOK a true 
		cbcon = new CBconnect();
		// Recupere L'id du mail utiliser dans la bdd
		IDMail=cbcon.connexionCheckMail(fenetreco.getTxtEmail().getText());
		//Recupere L'ID du PWD utilis� 
		IDPass=cbcon.connexionCheckPasswd(fenetreco.getPwdMotDePasse().getText());
		
		// Si idpwd + id MAIl identique et non = -1 : Login OK Ouverture de la page d'accueil
		if (IDMail==IDPass && IDMail!=-1 && IDPass!=-1 ){
			System.out.println("Login + Mail OK : Ouverture Accueil Joueur n�" + IDMail);
			this.runAccueil(IDMail);
		}
		else {
			if (IDPass==-1 || IDMail==-1){
				this.fenetreco.getLblLidPwpError().setVisible(true);	
			}
		}
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
	
	public void runAccueil(int Id) {
		this.cacc = new Caccueil(this, Id);
		this.closeConnexion();
		cacc.displayAccueil();
	}
	

	public Vconnexion getFenetreco() {
		return fenetreco;

	}

	public void setFenetreco(Vconnexion fenetreco) {
		this.fenetreco = fenetreco;
	}

public void test() {
	
}
}

