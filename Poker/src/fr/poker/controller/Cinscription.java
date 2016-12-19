package fr.poker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import fr.poker.view.*;

public class Cinscription extends JFrame {
	private Vinscription vins;
	private JFrame frameins;
	private Cconnexion ccon;
	private ArrayList<String> txtFields;
	public Cinscription(Cconnexion c) {
		this.ccon = c;
		this.vins = new Vinscription(this, ccon.getFenetreco().getFrame());
		this.txtFields = new ArrayList<>();
	}
	
	public Cconnexion getCcon() {
		return ccon;
	}

	public void setCcon(Cconnexion ccon) {
		this.ccon = ccon;
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
	
	
	public boolean verifyFields(){
		Pattern p_special_charac = Pattern.compile("[^ \\w]");
		Pattern p_mail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
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
//		txtFields.add(vins.getTxtEmail().getText());
//		txtFields.add(vins.getTxtPhoneNumber().getText());
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
		//Vérifie les informations par rapport à la base de donnée
		
		return true;
	}

	public Vinscription getVins() {
		return vins;
	}

	public void setVins(Vinscription vins) {
		this.vins = vins;
	}
	
}
