package fr.poker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTextField;

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
		txtFields.add(vins.getPwdAccount().getText());
		txtFields.add(vins.getPwdConfirm().getText());
		txtFields.add(vins.getTxtEmail().getText());
		txtFields.add(vins.getTxtFirstName().getText());
		txtFields.add(vins.getTxtLastName().getText());
		txtFields.add(vins.getTxtPhoneNumber().getText());
		txtFields.add(vins.getTxtPseudo().getText());
		for(String s : txtFields){
			if(s.contains(" ") == true){
				vins.getLblErrorNumPhone().setVisible(false);
				vins.getLblErrorMail().setVisible(false);
				vins.getLblErrorPwd().setVisible(false);
				vins.getLblErrorField().setVisible(true);
				return false;
			}
			if(vins.getPwdAccount().getText().equals(vins.getPwdConfirm().getText())){
				vins.getLblErrorNumPhone().setVisible(false);
				vins.getLblErrorMail().setVisible(false);
				vins.getLblErrorPwd().setVisible(true);
				vins.getLblErrorField().setVisible(false);
				return false;
			}
		}
		return true;
	}

	public Vinscription getVins() {
		return vins;
	}

	public void setVins(Vinscription vins) {
		this.vins = vins;
	}
}
