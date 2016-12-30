package fr.poker.controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.poker.controller.bdd.CBcompte;
import fr.poker.controller.bdd.CBconnect;
import fr.poker.controller.bdd.CBsalle;
import fr.poker.view.Vcreation;
import fr.poker.view.Vparametres;

public class Ccreation{
	
	private Vcreation vCrea;
	private JFrame frameCrea;
	private Caccueil cAcc;
	private ArrayList<String> txtFields;
	private int IDplayer;
	private boolean isPrivate=false;
	
	private CBconnect cbCon;
	private CBsalle cbSalle;
	private CBcompte cbCpt;
	
	public Ccreation(Caccueil a,int Id) {
		this.vCrea=new Vcreation(this);
		this.IDplayer = Id;
		this.cAcc= a;
		
		System.out.println("Creation Ouvert pour joueur : " + IDplayer);
	}


	public Vcreation getvCrea() {
		return vCrea;
	}


	public void setvCrea(Vcreation vCrea) {
		this.vCrea = vCrea;
	}


	public void displayCrea(){
		//System.out.println("display creation ");
		vCrea.getFrame().setVisible(true);
	}
	
	public void runAccueil() {
		this.cAcc = new Caccueil(this, IDplayer);
		cAcc.displayAccueil();
		vCrea.getFrame().dispose();
		System.out.println("close creation");	
	}



	public boolean isPrivate() {
		return isPrivate;
	}


	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}


	public void runSalle() {
		// Sert au clique sur le bouton de lancement de la salle, fait differentes verification, recupère un ID disponnible et l'assigne à la salle
		
		cbCon = new CBconnect();
		cbSalle = new CBsalle(cbCon);
		String pwdSalle = "";
		String pwdConf = "";
		String nomSalle = "";
		int portSalle;
		int portChat;
		boolean pwdOK=false;
		boolean nomOK=false;
		
		//verifie si les Pwd entrés sont identique si if isPrivate=true
		
		if (isPrivate==true){
			
			pwdSalle=vCrea.getStringPwdSalle();
			pwdConf=vCrea.getStringPwdSalleConfirm();
			System.out.println(pwdSalle + pwdConf);
			if (pwdSalle.equals(pwdConf)==true)
			{	
				System.out.println("Champs pwd identiques");
				pwdOK=true;
			}
			else
			{
				System.out.println("Champs pwd différents");
				//to do : Affichage message d'erreur : Mot de passe entrée différent 
			}
		}
		if (isPrivate==false){
			pwdSalle="";
			pwdConf="";
			pwdOK=true;
		}
		
		//Verfie que le nom donnée à la salle  n'existe pas.
		
		nomOK=cbSalle.verifDataSalle(vCrea.getStringTxtNameSalle().toString());
		
		if (nomOK==true){
			nomSalle=vCrea.getStringTxtNameSalle().toString();
		}
		//Essaye de récupérer un port disponnible dans la Base de donnée pour le Chat et un port pour la salle
		
		portSalle=cbSalle.getPortSalle();
		portChat=cbSalle.getPortChat();
		
		// Creation de la salle : 
		if ((nomOK==true && pwdOK==true && portChat !=-1 && portSalle !=-1)==false ){
			//créer la salle 
			
			/* 
			 * Test Value : 
			 */
			/*isPrivate=false;
			pwdSalle="";
			nomSalle= "SallePublique1";
			portSalle=4565;//4555-4565 
			portChat=4580;//4570 */
			
			cbSalle.creeSalle(isPrivate,pwdSalle, nomSalle, portSalle, portChat);
			System.out.println("partie crée : "+ nomSalle);
			runAccueil();
		}
		else if(nomOK==false){
			System.out.println("le nom de la salle existe deja");
		}
		else if(pwdOK==false){
			System.out.println("Erreure Mot de passe");
		}
		else if(portChat==-1){
			System.out.println("Problème port Chat");
		}
		else if(portSalle==-1){
			System.out.println("Problème port Salle");
		}
		
		
	}


	public void maskPwd() {
		vCrea.activePassword(false);
		isPrivate=false;
	}


	public void displayPwd() {
		vCrea.activePassword(true);
		isPrivate=true;
	}


	public void deleteTxtInField(JTextField txtFields) {
		txtFields.setText("");
		
	}
	
	
	
}



