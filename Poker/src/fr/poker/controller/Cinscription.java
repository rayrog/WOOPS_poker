package fr.poker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import fr.poker.controller.bdd.CBcompte;
import fr.poker.controller.bdd.CBconnect;
import fr.poker.view.*;

public class Cinscription extends JFrame {
	private Vinscription vins;
	private JFrame frameins;
	private Cconnexion cCon;
	private ArrayList<String> txtFields;
	private CBconnect cbCon;
	private CBcompte cbCompte;
	private javax.swing.Timer timer;
	public Cinscription(Cconnexion c) {
		this.cCon = c;
		this.vins = new Vinscription(this, cCon.getFenetreco().getFrame());
		this.txtFields = new ArrayList<>();
	}
	
	public boolean verifyFields(){
		//Expression régulière pour les caractèress spéciaux
		Pattern p_special_charac = Pattern.compile("[^ \\w]");
		//Expression régulière pour l'adresse mail
		Pattern p_mail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		//Expression régulière pour le numéro de téléphone
		Pattern p_num = Pattern.compile("^[0-9]{10}$");
		ArrayList<String> compare = new ArrayList<String>();
		for(int i = 0; i<vins.getTextInitiaux().length; i++){
			compare.add(vins.getTextInitiaux()[i]);
		}
		txtFields = new ArrayList<>();
		txtFields.add(vins.getPwdAccount().getText());
		txtFields.add(vins.getPwdConfirm().getText());
		txtFields.add(vins.getTxtLastName().getText());
		txtFields.add(vins.getTxtFirstName().getText());
		txtFields.add(vins.getTxtPseudo().getText());
		for(String s : txtFields){
			//Vérifie si l'utilisateur à renseigner tous les champs
			if(compare.contains(s)){
				vins.getLblErrorField().setText("Tous les champs doivent être renseignés !");
				vins.getLblErrorField().setVisible(true);
				return false;					
			}
			Matcher m = p_special_charac.matcher(s);
			//Vérifie si il y a des espaces ou caractères spéciaux dans les champs
			if(s.contains(" ") == true || m.find()){
				vins.getLblErrorField().setText("Des champs contiennent des espaces ou des caractères spéciaux !");
				vins.getLblErrorField().setVisible(true);
				return false;	
			}
		}
		//Vérifie que le mot de passe entré et sa confirmation sont semblables
		if((vins.getPwdAccount().getText()).equals(vins.getPwdConfirm().getText()) == false){
			vins.getLblErrorField().setText("Les mots de passes doivent être identiques !");
			vins.getLblErrorField().setVisible(true);
			return false;	
		}
		//Vérifie si l'email a le bon format
		Matcher m_mail = p_mail.matcher(vins.getTxtEmail().getText());
		if(m_mail.find() == false) {
			vins.getLblErrorField().setText("L'email doit être au bon format !");
			vins.getLblErrorField().setVisible(true);
			return false;		
		}		
		//Vérifie si e numéro de téléphone a le bon format
		Matcher m_num = p_num.matcher(vins.getTxtPhoneNumber().getText());
		if(m_num.find() == false) {
			vins.getLblErrorField().setText("Le numéro de téléphone doit être au bon format !");
			vins.getLblErrorField().setVisible(true);
			return false;	
		}
		return true;
	}

	public boolean verifyBdd() {
		cbCon = new CBconnect();
		cbCompte = new CBcompte(cbCon);
		//Vérifie si le pseudo existe déjà en BDD
		if(cbCompte.checkPseudo(vins.getTxtPseudo().getText()) != -1) {
			System.out.println("Le pseudo existe déjà !");
			vins.getLblErrorField().setText("Le pseudo existe déjà !");
			vins.getLblErrorField().setVisible(true);
			return false;
		}
		//Vérifie si le mail existe déjà en BDD
		if(cbCompte.checkMail(vins.getTxtEmail().getText()) != -1) {
			System.out.println("Le mail existe déjà en BDD");
			vins.getLblErrorField().setText(" Le mail est déjà enregistré avec un autre compte !");
			vins.getLblErrorField().setVisible(true);
			return false;
		}
		return true;
	}
	
	public void insertNewUserData() {
		this.timer = new javax.swing.Timer(4000, null);
		cbCon = new CBconnect();
		cbCompte = new CBcompte(cbCon);
		cbCompte.inscription(this);
		this.vins.getLblSuccess().setVisible(true);
		timer.start();
		this.closeInscription();
		this.cCon.displayConnexion();	
	}
	
	public Vinscription getVins() {
		return vins;
	}

	public void setVins(Vinscription vins) {
		this.vins = vins;
	}

	public Cconnexion getCcon() {
		return cCon;
	}

	public void setCcon(Cconnexion ccon) {
		this.cCon = ccon;
	}

	public void displayInscription(){
		vins.getFrame().setVisible(true);
	}
	
	public void closeInscription(){
		vins.getFrame().dispose();
	}
	
	public void deleteTxtInField(JTextField txtField) {
		txtField.setText("");
	}
	
	public void fillField(JTextField txtField, String txt) {
		txtField.setText(txt);
	}
	
	public void runInscription(){
		displayInscription();
	}
	
}
